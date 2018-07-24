/*
 * created on 2018年7月23日
 * 
 * $Author: Vincent $
 * $Revision: 1.0 $ 
 * $Date: 2018年7月23日 $
 */
package trendMicro;

import static org.junit.Assert.*;

import org.junit.Test;

public class TwoPointsMaxDistanceTest {

    @Test
    public void testSolution() throws Exception {
        assertTrue(new TwoPointsMaxDistance().solution(1, 1, 2, 3)==5);
    }
    

}
