package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Application {
    final static int NUMBER_SIZE = 3;

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
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
        while (pick < NUMBER_SIZE) {
            randomDigit = Randoms.pickNumberInRange(1, 9);
            if (isPick[randomDigit - 1]) {
                continue;
            }
            randomNumber.add(randomDigit);
            isPick[randomDigit - 1] = true;
            pick++;
        }
        return randomNumber;
    }

    private void askAndAnswerLoop(ArrayList<Integer> correctNumber) {
        ArrayList<Integer> askNumber;
        boolean correct = false;
        while (!correct) {
            askNumber = getNumber();
            correct = compareNumber(correctNumber, askNumber);
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        if (askRetry()) {
            this.startGame();
        }
    }

    private ArrayList<Integer> getNumber() {
        ArrayList<Integer> askNumber;
        try {
            String answer = readLine().replace(" ", "");
            askNumber = stringToArrayListInteger(answer);
            checkNumberSize(askNumber);
            checkOverlap(askNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        return askNumber;
    }

    private ArrayList<Integer> stringToArrayListInteger(String askString) {
        ArrayList<Integer> askArrayListInteger = new ArrayList<>();
        for (String number : askString.split("")) {
            askArrayListInteger.add(Integer.parseInt(number));
        }
        return askArrayListInteger;
    }

    private void checkNumberSize(ArrayList<Integer> arrayList) {
        if (arrayList.size() > 3) {
            throw new IllegalArgumentException();
        }
    }

    private void checkOverlap(ArrayList<Integer> arrayList) {
        Set<Integer> hashSet = new HashSet<>(arrayList);
        if (arrayList.size() != hashSet.size()) {
            throw new IllegalArgumentException();
        }
    }

    private boolean compareNumber(ArrayList<Integer> correctNumber, ArrayList<Integer> askNumber) {
        int ball = 0;
        int strike = 0;

        strike += countStrike(correctNumber, askNumber);
        if (strike < NUMBER_SIZE - 1) {
            ball += countBall(correctNumber, askNumber, strike);
        }
        printBallAndStrike(ball, strike);
        return strike == NUMBER_SIZE;
    }

    private int countStrike(ArrayList<Integer> correctNumber, ArrayList<Integer> askNumber) {
        int count = 0;
        for (int i = 0; i < NUMBER_SIZE; i++) {
            if (correctNumber.get(i).equals(askNumber.get(i))) {
                count++;
            }
        }
        return count;
    }

    private int countBall(ArrayList<Integer> correctNumber, ArrayList<Integer> askNumber, int strike) {
        int count = 0;
        for (Integer number : correctNumber) {
            if (askNumber.contains(number)) {
                count++;
            }
        }
        return count - strike;
    }

    private void printBallAndStrike(int ball, int strike) {
        if (ball == 0 && strike == 0) {
            System.out.print("낫싱");
        }
        if (ball != 0) {
            System.out.print(ball + "볼 ");
        }
        if (strike != 0) {
            System.out.print(strike + "스트라이크");
        }
        System.out.print("\n");
    }

    private boolean askRetry() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String answer = readLine().replace(" ", "");
        return checkValue(answer);
    }

    private boolean checkValue(String answer) {
        boolean[] retryOrExit = {true, false};
        String retry = "1";
        String exit = "2";
        if (answer.equals(retry) || answer.equals(exit)) {
            int answerIdx = answer.charAt(0) - '0' - 1;
            return retryOrExit[answerIdx];
        }
        throw new IllegalArgumentException();
    }
}
