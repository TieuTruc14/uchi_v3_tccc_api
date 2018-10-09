package com.vn.osp.notarialservices.utils;


import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * <P>
 * String util function
 * </P>
 *
 * @author Nguyen Thanh Hai
 * @version $Revision: 27301 $ <BR>
 */
public class EditString {

    private static final String DASH = "-";
    public static final String UNDERSCORE = "_";
    public static final String SEMICOLON = ";";
    public static final String SPACE = " ";

    /**
     * <p>
     * Display double number
     * </p>
     *
     * @param value
     * @return double number
     */
    public static String doubleDisp(Double value) {
        if (value == null) {
            return "0.00";
        }
        return new DecimalFormat("#.00").format(value);
    }

    /**
     * Check char input is number
     *
     * @param c
     *            char
     * @return true: char is number. false: char not number
     */
    public static boolean isDigit(char c) {
        int x = (int) c;
        if ((x >= 48) && (x <= 57)) {
            return true;
        }
        return false;
    }

    /**
     * Check String is null
     *
     * @param str
     *            String
     * @return true String input is null or length = 0
     */
    public static boolean isNull(String str) {
        return (str == null || str.length() <= 0);
    }

    /**
     * Check String input is number
     *
     * @param number
     *            String
     * @return true: String input is number. false: String input is not number
     */
    public static boolean isNumber(String number) {
        if (isNull(number)) {
            return false;
        }
        char[] c = number.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (!isDigit(c[i])) {
                return false;
            }
        }
        return true;
    }
    /**
     * Remove CR char for display in Excel file
     *
     * @param str
     * @return
     */
    public static String removeBoldCode(String str) {
        if (str == null) {
            return null;
        }

        String rtnStr = str.replaceAll("&lt;b&gt;", "");
        rtnStr = rtnStr.replaceAll("&lt;/b&gt;", "");

        return rtnStr;

    }

    public static boolean isTelephoneOrfax(String str) {
        if (isNull(str)) {
            return true;
        }
        char[] c = str.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (!isDigit(c[i]) && !DASH.equals(c[i])) {
                return false;
            }
        }
        return true;
    }




    /**
     * Remove CR char for display in Excel file
     *
     * @param str
     * @return
     */
    public static String removeCR(String str) {
        if (str == null) {
            return null;
        }

        String rtnStr = str.replaceAll("\r", "");

        return rtnStr;

    }
    
    
    public static String convertToFilePath(String str){
    	if (str == null) {
            return "";
        }
    	String result = str;
    	String rs = str.substring(str.length() - 1);
    	if(!rs.equals("\\") && !rs.equals("/")){
    		result = str + "/";
    	}
    	return result;
    }

    /**
     * Convert unicode string to ASCII
     *
     * @param str
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String convertUnicodeToASCII(String str) throws UnsupportedEncodingException {

        if (str == null) {
            return "";
        }

        String rs = str.replace('\u0111', 'd');
        rs = rs.replace('\u0110', 'D');
        rs = rs.replace('\u00D0', 'D');
        rs = rs.replace('\u0089', 'D');
        rs = rs.replaceAll("\\%", "\\*");

        rs = Normalizer.normalize(rs, Normalizer.Form.NFKD);
        String regex = "[\\p{InCombiningDiacriticalMarks}\\p{IsLm}\\p{IsSk}]+";

        rs = new String(rs.replaceAll(regex, "").getBytes("ascii"), "ascii");

        return rs;
    }

    public static String cutString(String str) throws UnsupportedEncodingException {
        if (str == null) {
            return null;
        }
        if ("".equals(str.trim())) {
            return "";
        }
        String temp = str.trim().toUpperCase();
        temp = Constants.SPACE + temp;
        int i=0;
        String rs = "";
        while (i < temp.length()) {
            if((temp.charAt(i) == ' ') && (temp.charAt(i+1) != ' ')) {
                rs = rs + temp.charAt(i+1);
            }
            i++;
        }
        return rs;
    }

    
    
    



    /**
     *
     * @return
     */
    public static String getDisp(String input, int count) {
        if (input == null) {
            return null;
        }
        if (input.length() > count ) {
            int index = count;
            while (index < input.length() && input.charAt(index) != ' ') {
                index++;
            }
            String  titleReturn = (index == input.length()) ? input.substring(0, index) : input.substring(0, index) + " ... ";
            return titleReturn;
        }
        return input;
    }
    /**
    *
    * @return
    */
   public static String getDispPath(String input, int count) {
       if (input == null) {
           return null;
       }
       if (input.length() > count ) {
           String  titleReturn = input.substring(0, count) + " ... ";
           return titleReturn;
       }
       return input;
   }
    
