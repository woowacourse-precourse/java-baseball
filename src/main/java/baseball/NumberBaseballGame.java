package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class NumberBaseballGame {
    private final int MAX_NUMBER_SIZE = 3;
    private int goGameAnswer;
    private List<Integer> randomNumber = new ArrayList<>();
    private int[] gameResults = {0, 0};
    private String number;

    // 게임 시작 후 랜덤 숫자 생성 메소드
    public void gameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        goGameAnswer = 1;
        createRandomNumber();
    }

    // 게임 지속 여부 반환하기
    public int getGoGameAnswer() {
        return goGameAnswer;
    }

    // 사용자로부터 숫자를 입력받는 메소드
    public void inputNumber() {
        System.out.println(randomNumber);
        System.out.print("숫자를 입력해주세요 : ");
        number = Console.readLine();
    }

    // 숫자 판단으로 게임 결과 체크하기
    public void countGameResults() {
        gameResults = new int[]{0, 0};
        for (int i = 0; i < MAX_NUMBER_SIZE; i++) {
            int dividedNumber = Integer.parseInt(String.valueOf(number.charAt(i)));
            hasNumber(dividedNumber, i);
        }
    }

    // 해당 숫자가 포함되어 있는지 확인하기
    public void hasNumber(int dividedNumber, int index) {
        if (randomNumber.get(index) == dividedNumber) {
            gameResults[0]++;
        } else if (randomNumber.contains(dividedNumber)) {
            // 같은 자리는 아니지만 해당 값을 포함하고 있다면
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
            createRandomNumber();
        }
    }

    // 중복 없는 세자리 난수 생성
    // 들여쓰기 3 이상
    public void createRandomNumber() {
        randomNumber.clear();
        while (randomNumber.size() < MAX_NUMBER_SIZE) {
            int number = Randoms.pickNumberInRange(1, 9);
            if (!randomNumber.contains(number)) {
                randomNumber.add(number);
            }
        }
    }

}
