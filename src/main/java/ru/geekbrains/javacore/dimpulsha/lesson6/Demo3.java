package ru.geekbrains.javacore.dimpulsha.lesson6;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

public class Demo3 {
    public static void main(String[] args) throws IOException {

        URL url = new URL ("https","geekbrains.ru", 443, "/");

        //1  openStream
        InputStream in = url.openStream();
        new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8))
                .lines()
                // это такая запись для foreach
                .forEach(System.out::println);

        //
        URLConnection urlConnection = url.openConnection();
        in = urlConnection.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
        PrintWriter printWriter = new PrintWriter("tst.html");
        String current = null;
        while ((current = bufferedReader.readLine()) != null) {
            printWriter.println(current);
        }
        printWriter.close();
        bufferedReader.close();

        // http
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.connect();

        System.out.println(httpURLConnection.getResponseCode());
        System.out.println(httpURLConnection.getResponseMessage());
        System.out.println(httpURLConnection.getRequestMethod());
        System.out.println(httpURLConnection.getConnectTimeout());


        //заголовки
        Map <String , List<String>> headers = httpURLConnection.getHeaderFields();
        for (String k: headers.keySet()) {
            System.out.printf("key :  %s, value: %s \n", k, headers.get(k));
        }
    }
}
