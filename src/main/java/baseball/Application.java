package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    private static void playGame() {
        String answer = createRandomNumber();
        boolean isAnswer = false;

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (!isAnswer) {
            // TODO: 게임 진행
        }
    }

    private static String createRandomNumber() {
        String answer = new String();

        while (answer.length() < 3) {
            String randomNumber = String.valueOf(Randoms.pickNumberInRange(1, 9));
            if (!answer.contains(randomNumber)) {
                answer += randomNumber;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        playGame();
    }
}
