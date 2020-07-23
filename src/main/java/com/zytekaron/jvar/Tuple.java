package com.zytekaron.jvar;

public class Tuple<T, U> {
    private T first;
    private U second;
    
    public Tuple(T weight, U result) {
        this.first = weight;
        this.second = result;
    }
    
    public T getFirst() {
        return first;
    }
    
    public U getSecond() {
        return second;
    }
}