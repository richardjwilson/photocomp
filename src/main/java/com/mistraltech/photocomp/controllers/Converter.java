package com.mistraltech.photocomp.controllers;

public interface Converter<S, T> {
    T convert(S source);
}
