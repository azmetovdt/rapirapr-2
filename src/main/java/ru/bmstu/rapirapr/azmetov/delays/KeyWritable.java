package ru.bmstu.rapirapr.azmetov.delays;


import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class KeyWritable implements WritableComparable {
    public static IntWritable isFlightInfo;
    public static IntWritable airportId;

    public KeyWritable(String airportId, boolean isFlightInfo) {
        
    }
    @Override
    public int compareTo(Object o) {

    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        isFlightInfo.write(dataOutput);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        isFlightInfo.readFields(dataInput);
    }
}