public static String getFileNameDisp(String fileName, int count) {
        
        if (fileName == null) {
            return "";
        }
        
        int index = fileName.lastIndexOf('.');
        if (index >= 0) {
            if (fileName.length() > count) {
                int middle = count / 2;
                return fileName.substring(0, middle) + "..." + fileName.substring(index-middle, index) + fileName.substring(index, fileName.length());
            }
            
        } else if (fileName.length() > count) {
            return fileName.substring(0, count);
        }
        
        return fileName;
    }
    
    /**
     * Parse key search
     * 
     * @param key
     * @return
     */
    public static List<String> parseKeySearch(String key) {
        List<String> subkeys = new ArrayList<String>();
        key = key.trim();
        
        if ("+".equals(key)) {key = "";}
        if ("-".equals(key)) {key = "";}
        
        while (key.length() > 1 && (key.charAt(0) == '+' || key.charAt(0) == '-')) {
            key = key.substring(1, key.length());
        }
        
        if ("+".equals(key)) {key = "";}
        
        while (key.length() > 0 && (key.charAt(key.length() - 1) == '+' || key.charAt(key.length() - 1) == '-')) {
            key = key.substring(0, key.length() - 1);
        }
        
        if ("-".equals(key)) {key = "";}
       
        //key = key.replaceAll(Constants.PLUS, "\\+ ");
//        key = escapeForSearch(key);
        
        Pattern pattern = Pattern.compile("\\s+");
        Matcher matcher = pattern.matcher(key);
        key = matcher.replaceAll(" ");
        
        //key = key.replaceAll("\"" + Constants.SPACE + "\"", "\"" + Constants.SPACE + Constants.SPACE + "\"");
        key = key.replaceAll("\"\"", "\"" + Constants.SPACE + "\"");
        
        String[] temp = key.split(Constants.MASK);
        for (int i = 0; i < temp.length; i++) {   
            if (i % 2 == 1) {
                if (!EditString.isNull(temp[i].trim())) {
                    if (subkeys.size() > 0 && !Constants.SPACE.equals(subkeys.get(subkeys.size() - 1))
                            && !Constants.PLUS.equals(subkeys.get(subkeys.size() - 1))) {
                        subkeys.add(Constants.SPACE);
                    }
                    subkeys.add(Constants.MASK + temp[i] + Constants.MASK);
                }
            } else if (i % 2 == 0) {
                parseSubKey(temp[i], Constants.PLUS, subkeys);
            }
        }
        
        while (subkeys.size() > 0 && Constants.PLUS.equals(subkeys.get(subkeys.size() - 1))) {
            subkeys.remove(subkeys.size() - 1);
        }
        while (subkeys.size() > 0 && Constants.MINUS.equals(subkeys.get(subkeys.size() - 1))) {
            subkeys.remove(subkeys.size() - 1);
        }
        while (subkeys.size() > 0 && EditString.isNull(subkeys.get(subkeys.size() - 1).trim())) {
            subkeys.remove(subkeys.size() - 1);
        }
        if (subkeys.size() > 0 && !Constants.PLUS.equals(subkeys.get(0))) {
            subkeys.add(0, Constants.PLUS);
        }
        
        return subkeys;
    }
    
    /**
     * Parse key search
     * 
     * @param key
     * @return
     */
    public static String parseKeyForSearch(String key) {
		String escapeChars ="[\\\\+\\-\\!\\(\\)\\:\\^\\]\\{\\}\\~\\?\\<\\>\\;\\!\\@\\#\\$\\%\\&\\.\\,\\/\\_\\|\\=]";
		key = key.replaceAll(escapeChars, " ");
		key = key.replace('[',(char) 0x20);
		key = key.replace(']',(char) 0x20);
		key = key.trim();
		return key;
    
    }
    public static String removeDauNhayKep(String key){
        if(key!= null && !key.equals("")){
            key = key.trim().replaceAll("\"","");
        }

        return key;
    }
    /**
     * Parse sub key 
     * @param subKey
     * @param regex
     * @param subkeys
     */
    private static void parseSubKey(String subKey, String regex, List<String> subkeys) {
        String[] temp1 = subKey.split(Constants.PLUS);
        
        if (!EditString.isNull(subKey) && EditString.isNull(subKey.trim())
                && !Constants.SPACE.equals(subkeys.get(subkeys.size() - 1))
                && !Constants.PLUS.equals(subkeys.get(subkeys.size() - 1))) {
            subkeys.add(Constants.SPACE);
        }
        
        for (int i = 0; i < temp1.length; i++) {
            if (!EditString.isNull(temp1[i].trim())) {
                
                if (i > 0 && subkeys.size() > 0 && !Constants.SPACE.equals(subkeys.get(subkeys.size() - 1))
                        && !Constants.PLUS.equals(subkeys.get(subkeys.size() - 1))) {
                    subkeys.add(Constants.PLUS);
                }
                               
                String[] temp2 = temp1[i].trim().split(Constants.SPACE);
                
                if (subkeys.size() > 0 && !Constants.SPACE.equals(subkeys.get(subkeys.size() - 1))
                        && !Constants.PLUS.equals(subkeys.get(subkeys.size() - 1))) {
                    subkeys.add(Constants.SPACE);
                }
                
                for (int k = 0; k < temp2.length; k++) {
                    if (k != temp2.length - 1) {
                        subkeys.add(temp2[k]);
                        subkeys.add(Constants.SPACE);
                    } else {
                        subkeys.add(temp2[k]);
                    }
                }                
            }
            if (i > 0 && i == temp1.length - 1 && EditString.isNull(temp1[i].trim())
                    && subkeys.size() > 0 && !Constants.SPACE.equals(subkeys.get(subkeys.size() - 1))
                    && !Constants.PLUS.equals(subkeys.get(subkeys.size() - 1))) {
                subkeys.add(Constants.PLUS);
            }
        }
    }
    
    /**
     * Parse key search
     * 
     * @param key
     * @return
     */
    public static List<String> parseForHighLight(String key, int count) {
        List<String> subkeys = new ArrayList<String>();
        String subKey;
        while (key.length()>count) {
        	int index = count;
        	while (index < key.length() && key.charAt(index) != ' ') {
                index++;
            }
        	subKey="";
        	subKey = key.substring(0,index);
			subkeys.add(subKey);
			key = key.substring(subKey.length());			
		}
        subkeys.add(key);
        return subkeys;
    }
    /**
     * Get number from string
     * @param contractNumber
     * @return
     */
	public static String getNumber(String contractNumber) {
		
		if (contractNumber==null||"".equals(contractNumber.trim())) return null;
    	
    	if (!Character.isDigit(contractNumber.charAt(0))) {
    		return null;
    	} else {
    	Pattern p = Pattern.compile("-?\\d+");
    	Matcher m = p.matcher(contractNumber);
    	if (m.find()) {
    	  return m.group();
    	} else return null;
    	
    	}
    }
	
	/**
     * Parse Data For Search
     * 
     * @param text
     * @return
     */
    public static String parseDataForSearch(String text) {
        String[] delimiters = {",", ";", "\\.", "-", "_", "\\?", "!", ":"};
        for (int i = 0; i < delimiters.length; i++) {
            text = text.replaceAll(delimiters[i], Constants.SPACE + delimiters[i] + Constants.SPACE);
        }
        
        Pattern pattern = Pattern.compile("\\s+");
        Matcher matcher = pattern.matcher(text);
        text = matcher.replaceAll(" ");
        
        return text;
    }
    

    
    public static String replaceHightlight2(String text, String key) {
        
        if (EditString.isNull(text)) {
            return "";
        }
            
        return text.replaceAll(key, "<span class=\"highlighted\">" + key + "</span>");
    }
    
    public static List<Boolean> parseListDateBackup(String key){
    	List<Boolean> subkeys = new ArrayList<Boolean>();
        key = key.trim();
        while(key.indexOf(" ") > 0){
        	int index = key.indexOf(" ");
        	String key1 = key.substring(0, index);
        	subkeys.add(Boolean.parseBoolean(key1));
        	key = key.substring(index).trim();
        }
        subkeys.add(Boolean.parseBoolean(key.trim()));
        return subkeys;
    }
	
}
