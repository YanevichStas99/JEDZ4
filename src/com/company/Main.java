package com.company;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Task 1");
        Random rand=new Random();
        int[] arr=new int[1000];
        for (int i = 0; i <arr.length ; i++) {
            arr[i]=rand.nextInt(1000);
        }
        int value=521;
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(binarSearch(arr,value));
        System.out.println("Task 2");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter robot`s way:");
        String s = scanner.nextLine();
        System.out.println(robotWay(s));

    }

    private static boolean binarSearch(int[] arr, int value) {
        int left=0;
        int right=arr.length-1;
        boolean result=false;
        int mid = (right+1) / 2;
        while (right!=mid && left!=mid){
            if (arr[mid]==value){
                result=true;
                return result;
            }
            if(arr[mid]>value){
                right=mid;
                mid=(left+right)/2;
            }else {
                left=mid;
                mid=(left+right)/2;
            }
        }
        if (arr[right] == value)
            result=true;
        if (arr[left] == value)
            result=true;
        return result;
    }

    private static boolean robotWay(String s) {
        int countHorizont = 0;
        int countVertical = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'U') {
                countVertical++;
            }
            if (s.charAt(i) == 'D') {
                countVertical--;
            }
            if (s.charAt(i) == 'R') {
                countHorizont++;
            }
            if (s.charAt(i) == 'L') {
                countHorizont--;
            }
        }
        if (countHorizont == 0 && countVertical==0){
            return true;
        }else {
            return false;
        }
    }
}
