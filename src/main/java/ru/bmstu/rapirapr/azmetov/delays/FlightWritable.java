package ru.bmstu.rapirapr.azmetov.delays;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class FlightWritable implements Writable {
    public Text delay;


    public FlightWritable(Text delay) {
        this.delay = delay;
    }
    public FlightWritable(String delay) {
        this.delay = new Text(delay);
    }

    @Override
    public void write(DataOutput out) throws IOException {
        delay.write(out);
    }

    @Override
    public void readFields(DataInput in) throws IOException {
        delay.readFields(in);
    }
}
