package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

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
            if (isPick[randomDigit-1]) {
                continue;
            }
            randomNumber.add(randomDigit);
            isPick[randomDigit-1] = true;
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

    public ArrayList<Integer> getNumber() {
        ArrayList<Integer> answerNumber;
        try {
            String answer = readLine().replace(" ", "");
            answerNumber = stringToArrayListInteger(answer);
            checkOverlap(answerNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        return answerNumber;
    }

    private ArrayList<Integer> stringToArrayListInteger(String answerString) {
        ArrayList<Integer> answerArrayListInteger = new ArrayList<>();
        for (String number : answerString.split("")) {
            answerArrayListInteger.add(Integer.parseInt(number));
        }
        return answerArrayListInteger;
    }

    private void checkOverlap(ArrayList<Integer> arrayList) {
        Set<Integer> hashSet = new HashSet<>(arrayList);
        if (arrayList.size() != hashSet.size()) {
            throw new IllegalArgumentException();
        }
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
