package model;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
//        String input = "ПппппппппПППппппррррррРРрррррррииВееееееееЕЕЕеетттттттт!!!!!";
//        System.out.println(test(input));

//        System.out.println(getClosestToZero(List.of(9, 3, -5, 4, -4, 7, 3, 11, -3, -2, -1)));
//
//        System.out.println(searchInsert(new int[]{1, 3}, 2));
//
//        System.out.println(lengthOfLastWord("   fly me   to   the moon"));
//
//        System.out.println(Arrays.toString(plusOne(new int[]{9, 9, 9, 9})));
//
//        System.out.println(addBinary("111011010011", "10101010111"));
//
//        System.out.println(mySqrt(2147483647));
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Integer.MAX_VALUE / 2);
//        Integer x = 15;
//        System.out.println(x.hashCode());
        Map<Integer, List<Integer>> map = new HashMap<>();
        map.put(1, List.of(1,2,3,4,5,6));
        map.put(2, List.of(10,20,30,40,50,60));

        /*List<Integer> result = */map.entrySet().stream().flatMap(entry -> {
            int key = entry.getKey();
            List<Integer> list = entry.getValue();
            return list.stream().map(num -> Map.entry(num, key));
        }).forEach(action -> {
            System.out.println("Ключ: " + action.getKey());
            System.out.println("Значение: " + action.getValue());
        });
//        result.forEach(System.out::println);
    }


    public static String test(String input) {

        char c = input.charAt(0);
        StringBuilder sb = new StringBuilder(String.valueOf(c));

        for (int i = 1; i < input.length(); i++) {
            if (Character.toLowerCase(input.charAt(i)) != Character.toLowerCase(c)) {
                sb.append(input.charAt(i));
                c = input.charAt(i);
            }
        }
        return sb.toString();
    }

    public static int getClosestToZero(final List<Integer> ints) {
        // 9, 3, -5, 4, -4, 7, 3, 11, -3 -> 3
        int prevResult = ints.get(0);
        int result = ints.get(0); //-3
        for (int i = 1; i < ints.size(); i++) {
            if (Math.abs(ints.get(i)) <= Math.abs(result)) {
                prevResult = result;
                result = ints.get(i);
            }
        }
        if (Math.abs(result) < Math.abs(prevResult)) return result;
        else return result > prevResult ? result : prevResult;
    }

    public static boolean isPalindrome(String text) {
        return true;
    }

    public static void test() {
        System.out.println("changes made in branch new_feature1");
    }


    public static int searchInsert(int[] nums, int target) {

        int begin = 0;
        int end = nums.length - 1;
        int middle;

        if (target > nums[end]) return nums.length;
        if (target < nums[begin]) return begin;

        while (begin <= end) {
            middle = (begin + end) / 2;
            int result = nums[middle];

            if (result == target) return middle;
            else if (target < result) {
                end = middle - 1;
            } else {
                begin = middle + 1;
            }
        }
        return begin;
    }

    public static int lengthOfLastWord(String s) {
        // "   fly me   to   the moon  "
//        Pattern pattern = Pattern.compile("\\w+");
//        Matcher matcher = pattern.matcher(s);
//        String temp = "";
//        while (matcher.find()) temp = matcher.group();
//        StringBuilder sb = new StringBuilder();
//        int flag = 0;
//        for (int i = s.length() - 1; i >= 0; i--) {
//            char c = s.charAt(i);
//            if (Character.toString(c).matches("\\w")) {
//                flag = 1;
//                sb.append(c);
//            } else if (flag == 1 && !Character.toString(c).matches("\\w")) break;
//        }
//        return sb.length();
        int count = 0;
        String str = s.trim();
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) != ' ') count++;
            else break;
        }
        return count;
    }

    public static int[] plusOne(int[] digits) {
        // [1, 2, 3] -> [1, 2, 4]
        // [9] -> [1, 0]
        for (int i = digits.length - 1; i >= 0; i--) {
            if ((digits[i] + 1) < 10) {
                digits[i] += 1;
                return digits;
            } else {
                digits[i] = 0;
            }
        }

        if (digits[0] == 0) {
            int[] newArray = new int[digits.length + 1];
            newArray[0] = 1;
            return newArray;
        }

        return digits;
    }

    public static String addBinary(String a, String b) {

        int indexA = a.length() - 1;
        int indexB = b.length() - 1;
        int grad = 0;
        StringBuilder sb = new StringBuilder();
        while (indexA >= 0 && indexB >= 0) {
            if (a.charAt(indexA) == '1' && b.charAt(indexB) == '1') {
                if (grad == 0) sb.append('0');
                else sb.append('1');
                grad = 1;
            } else if ((a.charAt(indexA) == '1' && b.charAt(indexB) == '0') ||
                    (a.charAt(indexA) == '0' && b.charAt(indexB) == '1')) {
                    if (grad == 0) sb.append('1');
                    else {
                        sb.append('0');
                    }
            } else {
                if (grad == 0) sb.append('0');
                else {
                    sb.append('1');
                    grad = 0;
                }
            }

            indexA--;
            indexB--;
        }
        if (indexA >= 0) {
            while (indexA >= 0) {
                if (grad == 0) {
                    sb.append(a.charAt(indexA));
                } else {
                    if (a.charAt(indexA) == '0') {
                        sb.append('1');
                        grad = 0;
                    } else {
                        sb.append('0');
                    }
                }
                indexA--;
            }
        }
        if (indexB >= 0) {
            while (indexB >= 0) {
                if (grad == 0) {
                    sb.append(b.charAt(indexB));
                } else {
                    if (b.charAt(indexB) == '0') {
                        sb.append('1');
                        grad = 0;
                    } else {
                        sb.append('0');
                    }
                }
                indexB--;
            }
        }

        if (grad == 1) sb.append('1');



        return sb.reverse().toString();
    }

//    public static int mySqrt(int x) {
//
//        if (x == 0) return 0;
//
//        int result = 46335;
//
//        while (result * result > 0 && result * result <= Integer.MAX_VALUE) {
//            int temp = result + 1;
//            if (temp*temp > x) {
//                return result;
//            } else result++;
////            if (result == Integer.MAX_VALUE / 2) break;
//        }
//
//        return result;
//    }

    public static int climbStairs(int n) {



        return 0;
    }

    public static <T> List<T> extractMap(Map<T, List<T>> map) {

        return map.entrySet().stream().flatMap(entry -> entry.getValue().stream()).toList();
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
//        You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
//
//                Merge nums1 and nums2 into a single array sorted in non-decreasing order.
//
//                The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
//
//
//
//        Example 1:
//
//        Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
//        Output: [1,2,2,3,5,6]
//        Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
//        The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
//                Example 2:
//
//        Input: nums1 = [1], m = 1, nums2 = [], n = 0
//        Output: [1]
//        Explanation: The arrays we are merging are [1] and [].
//                The result of the merge is [1].
//                Example 3:
//
//        Input: nums1 = [0], m = 0, nums2 = [1], n = 1
//        Output: [1]
//        Explanation: The arrays we are merging are [] and [1].
//                The result of the merge is [1].
//                Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.
    }
}
