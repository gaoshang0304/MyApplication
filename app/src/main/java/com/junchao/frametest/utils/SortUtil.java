package com.junchao.frametest.utils;

import java.util.Arrays;
import java.util.List;

/**
 * �ַ�������
 */
public class SortUtil {

    /**
     * ���ô˷���
     *
     * @param list
     * @return
     */
    public static List<String> listSort(List<String> list) {
        String[] array = (String[]) list.toArray(new String[list.size()]);
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (singleSort(array[i], array[j]) == 1) {
                    String temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return Arrays.asList(array);
    }
    /**
     * �Ƚ������ַ�
     *
     * @param one
     * @param two
     * @return
     */
    public static int singleSort(String one, String two) {
        int[] left = stringToAscii(one);
        int[] right = stringToAscii(two);
        int size = left.length < right.length ? left.length : right.length;
        for (int i = 0; i < size; i++) {
            // ����10000˵���Ǻ��� �������ж�һ���Ƿ���� ��������ж� �����жϴ���
            if (left[i] > 10000 && right[i] > 10000 && left[i] != right[i]) {
                if (chineseCompare(one, two, i) != 0) {
                    return chineseCompare(one, two, i);
                }
            } else {
                if (intCompare(left[i], right[i]) != 0) {
                    return intCompare(left[i], right[i]);
                }
            }
        }
        return intCompare(left.length, right.length);
    }
    /**
     * ���ֱȽ�
     *
     * @param one
     * @param two
     * @param i
     * @return
     */
    private static int chineseCompare(String one, String two, int i) {
        String substringleft;
        String substringright;
        if (i > 0) {
            substringleft = one.substring(i - 1, i);
            substringright = two.substring(i - 1, i);
        } else {
            substringleft = one.substring(0, i);
            substringright = two.substring(0, i);
        }
        // ��ú���ƴ������ĸ��ASCII��
        // ���������CharacterParser.convert���� �ĳ� public static ��Ȼ�ᱨ��
        int subLeft = stringToAscii(CharacterParserNew.convert(substringleft)
                .substring(0, 1))[0];
        int subRight = stringToAscii(CharacterParserNew.convert(substringright)
                .substring(0, 1))[0];
        System.out.println(CharacterParserNew.convert(substringleft).substring(0,
                1));
        return intCompare(subLeft, subRight);
    }
    /**
     * ���ֱȽ�
     * @param subLeft
     * @param subRight
     * @return
     */
    private static int intCompare(int subLeft, int subRight) {
        if (subLeft > subRight) {
            return 1;
        } else if (subLeft < subRight) {
            return -1;
        } else {
            return 0;
        }
    }
    /**
     * ���ASCII��
     * @param value
     * @return
     */
    public static int[] stringToAscii(String value) {
        char[] chars = value.toCharArray();
        int j = chars.length;
        int[] array = new int[j];
        for (int i = 0; i < chars.length; i++) {
            array[i] = (int) chars[i];
        }
        return array;
    }
}
