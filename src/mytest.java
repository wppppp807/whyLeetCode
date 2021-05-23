import org.junit.Test;

import java.util.*;

public class mytest {

    @Test
    public void test01(){
        int[] arr = new int[]{10,7,2,4,7,62,3,4,2,1,8,9,19};
        System.out.println("before:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+",");
        }
        System.out.println();
        quick(arr,0,arr.length-1);
        System.out.println("after:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+",");
        }
    }
    public void quick(int[] arr, int left, int right){
        if (arr == null || arr.length == 0 || left > right)
            return;
        int key = arr[left];
        int i = left;
        int j = right;
        while (i < j){
            while (arr[j] >= key && i < j)
                j--;
            while (arr[i] <= key && i < j)
                i++;
            if (i < j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        arr[left] = arr[i];
        arr[i] = key;
        quick(arr,left,i-1);
        quick(arr,i+1,right);
    }


    @Test
    public void test02(){
        int i = new Solution().myAtoi("2147483648");
        System.out.println(i);
    }
}







class Solution {
    public int myAtoi(String s) {
        int len = s.length();
        char[] chars = s.toCharArray();
        int index = 0;
        while (index < len && chars[index]==' '){
            index++;
        }
        if (index == len)
            return 0;
        boolean flag = true;
        if (chars[index] == '+')
            index += 1;
        else if (chars[index] =='-'){
            flag = false;
            index += 1;
        }
        int res = 0;
        while (index < len){
            if (chars[index]>'9' || chars[index]<'0')
                break;
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && (chars[index] - '0') > Integer.MAX_VALUE % 10)) {
                return flag?Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
            res = res*10 + chars[index]-'0';
            index++;
        }
        return flag?res:-res;
    }
}