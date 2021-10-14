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
