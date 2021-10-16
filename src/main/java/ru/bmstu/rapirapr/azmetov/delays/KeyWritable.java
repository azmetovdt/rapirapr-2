package ru.bmstu.rapirapr.azmetov.delays;


import org.apache.hadoop.io.BooleanWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class KeyWritable implements WritableComparable<KeyWritable> {
    public Text airportId;
    public BooleanWritable isFlightInfo;

    public KeyWritable() {
        this.isFlightInfo = new BooleanWritable();
        this.airportId = new Text();
    }

    public KeyWritable(Text airportId, BooleanWritable isFlightInfo) {
        this.isFlightInfo = isFlightInfo;
        this.airportId = airportId;
    }
    public KeyWritable(String airportId, boolean isFlightInfo) {
        this.isFlightInfo = new BooleanWritable(isFlightInfo);
        this.airportId = new Text(airportId);
    }
    @Override
    public int compareTo(KeyWritable o) {
        if (airportId.equals(o.airportId)) {
            return isFlightInfo.compareTo(o.isFlightInfo);
        } else {
            return airportId.compareTo(o.airportId);
        }
    }

    @Override
    public void write(DataOutput out) throws IOException {
        isFlightInfo.write(out);
        airportId.write(out);
    }

    @Override
    public void readFields(DataInput in) throws IOException {
        isFlightInfo.readFields(in);
        airportId.readFields(in);
    }

    @Override
    public int hashCode()
    {
        return airportId.hashCode();
    }

}
