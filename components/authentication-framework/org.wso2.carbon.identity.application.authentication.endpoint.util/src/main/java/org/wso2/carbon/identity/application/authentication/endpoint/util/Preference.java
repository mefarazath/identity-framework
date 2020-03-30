package org.wso2.carbon.identity.application.authentication.endpoint.util;

public class Preference {

    private String stylePath;
    private String headerTitle;
    private String titleText;
    private String logoPath;
    private boolean showPrivacyPolicy;
    private String footerText;

    public String getStylePath() {

        return stylePath;
    }

    public Preference style(String stylePath) {

        this.stylePath = stylePath;
        return this;
    }

    public String getHeaderTitle() {

        return headerTitle;
    }

    public Preference headerTitle(String headerTitle) {

        this.headerTitle = headerTitle;
        return this;
    }

    public String getTitleText() {

        return titleText;
    }

    public Preference title(String titleText) {

        this.titleText = titleText;
        return this;

    }

    public String getLogoPath() {

        return logoPath;
    }

    public Preference logo(String logoPath) {

        this.logoPath = logoPath;
        return this;

    }

    public boolean isShowPrivacyPolicy() {

        return showPrivacyPolicy;
    }

    public Preference showPrivacyPolicy(boolean showPrivacyPolicy) {

        this.showPrivacyPolicy = showPrivacyPolicy;
        return this;
    }

    public String getFooterText() {

        return footerText;
    }

    public Preference footer(String footerText) {

        this.footerText = footerText;
        return this;
    }
}
