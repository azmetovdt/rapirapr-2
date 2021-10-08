package ru.bmstu.rapirapr.azmetov.delays;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class DelaysMapJoinMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
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
