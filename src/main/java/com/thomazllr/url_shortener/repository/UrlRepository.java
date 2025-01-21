package com.thomazllr.url_shortener.repository;

import com.thomazllr.url_shortener.model.Url;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UrlRepository extends JpaRepository<Url, String> {
}
