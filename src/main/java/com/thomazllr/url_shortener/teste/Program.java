package com.thomazllr.url_shortener.teste;

import org.apache.commons.lang3.RandomStringUtils;

public class Program {
    public static void main(String[] args) {

        final int SHORT_ID_LENGTH = 8;

        String shortId = RandomStringUtils.random(5, true, true);


        System.out.println(shortId);


    }
}
