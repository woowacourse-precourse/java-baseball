package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.*;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final String LENGTH_ERROR = "length is over three";
    private static final String INPUT_ERROR = "input is not a number";

    public static List<Integer> getStringToIntegerList(String userNum) {
        List<Integer> userNumList = new ArrayList<Integer>();
        for (char num : userNum.toCharArray()) {
            userNumList.add(Character.getNumericValue(num));
        }
        return userNumList;
    }

    public static List<Integer> getUserNum() {
        String userNum = readLine();
        if (inputErrorHandle(userNum) > 0)
            return null;
        return getStringToIntegerList(userNum);
    }

    public static int inputErrorHandle(String userNum) {
        if (ExceptionBaseball.checkUserNumAlpha(userNum)) {
            System.out.println(INPUT_ERROR);
            return 1;
        } else if (ExceptionBaseball.checkUserNumLength(userNum)) {
            System.out.println(LENGTH_ERROR);
            return 2;
        }
        return 0;
    }

    public static void showBallCount(int ball, int strike) {
        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
        } else if (ball > 0) {
            System.out.printf("%d볼 ", ball);
        } else if (strike > 0) {
            System.out.printf("%d스트라이크\n", strike);
        }
    }
    public static int showPrompt(List<Integer> answer) {
        List<Integer> userNum;
        boolean result = false;
        while (result == false) {
            System.out.println("숫자를 입력해주세요 : ");
            if ((userNum = getUserNum()) == null)
                continue;
            int strike = CheckBallCount.countStrike(userNum, answer);
            int ball = CheckBallCount.countBall(userNum, answer);
            showBallCount(ball, strike);
            if (strike == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                result = true;
            }
        }
//        while (true) {
//            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
//            try {
//                int ExitOrNew = Integer.parseInt(readLine());
//                if (ExitOrNew != 1 && ExitOrNew != 2) {
//                    System.out.println("1 혹은 2를 입력해주세요");
//                    continue;
//                }
//                return ExitOrNew;
//            } catch (Exception e) {
//                System.out.println("숫자를 입력해주세요");
//            }
//        }
        return 1;
    }

    public static List<Integer> getAnswer() {
        List<Integer> answer = new ArrayList<>();
        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<Integer> answer = getAnswer();
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            int result = showPrompt(answer);
            if (result == 2)
                break;
        }
    }
}
