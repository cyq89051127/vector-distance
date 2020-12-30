package com.cyq.es.plugin;

import java.util.List;

/**
 * @author chaiyongqiang
 * @date 2020-12-22 14:26
 */
public class EuclideanDistanceComputer {
    public static double getScore(List<Double> inputVector, double[] docVector){
        if (inputVector.size() != docVector.length){
            return 0.0d;
        }

        double resultScore = 0.0d;
        for (int i=0; i < inputVector.size(); i++){
            Double x = inputVector.get(i);
            Double y = docVector[i];
            resultScore +=  Math.pow((x-y), 2);
        }
        // Elasticsearch的score不能为负数
        return Math.sqrt(resultScore);
    }
}
