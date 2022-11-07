package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class NumberBaseballGame {
    private final int MAX_NUMBER_SIZE = 3;
    private int goGameAnswer;
    private String randomNumber;
    private int[] gameResults = {0, 0};
    private String number;

    // 게임 시작 후 랜덤 숫자 생성 메소드
    public void gameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        goGameAnswer = 1;
        randomNumber = String.valueOf(Randoms.pickNumberInRange(100, 999));
    }

    // 사용자로부터 숫자를 입력받는 메소드
    public void inputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        System.out.println(randomNumber);
        number = Console.readLine();
    }

    // 숫자 판단으로 게임 결과 체크하기
    public void countGameResults() {
        gameResults = new int[]{0, 0};
        for (int i = 0; i < MAX_NUMBER_SIZE; i++) {
            char dividedNumber = number.charAt(i);
            hasNumber(dividedNumber, i);
        }
    }

    // 해당 숫자가 포함되어 있는지 확인하기
    public void hasNumber(char dividedNumber, int index) {
        if (randomNumber.indexOf(dividedNumber) == index) {
            gameResults[0]++;
        } else if (randomNumber.indexOf(dividedNumber) != -1) {
            gameResults[1]++;
        }
    }

    // 게임 결과 출력하기
    public void printGameResult() {
        if (gameResults[0] == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            inputGoGameAnswer();
        } else if (gameResults[0] == 0 && gameResults[1] == 0) {
            System.out.println("낫싱");
        } else {
            System.out.println(gameResults[0] + "스트라이크 " + gameResults[1] + "볼");
        }
    }

    // 게임 지속 여부 물어보기
    public void inputGoGameAnswer() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        goGameAnswer = Integer.parseInt(Console.readLine());

        if (goGameAnswer == 1) {
            randomNumber = String.valueOf(Randoms.pickNumberInRange(100, 999));
        }
    }

}
