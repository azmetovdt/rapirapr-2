package ru.bmstu.rapirapr.azmetov.delays;

import org.apache.hadoop.mapreduce.Partitioner;

public class HashPartitioner<K, V> extends Partitioner<K, V> {
    protected 
    public int getPartition(K key, V value, int numReduceTasks) {
        return (key.hashCode() & Integer.MAX_VALUE) % numReduceTasks;
    }
}