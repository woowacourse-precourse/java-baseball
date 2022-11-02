package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Application {
    private static final int PLAYING = 3;
    private static final int READY = 1;
    private static final int EXCEPTION = -1;
    private static final int ONEMORETIME = 1;


    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int regame_input = 1;
        boolean playing_exception = false;

        System.out.println("숫자 야구 게임을 시작합니다.");
        do {
            playing_exception = startGame();
            if (playing_exception) return;
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            regame_input = userInput(READY);
            if (regame_input == EXCEPTION) return;
        } while (regame_input == ONEMORETIME);
    }

    private static boolean startGame() {
        boolean answer=false;
        int playing_input=1;
        int computer_num;

        computer_num=initComputerNum();
        while(!answer){
            System.out.print("숫자를 입력해주세요 : ");
            playing_input=userInput(PLAYING);
            if(playing_input==EXCEPTION) return true;
            answer=hint(computer_num,playing_input);
        }
        return false;
    }

    private static boolean hint(int computer_num,int player_num){
        return true;
    }

    private static int initComputerNum(){
        return 1;
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
            System.out.println("입력 에러\n프로그램을 종료합니다.");
            return -1;
        }
    }

    private static int input_String_to_int(String input_String, int play_mode) {
        char[] input_charArray = input_String.toCharArray();
        int input_int;

        if (play_mode == READY && (!input_String.equals("1") && !input_String.equals("2"))) {
            throw new IllegalArgumentException();
        }

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
        if (numSet.size() != play_mode) {
            return true;
        }
        return false;
    }
}
