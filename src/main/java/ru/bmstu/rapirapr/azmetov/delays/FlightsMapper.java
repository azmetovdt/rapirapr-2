package ru.bmstu.rapirapr.azmetov.delays;

import java.io.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;

public class WordMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
    public static final String regex = "[^\\w-\\sа-я]";
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
    String line = value.toString();
    String[] words = line.replaceAll(regex,"").toLowerCase().split(" ");
    for (String word : words) {
        context.write(new Text(word), new IntWritable(1));
        }
    }
}
