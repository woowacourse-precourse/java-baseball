package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void startApp() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        // TODO: 게임 시작 호출
    }

    public static void startGame() {
        String answer = createThreeDigitNumber(); // TODO: 3자리 숫자 랜덤 생성 호출
        boolean isAnswer = false;

        while (!isAnswer) {
            // TODO: 입력 호출
            // TODO: 정답 비교 호출
        }

        // TODO: 게임 종료 호출
    }

    public static String createThreeDigitNumber() {
        String answer = new String();

        while (answer.length() < 3) {
            String num = String.valueOf(Randoms.pickNumberInRange(1, 9));
            if (!answer.contains(num)) {
                answer += num;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        startApp();
    }
}
