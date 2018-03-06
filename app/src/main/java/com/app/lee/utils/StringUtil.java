package com.app.lee.utils;

import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by lichen on 2017/10/30.
 */

public class StringUtil {

    /**
     * 判断字符串是否有值，如果为null或者是空字符串或者只有空格或者为"null"字符串，则返回true，否则则返回false
     */
    public static boolean isEmpty(String value) {
        if (value != null && !"".equalsIgnoreCase(value.trim())
                && !"null".equalsIgnoreCase(value.trim())) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean isEmptyNull(String value) {
        if (value != null && !"null".equalsIgnoreCase(value)) {
            return false;
        }
        return true;
    }

    /**
     * 判断EditText 文本内容是否为空
     */
    public static boolean isEmpty(EditText editText) {
        return isEmpty(editText.getText().toString().trim());
    }

    /**
     * 判断是否为电话号码
     *
     * @param number
     * @return
     */
    public static boolean isPhoneNumber(String number) {
        if (number == null) {
            return false;
        }
        String telRegex = "[1][34578]\\d{9}";
        return number.matches(telRegex);
    }

    /**
     * 手机号加密
     *
     * @param phoneNumber
     * @return
     */
    public static String encryptPhoneNumber(String phoneNumber) {
        return phoneNumber.replace(phoneNumber.substring(3, 7), "****");
    }

    /**
     * 规则1：至少包含大小写字母及数字中的一种
     * 是否包含
     *
     * @param str
     * @return
     */
    public static boolean isLetterOrDigit(String str) {
        boolean isLetterOrDigit = false;//定义一个boolean值，用来表示是否包含字母或数字
        for (int i = 0; i < str.length(); i++) {
            if (Character.isLetterOrDigit(str.charAt(i))) {   //用char包装类中的判断数字的方法判断每一个字符
                isLetterOrDigit = true;
            }
        }
        String regex = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,16}$";
        boolean isRight = isLetterOrDigit && str.matches(regex);
        return isRight;
    }

    /**
     * 校验ip
     * @param str
     * @return
     */
    public static boolean checkIP(String str) {

            /*正则表达式*/
        String ip = "^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\."
                + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
                + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
                + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";//限定输入格式
        Pattern p = Pattern.compile(ip);
        Matcher m = p.matcher(str);
        boolean b = m.matches();

        if (b == false) {
            return false;
        } else {
            return true;
        }
    }
}
