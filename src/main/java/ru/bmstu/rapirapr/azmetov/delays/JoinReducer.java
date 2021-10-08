package ru.bmstu.rapirapr.azmetov.delays;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Iterator;

public class JoinReducer extends Reducer<Text, Text, Text, Text> {
    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context) throws
            IOException, InterruptedException {
        Iterator<Text> iter = values.iterator();
        Text systemInfo = new Text(iter.next());
        context.write(key, new Text(""));
        while (iter.hasNext()) {
            Text call = iter.next();
            Text outValue = new Text(call.toString() + ":" + systemInfo.toString());
            context.write(call, outValue);
        }
    }
}