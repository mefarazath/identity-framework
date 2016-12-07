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

package org.wso2.carbon.identity.framework.context;

import org.wso2.carbon.identity.common.base.message.MessageContext;
import org.wso2.carbon.identity.framework.message.IdentityRequest;
import org.wso2.carbon.identity.framework.message.IdentityResponse;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class IdentityMessageContext<T1 extends Serializable, T2 extends Serializable, T3 extends IdentityRequest,
        T4 extends IdentityResponse> extends MessageContext implements Serializable {

    private static final long serialVersionUID = 104614801932285909L;

    protected T3 identityRequest;
    protected T4 identityResponse;
    protected Map<T1, T2> parameters = new HashMap<>();

    public IdentityMessageContext(T3 identityRequest, T4 identityResponseMessage) {
        this.identityRequest = identityRequest;
        this.identityResponse = identityResponseMessage;
    }

    public IdentityMessageContext(T3 identityRequest, T4 identityResponseMessage, Map<T1, T2> parameters) {
        this.identityRequest = identityRequest;
        this.identityResponse = identityResponseMessage;
    }

    public T3 getIdentityRequest() {
        return identityRequest;
    }

    public void setIdentityRequest(T3 identityRequest) {
        this.identityRequest = identityRequest;
    }

    public void setIdentityResponse(T4 identityResponse) {
        this.identityResponse = identityResponse;
    }

    public T4 getIdentityResponse() {
        return identityResponse;
    }

    @Override
    public Map<T1, T2> getParameters() {
        return parameters;
    }

    public void addParameter(T1 key, T2 value) {
        parameters.putIfAbsent(key, value);
    }

    public T2 getParameter(T1 key) {
        return parameters.getOrDefault(key, null);
    }

}
