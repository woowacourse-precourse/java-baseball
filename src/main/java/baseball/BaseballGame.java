package baseball;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class BaseballGame {
    private final int SIZE = 3;
    private final ArrayList<String> answer;
    public final ArrayList<String> inputs;
    private Check check;
    private int ballCount;
    private int strikeCount;

    public BaseballGame() {
        check = new Check();
        answer = new ArrayList<>(SIZE);// arrayList 의 크기 3으로 고정
        inputs = new ArrayList<>(SIZE);
        ballCount = 0;
        strikeCount = 0;
        initAnswer();

        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void run() {
        while (true) {
            System.out.print("숫자를 입력해 주세요: ");
            String input = Console.readLine();

            check.checkNumberInput(inputs, input, SIZE);
            System.out.println(input);

            countStrikeOrBall();
            printResult();

            if (checkTerminateOrContinue() == 0)
                return;
        }
    }

    private void initAnswer() {
        for (int i = 0; i < SIZE; i++)
            answer.add(Integer.toString(Randoms.pickNumberInRange(1, 9)));
    }

    private void countStrikeOrBall() {
        for (String s : inputs) {
            if (answer.contains(s) && (inputs.indexOf(s) == answer.indexOf(s)))
                strikeCount++;
            else if (answer.contains(s) && (inputs.indexOf(s) != answer.indexOf(s)))
                ballCount++;
        }
    }

    private void printResult() {
        if (strikeCount != 0 && ballCount != 0)
            System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
        else if (strikeCount == 0 && ballCount != 0)
            System.out.println(ballCount + "볼");
        else if (strikeCount != 0) {
            if (strikeCount == 3) {
                System.out.println("3스트라이크\n" +
                        "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                        "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            } else
                System.out.println(strikeCount + "스트라이크");
        } else
            System.out.println("낫싱");
    }

    private int checkTerminateOrContinue() {
        if (strikeCount == 3) {
            String continued = Console.readLine();
            System.out.println(continued);
            answer.clear();

            if (check.checkAnswer(continued)) {
                System.out.println("게임 종료");
                return 0;
            }

            initAnswer();   // 한 게임이 종료되었으므로 정답 초기화
        }

        ballCount = 0;
        strikeCount = 0;
        return 1;
    }
}