package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

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
    public static boolean showPrompt(List<Integer> answer) {
        List<Integer> userNumList;
        int strike = 0;
        int ball = 0;
        String userNum = null;
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            System.out.println("숫자를 입력해주세요 : ");
            userNum = Console.readLine();
            userNumList = getStringToIntegerList(userNum);
            if (ExceptionBaseball.checkUserNumAlpha(userNum)) {
                System.out.println(INPUT_ERROR);
                continue;
            } else if (ExceptionBaseball.checkUserNumLength(userNum)) {
                System.out.println(LENGTH_ERROR);
                continue;
            }
        }
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
        System.out.println(answer);
        showPrompt(answer);
    }
}
