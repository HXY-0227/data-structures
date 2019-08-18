package com;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class FileUtil {

    public static boolean readFile(String fileName, ArrayList<String> words) {

        if (null == fileName || null == words) {
            System.out.println("filename is null or words is null");
            return false;
        }

        // 文件读取
        Scanner scanner;

        try {
            File file = new File(fileName);
            if (file.exists()) {
                FileInputStream fis = new FileInputStream(fileName);
                scanner = new Scanner(new BufferedInputStream(fis), "UTF-8");
                scanner.useLocale(Locale.ENGLISH);
            } else {
                return false;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Cannot open " + fileName);
            return false;
        }

        if (scanner.hasNextLine()) {
            String context = scanner.useDelimiter("\\A").next();
            int start = firstCharacterIndex(context, 0);
            for (int i = start + 1; i <= context.length();) {
                if (i == context.length() || !Character.isLetter(context.charAt(i))) {
                    String word = context.substring(start, i).toLowerCase();
                    words.add(word);
                    start = firstCharacterIndex(context, i);
                    i = start + 1;
                } else {
                    i++;
                }
            }
        }

        return true;
    }

    // 寻找字符串context中，从start的位置开始的第一个字母字符的位置
    private static int firstCharacterIndex(String context, int start) {
        for (int i = start; i < context.length(); i ++) {
            if (Character.isLetter(context.charAt(i))) {
                return i;
            }
        }

        return context.length();
    }
}
