package com.thomazllr.url_shortener.model.dto;

import com.thomazllr.url_shortener.model.Url;
import org.hibernate.validator.constraints.URL;

public record UrlDto(@URL(message = "You need to provide the URL") String url) {

    public Url toUrl() {
        Url urlEntity = new Url();
        urlEntity.setUrl(url);
        return urlEntity;
    }
}
