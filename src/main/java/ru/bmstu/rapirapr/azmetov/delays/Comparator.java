package ru.bmstu.rapirapr.azmetov.delays;

import org.apache.hadoop.io.RawComparator;
import org.apache.hadoop.io.WritableComparator;

public class Comparator extends WritableComparator {


    @Override
    public int compare(KeyWritable o1, KeyWritable o2) {
        return o1.compareTo(o2);
    }
}
