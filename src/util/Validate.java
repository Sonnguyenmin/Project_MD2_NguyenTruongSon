package util;

import java.util.regex.Pattern;

public class Validate {
    public static boolean usernames (String username) {
        String[] arrUser = username.split("");
        for(String str : arrUser) {
            if (str.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public static boolean password (String password) {
        if (password.length() < 6) {
            return false;
        }
        String[] arrPassword = password.split("");
        for(String str : arrPassword) {
            if (str.isEmpty()) {
                return false;
            }
        }
        return true;
    }

//    // username phải ít nhât 6 kí tự, không có kí ự đặc biệt , không trung lặp
//    public  static  boolean checkUserNameIsValid(String username){
//        return Pattern.matches("^[0-9a-zA-Z]{6,}$",username);
//    }
//
//    public  static  boolean checkPhoneIsValid(String username){
//        return Pattern.matches("^(032|033|034|035|036|037|038|039|096|097|098|086|083|084|085|081|082|088|091|094|070|079|077|076|078|090|093|089|056|058|092|059|099)[0-9]{7}$",username);
//    }
}
