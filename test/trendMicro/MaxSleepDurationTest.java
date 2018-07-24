/*
 * created on 2018年7月20日
 * 
 * $Author: Vincent $
 * $Revision: 1.0 $ 
 * $Date: 2018年7月20日 $
 */
package trendMicro;

import static org.junit.Assert.assertTrue;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import trendMicro.MaxSleepDuration;

public class MaxSleepDurationTest {

    @Test
    public void testSolution() throws Exception {
        StringBuilder schedule = new StringBuilder();
        //case 1
        schedule.append("Mon 10:00-17:30\n");
        schedule.append("Wed 05:00-07:30\n");
        schedule.append("Wed 23:00-23:50\n");
        schedule.append("Thu 03:00-07:00\n");
        schedule.append("Sun 18:00-22:00\n");
        assertTrue(new MaxSleepDuration().solution(schedule.toString()) == 4980);
        
        //case 2
        schedule = new StringBuilder();
        schedule.append("Wed 07:00-08:00\n");
        schedule.append("Fri 07:00-08:00\n");
        assertTrue(new MaxSleepDuration().solution(schedule.toString()) == 3840);
    }
}
