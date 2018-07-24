/*
 * created on 2018年7月20日
 * 
 * $Author: Vincent $
 * $Revision: 1.0 $ 
 * $Date: 2018年7月20日 $
 */
package trendMicro;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxSleepDuration {
    private static final String midnight0 = "00:00";

    private static final String midnight24 = "24:00";

    private static final Map<String, Integer> dayNumber = new HashMap<String, Integer>();

    private class Meeting {
        String day;

        String beginTime;

        String endTime;

        Meeting(String day, String beginTime, String endTime) {
            this.day = day;
            this.beginTime = beginTime;
            this.endTime = endTime;
        }
    }

    public int solution(String schedule) throws ParseException {
        ArrayList<Meeting> meetings = new ArrayList<Meeting>();
//        String[] schedules = StringUtils.split(schedule, "\n");
        String[] schedules = schedule.split("\n");
        for (String oneMeeting : schedules) {
//            String meetingDay = StringUtils.split(oneMeeting, " ")[0];
            String meetingDay = oneMeeting.split(" ")[0];
//            String meetingTime = StringUtils.split(oneMeeting, " ")[1];
            String meetingTime = oneMeeting.split(" ")[1];
//            String meetingBeginTime = StringUtils.split(meetingTime, "-")[0];
            String meetingBeginTime = meetingTime.split("-")[0];
//            String meetingEndTime = StringUtils.split(meetingTime, "-")[1];
            String meetingEndTime = meetingTime.split( "-")[1];
            meetings.add(
                    new Meeting(meetingDay, meetingBeginTime, meetingEndTime));
        }

        List<Long> sleepMinutes = new ArrayList<Long>();
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        for (int i = 0; i < meetings.size(); i++) {
            // 1. compute difference between current and previous meeting
            if (i == 0) { // first day
                if (meetings.get(i).day.equals("Mon")) { // Monday
                    Date time1 = format.parse(midnight0);
                    Date time2 = format.parse(meetings.get(0).beginTime);
                    long diff = (time2.getTime() - time1.getTime()) / 60000;
                    sleepMinutes.add(diff);
                } else { // not Monday
                    Date time1 = format.parse(midnight0);
                    Date time2 = format.parse(meetings.get(i).beginTime);
                    long diff1 = (time2.getTime() - time1.getTime()) / 60000;
                    Integer currDayNum = dayNumber.get(meetings.get(i).day);
                    Integer MondayNum = dayNumber.get("Mon");
                    long diff2 = (currDayNum - MondayNum) * 24 * 60;
                    sleepMinutes.add(diff1 + diff2);
                }

            } else if (!meetings.get(i).day.equals(meetings.get(i - 1).day)) {
                // previous and current meeting day are not the same
                Date time1 = format.parse(midnight0);
                Date time2 = format.parse(meetings.get(i).beginTime);
                long diff1 = (time2.getTime() - time1.getTime()) / 60000;
                Integer preDayNum = dayNumber.get(meetings.get(i - 1).day);
                Integer currDayNum = dayNumber.get(meetings.get(i).day);
                long diff2 = (currDayNum - preDayNum - 1) * 24 * 60;
                Date time3 = format.parse(meetings.get(i - 1).endTime);
                Date time4 = format.parse(midnight24);
                long diff3 = (time4.getTime() - time3.getTime()) / 60000;
                sleepMinutes.add(diff1 + diff2 + diff3);
            } else {
                // previous and current meeting day are not the same
                Date time1 = format.parse(meetings.get(i - 1).endTime);
                Date time2 = format.parse(meetings.get(i).beginTime);
                long diff = (time2.getTime() - time1.getTime()) / 60000;
                sleepMinutes.add(diff);
            }

            // 2. compute difference between last meeting and Sun 24:00
            if (i == (meetings.size() - 1)) { // last day
                if (meetings.get(i).day.equals("Sun")) { // Sunday
                    Date time1 = format.parse(meetings.get(i).endTime);
                    Date time2 = format.parse(midnight24);
                    long diff = (time2.getTime() - time1.getTime()) / 60000;
                    sleepMinutes.add(diff);
                } else { // not Sunday
                    Date time1 = format.parse(meetings.get(i).endTime);
                    Date time2 = format.parse(midnight24);
                    long diff1 = (time2.getTime() - time1.getTime()) / 60000;
                    Integer currDayNum = dayNumber.get(meetings.get(i).day);
                    Integer SundayNum = dayNumber.get("Sun");
                    long diff2 = (SundayNum - currDayNum) * 24 * 60;
                    sleepMinutes.add(diff1 + diff2);
                }
            }
        }

        System.out.println("mins: " + sleepMinutes);
        return Collections.max(sleepMinutes).intValue();
    }

    public MaxSleepDuration() {
        dayNumber.put("Mon", 1);
        dayNumber.put("Tue", 2);
        dayNumber.put("Wed", 3);
        dayNumber.put("Thu", 4);
        dayNumber.put("Fri", 5);
        dayNumber.put("Sat", 6);
        dayNumber.put("Sun", 7);
    }

}
