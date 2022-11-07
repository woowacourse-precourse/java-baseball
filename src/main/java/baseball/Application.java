package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {

    public static boolean playGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        return true;
    }

    public static boolean restartGame() {

        int answer;

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        answer = Integer.parseInt(Console.readLine());

        if (answer == 1) {
            return true;    // 게임 재시작
        } else {
            return false;   // 게임 종료
        }

    }

    public static List<Integer> createAnswer() {

        List<Integer> answer = new ArrayList<>();
        while (answer.size() < 3) {
            int randNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randNumber)) {
                answer.add(randNumber);
            }
        }
        return answer;
    }

    public static boolean checkAnswer(List<Integer> answer) {   // Index ( 0 : BALL / 1 : STRIKE )
        if (answer.get(1) == 3) {
            return true;
        } else {
            return false;
        }
    }

    public static List<Integer> separateNumberToDigit(int number) {

        List<Integer> digits = new ArrayList<>();

        while (number > 0) {
            digits.add(number % 10);
            number /= 10;
        }

        Collections.reverse(digits);

        return digits;

    }

    public static Integer countBall(List<Integer> answer, List<Integer> digits) {

        int count = 0;

        for (int i = 0; i < digits.size(); i++) {

            int digit = digits.get(i);

            for (int j = 0; j < answer.size(); j++) {

                if (answer.get(j) == digit && i != j) {
                    count++;
                }

            }
        }

        return count;
    }

    public static Integer countStrike(List<Integer> answer, List<Integer> digits) {

        int count = 0;

        for (int i = 0; i < digits.size(); i++) {

            int digit = digits.get(i);

            for (int j = 0; j < answer.size(); j++) {

                if (answer.get(j) == digit && i == j) {
                    count++;
                }

            }
        }

        return count;
    }

    public static void main(String[] args) {

        boolean status = playGame();
        List<Integer> answer = createAnswer();

        while (status != false) {

            System.out.print("숫자를 입력해주세요 : ");
            int number = Integer.parseInt(Console.readLine());
            List<Integer> digits = separateNumberToDigit(number);

            List<Integer> count = new ArrayList<>();    // Index ( 0 : BALL / 1 : STRIKE )
            count.add(countBall(answer, digits));
            count.add(countStrike(answer,digits));

            if (checkAnswer(count)) {
                status = restartGame();
                answer = createAnswer();
            }
        }

    }


}
