package com.vn.osp.notarialservices.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Validate util class
 * 
 * @author haint
 * @version $Revision: 17051 $
 */
public class ValidateParam {


    
    public boolean isMinLength(String str, int minLength) {

        if (str.length() >= minLength) {
            return true;
        } else {
            return false;
        }
    }


    
    public boolean isMaxLength(String str, int maxLength) {

        if (str.length() <= maxLength) {
            return true;
        } else {
            return false;
        }
    }


   
    public boolean checkSimple(String str) {
        boolean check = false;
        String oneByte = str.substring(0, 1);
        for (int i = 0; i < str.length(); i++) {
            if (!oneByte.equals(str.substring(i, i + 1))) {
                check = true;
                break;
            }
        }
        return check;
    }


    
    public boolean isInteger(String str) {
        if (str == null || !str.matches("[0-9]+$")) {
            return false;
        }
        return true;
    }


    
    public boolean isAlphanumeric(String str) {
        String strNum = "0123456789";
        String strChar = "aAbBcCdDeEfFgGhHiIjJkKmLlMnNoOpPqQrRsStTuUvVwWxXyYzZ";
        for (int i = 0; i < str.length(); i++) {
            if ((strNum.indexOf(str.charAt(i)) < 0)
                    && (strChar.indexOf(str.charAt(i)) < 0)) {
                return false;
            }
        }
        return true;
    }


    
    public boolean isAlphanumericPlus(String str) {
        String strNum = "0123456789";
        String strChar = "aAbBcCdDeEfFgGhHiIjJkKmLlMnNoOpPqQrRsStTuUvVwWxXyYzZ-_";
        for (int i = 0; i < str.length(); i++) {
            if ((strNum.indexOf(str.charAt(i)) < 0)
                    && (strChar.indexOf(str.charAt(i)) < 0)) {
                return false;
            }
        }
        return true;
    }


    
    public boolean isEncryptedPassword(String str) {
        String strNum = "0123456789";
        String strChar = "aAbBcCdDeEfFgGhHiIjJkKmLlMnNoOpPqQrRsStTuUvVwWxXyYzZ./";

        for (int i = 0; i < str.length(); i++) {
            if ((strNum.indexOf(str.charAt(i)) < 0)
                    && (strChar.indexOf(str.charAt(i)) < 0)) {
                return false;
            }
        }
        return true;
    }


    
    public boolean isTelephoneFormat(String telephone) {
        if (!telephone
                .matches("(\\([0-9]+\\)([\\-][#*0-9]|[#*0-9])*|[#*0-9]([\\-][#*0-9]|[#*0-9])*([\\-]?\\([0-9]+\\))?([\\-][#*0-9]|[#*0-9])*)")) {
            return false;
        }
        return true;
    }


    
    public boolean isMailAddressFormat(String mailAddress) {
        if (!mailAddress
                .matches("[\\p{Graph}&&[^@]]+@[\\p{Graph}&&[^.@]]+(\\.[\\p{Graph}&&[^.@]]+)+")) {
            return false;
        }

        return true;
    }


    
    public boolean isIPAddressFormat(String str) {
        if (!str
                .matches("((25[0-5]|(2[0-4]|[0-1][\\d]|[\\d])?[\\d])\\.){3}(25[0-5]|(2[0-4]|[0-1][\\d]|[\\d])?[\\d])")) {
            return false;
        }

        return true;
    }


    
   
    public static boolean isFileNameFormat(String str) {
        String regex = "[;\\\\/:\\*?\\\"<>\\|]";

        Pattern p = Pattern.compile(regex);
        Object m = p.matcher(str);

        return !((Matcher) m).find();
    }


    
    public boolean isAbleConvertToInteger(String str) {
        if (!isInteger(str)) {
            return false;
        }

        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException fex) {
            return false;
        }
    }


    
    public boolean isAbleConvertToLong(String str) {
        if (!isInteger(str)) {
            return false;
        }

        try {
            Long.parseLong(str);
            return true;
        } catch (NumberFormatException fex) {
            return false;
        }
    }

    
    
    public boolean isAbleConvertToDouble(String value) {
        if (value == null || "".equals(value)) {
            return false;
        }
        
        try {
            Double.parseDouble(value);
            return true;
        } catch (NumberFormatException fex) {
            return false;
        }
    }
}
