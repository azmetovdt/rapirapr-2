package ru.bmstu.rapirapr.azmetov.delays;

import org.apache.hadoop.io.WritableComparator;

public class Comparator extends WritableComparator {

    public int compare(KeyWritable o1, KeyWritable o2)  {
        return o1.airportId.compareTo(o2.airportId);
    }
}
