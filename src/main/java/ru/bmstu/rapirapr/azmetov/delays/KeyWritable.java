package ru.bmstu.rapirapr.azmetov.delays;


import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class KeyWritable implements WritableComparable {
    private static IntWritable isAirport;
    private static IntWritable airportId;


    @Override
    public int compareTo(Object o) {
    

    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        isAirport.write(dataOutput);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        isAirport.readFields(dataInput);
    }
}
