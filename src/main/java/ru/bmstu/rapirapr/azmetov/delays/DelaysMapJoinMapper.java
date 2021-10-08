package ru.bmstu.rapirapr.azmetov.delays;


import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

import java.io.IOException;

public class DelaysMapJoinMapper extends MapReduceBase implements Mapper<Text, Text, Text, Text> {
    @Override
    public void map(Text key, Text value, OutputCollector<Text, Text> output, Reporter reporter) throws IOException {
        Text a = (Text) value;
        Text b = (Text) value;
        output.collect(a, b);
    }

}