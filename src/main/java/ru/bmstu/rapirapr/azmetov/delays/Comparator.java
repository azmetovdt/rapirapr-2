package ru.bmstu.rapirapr.azmetov.delays;

import org.apache.hadoop.io.WritableComparator;

public class Comparator extends WritableComparator {

    @Override
    public int compare(Object o1, Object o2) {
        return ((KeyWritable) o1).compareTo((KeyWritable) o2);
    }
}
