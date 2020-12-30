package com.cyq.es.plugin;

import java.util.List;

/**
 * @author chaiyongqiang
 * @date 2020-12-22 18:21
 */
public class CosineDistanceComputer {
    public static double getScore(List<Double> inputVector, double[] docVector) {
        if (inputVector.size() != docVector.length) {
            return 0.0d;
        }

        double resultScore;
        double mulResult = 0.0d;
        double sumA = 0.0d;
        double sumB = 0.0d;
        for (int i = 0; i < inputVector.size(); i++) {
            Double x = inputVector.get(i);
            Double y = docVector[i];
            mulResult += x * y;
            sumA += x * x;
            sumB += y * y;
        }

        if (sumA == 0.0 || sumB == 0.0){
            return 0.0;
        }
        resultScore = mulResult / Math.sqrt(sumA * sumB);

        if (resultScore < 0){
            return ( resultScore + 1 ) / 2;
        }
        return resultScore;
    }
}
