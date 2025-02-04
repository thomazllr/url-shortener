package com.thomazllr.url_shortener.controller;

import com.thomazllr.url_shortener.model.Url;
import com.thomazllr.url_shortener.model.dto.UrlDto;
import com.thomazllr.url_shortener.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/")
public class UrlController implements GenericController {

    @Autowired
    private UrlService service;

    @PostMapping()
    public ResponseEntity<UrlDto> save(@RequestParam UrlDto url) {
        var entity = service.saveUrl(url);
        var location = generateHeaderLocation(entity.getId());
        return ResponseEntity
                .created(location)
                .body(new UrlDto(entity.getShortUrl()));
    }

    @GetMapping("{id}")
    public ResponseEntity<Void> redirect(@PathVariable String id) {
        var url = service.findById(id);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create(url.getUrl()));
        return new ResponseEntity<>(headers, HttpStatus.MOVED_PERMANENTLY);

    }

    @GetMapping
    public List<Url> getAll() {
        return service.findAll();
    }
}
