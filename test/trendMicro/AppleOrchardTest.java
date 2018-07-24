/*
 * created on 2018年7月23日
 * 
 * $Author: Vincent $
 * $Revision: 1.0 $ 
 * $Date: 2018年7月23日 $
 */
package trendMicro;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.google.common.collect.Lists;

public class AppleOrchardTest {

    @Test
    public void testSolution() throws Exception {
        assertTrue(
                new AppleOrchard().solution(new int[] { 3, 7, 9 }, 2, 2) == -1);
        assertTrue(new AppleOrchard()
                .solution(new int[] { 6, 1, 4, 6, 3, 2, 7, 4 }, 3, 2) == 24);
        assertTrue(new AppleOrchard()
                .solution(new int[] { 3, 1, 4, 6 }, 2, 2) == 14);
        assertTrue(new AppleOrchard()
                .solution(new int[] { 3, 1, 4, 6 }, 2, 1) == 13);
    }

    @Test
    public void testGetConsecutivePositions() throws Exception {
        List<List<Integer>> a = new AppleOrchard()
                .getConsecutivePositions(Lists.newArrayList(1, 2, 3, 4), 2);
        System.out.println(a);
        a = new AppleOrchard()
                .getConsecutivePositions(Lists.newArrayList(1, 2, 3, 4), 3);
        System.out.println(a);
        a = new AppleOrchard()
                .getConsecutivePositions(Lists.newArrayList(5, 6, 7), 2);
        System.out.println(a);
        a = new AppleOrchard()
                .getConsecutivePositions(Lists.newArrayList(5, 6, 7), 4);
        System.out.println(a);

    }

}
