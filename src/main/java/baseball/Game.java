package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Game {

    public static void run() {

        boolean status = Game.playGame();
        List<Integer> answer = Answer.createAnswer();

        while (status) {

            System.out.println("숫자를 입력해주세요 : ");
            String number = Console.readLine();
            List<Integer> digitList = Convert.convertNumberToDigit(number);

            List<Integer> countList = new ArrayList<>();    // Index ( 0 : BALL / 1 : STRIKE )
            countList.add(Count.countBall(answer, digitList));
            countList.add(Count.countStrike(answer, digitList));
            Count.showCount(countList);

            if (Answer.checkAnswer(countList)) {
                status = Game.restartGame();
                answer = Answer.createAnswer();
            }

        }

        return;

    }

    public static boolean playGame() {

        System.out.println("숫자 야구 게임을 시작합니다.");

        return true;

    }

    public static boolean restartGame() {

        String answer;

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        answer = Console.readLine();

        if (Integer.parseInt(answer) == 1) {
            return true;    // 게임 재시작
        } else {
            System.out.println("게임 종료");
            return false;
        }

    }
}
