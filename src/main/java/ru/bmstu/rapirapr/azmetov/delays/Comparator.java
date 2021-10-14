package ru.bmstu.rapirapr.azmetov.delays;

import org.apache.hadoop.io.RawComparator;

public class Comparator extends Writable<KeyWritable> {


    @Override
    public int compare(KeyWritable o1, KeyWritable o2) {
        return o1.compareTo(o2);
    }

    public int compare(byte[] bytes, int i, int i1, byte[] bytes1, int i2, int i3) {
        return 1   ;
    }
}
