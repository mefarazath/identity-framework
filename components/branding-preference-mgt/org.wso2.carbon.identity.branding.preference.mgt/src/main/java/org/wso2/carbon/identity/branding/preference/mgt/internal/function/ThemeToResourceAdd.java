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
import org.wso2.carbon.identity.configuration.mgt.core.model.ResourceAdd;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import static org.wso2.carbon.identity.branding.preference.mgt.internal.Constants.THEME_RESOURCE_NAME;
import static org.wso2.carbon.identity.branding.preference.mgt.internal.Constants.ThemeAttributes.BACKGROUND_COLOUR_CODE;
import static org.wso2.carbon.identity.branding.preference.mgt.internal.Constants.ThemeAttributes.FAVICON;
import static org.wso2.carbon.identity.branding.preference.mgt.internal.Constants.ThemeAttributes.FOOTER_TEXT;
import static org.wso2.carbon.identity.branding.preference.mgt.internal.Constants.ThemeAttributes.HEADER_TEXT;
import static org.wso2.carbon.identity.branding.preference.mgt.internal.Constants.ThemeAttributes.LOGO;
import static org.wso2.carbon.identity.branding.preference.mgt.internal.Constants.ThemeAttributes.PRIMARY_COLOUR_CODE;
import static org.wso2.carbon.identity.branding.preference.mgt.internal.Constants.ThemeAttributes.THEME_PATH;
import static org.wso2.carbon.identity.branding.preference.mgt.internal.Constants.ThemeAttributes.TITLE_TEXT;

public class ThemeToResourceAdd implements Function<Theme, ResourceAdd> {

    @Override
    public ResourceAdd apply(Theme theme) {

        ResourceAdd resourceAdd = new ResourceAdd();
        resourceAdd.setName(THEME_RESOURCE_NAME);

        List<Attribute> attributes = new ArrayList<>();
        addAttribute(attributes, HEADER_TEXT, theme.getHeaderText());
        addAttribute(attributes, FOOTER_TEXT, theme.getFooterText());
        addAttribute(attributes, TITLE_TEXT, theme.getTitleText());

        addAttribute(attributes, LOGO, theme.getLogo());
        addAttribute(attributes, FAVICON, theme.getFavicon());

        addAttribute(attributes, BACKGROUND_COLOUR_CODE, theme.getBackgroundColorCode());
        addAttribute(attributes, PRIMARY_COLOUR_CODE, theme.getPrimaryColorCode());

        addAttribute(attributes, THEME_PATH, theme.getThemePath());

        resourceAdd.setAttributes(attributes);
        return resourceAdd;
    }

    private void addAttribute(List<Attribute> attributeList, String key, String value) {

        if (value != null) {
            Attribute attribute = new Attribute();
            attribute.setKey(key);
            attribute.setValue(value);
            attributeList.add(attribute);
        }
    }
}
