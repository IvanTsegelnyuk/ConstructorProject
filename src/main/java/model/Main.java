package model;

public class Main {

    public static void main(String[] args) {
        String input = "ПппппппппПППппппррррррРРрррррррииВееееееееЕЕЕеетттттттт!!!!!";
        System.out.println(test(input));
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
}
