package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    static boolean isContinue = true;

    public static void main(String[] args) {
        printInitMessage();
        while (isContinue) {
            play();
        }
    }

    private static void printInitMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void play() {
        List<Integer> answer = pickThreeNumbers();
        String hint = "";

        while (!hint.equals("3스트라이크")) {
            List<Integer> userAnswer = stringConvertToIntegerList(getUserAnswer()); // 입력받은 값을 리스트로 변경
            Score score = checkAnswer(answer, userAnswer);
            hint = score.getScore();
            System.out.println(hint);
        }
        printGameOver();
        setIsContinue(Console.readLine());
    }

    public static List<Integer> pickThreeNumbers() {
        List<Integer> result = new ArrayList<>();
        while (result.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!result.contains(randomNumber)) {
                result.add(randomNumber);
            }
        }
        return result;
    }

    public static List<Integer> stringConvertToIntegerList(String str) {
        return Arrays.stream(str.split(""))
                .map(el -> Integer.parseInt(el))
                .collect(Collectors.toList());
    }

    private static String getUserAnswer() {
        System.out.print("숫자를 입력해주세요 : ");
        String result = Console.readLine();
        if (!isValid(result)) {
            throw new IllegalArgumentException();
        }

        return result;
    }

    public static boolean isValid(String str) {
        if (str.length() != 3) return false;
        for (int i = 0; i < str.length(); i++) {
            if (!('0' <= str.charAt(i) && str.charAt(i) <= '9')) {
                return false;
            }
        }

        return true;
    }

    public static Score checkAnswer(List<Integer> answer, List<Integer> userAnswer) {
        Score score = new Score(); // 점수 초기화

        for (int i = 0; i < 3; i++) {
            if (answer.get(i).equals(userAnswer.get(i))) {
                // 같은 자리에 있는 경우
                score.plusStrike();
                continue;
            }
            if (answer.contains(userAnswer.get(i))) {
                // 다른 자리에 있는 경우
                score.plusBall();
            }
        }

        return score;
    }

    private static void printGameOver() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public static void setIsContinue(String selectedNum) {
        if (selectedNum.equals("1")) {
            isContinue = true;
        } else {
            isContinue = false;
        }
    }

}
