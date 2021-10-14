package ru.bmstu.rapirapr.azmetov.delays;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Iterator;

public class JoinReducer extends Reducer<KeyWritable, Text, Text, Text> {
    @Override
    protected void reduce(KeyWritable key, Iterable<Text> values, Context context) throws
            IOException, InterruptedException {
        Iterator<Text> valuesIterator = values.iterator();
        Text airportName = valuesIterator.next();
        float minDelay = 0, maxDelay = Float.MAX_VALUE, sumDelay = 0;
        int counter = 0;
        while (valuesIterator.hasNext()) {
            if (Float.pa)
            float delay = Float.parseFloat(valuesIterator.next().toString());
            minDelay = Math.min(minDelay, delay);
            maxDelay = Math.max(maxDelay, delay);
            sumDelay += delay;
            counter++;
        }

        if (counter > 0) {
            float averageDelay = sumDelay / counter;
            String outValue = String.format("%s %s %s %s", airportName, minDelay, maxDelay, averageDelay);
            context.write(new Text(key.airportId), new Text(outValue));
        }

    }
}