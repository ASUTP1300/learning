//package yndx;
//
//public class BSearch {
//    public static void main(String[] args) {
//        String s = "11";
////        System.out.println((int) s.toCharArray()[0]);
//
////      31v2d
//        int[] nums = new int[9];
//        int j = 0;
//
//        if (check(s.charAt(0))) {
//
//        }
//
//
//        for (int i = '0'; i <= '9'; i++) {
//            nums[j] = i;
//            System.out.println((char) i);
//        }
//    }
//
//    //3(a2b)
//    static String rebuild(String str) {
//        int i = 0;
//        String acum = "";
//        while (check(str.charAt(i))) {
//            acum += str.charAt(0);
//            i++;
//        }
//        if (acum.isEmpty()) {
//            return "";
//        }
//        i = Integer.parseInt(acum);
//
//        while (i >= 0) {
//        }
//
//
//    }
//
//    static boolean check(char c) {
//        return c >= '0' && c <= '9';
//    }
//
//
//    //[0] 1
//    //1, 2, 3, 4, 5
//    static boolean bSearch(int[] a, int x) {
//        int l = 0;
//        int r = a.length;// 7
//        int p = 0;
//
//        while (l < r) {
//            p = (r + l) / 2;
//
//            if (a[p] == x) {
//                return true;
//            }
//            if (a[p] > x) {
//                r = p;
//            } else {
//                l = p + 1;
//                System.out.println("l is: " + l);
//            }
//        }
//        return false;
//    }
//
//
//    static int solveEq(int y) {
//        int l = 0;
//        int r = y;
//        int mid = 0;
//        int f = 0;
//
//        for (int i = 0; i < 100; i++) {
//            mid = (l + r) / 2;
//            System.out.println("--------------");
//            System.out.println("mid : " + r);
//            System.out.println("--------------");
//            if (mid * mid > y) {
//                r = mid;
//                System.out.println("r : " + r);
//            } else {
//                l = mid;
//                System.out.println("l : " + l);
//            }
//        }
//        return l;
//    }
//
////    static int partition(int[] a) {
////        int l = 0;
////        int r = a.length;
////        int p =
////    }
//}
//
//
//
