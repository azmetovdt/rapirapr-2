package ru.bmstu.rapirapr.azmetov.delays;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Iterator;

public class JoinReducer extends Reducer<Text, Text, Text, Text> {
    @Override
    protected void reduce(KeyWritable key, Iterable<Text> values, Context context) throws
            IOException, InterruptedException {
        Iterator<Text> valuesIterator = values.iterator();
        Text firstInfoPiece = new Text(valuesIterator.next());
        String outValue = firstInfoPiece.toString();
        while (valuesIterator.hasNext()) {
            Text infoPiece = valuesIterator.next();
            if (infoPiece.getLength() > 0 && infoPiece.toString() != "0.00")
            outValue = outValue + "|" + infoPiece;
        }
        context.write(key.airportId, new Text(outValue));

    }
}