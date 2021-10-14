package ru.bmstu.rapirapr.azmetov.delays;


import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.join.TupleWritable;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class AirportsJoinMapper extends Mapper<LongWritable, Text, Text, Text> {
    @Override
    public void map(LongWritable key, Text value, Context context) throws IOException {
        context.write(new KeyWritable());
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