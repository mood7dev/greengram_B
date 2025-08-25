package com.green.greengram.config.constants;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@ConfigurationProperties(prefix = "constants.oauth2")
@RequiredArgsConstructor
public class ConstOAuth2 {
    public final String baseUri;
    public final String authorizationRequestCookieName;
    public final String redirectUriParamCookieName;
    public final int cookieExpirySeconds;
    public final List<String> authorizedRedirectUris;

}
