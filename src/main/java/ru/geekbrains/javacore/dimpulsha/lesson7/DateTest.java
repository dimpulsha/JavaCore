package ru.geekbrains.javacore.dimpulsha.lesson7;

    import java.text.SimpleDateFormat;
    import java.text.DateFormat;
    import java.util.Date;


public class DateTest {
        public static void main(String[] args) {
            String stringDate = "03/08/1995";
            String stringDate2 = "02-09-1995 23:37:50";
            String stringDate3 = "2021-07-16T07:00:00+03:00";
            String stringDate4 = "04 02, 1995";
            String stringDate5 = "Thu, May 02 1995";
            String stringDate6 = "Thu, May 02 1995 23:37:50";
            DateFormat date = new SimpleDateFormat("dd/MM/yyyy");
            DateFormat date2 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            DateFormat date3 = new SimpleDateFormat("yyyy-MM-dd");
            DateFormat date4 = new SimpleDateFormat("MM dd, yyyy");
            DateFormat date5 = new SimpleDateFormat("E, MMM dd yyyy");
            DateFormat date6 = new SimpleDateFormat("E, MMM dd yyyy HH:mm:ss");
            try{
                Date nDateTest1 = date.parse(stringDate);
                System.out.println(stringDate + " : " + date.format(nDateTest1));
                Date nDateTest2 = date2.parse(stringDate2);
                System.out.println(stringDate2 + " : " + date2.format(nDateTest2));
                Date nDateTest3 = date3.parse(stringDate3);
                System.out.println(stringDate3 + " : " + date3.format(nDateTest3));
                Date nDateTest4 = date4.parse(stringDate4);
                System.out.println(stringDate4 + " : " + date4.format(nDateTest4));
                Date nDateTest5 = date5.parse(stringDate5);
                System.out.println(stringDate5 + " : " + date5.format(nDateTest5));
                Date nDateTest6 = date6.parse(stringDate6);
                System.out.println(stringDate6 + " : " + date6.format(nDateTest6));
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }

