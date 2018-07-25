/*
 * created on 2018年7月23日
 * 
 * $Author: Vincent $
 * $Revision: 1.0 $ 
 * $Date: 2018年7月23日 $
 */
package trendMicro;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.google.common.collect.Lists;

public class TwoPointsMaxDistanceTest {

    @Test
    public void testSolution() throws Exception {
        assertTrue(new TwoPointsMaxDistance().solution(1, 1, 2, 3) == 5);
        assertTrue(new TwoPointsMaxDistance().solution(1, 2, 3, 4) == 10);
    }

    @Test
        public void testGetTwoPointCombinations() throws Exception {
            final List<List<List<Integer>>> ret = new TwoPointsMaxDistance()
                    .getTwoPointCombinations(1, 1, 2, 3);
            assertTrue(ret.size() == 10);
            List<ArrayList<Integer>> twoPoint1 = Lists.newArrayList(
                    Lists.newArrayList(1, 1), Lists.newArrayList(2, 3));
            List<ArrayList<Integer>> twoPoint2 = Lists.newArrayList(
                    Lists.newArrayList(1, 1), Lists.newArrayList(3, 2));
            List<ArrayList<Integer>> twoPoint3 = Lists.newArrayList(
                    Lists.newArrayList(1, 2), Lists.newArrayList(1, 3));
            List<ArrayList<Integer>> twoPoint4 = Lists.newArrayList(
                    Lists.newArrayList(1, 2), Lists.newArrayList(3, 1));
            List<ArrayList<Integer>> twoPoint5 = Lists.newArrayList(
                    Lists.newArrayList(2, 1), Lists.newArrayList(1, 3));
            List<ArrayList<Integer>> twoPoint6 = Lists.newArrayList(
                    Lists.newArrayList(2, 1), Lists.newArrayList(3, 1));
            List<ArrayList<Integer>> twoPoint7 = Lists.newArrayList(
                    Lists.newArrayList(1, 3), Lists.newArrayList(1, 2));
            List<ArrayList<Integer>> twoPoint8 = Lists.newArrayList(
                    Lists.newArrayList(1, 3), Lists.newArrayList(2, 1));
            List<ArrayList<Integer>> twoPoint9 = Lists.newArrayList(
                    Lists.newArrayList(3, 1), Lists.newArrayList(1, 2));
            List<ArrayList<Integer>> twoPoint10 = Lists.newArrayList(
                    Lists.newArrayList(3, 1), Lists.newArrayList(2, 1));
            ret.containsAll(Lists.newArrayList(twoPoint1, twoPoint2, twoPoint3,
                    twoPoint4, twoPoint5, twoPoint6, twoPoint7, twoPoint8,
                    twoPoint9, twoPoint10));
        }

}
