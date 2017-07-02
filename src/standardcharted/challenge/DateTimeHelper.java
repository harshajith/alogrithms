package standardcharted.challenge;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Harsha on 9/5/17.
 */
public class DateTimeHelper {


    public static List<Date> getValidNextDates(Date currentDate) {

        List<Date> validDates = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);

        if(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY){
            addOneDay(validDates, calendar, 1);
            addOneDay(validDates, calendar, 1);
            addOneDay(validDates, calendar, 1);
        }else if(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY){
            addOneDay(validDates, calendar, 1);
            addOneDay(validDates, calendar, 1);
        }else if(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY){
            addOneDay(validDates, calendar, 1);
        }else if(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY){
            addOneDay(validDates, calendar, 1);
        }else if(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.TUESDAY){
            addOneDay(validDates, calendar, 1);
        }else if(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.WEDNESDAY){
            addOneDay(validDates, calendar, 1);
        }else if(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.THURSDAY){
            addOneDay(validDates, calendar, 1);
        }
        return validDates;
    }


    public static List<Date> getValidPreviousDates(Date currentDate){
        List<Date> validDates = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);

        if(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY){
            addOneDay(validDates, calendar, -1);
            addOneDay(validDates, calendar, -1);
            addOneDay(validDates, calendar, -1);
        }else if(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY){
            addOneDay(validDates, calendar, -1);
            addOneDay(validDates, calendar, -1);
        }else if(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY){
            addOneDay(validDates, calendar, -1);
        }else if(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY){
            addOneDay(validDates, calendar, -1);
        }else if(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.THURSDAY){
            addOneDay(validDates, calendar, -1);
        }else if(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.WEDNESDAY){
            addOneDay(validDates, calendar, -1);
        }else if(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.TUESDAY){
            addOneDay(validDates, calendar, -1);
        }
        return validDates;
    }

    private static void addOneDay(List<Date> validDates, Calendar calendar, int increment) {
        calendar.add(Calendar.DATE, increment);
        validDates.add(calendar.getTime());
    }


    public static Date convertStringToDate(String dateString) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        try {
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

}
