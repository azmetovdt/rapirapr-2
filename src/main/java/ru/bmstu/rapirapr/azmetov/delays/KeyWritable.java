package ru.bmstu.rapirapr.azmetov.delays;


import org.apache.hadoop.io.BooleanWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class KeyWritable implements WritableComparable {
    private BooleanWritable isFlightInfo;
    public Text airportId;

    public KeyWritable(Text airportId, BooleanWritable isFlightInfo) {
        this.isFlightInfo = isFlightInfo;
        this.airportId = airportId;
    }
    @Override
    public int compareTo(Object o) {
        if(isFlightInfo.compareTo(o.isFlightInfo) == 0) {
            return airportId.compareTo(o.airportId);
        } else {
            return isFlightInfo.equals(new BooleanWritable(true)) ? 1 : -1;
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
    public int compareTo(Object o) {
        return 0;
    }
}
