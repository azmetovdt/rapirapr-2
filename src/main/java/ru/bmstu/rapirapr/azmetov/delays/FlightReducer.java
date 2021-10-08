package ru.bmstu.rapirapr.azmetov.delays;

import java.io.*;
import java.util.Iterator;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;

public class WordReducer extends Reducer<Text, IntWritable, Text, LongWritable> {
    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws
    IOException, InterruptedException {
        long count=0;
        Iterator iter = values.iterator();
        while(iter.hasNext()) {
            iter.next();
            count++;
        }
        context.write(key, new LongWritable(count));
    }
}