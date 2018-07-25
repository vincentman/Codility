/*
 * created on 2018年7月23日
 * 
 * $Author: Vincent $
 * $Revision: 1.0 $ 
 * $Date: 2018年7月23日 $
 */
package trendMicro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * Don't care time and space complexity
 * 
 * Has two points in one two dimension coordinate, compute max square distance
 * (x1 - x2)^2 + (y1 - y2)^2
 */
public class TwoPointsMaxDistance {
    public int solution(int A, int B, int C, int D) {
        List<List<List<Integer>>> twoPointCombinations = getTwoPointCombinations(A, B, C, D);

        List<Integer> distances = Lists.newArrayList();
        for (List<List<Integer>> twoPoint : twoPointCombinations) {
            List<Integer> point1 = twoPoint.get(0);
            List<Integer> point2 = twoPoint.get(1);
            final Integer x1 = point1.get(0);
            final Integer x2 = point2.get(0);
            final Integer y1 = point1.get(1);
            final Integer y2 = point2.get(1);
            int square1 = (int) Math
                    .pow(x1.intValue() - x2.intValue(), 2);
            int square2 = (int) Math
                    .pow(y1.intValue() - y2.intValue(), 2);
            distances.add(square1 + square2);
        }
        
        return Collections.max(distances).intValue();
    }

    List<List<List<Integer>>> getTwoPointCombinations(int A, int B, int C,
            int D) {
        Set<List<List<Integer>>> twoPointSet = new HashSet<List<List<Integer>>>();
        // two point (x1,y1) and (x2,y2), combinations: (A,B) (C,D)
        twoPointSet.add(getTwoPoint(A, B, C, D));
        twoPointSet.add(getTwoPoint(A, B, D, C));
        twoPointSet.add(getTwoPoint(B, A, C, D));
        twoPointSet.add(getTwoPoint(B, A, D, C));
        // two point (x1,y1) and (x2,y2), combinations: (A,C) (B,D)
        twoPointSet.add(getTwoPoint(A, C, B, D));
        twoPointSet.add(getTwoPoint(A, C, D, B));
        twoPointSet.add(getTwoPoint(C, A, B, D));
        twoPointSet.add(getTwoPoint(C, A, D, B));
        // two point (x1,y1) and (x2,y2), combinations: (A,D) (B,C)
        twoPointSet.add(getTwoPoint(A, D, B, C));
        twoPointSet.add(getTwoPoint(A, D, C, B));
        twoPointSet.add(getTwoPoint(D, A, B, C));
        twoPointSet.add(getTwoPoint(D, A, C, B));

        return new ArrayList<List<List<Integer>>>(twoPointSet);
    }

    private List<List<Integer>> getTwoPoint(int x1, int y1, int x2, int y2) {
        List<List<Integer>> twoPoint = new ArrayList<List<Integer>>();
        List<Integer> point = new ArrayList<Integer>();
        point.add(x1);
        point.add(y1);
        twoPoint.add(point);
        point = new ArrayList<Integer>();
        point.add(x2);
        point.add(y2);
        twoPoint.add(point);

        return twoPoint;
    }
}
