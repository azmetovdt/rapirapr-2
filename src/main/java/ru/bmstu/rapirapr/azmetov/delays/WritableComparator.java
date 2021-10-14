package ru.bmstu.rapirapr.azmetov.delays;

import org.apache.hadoop.io.RawComparator;
import org.apache.hadoop.io.WritableComparable;

public class WritableComparator implements RawComparator<WritableComparable> {


    @Override
    public int compare(WritableComparable o1, WritableComparable o2) {
        return 0;
    }

    @Override
    public int compare(byte[] bytes, int i, int i1, byte[] bytes1, int i2, int i3) {
        return 0;
    }
}
