package baseball.view;

import baseball.utils.InputValidation;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Collections;

public class GameView {
    private static String GAME_START = "숫자 야구 게임을 시작합니다.";
    private static String INPUT_NUMBER = "숫자를 입력해주세요 : ";
    private static InputValidation inputValidation;

    public void gameStartMessage() {
        System.out.println(GAME_START);
    }

    public static int getInputNumber() {
        System.out.println(INPUT_NUMBER);
        String input = Console.readLine();
        inputValidation.validationNumber(input);
        return Integer.parseInt(input);
    }

    public static ArrayList<Integer> userNumber() {
        int user = getInputNumber();

        ArrayList<Integer> userInput = new ArrayList<>();
        while (user != 0) {
            userInput.add(user % 10);
            user /= 10;
        }
        Collections.reverse(userInput);

        return userInput;
    }


    public static void exitMessage(int game){
        if(game == 2){
            System.out.println("프로그램이 종료됩니다.");
        }
    }


}
