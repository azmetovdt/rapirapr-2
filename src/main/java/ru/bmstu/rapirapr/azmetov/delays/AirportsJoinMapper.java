package ru.bmstu.rapirapr.azmetov.delays;


import org.apache.hadoop.io.BooleanWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.join.TupleWritable;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class AirportsJoinMapper extends Mapper<LongWritable, Text, Text, Text> {
    @Override
    public void map(LongWritable key, Text value, Context context) throws IOException {
        String[] csvColumns = value.toString().split(",", 1);
        context.write(new KeyWritable(new Text(csvColumns[0]), new BooleanWritable(true)), new AirportWritable(csvColumns[1]));
    }
       /* String value = "";
        String airportCode = "";
        if (key.toString().charAt(0) == '"') {
            value = key.toString().split(",")[1];
        } else if (key.toString().split(",").length > 18) {
            airportCode = key.toString().split(",")[13];
            value =  key.toString().split(",")[18];

        } else {
            value =  key.toString();
        }

        output.collect(new Text(airportCode), new Text(value));
    }
 */
}