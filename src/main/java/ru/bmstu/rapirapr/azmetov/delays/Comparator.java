package ru.bmstu.rapirapr.azmetov.delays;

import org.apache.hadoop.io.WritableComparator;

public class Comparator extends WritableComparator {

    public int compare(KeyWritable o1, KeyWritable o2)  {
        if (o1 == null && o2 == null) return 0;
        if (o1 == null) return -1;
        if (o2 == null) return 1;
        return o1.airportId.compareTo(o2.airportId);
    }
}
