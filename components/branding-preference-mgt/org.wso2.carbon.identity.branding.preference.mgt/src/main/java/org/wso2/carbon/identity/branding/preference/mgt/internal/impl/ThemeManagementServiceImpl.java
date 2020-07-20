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
package org.wso2.carbon.identity.branding.preference.mgt.internal.impl;

import org.apache.commons.lang.StringUtils;
import org.wso2.carbon.context.PrivilegedCarbonContext;
import org.wso2.carbon.identity.branding.preference.mgt.ThemeManagementService;
import org.wso2.carbon.identity.branding.preference.mgt.exception.ThemeManagementException;
import org.wso2.carbon.identity.branding.preference.mgt.exception.ThemeManagementServerException;
import org.wso2.carbon.identity.branding.preference.mgt.internal.ThemeManagementServiceHolder;
import org.wso2.carbon.identity.branding.preference.mgt.internal.function.ResourceToTheme;
import org.wso2.carbon.identity.branding.preference.mgt.internal.function.ThemeToResourceAdd;
import org.wso2.carbon.identity.branding.preference.mgt.model.Theme;
import org.wso2.carbon.identity.configuration.mgt.core.ConfigurationManager;
import org.wso2.carbon.identity.configuration.mgt.core.exception.ConfigurationManagementException;
import org.wso2.carbon.identity.configuration.mgt.core.model.Resource;
import org.wso2.carbon.identity.configuration.mgt.core.model.ResourceAdd;
import org.wso2.carbon.identity.core.util.IdentityTenantUtil;

import static org.wso2.carbon.identity.branding.preference.mgt.internal.Constants.THEME_RESOURCE_NAME;
import static org.wso2.carbon.identity.branding.preference.mgt.internal.Constants.THEME_RESOURCE_TYPE;
import static org.wso2.carbon.identity.configuration.mgt.core.constant.ConfigurationConstants.ErrorMessages.ERROR_CODE_RESOURCE_DOES_NOT_EXISTS;


public class ThemeManagementServiceImpl implements ThemeManagementService {

    @Override
    public Theme getTheme(String tenantDomain) throws ThemeManagementException {

        try {
            startTenantFlow(tenantDomain);
            Resource resource = getConfigurationManager().getResource(THEME_RESOURCE_TYPE, THEME_RESOURCE_NAME);
            return new ResourceToTheme().apply(resource);
        } catch (ConfigurationManagementException e) {
            if (isResourceNotFound(e)) {
                return new Theme();
            }
            throw new ThemeManagementServerException("Error while getting theme.", e);
        } finally {
            endTenantFlow();
        }
    }

    @Override
    public void putTheme(String tenantDomain, Theme theme) throws ThemeManagementException {

        try {
            startTenantFlow(tenantDomain);
            ResourceAdd resourceAdd = new ThemeToResourceAdd().apply(theme);
            getConfigurationManager().replaceResource(THEME_RESOURCE_TYPE, resourceAdd);
        } catch (ConfigurationManagementException e) {
            throw new ThemeManagementServerException("Error while updating theme.", e);
        } finally {
            endTenantFlow();
        }
    }

    private boolean isResourceNotFound(ConfigurationManagementException ex) {

        return StringUtils.equals(ex.getErrorCode(), ERROR_CODE_RESOURCE_DOES_NOT_EXISTS.getCode());
    }

    private ConfigurationManager getConfigurationManager() {

        return ThemeManagementServiceHolder.getInstance().getConfigurationManager();
    }

    public void startTenantFlow(String tenantDomain) {

        int tenantId = IdentityTenantUtil.getTenantId(tenantDomain);

        PrivilegedCarbonContext.startTenantFlow();
        PrivilegedCarbonContext.getThreadLocalCarbonContext().setTenantDomain(tenantDomain);
        PrivilegedCarbonContext.getThreadLocalCarbonContext().setTenantId(tenantId);
    }

    public void endTenantFlow() {

        PrivilegedCarbonContext.endTenantFlow();
    }
}
