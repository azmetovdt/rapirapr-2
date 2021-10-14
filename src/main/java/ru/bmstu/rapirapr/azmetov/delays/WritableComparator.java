package ru.bmstu.rapirapr.azmetov.delays;


import org.apache.hadoop.io.RawComparator;
import org.apache.hadoop.io.WritableComparable;

public class WritableComparator implements RawComparator<WritableComparable> {


    @Override
    public int compare(WritableComparable o1, WritableComparable o2) {
        return o1.compareTo(o2);
    }


}
