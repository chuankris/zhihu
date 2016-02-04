/**
 * @Title: StringUtils.java
 * @Description: 字符串处理工具类
 * @author chuankris
 * @date 2012-2-8
 * @version V1.0
 * <p/>
 * Modification History:
 * 2012-2-8  |  chuankris   |  Created
 */
package util;


import com.zhihu.chuankris.myapplication.preferrence.GlobalContext;

import java.math.BigDecimal;

public class StringUtils {

    /**
     * 会话协议报文加解密密钥
     */
    private static final byte ENCODE_SEED = 0x6E;

    /**
     * <p>
     * Checks if a CharSequence is whitespace, e
     *
     * mpty ("") or null.
     * </p>
     *
     * <pre>
     * StringUtils.isBlank(null)      = true
     * StringUtils.isBlank("")        = true
     * StringUtils.isBlank(" ")       = true
     * StringUtils.isBlank("bob")     = false
     * StringUtils.isBlank("  bob  ") = false
     * </pre>
     *
     * @param cs
     *            the CharSequence to check, may be null
     * @return {@code true} if the CharSequence is null, empty or whitespace
     * @since 2.0
     * @since 3.0 Changed signature from isBlank(String) to
     *        isBlank(CharSequence)
     */

    /**
     * 解密
     *
     * @param bytes
     * @return
     */
    public static byte[] decrypt(byte[] bytes) {
        int len = bytes.length;
        for (int i = 0; i < len; i++) {
            bytes[i] = (byte) (bytes[i] ^ ENCODE_SEED);
        }
        return bytes;
    }

    /**
     * 加密
     *
     * @param bytes
     * @return
     */
    public static byte[] ecrypt(byte[] bytes) {

        if (isNotEmpty(bytes)) {
            int len = bytes.length;
            for (int i = 0; i < len; i++) {
                bytes[i] = (byte) (bytes[i] ^ ENCODE_SEED);
            }
        }
        return bytes;
    }

    public static boolean isNotEmpty(byte[] array) {
        return (array != null && array.length != 0);
    }

    public static boolean isBlank(CharSequence cs) {
        int strLen;
        if (cs == null || (strLen = cs.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if (Character.isWhitespace(cs.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }

    public static boolean IsImgValid(String cs) {
        if (isNullOrEmpty(cs)) {
            return false;
        }
        if (cs.contains("http")) {
            return true;
        } else {
            return false;
        }
    }


    /**
     * Checks if a CharSequence is not empty (""), not null and not whitespace
     * only.
     * </p>
     * <p/>
     * <pre>
     * StringUtils.isNotBlank(null)      = false
     * StringUtils.isNotBlank("")        = false
     * StringUtils.isNotBlank(" ")       = false
     * StringUtils.isNotBlank("bob")     = true
     * StringUtils.isNotBlank("  bob  ") = true
     * </pre>
     *
     * @param cs the CharSequence to check, may be null
     * @return {@code true} if the CharSequence is not empty and not null and
     * not whitespace
     * @since 3.0 Changed signature from isNotBlank(String) to
     * isNotBlank(CharSequence)
     */
    public static boolean isNotBlank(CharSequence cs) {
        return !StringUtils.isBlank(cs);
    }

    public static String splitDoubleToString(double doubleNum, int scale) {
        String sDouble = String.valueOf(doubleNum);
        int dotIndex = sDouble.indexOf(".");
        if (dotIndex + scale > sDouble.length() - 1) {
            return sDouble;
        } else {
            return sDouble.substring(0, dotIndex + scale + 1);
        }
    }

    /**
     * 四舍五入后保留小数点后 pointScale 位，不足用0补齐
     *
     * @param num
     * @param pointScale 精确到小数点后 几位
     * @return
     */
    public static String roundDoubleToString(double num, int pointScale) {
        BigDecimal bd = new BigDecimal(num);
        bd = bd.setScale(pointScale, 4);
        String result = (bd.doubleValue() + "");
        int doIndex = result.indexOf(".");

        if (result.length() - (doIndex + 1) < pointScale) {
            result = appendZero(result, pointScale - (result.length() - (doIndex + 1)));
        }

        return result;
    }

    public static String bytes2kb(long bytes) {
        BigDecimal filesize = new BigDecimal(bytes);
        BigDecimal megabyte = new BigDecimal(1024 * 1024);
        float returnValue = filesize.divide(megabyte, 2, BigDecimal.ROUND_UP).floatValue();
        if (returnValue > 1)
            return (returnValue + "  MB ");
        BigDecimal kilobyte = new BigDecimal(1024);
        returnValue = filesize.divide(kilobyte, 2, BigDecimal.ROUND_UP).floatValue();
        return (returnValue + "  KB ");
    }

    public static byte[] decrypt(byte[] bytes, int seed) {
        int len = bytes.length;
        for (int i = 0; i < len; i++) {
            bytes[i] = (byte) (bytes[i] ^ seed);
        }
        return bytes;
    }

    /**
     * @param src
     * @param i
     * @return
     */
    private static String appendZero(String src, int i) {
        StringBuilder result = new StringBuilder(src);
        while (i > 0) {
            result.append("0");
            i--;
        }
        return result.toString();
    }

    /**
     * 获取字符串的字节数，一个中文为2个字节，一个字母或数字为1个字节
     *
     * @param s
     * @return
     */
    public static int getByteCountsOfString(String s) {
        int length = 0;
        for (int i = 0; i < s.length(); i++) {
            int ascii = Character.codePointAt(s, i);
            if (ascii >= 0 && ascii <= 255)
                length++;
            else
                length += 2;

        }
        return length;

    }

    public static String getResource(int id) {
        String temp = "null";
        if (GlobalContext.getInstance().getApplicationContext() != null) {
            temp = GlobalContext.getInstance().getApplicationContext().getResources().getString(id);
        }
        return temp;

    }

    public static boolean isNullOrEmpty(String coverName) {
        if (coverName == null || coverName.trim().length() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static int parseInt(String str) {
        return parseInt(str, -1);
    }

    public static int parseInt(String str, int ev) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return ev;
        }
    }


}
