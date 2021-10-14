package ru.bmstu.rapirapr.azmetov.delays;


import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class FlightsJoinMapper extends Mapper<LongWritable, Text, KeyWritable, Text> {
    @Override
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] csvColumns = value.toString().split(",");
        context.write(new KeyWritable(csvColumns[0],true), new FlightWritable(csvColumns[18]).delay);
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