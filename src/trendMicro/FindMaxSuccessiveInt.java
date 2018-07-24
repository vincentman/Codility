/*
 * created on 2018年7月22日
 * 
 * $Author: Vincent $
 * $Revision: 1.0 $ 
 * $Date: 2018年7月22日 $
 */
package trendMicro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * requirements: 
 * @return larger than zero
 * time complexity => O(n)
 * space complexity => O(n)
 */
public class FindMaxSuccessiveInt {
    public int solution(int[] A) {
        List<Integer> aList = new ArrayList<Integer>();
        for (int i = 0; i < A.length; i++) {
            if (A[i] > 0) {
                aList.add(A[i]);
            }
        }
        if (aList.isEmpty()) return 1;
        Integer max = Collections.max(aList);
        int[] a = new int[max];
        for (int i = 0; i < aList.size(); i++) {
            int idx = aList.get(i);
            a[idx - 1] = idx;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0) {
                return i + 1;
            }
        }
        return max + 1;
    }
}
