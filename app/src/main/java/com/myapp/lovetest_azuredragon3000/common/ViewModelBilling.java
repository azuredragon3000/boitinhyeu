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

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.android.billingclient.api.BillingFlowParams;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.SkuDetails;

import java.util.List;
import java.util.Map;

public class ViewModelBilling extends AndroidViewModel {

    /**
     * Local billing purchase data.
     */
    private MutableLiveData<List<Purchase>> purchases;

    /**
     * SkuDetails for all known SKUs.
     */
    private MutableLiveData<Map<String, SkuDetails>> skusWithSkuDetails;

    /**
     * Subscriptions record according to the server.
     */
//    private MediatorLiveData<List<SubscriptionStatus>> subscriptions;

    /**
     * Send an event when the Activity needs to buy something.
     */
    public EventSingleLive<BillingFlowParams> buyEvent = new EventSingleLive<>();

    /**
     * Send an event when the UI should open the Google Play
     * Store for the user to manage their subscriptions.
     */
    public EventSingleLive<String> openPlayStoreSubscriptionsEvent = new EventSingleLive<>();

    public ViewModelBilling(Application application) {
        super(application);
        SubApp subApp = ((SubApp) application);
        purchases = subApp.getBillingClientLifecycle().purchases;
        skusWithSkuDetails = subApp.getBillingClientLifecycle().skusWithSkuDetails;
       // subscriptions = subApp.getRepository().getSubscriptions();
    }

}
