package ru.bmstu.rapirapr.azmetov.delays;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class Comparator extends WritableComparator {
    protected Comparator() {
        super(KeyWritable.class, true);
    }
    @Override
    public int compare(WritableComparable o1, WritableComparable o2)  {
        k1 
        return o1.airportId.compareTo(o2.airportId);
    }
}
