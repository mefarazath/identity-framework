/*
 * Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.carbon.identity.framework.response;

import org.wso2.carbon.identity.framework.context.IdentityMessageContext;

import java.io.Serializable;

/*
 * Abstract type that represents any return value from an IdentityProcessor
 */
public class IdentityResponse implements Serializable {

    private static final long serialVersionUID = 1348704275109461974L;

    protected IdentityMessageContext context;

    protected IdentityResponse(IdentityResponseBuilder builder) {
        this.context = builder.context;
    }

    public static class IdentityResponseBuilder {

        protected IdentityMessageContext context;

        public IdentityResponseBuilder(IdentityMessageContext context) {
            this.context = context;
        }

        public IdentityResponseBuilder() {

        }
        public IdentityResponse build() {
            return new IdentityResponse(this);
        }
    }
}
