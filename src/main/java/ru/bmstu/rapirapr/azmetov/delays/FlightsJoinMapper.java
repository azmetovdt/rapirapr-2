package ru.bmstu.rapirapr.azmetov.delays;


import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class FlightsJoinMapper extends Mapper<LongWritable, Text, KeyWritable, Text> {
    @Override
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] csvColumns = value.toString().split(",");
        String delay = csvColumns[14];
        if (delay != "0.00" && !StringUtils.isBlank(delay)) {
            context.write(new KeyWritable(delay, true), new FlightWritable(csvColumns[18]).delay);
        }
    }
}