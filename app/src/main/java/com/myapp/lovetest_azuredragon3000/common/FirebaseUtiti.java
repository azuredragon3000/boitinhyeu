package com.myapp.lovetest_azuredragon3000.common;

import android.app.Application;
import android.content.Context;
import android.os.Build;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.myapp.lovetest_azuredragon3000.login.data.Result;
import com.myapp.lovetest_azuredragon3000.listener.InterfaceFirebaseUtiti;
import com.myapp.lovetest_azuredragon3000.listener.LoginRepositoryListener;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FirebaseUtiti {

    DatabaseReference mDatabase;
    InterfaceFirebaseUtiti interfaceFirebaseUtiti;
    public final String PATHDB = "https://navigation-ce3f9-default-rtdb.asia-southeast1.firebasedatabase.app/";
    private static volatile FirebaseUtiti INSTANCE;
    private final String today;
    private final String urs;
    private final String second;
    //private UserApp userApp;

    private FirebaseUtiti( Context context) {
        //userApp = ((SubApp) context.getApplication()).getDatabaseTruyenTinhYeu();
        FirebaseApp.initializeApp(context);
        FirebaseDatabase database = FirebaseDatabase.getInstance(PATHDB);
        this.mDatabase = database.getReference();
        today = FunctionCommon.getToday();
        second = FunctionCommon.getSecond();
        urs = FunctionCommon.Encode2(Build.ID) +"_"+FunctionCommon.Encode2(Build.MANUFACTURER);
    }

    public static FirebaseUtiti getInstance(Application app) {
        if (INSTANCE == null) {
            synchronized (FirebaseUtiti.class) {
                if (INSTANCE == null) {
                    INSTANCE = new FirebaseUtiti(app);
                }
            }
        }
        return INSTANCE;
    }

    public void checkLogin(LoginRepositoryListener loginRepositoryListener, String username, String password) {
        String userId = Encode(username);
        mDatabase.child(Constant.APPNAME).child("users").child(userId).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    loginRepositoryListener.loginSuccess(new Result.Failed<>(new UserApp()));
                } else {
                    UpdateUser(task);
                }
            }

            private void UpdateUser(Task<DataSnapshot> task) {
                UserApp user = GetUser(String.valueOf(task.getResult().getValue()));
                if (!CheckUserName(username, password,user)) {
                    loginRepositoryListener.loginSuccess(new Result.Success<>(user));
                } else {
                    loginRepositoryListener.loginSuccess(new Result.Failed<>(user));
                }
            }
        });
    }

    public void firebaseCheckUsername(InterfaceFirebaseUtiti activity, String username, String password) {
        interfaceFirebaseUtiti = activity;
        String userId = Encode(username);
        mDatabase.child("lovetest_azuredragon3000").child("users").child(userId).get().addOnCompleteListener(task -> {
            if (!task.isSuccessful()) {

            } else {
                UserApp user = GetUser(String.valueOf(task.getResult().getValue()));
                if (CheckUserName(username, user)) {
                    if (FirebaseInsert(username, password)) {
                        interfaceFirebaseUtiti.insertSuccessful(new UserApp(username,username,password,"100"));
                    }else{
                        interfaceFirebaseUtiti.informWrongUserName();
                    }
                } else {
                    interfaceFirebaseUtiti.informWrongUserName();
                }
            }
        });
    }

    private boolean FirebaseInsert(String username, String password) {
        UserApp user = new UserApp(username,username, password,"100");
        String userId = Encode(username);
        mDatabase.child(Constant.APPNAME).child("users").child(userId).setValue(user);
        return true;
    }

    public static UserApp GetUser(String user2) {
        String pattern = "\\{(.*)=(.*), (.*)=(.*), (.*)=(.*), (.*)=(.*)\\}";
        // Create a Pattern object
        Pattern r = Pattern.compile(pattern);
        // Now create matcher object.
        Matcher m = r.matcher(user2);
        if (m.find()) {
            UserApp user = new UserApp("", "", "","");
            updateUser(user, Objects.requireNonNull(m.group(1)),m.group(2));
            updateUser(user, Objects.requireNonNull(m.group(3)),m.group(4));
            updateUser(user, Objects.requireNonNull(m.group(5)),m.group(6));
            updateUser(user, Objects.requireNonNull(m.group(7)),m.group(8));
            return user;
        }else{
            return null;
        }
    }

    public static boolean CheckUserName(String username, UserApp user) {
        try{
            return !user.userId.equals(username);
        }catch (Exception e){
            return true;
        }
    }

    public static String Encode(String encode) {
        encode = encode.replaceAll("\\.","");
        encode = encode.replaceAll("#","");
        encode = encode.replaceAll("\\$","");
        encode = encode.replaceAll("\\[","");
        encode = encode.replaceAll("]","");
        return encode;
    }

    public static boolean CheckUserName(String username, String pass, UserApp user) {
        try{
            return !user.userId.equals(username) || !user.pass.equals(pass);
        }catch (Exception e){
            return true;
        }
    }

    /* private static */
    private static void updateUser(UserApp user, String gr1, String gr2) {
        switch (gr1) {
            case "pass":
                user.pass = gr2;
                break;
            case "name":
                user.name = gr2;
                break;
            case "userId":
                user.userId = gr2;
                break;
            case "gold":
                user.gold = gr2;
                break;
            default:
                break;
        }
    }

    public void updateDBUser(UserApp user) {
        String encode = Encode(user.userId);
        mDatabase.child(encode).setValue(user);
    }

    public void updateDBAds(String appChild, String app, String information){
        mDatabase.child(app).child(today).child(urs).child(appChild).child("ads").child(second).setValue(information);
    }
    public void updateDB(String appChild, String app) {
        mDatabase.child(app).child(today).child(urs).child(appChild).child("number").get().addOnCompleteListener(task -> {
            if (!task.isSuccessful()) {

            }
            else {
                String t = String.valueOf(task.getResult().getValue());
                if(!t.equals("null")){
                    int bty = Integer.parseInt(t);
                    bty++;
                    mDatabase.child(app).child(today).child(urs).child(appChild).child("number").setValue(bty);
                }else{
                    mDatabase.child(app).child(today).child(urs).child(appChild).child("number").setValue(1);
                }
            }
        });
    }

    public void updateDB2(String appChild,  String app, String information) {
        mDatabase.child(app).child(today).child(urs).child(appChild).child("data").child(second).setValue(information);
    }
}
