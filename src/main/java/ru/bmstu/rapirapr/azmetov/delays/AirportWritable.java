package ru.bmstu.rapirapr.azmetov.delays;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class AirportWritable implements Writable {
    public Text airportName;

    public AirportWritable(Text airportName) {
        this.airportName = airportName;
    }
    public AirportWritable(String airportName) {
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
