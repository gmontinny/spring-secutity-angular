package com.gmontinny.multipleauthapi.security.oauth2.user;

import java.util.Map;

public class FacebookOAuth2UserInfo extends OAuth2UserInfo  {

    public FacebookOAuth2UserInfo(Map<String, Object> attributes) {
        super(attributes);
    }

    @Override
    public String getId() {
        return (String) attributes.get("id");
    }

    @Override
    public String getName() {
        return (String) attributes.get("name");
    }

    @Override
    public String getEmail() {
        return (String) attributes.get("email");
    }

    @Override
    public String getImageUrl() {
        if (attributes.containsKey("picture")) {
            Object picture = attributes.get("picture");
            if (picture instanceof Map) {
                Map<String, Object> pictureObj = (Map<String, Object>) picture;
                if (pictureObj.containsKey("data")) {
                    Object data = pictureObj.get("data");
                    if (data instanceof Map) {
                        Map<String, Object> dataObj = (Map<String, Object>) data;
                        if (dataObj.containsKey("url")) {
                            return (String) dataObj.get("url");
                        }
                    }
                }
            }
        }
        return null;
    }
}
