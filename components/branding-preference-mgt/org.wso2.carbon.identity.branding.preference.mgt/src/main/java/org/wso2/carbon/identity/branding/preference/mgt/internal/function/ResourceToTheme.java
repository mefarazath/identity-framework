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
package org.wso2.carbon.identity.branding.preference.mgt.internal.function;

import org.wso2.carbon.identity.branding.preference.mgt.model.Theme;
import org.wso2.carbon.identity.configuration.mgt.core.model.Attribute;
import org.wso2.carbon.identity.configuration.mgt.core.model.Resource;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.wso2.carbon.identity.branding.preference.mgt.internal.Constants.ThemeAttributes.BACKGROUND_COLOUR_CODE;
import static org.wso2.carbon.identity.branding.preference.mgt.internal.Constants.ThemeAttributes.FAVICON;
import static org.wso2.carbon.identity.branding.preference.mgt.internal.Constants.ThemeAttributes.FOOTER_TEXT;
import static org.wso2.carbon.identity.branding.preference.mgt.internal.Constants.ThemeAttributes.HEADER_TEXT;
import static org.wso2.carbon.identity.branding.preference.mgt.internal.Constants.ThemeAttributes.LOGO;
import static org.wso2.carbon.identity.branding.preference.mgt.internal.Constants.ThemeAttributes.PRIMARY_COLOUR_CODE;
import static org.wso2.carbon.identity.branding.preference.mgt.internal.Constants.ThemeAttributes.THEME_PATH;
import static org.wso2.carbon.identity.branding.preference.mgt.internal.Constants.ThemeAttributes.TITLE_TEXT;

public class ResourceToTheme implements Function<Resource, Theme> {

    @Override
    public Theme apply(Resource resource) {

        Theme theme = new Theme();
        if (resource.isHasAttribute()) {
            List<Attribute> attributes = resource.getAttributes();
            Map<String, String> attributeMap = getAttributeMap(attributes);

            setIfNotNull(attributeMap.get(HEADER_TEXT), theme::setHeaderText);
            setIfNotNull(attributeMap.get(FOOTER_TEXT), theme::setFooterText);
            setIfNotNull(attributeMap.get(TITLE_TEXT), theme::setTitleText);

            setIfNotNull(attributeMap.get(LOGO), theme::setLogo);
            setIfNotNull(attributeMap.get(FAVICON), theme::setFavicon);

            setIfNotNull(attributeMap.get(PRIMARY_COLOUR_CODE), theme::setPrimaryColorCode);
            setIfNotNull(attributeMap.get(BACKGROUND_COLOUR_CODE), theme::setBackgroundColorCode);

            setIfNotNull(attributeMap.get(THEME_PATH), theme::setThemePath);
        }
        return theme;
    }

    private Map<String, String> getAttributeMap(List<Attribute> attributes) {

        if (attributes != null) {
            return attributes.stream().collect(Collectors.toMap(Attribute::getKey, Attribute::getValue));
        }

        return Collections.emptyMap();
    }

    public void setIfNotNull(String value, Consumer<String> consumer) {

        if (value != null) {
            consumer.accept(value);
        }
    }
}
