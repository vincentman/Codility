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

public class FindMaxSuccessiveIntTest {

    @Test
    public void testSolution() throws Exception {
        assertTrue(new FindMaxSuccessiveInt()
                .solution(new int[] { 1, 5, 2, 10, 3 }) == 4);
        assertTrue(new FindMaxSuccessiveInt()
                .solution(new int[] { -100, 0, -10 }) == 1);
        assertTrue(new FindMaxSuccessiveInt()
                .solution(new int[] { -10, 10, 1, 3, 4, 6 }) == 2);
        assertTrue(new FindMaxSuccessiveInt()
                .solution(new int[] { 1, 2, 3, 4 }) == 5);
    }

}
