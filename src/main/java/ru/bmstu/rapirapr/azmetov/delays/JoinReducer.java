package ru.bmstu.rapirapr.azmetov.delays;

import org.apache.commons.lang.StringUtils;
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
            float delay = Float.parseFloat(valuesIterator.next().toString());
            
            if (!StringUtils.isBlank(infoPiece.toString()))
                outValue = outValue + "|" + infoPiece;
        }
        if(!StringUtils.isBlank(outValue)) {

            context.write(new Text(key.airportId), new Text(outValue));
        }

    }
}