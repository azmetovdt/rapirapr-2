package ru.bmstu.rapirapr.azmetov.delays;

import org.apache.hadoop.io.RawComparator;

public class WritableComparator implements RawComparator {
    @Override
    public int compare(byte[] bytes, int i, int i1, byte[] bytes1, int i2, int i3) {
        return 0;
    }
}
