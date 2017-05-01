package com.javarush.task.task32.task3211;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.security.MessageDigest;

/* 
Целостность информации
*/

public class Solution {
    public static void main(String... args) throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(new String("test string"));
        oos.flush();
        System.out.println(compareMD5(bos, "5a47d12a2e3f9fecf2d9ba1fd98152eb")); //true

    }

    public static boolean compareMD5(ByteArrayOutputStream byteArrayOutputStream, String md5) throws Exception {
        byte bytes[] = byteArrayOutputStream.toByteArray();

        MessageDigest messageDigest = MessageDigest.getInstance("md5");
        StringBuffer hash = new StringBuffer(32);
        byte checksum[] = messageDigest.digest(bytes);
        for (byte b : checksum) {
            String hex = Integer.toHexString(b & 0xFF);
            if (hex.length() == 1) {
                hash.append('0');
            }
            hash.append(hex);
        }
//        System.out.println("Object checksum: " + hash.toString());
        if (hash.toString().equals(md5)) {
            return true;
        } else {
            return false;
        }
    }
}
