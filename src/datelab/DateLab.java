package datelab;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author cmtenga
 */
public class DateLab {

    /**
     * @param args the command line arguments
     */
    public static final long DAY_UNITS = 1000L * 60L * 60L * 24L;

    public static int dateDiff(long dateUtilitiesUnitField, Calendar firstDate,
            Calendar secondDate) throws IllegalArgumentException {
        long diff = Math.abs(firstDate.getTimeInMillis() - secondDate.getTimeInMillis());
        double diffAmt = (double) diff / dateUtilitiesUnitField;
        return (int) Math.round(diffAmt);


    }

    public static void main(String[] args) {

        System.out.println("Question 1");
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a");
        String formatDate = sdf.format(date);
        System.out.println("Date is " + formatDate);

        System.out.println();
        System.out.println("Question 2");
        Calendar cal = Calendar.getInstance();
        System.out.println("Date " + sdf.format(cal.getTime()));
        int dayOfYr = cal.get(Calendar.DAY_OF_YEAR);
        System.out.println("Days in the year todate is " + dayOfYr);

        System.out.println();
        System.out.println("Question 3");//minus 0ne week = 7 days
        Date date3 = new Date();
        Calendar firstDate = Calendar.getInstance();
        Calendar secondDate = Calendar.getInstance();
        secondDate.add(Calendar.DATE, -7);
        int difference = dateDiff(DAY_UNITS, firstDate, secondDate);
        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
        System.out.println(df.format(date3));
        System.out.println(df.format(secondDate.getTime()));


        System.out.println("Number of days elapsed is " + difference);

        System.out.println();
        System.out.println("Question 4");//add 30 days
                Calendar firstDate4 = Calendar.getInstance();
        Calendar secondDate4 = Calendar.getInstance();
        secondDate4.add(Calendar.DATE, 30);
        int days = dateDiff(DAY_UNITS, firstDate4, secondDate4);
        System.out.println(df.format(date));
        System.out.println(df.format(secondDate4.getTime()));
        System.out.println("Number of days elapsed is "+days);

        System.out.println();
        System.out.println("Question 5");
        String strDate = "04/12/1952 03:30:42 PM ";
        try {

            date = sdf.parse(strDate);
        } catch (ParseException pe) {
            System.out.println("Couldn't parse the date. Reason: " + pe);

        }

        System.out.println("Date " + sdf.format(date));
    }
}
