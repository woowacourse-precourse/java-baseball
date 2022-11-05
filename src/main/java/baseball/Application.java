package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 출력: 숫자 야구 게임을 시작합니다.
        Application newGame = new Application();
        newGame.startGame();
    }

    public void startGame() {
        ArrayList<Integer> correctNumber = settingNumber();
        askAndAnswerLoop(correctNumber);
    }

    public ArrayList<Integer> settingNumber() {
        boolean[] isPick = new boolean[9];
        int randomDigit;
        ArrayList<Integer> randomNumber = new ArrayList<>();
        int pick = 0;
        while (pick < 3) {
            randomDigit = Randoms.pickNumberInRange(1, 9);
            if (isPick[randomDigit]) {
                continue;
            }
            randomNumber.add(randomDigit);
            isPick[randomDigit] = true;
            pick++;
        }
        return randomNumber;
    }

    private void askAndAnswerLoop(ArrayList<Integer> correctNumber) {
        ArrayList<Integer> askNumber;
        boolean loop = true;
        while (loop) {
            askNumber = getNumber();
            loop = compareOfNumber(correctNumber, askNumber);
        }
        // 종료문구 출력
        if (askRetry()) {
            this.startGame();
        }
    }

    private ArrayList<Integer> getNumber() {
        ArrayList<Integer> askNumber = new ArrayList<>();
        //사용자에게 숫자 3개 입력받고 예외 검사
        return askNumber;
    }

    private boolean compareOfNumber(ArrayList<Integer> correctNumber, ArrayList<Integer> askNumber) {
        // 비교하며, 몇 볼, 몇 스트라이크 or 낫싱 인지 출력
        // 만약 3스트라이크면 false 반환
        return true;
    }

    private boolean askRetry() {
        // 입력받기
        return false;
    }
}
