package com.eazybytes.springsecuritybasic.config;

class Solution {
    public static String reverseWords(String s) {
        String[] array = s.split(" ");
        String result = "";
        for(int i = array.length -1; i >=0; i--){
            result += array[i];
            if(i > 0){
                result += " ";
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String result = reverseWords("  hello world  ");
        System.out.println(result);
    }
}

