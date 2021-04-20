package com.switchfully.spaceshark.utils;

import java.util.regex.Pattern;

final public class ValidationUtil {

    private static final String EMAIL_FORMAT = "^\\w+@\\w+\\.\\w+$";

    public static boolean isNull(Object object) {
        return object == null;
    }

    public static boolean isEmptyString(Object object) {
        return object.toString().isEmpty();
    }

    public static boolean isBlankString(Object object) {
        return object.toString().isBlank();
    }

    public static void throwExceptionIfNullObject(Object object, String objectName) {
        if (object == null) {
            throw new IllegalArgumentException(objectName + " cannot be null.");
        }
    }

    public static boolean isValidEmail(String email) {
        return email.matches(EMAIL_FORMAT);
    }

    public static void throwExceptionIfEmailNullEmptyBlankOrInvalid(String email, String emailname) {
        throwExceptionIfNullOrEmptyOrBlank(email, emailname);
        if(!isValidEmail(email)) throw new IllegalArgumentException(email + "Invalid email format.");
    }

    public static boolean isValidPhoneNumber(String phoneNumber) {
        String regex = "^\\+(?:[0-9] ?){6,14}[0-9]$";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(phoneNumber).matches();
    }

    public static void throwExceptionIfPhoneNumberNullEmptyBlankOrInvalid(String phonenumber, String phone){
        throwExceptionIfNullOrEmptyOrBlank(phonenumber, phone);
        if(!isValidPhoneNumber(phonenumber)) throw new IllegalArgumentException(phonenumber + "Invalid phonenumber.");
    }

    public static void throwExceptionIfNullOrEmptyOrBlank(Object object, String objectName) {
        if (isNull(object))
            throw new IllegalArgumentException(objectName + " cannot be null.");
        else if (isBlankString(object))
            throw new IllegalArgumentException(objectName + " cannot be blank.");
        else if (isEmptyString(object))
            throw new IllegalArgumentException(objectName + " cannot be empty.");
    }

}
