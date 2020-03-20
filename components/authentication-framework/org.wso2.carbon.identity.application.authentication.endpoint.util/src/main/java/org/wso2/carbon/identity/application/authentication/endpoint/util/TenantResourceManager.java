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

    private static Map<String, Preferences> tenants = new HashMap<>();

    static {
        tenants.put("abc.com",
                new Preferences().style("https://mefarazath.github.io/abc.com.min.css").logo(null).title("ABC.COM"));
        tenants.put("wso2.com",
                new Preferences().style("https://mefarazath.github.io/wso2.com.min.css").logo(null).title("WSO2.COM"));
    }

    public static String getCustomStyle(String tenantDomain) {

        if (tenants.containsKey(tenantDomain)) {
            return tenants.get(tenantDomain).getStylePath();
        }
        return null;
    }

    public static String getTitleText(String tenantDomain) {

        if (tenants.containsKey(tenantDomain)) {
            return tenants.get(tenantDomain).getTitleText();
        }
        return null;
    }

    public boolean showPrivacyPolicy(String tenantDomain) {

        if (tenants.containsKey(tenantDomain)) {
            return tenants.get(tenantDomain).isShowPrivacyPolicy();
        }
        return false;
    }

    public String getCustomLogo(String tenantDomain) {

        if (tenants.containsKey(tenantDomain)) {
            return tenants.get(tenantDomain).getLogoPath();
        }
        return null;
    }

    static class Preferences {

        private String stylePath;
        private String titleText;
        private String logoPath;
        private boolean showPrivacyPolicy;

        public String getStylePath() {

            return stylePath;
        }

        public Preferences style(String stylePath) {

            this.stylePath = stylePath;
            return this;
        }

        public String getTitleText() {

            return titleText;
        }

        public Preferences title(String titleText) {

            this.titleText = titleText;
            return this;

        }

        public String getLogoPath() {

            return logoPath;
        }

        public Preferences logo(String logoPath) {

            this.logoPath = logoPath;
            return this;

        }

        public boolean isShowPrivacyPolicy() {

            return showPrivacyPolicy;
        }

        public Preferences showPrivacyPolicy(boolean showPrivacyPolicy) {

            this.showPrivacyPolicy = showPrivacyPolicy;
            return this;
        }
    }
}
