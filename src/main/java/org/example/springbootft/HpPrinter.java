package org.example.springbootft;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

@Component
public class HpPrinter implements Printer {
    @Value("${HpPrinter.name}")
    public String name;
    @Value("${HpPrinter.type}")
    public String type;


    @Override
    public void print(String text) {
        byte[] bytes = name.getBytes();
        System.out.println("這是" + new String(bytes, StandardCharsets.ISO_8859_1) + "HpPrinter");
        System.out.println("型號是" + type);
        System.out.println("HpPrinter:" + text);
    }
}
