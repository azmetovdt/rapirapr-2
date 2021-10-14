package ru.bmstu.rapirapr.azmetov.delays;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class FlightWritable implements Writable {
    private Text delay;


    public FlightWritable(Text airportName) {
        this.airportName = airportName;
    }
    public FlightWritable(String airportName) {
        this.airportName = new Text(airportName);
    }

    @Override
    public void write(DataOutput out) throws IOException {
        airportName.write(out);
    }

    @Override
    public void readFields(DataInput in) throws IOException {
        airportName.readFields(in);
    }
}
