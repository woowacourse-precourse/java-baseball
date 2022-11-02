package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Application {
    private static final int PLAYING = 3;
    private static final int READY = 1;
    private static final int EXCEPTION = -1;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
//        int user_input = userInput(PLAYING);
//        if (user_input == EXCEPTION) return;
//        System.out.println(user_input);
    }

    private static int userInput(int play_mode) {
        String input_String;
        int input_int;
        Scanner scanner = new Scanner(System.in);

        input_String = scanner.next();
        try {
            input_int = input_String_to_int(input_String, play_mode);
            return input_int;
        } catch (IllegalArgumentException e) {
            System.out.println("Input Error");
            return -1;
        }
    }

    private static int input_String_to_int(String input_String, int play_mode) {
        char[] input_charArray = input_String.toCharArray();
        int input_int;

        if (isNumberOfDigits(input_String, play_mode) || isNumberSet(input_charArray) || isNumberOverlap(input_charArray, play_mode)) {
            throw new IllegalArgumentException();
        }
        input_int = Integer.parseInt(input_String);
        return input_int;
    }

    //게임 중 3자리가 아닌 경우 혹은 게임이 끝나고 1자리가 아닌 경우
    private static boolean isNumberOfDigits(String input_String, int play_mode) {
        if (input_String.length() != play_mode) {
            return true;
        }
        return false;
    }

    //0~9사이의 숫자가 아닌 경우
    private static boolean isNumberSet(char[] input_charArray) {
        for (int i = 0; i < input_charArray.length; i++) {
            if (input_charArray[i] < '0' || input_charArray[i] > '9') {
                return true;
            }
        }
        return false;
    }

    //중복된 숫자가 있는 경우
    private static boolean isNumberOverlap(char[] input_charArray, int play_mode) {
        HashSet<Character> numSet = new HashSet<>();
        for (int i = 0; i < input_charArray.length; i++) {
            numSet.add(input_charArray[i]);
        }
        if(numSet.size()!=play_mode){
            return true;
        }
        return false;
    }
}
