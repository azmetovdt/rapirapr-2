package ru.bmstu.rapirapr.azmetov.delays;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class CSVWritable implements Writable {
    private static Text code;
    private static Text airportName;

    public CSVWritable(Text text) {

    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        code.write(dataOutput);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        code.readFields(dataInput);
    }
}
