package baseball;


import baseball.model.Answer;
import baseball.model.Nums;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

import static baseball.Judgment.getJudg;
import static baseball.Random.generateRandomNumber;

public class Application {
    public static void main(String[] args) {
        int endGame = 0;
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (endGame != 2) {
            startGame();
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            endGame = Integer.parseInt(Console.readLine());
        }
    }

    public static void baseballGame() {
        Answer answer = new Answer(generateRandomNumber(3));

        int[] judg = new int[]{0, 0};
        while (judg[1] != 3) {
            System.out.print("숫자를 입력해주세요 : ");
            judg = getJudg(answer);
        }
    }

    private static void startGame() {
        try {
            baseballGame();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            throw e;
        }
    }

}
