package ru.bmstu.rapirapr.azmetov.delays;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class Comparator extends WritableComparator {
    protected Comparator() {
        super(KeyWritable.class, true);
    }
    @Override
    public int compare(WritableComparable o1, WritableComparable o2)  {
        KeyWritable k1 = (KeyWritable) o1;
        KeyWritable k2 = (KeyWritable) o2;
        return k2.airportId.compareTo(k2.airportId);
    }
}
