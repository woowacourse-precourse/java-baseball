package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        gameStart();
    }

    private static List<Integer> createRandomThreeNums() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static Boolean isNothing(List<Integer> userInput, List<Integer> computer) {
        boolean isNothing = true;
        for (Integer integer : userInput) {
            if (computer.contains(integer)) {
                isNothing = false;
                break;
            }
        }
        return isNothing;
    }

    public static int numberOfStrikes(List<Integer> userInput, List<Integer> computer) {
        int strike_cnt = 0;
        for (int i = 0; i < userInput.size(); i++) {
            if (userInput.get(i).equals(computer.get(i))) {
                strike_cnt++;
            }
        }
        return strike_cnt;
    }

    public static int numberOfBalls(List<Integer> userInput, List<Integer> computer) {
        int ball_cnt = 0;
        for (int i = 0; i < userInput.size(); i++) {
            if (!userInput.get(i).equals(computer.get(i)) && computer.contains(userInput.get(i))) {
                ball_cnt++;
            }
        }
        return ball_cnt;
    }

    public static void printResult(int strike_cnt, int ball_cnt) {
        List<String> result = new ArrayList<>();
        if (ball_cnt > 0) {
            result.add(ball_cnt + "볼");
        }

        if (strike_cnt > 0) {
            result.add(strike_cnt + "스트라이크");
        }
        System.out.println(String.join(" ", result));
    }

    public static void gameStart(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        int replay = 1;

        while (replay == 1) {
            List<Integer> computer = createRandomThreeNums();
            replay = userTry(computer);
        }
    }

    public static int userTry(List<Integer> computer) {
        boolean isRightAnswer = false;
        String replay_or_not = "";

        while (!isRightAnswer) {
            System.out.print("숫자를 입력해주세요 : ");
            String user_input = readLine();
            String[] user_input_list = user_input.split("");
            List<Integer> user = new ArrayList<>();

            for (String num : user_input_list) {
                user.add(Integer.valueOf(num));
            }

            if (isNothing(user, computer)) {
                System.out.println("낫싱");
                continue;
            }

            int strike = numberOfStrikes(user, computer);
            int ball = numberOfBalls(user, computer);

            printResult(strike, ball);

            if (strike == 3) {
                isRightAnswer = true;
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                replay_or_not = readLine();
                if (!replay_or_not.equals("1") && !replay_or_not.equals("2")) {
                    // TODO: 예외 처리
                }
            }
        }
        return Integer.parseInt(replay_or_not);
    }
}
