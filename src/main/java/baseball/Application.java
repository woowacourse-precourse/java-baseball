package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static String NewGameNumber(){
        String targetNumber = "";
        while(targetNumber.length() < 3){
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if (!targetNumber.contains(Integer.toString(randomNumber))){
                targetNumber += Integer.toString(randomNumber);
            }
        }

        return targetNumber;
    }

    public static boolean isIllegalInput(String userInput) {
        try {
            if (userInput.length() != 3 || wrongInputValueCheck(userInput) == false) {
                throw new IllegalArgumentException();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            return true;
        }
        return false;
    }

    public static boolean wrongInputValueCheck(String userInput){
        int userInputNumber = Integer.parseInt(userInput);
        int num1 = userInputNumber % 10;
        int num2 = userInputNumber / 10 % 10;
        int num3 = userInputNumber / 100 % 10;

        if (num1 == num2 || num1 == num3 || num2 == num3) return false;

        return true;
    }

    public static int StrikeBallCheck(String answer, String targetNumber) {
        int strike = 0;
        int ball = 0;

        for (int compareInteger = 0; compareInteger < 3; compareInteger++) {
            if (answer.charAt(compareInteger) == targetNumber.charAt(compareInteger)) strike += 1;

            else if (answer.indexOf(targetNumber.charAt(compareInteger)) != -1) ball += 1;
        }

        return StrikeBallResultPrint(strike, ball);
    }

    public static int StrikeBallResultPrint(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱\n");
        }

        else if (strike != 0 && ball == 0) {
            System.out.println(strike + "스트라이크\n");
            if (strike == 3) return 1;
        }

        else if (strike == 0 && ball != 0) {
            System.out.println(ball + "볼\n");
        }

        else {
            System.out.println(ball + "볼 " + strike + "스트라이크\n");
        }

        return 0;
    }

    public static int gameRestartChecker(int ThreeStrikeCheck) {
        if (ThreeStrikeCheck == 1) {
            System.out.println("3개의 숫자를 모두 맞히셧습니다! 게임 종료\n");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");

            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        boolean newNumberFlag = true;
        String gameNumber = null;
        Scanner scanner = new Scanner(System.in);

        System.out.println("숫자 야구 게임을 시작합니다.\n");

        while(true){
            if (newNumberFlag == true) {
                gameNumber = NewGameNumber();
            }

            newNumberFlag = false;

            System.out.println("숫자를 입력해주세요 : ");
            String userInput = scanner.nextLine();

            if (isIllegalInput(userInput)) {
                break;
            }

            StrikeBallCheck(userInput, gameNumber);

            if (gameRestartChecker(StrikeBallCheck(userInput, gameNumber)) == 1) {
                Scanner reGameScanner = new Scanner(System.in);
                String reGameCheck = reGameScanner.next();

                if (reGameCheck == "2") return;

                newNumberFlag = true;
            }
        }
    }
}
