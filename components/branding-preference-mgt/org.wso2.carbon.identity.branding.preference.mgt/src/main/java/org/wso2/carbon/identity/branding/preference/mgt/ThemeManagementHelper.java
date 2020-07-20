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
package org.wso2.carbon.identity.branding.preference.mgt;

import org.apache.commons.lang.StringUtils;
import org.wso2.carbon.context.PrivilegedCarbonContext;
import org.wso2.carbon.identity.core.util.IdentityUtil;
import org.wso2.carbon.utils.multitenancy.MultitenantConstants;

import javax.servlet.http.HttpServletRequest;

public class ThemeManagementHelper {

    private static ThemeManagementService themeManagementService;

    private ThemeManagementHelper() {

    }

    public static String getTenantDomain(HttpServletRequest request) {

        String tenantDomain = (String) IdentityUtil.threadLocalProperties.get().get("TenantNameFromContext");
        if (StringUtils.isBlank(tenantDomain)) {
            tenantDomain = request.getParameter("tenantDomain");
        }

        if (StringUtils.isBlank(tenantDomain)) {
            tenantDomain = MultitenantConstants.SUPER_TENANT_DOMAIN_NAME;
        }

        return tenantDomain;
    }

    public static ThemeManagementService getThemeManagementService() {

        if (themeManagementService == null) {
            ThemeManagementService themeManagementOSGiService = (ThemeManagementService) PrivilegedCarbonContext
                    .getThreadLocalCarbonContext().getOSGiService(ThemeManagementService.class, null);

            if (themeManagementOSGiService != null) {
                themeManagementService = themeManagementOSGiService;
            } else {
                throw new IllegalStateException("ThemeManagementService is not registered.");
            }
        }

        return themeManagementService;
    }

}
