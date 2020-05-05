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
package org.wso2.carbon.identity.core;

public class DefaultServiceURLOptionsBuilder {

    private String tenantDomain;
    private boolean addTenantDomainInPath;
    private boolean addTenantDomainInQueryString;

    public DefaultServiceURLOptionsBuilder(String tenantDomain) {

        this.tenantDomain = tenantDomain;
    }

    public DefaultServiceURLOptionsBuilder addTenantDomainInQueryString() {

        this.addTenantDomainInQueryString = true;
        return this;
    }

    public DefaultServiceURLOptionsBuilder addTenantDomainInPath() {

        this.addTenantDomainInPath = true;
        return this;
    }

    public ServiceUrlOptions build() {

        return new ServiceUrlOptionsImpl(tenantDomain, addTenantDomainInPath, addTenantDomainInQueryString);
    }

    private class ServiceUrlOptionsImpl implements ServiceUrlOptions {

        private String tenantDomain;
        private boolean addTenantDomainInPath;
        private boolean addTenantDomainInQueryString;

        public ServiceUrlOptionsImpl(String tenantDomain, boolean addTenantDomainInPath,
                                     boolean addTenantDomainInQueryString) {

            this.tenantDomain = tenantDomain;
            this.addTenantDomainInPath = addTenantDomainInPath;
            this.addTenantDomainInQueryString = addTenantDomainInQueryString;
        }

        @Override
        public String getTenantDomain() {

            return tenantDomain;
        }

        @Override
        public boolean appendTenantDomainAsPathParam() {

            return addTenantDomainInPath;
        }

        @Override
        public boolean appendTenantDomainAsQueryParam() {

            return addTenantDomainInQueryString;
        }
    }
}
