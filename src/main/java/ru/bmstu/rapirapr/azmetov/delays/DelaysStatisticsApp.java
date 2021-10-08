package ru.bmstu.rapirapr.azmetov.delays;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class DelaysStatisticsApp {
    public static final String jobName = "DelaysStatistics";

    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.err.println("Usage: ru.bmstu.rapirapr.azmetov.warandpeace.DelaysStatistics <input path> <output path>");
            System.exit(-1);
        }
        conf.setInputFormat(CompositeInputFormat.class);
        FileOutputFormat.setOutputPath(conf, new Path(args[2]));
        conf.set("mapred.join.expr", CompositeInputFormat.compose("inner",
                KeyValueTextInputFormat.class,
                args[0],
                args[1]
        ));

        conf.setMapperClass(MapJoinMapper.class);
        conf.setOutputKeyClass(Text.class);
        conf.setOutputValueClass(Text.class);
        JobClient.runJob(conf);
    }
}