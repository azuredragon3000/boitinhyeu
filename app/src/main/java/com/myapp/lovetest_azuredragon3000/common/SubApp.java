/*
 * Copyright 2020 Google LLC. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.myapp.lovetest_azuredragon3000.common;

import android.app.Application;


/**
 * Android Application class. Used for accessing singletons.
 */
public class SubApp extends Application {
    public BillingClientLifecycle getBillingClientLifecycle() {
        return BillingClientLifecycle.getInstance(this);
    }

    public DatabaseTruyenTinhYeu getDatabaseTruyenTinhYeu(){
        return DatabaseTruyenTinhYeu.getInstance(this);
    }
    public DatabaseTuViManager1 getDatabaseTuViManager1(){
        return DatabaseTuViManager1.getInstance(this);
    }
    public DatabaseTuViManager2 getDatabaseTuviManager2(){
        return DatabaseTuViManager2.getInstance(this);
    }
    public FirebaseUtiti getDatabaseFirebase(){
        return FirebaseUtiti.getInstance(this);
    }

    public DatabaseCungHoangDao getDatabaseCungHoangDao() {
        return DatabaseCungHoangDao.getInstance(this);
    }

    public DatabaseBoiPhuongDong getDatabaseBoiPhuongDong() {
        return DatabaseBoiPhuongDong.getInstance(this);
    }
}
