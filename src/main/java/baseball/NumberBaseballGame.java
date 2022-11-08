package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.ArrayList;


public class NumberBaseballGame {
    private final int maxNumberSize = 3;
    private int ContinueGame;
    private List<Integer> randomNumber = new ArrayList<>();
    private int[] gameResults = {0, 0};
    private String number;

    // 게임 시작시 멘트 출력 메소드
    public void StartGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        ContinueGame = 1;
        CreateRandomNumber();
    }

    // 중복 없는 세자리 난수 생성
    public void CreateRandomNumber() {
        randomNumber.clear();
        while (randomNumber.size() < maxNumberSize) {
            int insertTempNumber = Randoms.pickNumberInRange(1, 9);
            insertNotDuplicatedNumber(insertTempNumber);
        }
    }

    // 중복이 아니라면 난수를 배열 안에 넣는 메소드
    public void insertNotDuplicatedNumber(int insertTempNumber) {
        if (!randomNumber.contains(insertTempNumber)) {
            randomNumber.add(insertTempNumber);
        }
    }

    // 게임 지속 여부 반환하기
    public int getContinueGame() {
        return ContinueGame;
    }

    // 사용자로부터 숫자를 입력받는 메소드
    public String inputNumber() {
        // System.out.println(randomNumber);
        System.out.print("숫자를 입력해주세요 : ");
        number = Console.readLine();
        return number;
    }

    // 숫자 비교분석으로 게임 결과 체크하기
    public void CountResults() {
        gameResults = new int[] {0, 0};
        for (int i = 0; i < maxNumberSize; i++) {
            int dividedNumber = Integer.parseInt(String.valueOf(number.charAt(i)));
            hasNumber(dividedNumber, i);
        }
    }

    // 입력 숫자가 임의값에 포함되어 있는지 확인
    public void hasNumber(int dividedNumber, int index) {
        if (randomNumber.get(index) == dividedNumber) {
            gameResults[0]++;
        } else if (randomNumber.contains(dividedNumber)) {
            // 다른 자리값에 해당 값을 갖고 있다면 볼용으로 값 증가
            gameResults[1]++;
        }
    }

    // 게임 결과 출력하기
    public void PrintResult() {
        if (gameResults[0] == 3) {
            System.out.println(gameResults[0] + "스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            InputContinueGame();
        } else if (gameResults[0] == 0 && gameResults[1] == 0) {
            System.out.println("낫싱");
        } else if (gameResults[0] == 0) {
            System.out.println(gameResults[1] + "볼");
        } else if (gameResults[1] == 0) {
            System.out.println(gameResults[0] + "스트라이크");
        } else {
            System.out.println(gameResults[1] + "볼 " + gameResults[0] + "스트라이크");
        }
    }

    // 게임 지속 여부 물어보기
    public void InputContinueGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        ContinueGame = Integer.parseInt(Console.readLine());

        if (ContinueGame == 1) {
            CreateRandomNumber();
        } else {
            System.out.println("게임 종료");
        }
    }

}