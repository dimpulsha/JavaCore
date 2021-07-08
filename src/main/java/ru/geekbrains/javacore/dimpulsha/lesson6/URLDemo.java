package ru.geekbrains.javacore.dimpulsha.lesson6;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class URLDemo {
    public static void main(String[] args) throws IOException, URISyntaxException {
        URL url1 = new URL("https://geekbrains.ru/courses");
        URL url2 = new URL("https","geekbrains.ru", 443, "/");

        System.out.println(url1.getFile());
        System.out.println(url1.getPath());
        System.out.println(url1.getHost());

        System.out.println("===============");

        System.out.println(url2.getPort());
        System.out.println(url2.getProtocol());
        System.out.println(url2.getUserInfo());
        System.out.println(url2.getAuthority());
        System.out.println(url2.toURI());
    }
}
