package com.common.base;


import com.common.dto.QuarkResult;

@FunctionalInterface
public interface ResultProcessor {
    QuarkResult process();
}
