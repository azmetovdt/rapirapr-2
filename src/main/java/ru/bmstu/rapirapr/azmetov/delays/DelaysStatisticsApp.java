package ru.bmstu.rapirapr.azmetov.delays;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.KeyValueTextInputFormat;
import org.apache.hadoop.mapred.join.CompositeInputFormat;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class DelaysStatisticsApp {
    public static void main(String[] args) throws Exception {
        if (args.length != 3) {
            System.err.println("Usage: ru.bmstu.rapirapr.azmetov.warandpeace.DelaysStatistics <input1 path> <input2 path> <output path>");
            System.exit(-1);
        }

        JobConf conf = new JobConf(DelaysStatisticsApp.class);
        Job job = Job.getInstance(conf);

        conf.setInputFormat(CompositeInputFormat.class);
        FileOutputFormat.setOutputPath(job, new Path(args[2]));
        conf.set("mapred.join.expr", CompositeInputFormat.compose("inner",
                KeyValueTextInputFormat.class,
                args[0],
                args[1]
        ));

        conf.setMapperClass(DelaysMapJoinMapper.class);
        conf.setOutputKeyClass(Text.class);
        conf.setOutputValueClass(Text.class);
        JobClient.runJob(conf);
    }
}