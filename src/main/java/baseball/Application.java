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
            if (userInput.length() != 3) {
                throw new IllegalArgumentException();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            return true;
        }
        return false;
    }
    public static int StrikeBallCheck(String answer, String targetNumber) {
        int strike = 0;
        int ball = 0;

        for (int compareInteger = 0; compareInteger < 3; compareInteger++) {
            if (answer.charAt(compareInteger) == targetNumber.charAt(compareInteger)) strike += 1;

            else if (answer.indexOf(targetNumber.charAt(compareInteger)) != -1) ball += 1;
        }
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

        }
    }
}
