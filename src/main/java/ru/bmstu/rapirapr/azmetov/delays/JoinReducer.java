package ru.bmstu.rapirapr.azmetov.delays;

import org.apache.commons.lang3.math.NumberUtils;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Iterator;

public class JoinReducer extends Reducer<KeyWritable, Text, Text, Text> {
    @Override
    protected void reduce(KeyWritable key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        Iterator<Text> valuesIterator = values.iterator();
        String airportName = "";
        int counter = 0;
        float minDelay = Float.MAX_VALUE, maxDelay = 0, sumDelay = 0;

        while (valuesIterator.hasNext()) {
            String value = valuesIterator.next().toString();
            if (!NumberUtils.isParsable(value)) {
                airportName = value; 
            } else {
                float delay = Float.parseFloat(value);
                minDelay = Math.min(minDelay, delay);
                maxDelay = Math.max(maxDelay, delay);
                sumDelay += delay;
                counter++;
            }
        }

        if (counter > 0) {
            float averageDelay = sumDelay / counter;
            String outValue = String.format("%s %s %s %s", airportName, minDelay, maxDelay, averageDelay);
            context.write(new Text(key.airportId), new Text(outValue));
        }

    }
}