package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static camp.nextstep.edu.missionutils.Console.*;

public class Baseballgame {

    private static final String CONTINUE = "1";
    private static final String QUIT = "2";

    public Baseballgame() {
    }
    public void play() {
        do {
            game();
        } while (reGame());
    }

    public void game() {
        Com comBalls;
        Checkout check;
        comBalls = Com.makeRandomBalls();

        do {
            printUserInputMessage();
            check = Checkout.checkBalls(makeUserBalls(), comBalls);
            printResult(check);


        } while (!check.isAllStrikes());

    }

    private Boolean reGame() {
        String input = "";

        while (invalidInput(input)) {
            printCheckRestartMessage();
            input = getUserInput();
        }
        printCheckRestartExceptionMessage();
        return input.equals(CONTINUE);
    }

    private boolean invalidInput(String input) {
        return !input.equals(CONTINUE) && !input.equals(QUIT);
    }



    private Com makeUserBalls() {
        Com userBalls = null;
        while (userBalls == null) {
            String userInput = getUserInput();
            validateUserInput(userInput);

            try {
                userBalls = Com.stringToBalls(userInput);
            } catch (NumberFormatException e) {
                printFormatExceptionMessage();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return userBalls;
    }

    private void validateUserInput(String userInput) {
        if (checkUserInputLength(userInput)) {
            throw new IllegalArgumentException("입력값의 길이가 잘못 되었습니다.");
        }
    }

    private Boolean checkUserInputLength(String str) {
        return str.length() != 3;
    }

    private String getUserInput() {
        return readLine();
    }


    private void printUserInputMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    private void printResult(Checkout result) {
        System.out.println(result.getResultMessage());

    }

    private void printFormatExceptionMessage() {
        System.out.printf("%d개의 1~9 사이의 중복되지 않는 수만 입력할 수 있습니다.%n");
    }

    private void printCheckRestartExceptionMessage() {
        System.out.println("1, 2만 입력 가능합니다. 다시 입력해주세요.");
    }

    private void printCheckRestartMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }






}
