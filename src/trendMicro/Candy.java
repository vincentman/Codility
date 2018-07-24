/*
 * created on 2018年7月22日
 * 
 * $Author: Vincent $
 * $Revision: 1.0 $ 
 * $Date: 2018年7月22日 $
 */
package trendMicro;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset.Entry;

/**
 * requirements: 
 * time complexity => O(nlogn)
 * space complexity => 
 */
public class Candy {
    public int solution(int[] A) {
        int totalCount = A.length;
        HashMultiset<Integer> multiSet = HashMultiset.create();
        // add to multiSet: (type, count)
        for (Integer a : A) {
            multiSet.add(a);
        }
        // compute type count
        int typeCount = multiSet.entrySet().size();
        int canGivenCount = 0;
        // compute possibly given count 
        for (Entry<Integer> typeEntry : multiSet.entrySet()) {
            if (typeEntry.getCount() > 1) {
                canGivenCount += (typeEntry.getCount() - 1);
            }
        }
        if (canGivenCount >= totalCount / 2) {
            return typeCount;
        } else {
            return typeCount - (totalCount / 2 - canGivenCount);
        }
    }
}
