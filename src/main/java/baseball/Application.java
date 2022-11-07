package baseball;

import java.util.*;

import baseball.model.UserGenerate;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static final int NUM_SIZE = 3;
    public static void main(String[] args) {
        GameStart();
    }

    private static List<Integer> ComputerGenerate() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < NUM_SIZE) {
            AddComputerValue(computer);
        }
        return computer;
    }

    private static List<Integer> AddComputerValue(List<Integer> computer) {
        int randomNumber = Randoms.pickNumberInRange(1,9);
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber);
        }
        return computer;
    }

    private static String Hint(List<Integer> computer, List<Integer> user) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i<NUM_SIZE; i++) {
            if (computer.get(i) == user.get(i)) {
                strike += 1;
                continue;
            }
            if (computer.contains(user.get(i))) {
                ball += 1;
            }
        }
        return (HintResult(strike,ball));
    }

    private static String HintResult(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            return ("낫싱");
        }
        if (strike == 3) {
            return ("3스트라이크");
        }
        if (strike == 0) {
            return (ball+"볼");
        }
        if (ball == 0) {
            return (strike+"스트라이크");
        }
        return (ball+"볼 "+strike+"스트라이크");
    }

    private static void GameRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int input = Integer.valueOf(Console.readLine());
        if (input == 1) {
            GameStart();
        }
    }

    private static void GameStart() {
        List<Integer> computer = ComputerGenerate();
        List<Integer> user = new UserGenerate().user;
        String result = "";

        while (!result.equals("3스트라이크")) {
            user = new UserGenerate().user;
            result = Hint(computer,user);
            System.out.println(result);
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        GameRestart();
    }
}
