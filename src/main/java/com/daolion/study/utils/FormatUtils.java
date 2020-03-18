package com.daolion.study.utils;

/**
 * Created by lixiaodaoaaa on 2017/8/15.
 */

public class FormatUtils {

    //举例 01  formatter to  01
    public static String intValueTo2HexString(int value) {
        return String.format("%02x", value);
    }
    //举例 byte(ba)  formatter to  HexString BA
    public static String byteValueTo2HexString(byte byteValue) {
        return String.format("%02x", byteValue);
    }


    //举例 01  formatter to 00 01
    public static String intValueTo4HexString(int value) {
        return String.format("%04x", value);
    }

    /**
     * 将String转化为byte[]数组
     *
     * @param arg 需要转换的String对象
     * @return 转换后的byte[]数组
     * Exam:
     * form :"AABB010A0000007001"
     * To_sHEX_Bytes:AABB010A0000007001
     */
    public static byte[] toByteArray(String arg) {
        int len = arg.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(arg.charAt(i), 16) << 4) + Character.digit(arg
                    .charAt(i + 1), 16));
        }
        return data;
    }

    /**
     * 重新排序 string
     * 举例输入：00 11
     * 输出   :11 00
     * <p>
     * 输入 11 22
     * 输出 22 11
     *
     * @return
     */
    public static String revertString(String str) {
        String data0 = str.substring(2, str.length());
        String data1 = str.substring(0, 2);
        return data0 + data1;
    }

    /**
     * 重新排序 string
     * 输入 00000001
     * 输出：01 00 00 00
     *
     * @return
     */
    public static String revert4String(String str) {
        if (str.trim().toString().length() != 8) {
            return str;
        }
        String header = str.substring(0, 4);
        String endBody = str.substring(4, 8);
        return revertString(endBody) + revertString(header);
    }


    /***
     *
     * @param amountValue
     * FF 00 = 255
     * 00 01 = 25.6
     * 00 02  = 51.2
     * amountValue convertTo 16Hex
     * 数据位为 4个字节 data1 data2 data3 data4
     * @return
     */
    public static String fromAmountToAmountData(float amountValue) {
        Float calValue = amountValue * 10;
        int calIntegerValue = calValue.intValue();
        String hexValue = String.format("%08x", calIntegerValue);
        return revert4String(hexValue);
    }

    /**
     * hexString转 IntValue
     * 举例  Input 10->16
     * 举例 Input 1f -> 31
     *
     * @param hexString
     */
    public static int hexString2IntValue(String hexString) {
        if (hexString.trim().length() < 1) {
            return 0;
        }
        return Integer.valueOf(hexString, 16).intValue();
    }


    /**
     * hexString转 IntValue
     * 举例  Input 111A2AFF00
     * 举例  output 11 1A 2A FF 00
     */
    public static String formatterDataToShow(String data) {
        String regex = "(.{2})";
        return data.replaceAll(regex, "$1 ").toUpperCase();
    }

}
