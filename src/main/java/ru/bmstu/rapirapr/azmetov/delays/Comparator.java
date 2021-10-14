package ru.bmstu.rapirapr.azmetov.delays;

import org.apache.hadoop.io.RawComparator;

public class Comparator extends RawComparator {

    public int compare(KeyWritable o1, KeyWritable o2)  {
        return o1.compareTo(o2);
    }
}
