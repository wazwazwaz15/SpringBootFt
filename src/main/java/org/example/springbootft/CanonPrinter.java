package org.example.springbootft;

import org.springframework.stereotype.Component;

@Component
public class CanonPrinter implements Printer {
    @Override
    public void print(String text) {
        System.out.println("CanonPrinter: " + text);
    }
}
