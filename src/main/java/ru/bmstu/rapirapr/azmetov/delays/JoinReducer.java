package ru.bmstu.rapirapr.azmetov.delays;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Iterator;

public class JoinReducer extends Reducer<Text, Text, Text, Text> {
    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context) throws
            IOException, InterruptedException {
        Iterator<Text> valuesIterator = values.iterator();
        Text firstInfoPiece = new Text(valuesIterator.next());
        Text outValue = firstInfoPiece;
        while (valuesIterator.hasNext()) {
            Text infoPiece = valuesIterator.next();
            outValue = outValue.append(new Text("|" + infoPiece.toString()));
        }
        context.write(key, outValue);

    }
}