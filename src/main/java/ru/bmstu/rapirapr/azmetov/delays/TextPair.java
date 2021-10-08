package ru.bmstu.rapirapr.azmetov.delays;

import org.apache.hadoop.io.Text;

public class TextPair {
    private Text firstText;
    private Text secondText;

    public TextPair(Text first, Text second) {
        this.firstText = first;
        this.secondText = first;
    }
    public TextPair(String first, String second) {
        this.firstText = new Text(first);
        this.secondText = new Text(first);
    }
    
}
