package com.daolion.study;

import com.daolion.study.utils.FormatUtils;

/*
    ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━┓ 
       Author   :  lixiaodaoaaa
       Date     :  2018/7/6
       Time     :  13:59
    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━┛
 */
public class FromStudy {

    public static void main(String[] args) {
        byte[] headBytes = {(byte) 0xBA};//报头
        int[] headInts = {0xBA};

//        int value = byteToInt((byte) 0xBA);
//        System.out.println("value is " + value);

        String byteStr = FormatUtils.byteValueTo2HexString((byte) 0xBA);
        System.out.println("byteStr  is "+byteStr);
    }

    public static int byteToInt(byte b) {
        //Java 总是把 byte 当做有符处理；我们可以通过将其和 0xFF 进行二进制与得到它的无符值
        return b & 0xFF;
    }
}
