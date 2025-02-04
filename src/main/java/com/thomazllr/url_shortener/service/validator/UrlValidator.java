package com.thomazllr.url_shortener.service.validator;

import com.thomazllr.url_shortener.model.Source;
import org.springframework.stereotype.Component;

@Component
public class UrlValidator {

    public Source getUrlSource(String url) {
        String lowerCaseUrl = url.toLowerCase();
        if (lowerCaseUrl.contains("youtube.com") || lowerCaseUrl.contains("youtu.be")) return Source.YOUTUBE;
        if (lowerCaseUrl.contains("twitter.com") || lowerCaseUrl.contains("x.com")) return Source.TWITTER;
        if (lowerCaseUrl.contains("linkedin.com")) return Source.LINKEDIN;
        if (lowerCaseUrl.contains("facebook.com") || lowerCaseUrl.contains("fb.com")) return Source.FACEBOOK;
        return Source.OTHER;
    }

}