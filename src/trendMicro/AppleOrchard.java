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
import java.util.List;
import java.util.stream.Collectors;

public class AppleOrchard {
    public int solution(int[] A, int K, int L) {
        int inputLength = A.length;
        List<Integer> consecutiveIndexList = new ArrayList<Integer>();
        for (int i = 0; i < inputLength; i++) {
            consecutiveIndexList.add(i);
        }
        List<List<Integer>> aliceIndices = getConsecutivePositions(
                consecutiveIndexList, K);
        List<Integer> allSumOfAliceAndBob = new ArrayList<Integer>();
        for (List<Integer> aliceIndex : aliceIndices) {
            Integer maxIndex = aliceIndex.get(aliceIndex.size() - 1);
            List<Integer> largerPart = consecutiveIndexList.stream()
                    .filter(idx -> idx > maxIndex).collect(Collectors.toList());
            List<List<Integer>> largerIndicesForBob = getConsecutivePositions(
                    largerPart, L);
            Integer minIndex = aliceIndex.get(0);
            List<Integer> smallerPart = consecutiveIndexList.stream()
                    .filter(idx -> idx < minIndex).collect(Collectors.toList());
            List<List<Integer>> smallerIndicesForBob = getConsecutivePositions(
                    smallerPart, L);
            int aliceNum = 0;
            for (int i = 0; i < aliceIndex.size(); i++) {
                aliceNum += A[aliceIndex.get(i)];
            }
            System.out.println("Alice index: " + aliceIndex);
            System.out.println("Alice sum: " + aliceNum);
            if (largerIndicesForBob.isEmpty()
                    && smallerIndicesForBob.isEmpty()) {
                continue;
            }
            int bobNum = 0;
            for (int i = 0; i < largerIndicesForBob.size(); i++) {
                bobNum = 0;
                for (int j = 0; j < largerIndicesForBob.get(i).size(); j++) {
                    bobNum += A[largerIndicesForBob.get(i).get(j)];
                }
                System.out.println("Bob index: " + largerIndicesForBob.get(i));
                System.out.println("Bob sum: " + bobNum);
                final int sumOfAliceAndBob = aliceNum + bobNum;
                System.out.println("Sum of Alice and Bob: " + sumOfAliceAndBob);
                allSumOfAliceAndBob.add(sumOfAliceAndBob);
            }
            for (int i = 0; i < smallerIndicesForBob.size(); i++) {
                bobNum = 0;
                for (int j = 0; j < smallerIndicesForBob.get(i).size(); j++) {
                    bobNum += A[smallerIndicesForBob.get(i).get(j)];
                }
                System.out.println("Bob index: " + smallerIndicesForBob.get(i));
                System.out.println("Bob sum: " + bobNum);
                final int sumOfAliceAndBob = aliceNum + bobNum;
                System.out.println("Sum of Alice and Bob: " + sumOfAliceAndBob);
                allSumOfAliceAndBob.add(sumOfAliceAndBob);
            }
        }

        System.out.println("Possible sum: " + allSumOfAliceAndBob);
        return allSumOfAliceAndBob.isEmpty() ? -1
                : Collections.max(allSumOfAliceAndBob).intValue();
    }

    List<List<Integer>> getConsecutivePositions(List<Integer> positions,
            int n) {
        if (positions.size() < n) {
            return new ArrayList<List<Integer>>();
        }
        int size = positions.size();
        List<List<Integer>> outer = new ArrayList<List<Integer>>();
        for (int i = 0; i < size - n + 1; i++) {
            List<Integer> inner = new ArrayList<Integer>();
            for (int j = i; j < i + n; j++) {
                inner.add(positions.get(j));
            }
            outer.add(inner);
        }
        return outer;
    }
}
