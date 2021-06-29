package utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;


public class utility {
    public static int countNumberOfPages(int numberOfObjects, int pageSize) {
        return numberOfObjects / pageSize + (numberOfObjects % pageSize == 0 ? 0 : 1);
    }

    public static boolean validateStringLength(String s , int min , int max){
        boolean result = true;
        int length = s.length();
        if(length< min || length>max)
            result = false;
        return result;
    }

    public boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }

    public boolean validateDOB(String dob){
        if(dob == null) {
            return false;
        }
        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD");
        try {
            Date d = format.parse(dob);
            return true;
        } catch(ParseException e) {
            return false;
        }
    }
}
