package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static List<Integer> userNumberList;
    private static List<Integer> answerNumberList;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 아규 게임을 시작합니다.");

        baseball();
    }

    private static void baseball() {
        createRandomNumber();

        while(true) {
            userInputNumber();
            if (userNumberList.size() == 0) return;

            String roundResult = roundResult();
            System.out.println(roundResult);

            if (answerNumberList.equals(userNumberList)) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String restartNumber = Console.readLine();

        gameStartOrStop(restartNumber);
    }

    private static void gameStartOrStop(String restartNumber) {
        if (restartNumber.equals("1")) {
            baseball();
        } else if (restartNumber.equals("2")) {
            System.out.println("게임을 종료합니다.");
        }
    }

    private static String roundResult() {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < userNumberList.size(); i++) {
            if (userNumberList.get(i) == answerNumberList.get(i)) {
                strike++;
            } else if (answerNumberList.contains(userNumberList.get(i))){
                ball++;
            }
        }
        String result = "";
        if (strike == 0 && ball == 0) {
            result = "낫싱";
        } else if (strike == 0 && ball != 0) {
            result = String.format("%d볼", ball);
        } else if (ball == 0 && strike != 0) {
            result = String.format("%d스트라이크", strike);
        } else {
            result = String.format("%d볼 %d스트라이크", ball, strike);
        }
        return result;
    }

    private static void userInputNumber() {
        userNumberList = new ArrayList<>();

        System.out.print("숫자를 입력해주세요:");
        String userInput = Console.readLine();

        if (!userInput.matches("^[1-9]{3}$")) {
            throw new IllegalArgumentException();
        }
        for(int i = 0; i < userInput.length(); i++) {
            userNumberList.add(userInput.charAt(i) - 48);
        }
    }

    private static void createRandomNumber() {
        answerNumberList = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            int random = Randoms.pickNumberInRange(1, 9);

            while (answerNumberList.contains((random))) {
                random = Randoms.pickNumberInRange(1, 9);
            }
            answerNumberList.add(random);
        }
    }


}
