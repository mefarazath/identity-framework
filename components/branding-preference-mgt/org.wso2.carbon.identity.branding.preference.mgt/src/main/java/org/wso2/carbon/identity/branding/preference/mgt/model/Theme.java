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
package org.wso2.carbon.identity.branding.preference.mgt.model;

public class Theme {

    private String headerText;
    private String footerText;
    private String titleText;

    private String logo;
    private String favicon;

    private String primaryColorCode;
    private String backgroundColorCode;

    private String themePath;

    public String getHeaderText() {

        return headerText;
    }

    public void setHeaderText(String headerText) {

        this.headerText = headerText;
    }

    public String getFooterText() {

        return footerText;
    }

    public void setFooterText(String footerText) {

        this.footerText = footerText;
    }

    public String getTitleText() {

        return titleText;
    }

    public void setTitleText(String titleText) {

        this.titleText = titleText;
    }

    public String getLogo() {

        return logo;
    }

    public void setLogo(String logo) {

        this.logo = logo;
    }

    public String getFavicon() {

        return favicon;
    }

    public void setFavicon(String favicon) {

        this.favicon = favicon;
    }

    public String getPrimaryColorCode() {

        return primaryColorCode;
    }

    public void setPrimaryColorCode(String primaryColorCode) {

        this.primaryColorCode = primaryColorCode;
    }

    public String getBackgroundColorCode() {

        return backgroundColorCode;
    }

    public void setBackgroundColorCode(String backgroundColorCode) {

        this.backgroundColorCode = backgroundColorCode;
    }

    public String getThemePath() {

        return themePath;
    }

    public void setThemePath(String themePath) {

        this.themePath = themePath;
    }
}
