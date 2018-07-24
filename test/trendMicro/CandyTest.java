/*
 * created on 2018年7月22日
 * 
 * $Author: Vincent $
 * $Revision: 1.0 $ 
 * $Date: 2018年7月22日 $
 */
package trendMicro;

import static org.junit.Assert.*;

import org.junit.Test;

public class CandyTest {

    @Test
    public void testSolution() throws Exception {
        assertTrue(new Candy().solution(new int[] { 3, 3, 2, 5, 7, 9 }) == 3);
        assertTrue(new Candy()
                .solution(new int[] { 2, 2, 2, 5, 5, 5, 9, 9, 9, 10 }) == 4);
    }

}
