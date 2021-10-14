package ru.bmstu.rapirapr.azmetov.delays;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class Comparator extends WritableComparator {

    @Override
    public int compare(WritableComparable o1, WritableComparable o2) {
        return o1.compareTo(o2);
    }
}
