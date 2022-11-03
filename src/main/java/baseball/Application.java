package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class Application {
    static int strike = 0, ball = 0;

    public static void main(String[] args) {

        System.out.println("숫자 야구 게임을 시작합니다.");

        List<Integer> answer = new ArrayList<>(3);
        List<Integer> user_answer = new ArrayList<>(3);
        getRandomNum(answer, user_answer);
    }


    public static void getRandomNum(List<Integer> answer, List<Integer> userAnswer) {
        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
        getUserAnswer(answer, userAnswer);
    }

    public static void getUserAnswer(List<Integer> answer, List<Integer> userAnswer) {
        userAnswer.clear();
        strike = 0;
        ball = 0;
        System.out.print("숫자를 입력해주세요 : ");
        int user_answer = Integer.parseInt(Console.readLine());
        if (user_answer < 1000 && user_answer > 99) {
            for (int i = 0; i < 3; i++) {
                userAnswer.add(user_answer % 10);
                user_answer = user_answer / 10;
            }
            Collections.reverse(userAnswer);
            compare_Answer(answer, userAnswer);
        } else throw new IllegalArgumentException("잘못된 값 입력.");
    }

    public static void compare_Answer(List<Integer> answer, List<Integer> userAnswer) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                compare_eachAnswer(i, j, answer, userAnswer);
            }
        }
        check_Answer(answer, userAnswer);

    }

    public static void compare_eachAnswer(int i, int j, List<Integer> answer, List<Integer> userAnswer) {
        if (i == j) {
            if (Objects.equals(answer.get(i), userAnswer.get(j)))
                strike++;
        } else if (Objects.equals(answer.get(i), userAnswer.get(j)))
            ball++;
    }

    public static void check_Answer(List<Integer> answer, List<Integer> userAnswer) {
        String ball_announcement = "";
        String strike_announcement = "";

        if (strike != 0)
            strike_announcement = strike + "스트라이크";
        if (ball != 0)
            ball_announcement = ball + "볼";
        if (strike == ball)
            System.out.print("낫싱");
        if (strike == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            restart_game();
        } else {
            System.out.println(ball_announcement + " " + strike_announcement);
            getUserAnswer(answer, userAnswer);
        }
    }

    public static void restart_game() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        if (Integer.parseInt(Console.readLine()) == 1) {
            List<Integer> answer = new ArrayList<>(3);
            List<Integer> user_answer = new ArrayList<>(3);
            getRandomNum(answer, user_answer);
        }
    }
}