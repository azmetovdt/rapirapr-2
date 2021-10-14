package ru.bmstu.rapirapr.azmetov.delays;


import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class FlightsJoinMapper extends Mapper<LongWritable, Text, KeyWritable, Text> {
    @Override
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] csvColumns = value.toString().split(",");
        if 
        context.write(new KeyWritable(csvColumns[14],true), new FlightWritable(csvColumns[18]).delay);
    }
}