package ru.bmstu.rapirapr.azmetov.delays;


import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;
import org.apache.hadoop.mapred.join.TupleWritable;

import java.io.IOException;
import java.util.Arrays;

public class DelaysMapJoinMapper extends MapReduceBase implements Mapper<Text, TupleWritable, Text, Text> {
    @Override
    public void map(Text key, TupleWritable v, OutputCollector<Text, Text> output, Reporter reporter) throws IOException {
        String value = "";
        if (key.toString().charAt(0) == '"') {
            value = key.toString().split(",")[1];
        } else if (key.toString().split(",").length >)
        Text value = new Text(
                key.toString().charAt(0) == '"' ?
                key.toString().split(",")[1] :
                        Arrays.toString(key.toString().split(","))
        );

        output.collect(value, value);
    }

}