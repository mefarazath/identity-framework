/*
 * Copyright (c) 2020, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.wso2.carbon.identity.application.authentication.endpoint.util;

import java.util.HashMap;
import java.util.Map;

public class TenantResourceManager {

    private static Map<String, Preference> tenants = new HashMap<>();

    static {
        tenants.put("abc.com",
                new Preference()
                        .style("https://mefarazath.github.io/abc.com.min.css")
                        .logo("https://upload.wikimedia.org/wikipedia/en/2/27/Alpha_Beta_Logo.PNG")
                        .headerTitle("Alpha Beta Corporation")
                        .title("")
                        .footer("Alpha Beta Corporation"));

        tenants.put("pandora.com", new Preference()
                .style("https://mefarazath.github.io/pandora.com.min.css")
                .logo("https://i.ya-webdesign.com/images/transparent-png-image-4.png")
                .title("")
                .headerTitle("Pandora Inc.")
                .footer("Pandora Inc."));
    }

    public static Preference getPreferences(String tenantDomain) {

        if (tenants.containsKey(tenantDomain)) {
            return tenants.get(tenantDomain);
        }
        return new Preference();
    }

//    public static String getCustomStyle(String tenantDomain) {
//
//        if (tenants.containsKey(tenantDomain)) {
//            return tenants.get(tenantDomain).getStylePath();
//        }
//        return null;
//    }
//
//    public static String getTitleText(String tenantDomain) {
//
//        if (tenants.containsKey(tenantDomain)) {
//            return tenants.get(tenantDomain).getTitleText();
//        }
//        return null;
//    }
//
//    public boolean showPrivacyPolicy(String tenantDomain) {
//
//        if (tenants.containsKey(tenantDomain)) {
//            return tenants.get(tenantDomain).isShowPrivacyPolicy();
//        }
//        return false;
//    }
//
//    public String getCustomLogo(String tenantDomain) {
//
//        if (tenants.containsKey(tenantDomain)) {
//            return tenants.get(tenantDomain).getLogoPath();
//        }
//        return null;
//    }
}
