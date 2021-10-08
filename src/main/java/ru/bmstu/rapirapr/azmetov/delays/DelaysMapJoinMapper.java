package ru.bmstu.rapirapr.azmetov.delays;


import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;
import org.apache.hadoop.mapred.join.TupleWritable;

import java.io.IOException;

public class DelaysMapJoinMapper extends MapReduceBase implements Mapper<Text, TupleWritable, Text, Text> {
    @Override
    public void map(Text key, TupleWritable value, OutputCollector<Text, Text> output,
                    Reporter reporter) throws IOException {
        String data = value.toString();
        System.out.println(data);
        output.collect(value);
    }

}