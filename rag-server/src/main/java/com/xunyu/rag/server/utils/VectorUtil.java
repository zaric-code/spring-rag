package com.xunyu.rag.server.utils;

import java.util.List;

public class VectorUtil {

    public static Float[] toFloatArray(List<Double> vector) {
        Float[] result = new Float[vector.size()];
        for (int i = 0; i < vector.size(); i++) {
            result[i] = vector.get(i).floatValue();
        }
        return result;
    }

}
