package ru.bmstu.rapirapr.azmetov.delays;


import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class AirportsJoinMapper extends Mapper<LongWritable, Text, KeyWritable, Text> {
    public static final int AIRPORT_ID_COL_NUMBER = 0;
    public static final int AIRPORT_NAME_COL_NUMBER = 1;
    public static final String COLUMNS_DELIMITER = ",";
    public static final String QUOTE_SYMBOLS_REGEX = "\"";

    @Override
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] csvColumns = value.toString().split(COLUMNS_DELIMITER, 2);
        if (!key.equals(new LongWritable(0))) {
            context.write(
                    new KeyWritable(trimQuotationMark(csvColumns[AIRPORT_ID_COL_NUMBER]), false),
                    new AirportWritable(csvColumns[AIRPORT_NAME_COL_NUMBER]).airportName
            );
        }
    }

    private String trimQuotationMark(String s) {
        return s.replaceAll(QUOTE_SYMBOLS_REGEX, "");
    }
}