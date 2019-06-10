//package graphs.medium;
//
//// you can also use imports, for example:
//import java.util.*;
//
//// you can write to stdout for debugging purposes, e.g.
//// System.out.println("this is a debug message");
//
//class Solution {
//    public static void main(String[] args) {
//        int[] arr = {4, 3, 2, 6, 1};
//        System.out.println(solution(arr));
//
//        int[] arr2 = {2, 4, 1, 6, 5, 9, 7};
//        System.out.println(solution(arr2));
//
//        int[] arr3 = {2, 1, 6, 4, 3, 7};
//        System.out.println(solution(arr3));
//    }
//
//    public static int solution(int[] A) {
//        int len = A.length;
//        int[] B = new int[len];
//
//        for(int i = 0; i < len; i++) {
//            B[i] = A[i];
//        }
//
//        Arrays.sort(B);
//
//        int localMax = 0;
//        int count = 0;
//        for(int i = 0; i < len; i ++) {
//            localMax = Math.max(localMax, A[i]);
//
//            if(localMax == B[i])
//                count +=1;
//        }
//
//        return count;
//    }
//
//    public boolean equals(Object o) {
//        if (!(o instanceof Point)) {
//            return false;
//        }
//        return (x == ((Point) o).x && y == ((Point) o).y);
//    }
//}