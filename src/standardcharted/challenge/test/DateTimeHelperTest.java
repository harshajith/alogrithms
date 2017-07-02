package standardcharted.challenge.test;


import standardcharted.challenge.DateTimeHelper;

import java.util.Date;
import java.util.List;

/**
 * Test if this returns valid previous date and next date.
 * Created by Harsha on 9/5/17.
 */
public class DateTimeHelperTest {

    public static void main(String[] args){

        DateTimeHelper dateTimeHelper = new DateTimeHelper();

        System.out.println("Valid next days ===============");
        Date currentDate = DateTimeHelper.convertStringToDate("05-MAY-2017");
        List<Date> validNextDates  = dateTimeHelper.getValidNextDates(currentDate);
        validNextDates.stream().forEach(System.out::println);

        System.out.println("Valid previous days ===============");
        List<Date> validPreviousDates = dateTimeHelper.getValidPreviousDates((currentDate));
        validPreviousDates.stream().forEach(System.out::println);

    }



}
