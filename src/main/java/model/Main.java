package model;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        String input = "ПппппппппПППппппррррррРРрррррррииВееееееееЕЕЕеетттттттт!!!!!";
        System.out.println(test(input));

        System.out.println(getClosestToZero(List.of(9, 3, -5, 4, -4, 7, 3, 11, -3, -2, -1)));
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
}
