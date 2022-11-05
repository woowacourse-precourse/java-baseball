package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Application {
    static int goGame = 1;
    final static int MAX_NUMBER_SIZE = 3;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int strikeCount = 0;
        int ballCount = 0;
        String randomNumber = String.valueOf(pickNumberInRange(100, 999));

        System.out.println(randomNumber);
        System.out.println("숫자 야구 게임을 시작합니다.");
        // 숫자 입력 및 랜덤 수 생성
        System.out.print("숫자를 입력해주세요 : ");
        String number = readLine();

        for (int i = 0; i < MAX_NUMBER_SIZE; i++) {
            char dividedNumber = number.charAt(i);
            // dividedNumber의 자리수는 따로 구할 필요 없이 i를 사용한다.
            if (randomNumber.indexOf(dividedNumber) == i) {
                strikeCount++;
            } else if (randomNumber.indexOf(dividedNumber) != -1) {
                ballCount++;
            }
        }

        if (strikeCount == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            goGame = 2;
        }

        System.out.println(strikeCount + "스트라이크 " + ballCount + "볼");
    }
}
