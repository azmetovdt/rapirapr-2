package ru.bmstu.rapirapr.azmetov.aeroports;


public class WordCountApp {
    public static final String jobName = "Word count";

    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.err.println("Usage: ru.bmstu.rapirapr.azmetov.warandpeace.WordCountApp <input path> <output path>");
            System.exit(-1);
        }
        Job job = Job.getInstance();
        job.setJarByClass(WordCountApp.class);
        job.setJobName(jobName);
        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));
        job.setMapperClass(WordMapper.class);
        job.setReducerClass(WordReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        job.setNumReduceTasks(2);
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}