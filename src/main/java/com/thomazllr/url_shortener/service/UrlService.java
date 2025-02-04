package com.thomazllr.url_shortener.service;

import com.thomazllr.url_shortener.model.Url;
import com.thomazllr.url_shortener.model.dto.UrlDto;
import com.thomazllr.url_shortener.repository.UrlRepository;
import com.thomazllr.url_shortener.service.validator.UrlValidator;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UrlService {

    private UrlRepository repository;

    private UrlValidator validator;

    @Autowired
    public UrlService(UrlRepository repository, UrlValidator validator) {
        this.repository = repository;
        this.validator = validator;
    }

    public Url saveUrl(UrlDto request) {
        String shortId = RandomStringUtils.random(5, true, true);
        Url url = new Url();
        url.setId(shortId);
        url.setUrl(request.url());
        url.setShortUrl("localhost:8080/" + shortId);
        url.setCount(0);
        url.setSource(validator.getUrlSource(request.url()));
        return repository.save(url);
    }

    public List<Url> findAll() {
        return repository.findAll();
    }

    public Url findById(String id) {
        Url url = repository.findById(id).orElse(null);
        assert url != null;
        url.setCount(url.getCount() + 1);
        repository.save(url);
        return url;
    }
}
