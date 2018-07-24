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
        // write your code in Java SE 8
        List<Integer> inputList = Lists.newArrayList(A, B, C, D);
        List<Integer> combinationAB = Lists.newArrayList(A, B);
        List<Integer> combinationBA = Lists.newArrayList(B, A);
        List<Integer> combinationAC = Lists.newArrayList(A, C);
        List<Integer> combinationCA = Lists.newArrayList(C, A);
        List<Integer> combinationAD = Lists.newArrayList(A, D);
        List<Integer> combinationDA = Lists.newArrayList(D, A);
        List<Integer> combinationBC = Lists.newArrayList(B, C);
        List<Integer> combinationCB = Lists.newArrayList(C, B);
        List<Integer> combinationBD = Lists.newArrayList(B, D);
        List<Integer> combinationDB = Lists.newArrayList(D, B);
        List<Integer> combinationCD = Lists.newArrayList(C, D);
        List<Integer> combinationDC = Lists.newArrayList(D, C);

        HashSet<List<Integer>> combinationSet = Sets.newHashSet(combinationAB,
                combinationBA, combinationAC, combinationCA, combinationAD,
                combinationDA, combinationBC, combinationCB, combinationBD,
                combinationDB, combinationCD, combinationDC);
        List<List<Integer>> combinationList = new ArrayList<>(combinationSet);

        List<Integer> distances = Lists.newArrayList();
        for (int i = 0; i < combinationList.size() - 1; i++) {
            for (int j = i + 1; j <= combinationList.size() - 1; j++) {
                List<Integer> a = combinationList.get(i);
                List<Integer> b = combinationList.get(j);
                int square1 = (int) Math
                        .pow(a.get(0).intValue() - b.get(0).intValue(), 2);
                int square2 = (int) Math
                        .pow(a.get(1).intValue() - b.get(1).intValue(), 2);
                distances.add(square1 + square2);
                System.out.println(String.format(
                        "a1=%d,b1=%d,a2=%d,b2=%d,sum=%d", a.get(0), b.get(0),
                        a.get(1), b.get(1), square1 + square2));
            }
        }
        return Collections.max(distances).intValue();
    }

    private List<List<List<Integer>>> getCombinations(int A, int B, int C,
            int D) {
        Set<List<List<Integer>>> twoPointSet = new HashSet<List<List<Integer>>>();
        // part 1
        List<List<Integer>> twoPoint = new ArrayList<List<Integer>>();
        List<Integer> point = new ArrayList<Integer>();
        point.add(A);
        point.add(B);
        twoPoint.add(point);
        point = new ArrayList<Integer>();
        point.add(C);
        point.add(D);
        twoPoint.add(point);
        twoPointSet.add(twoPoint);

        return new ArrayList<List<List<Integer>>>(twoPointSet);
    }
}
