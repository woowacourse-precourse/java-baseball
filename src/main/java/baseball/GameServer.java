package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class GameServer {
    public List<Integer> computerNumbers;
    public List<Integer> userNumbers;
    public String userNumber;
    private boolean restart;
    private boolean isAnswer;
    int strike;
    int ball;

    public GameServer() {
        computerNumbers = new ArrayList<>();
        userNumbers = new ArrayList<>();
        restart = false;
        isAnswer = false;
        userNumber = "";
        strike = 0;
        ball = 0;
    }

    public void createRandomNumber() {
        computerNumbers.clear();
        while (computerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
    }

    public String getUserNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        userNumber = Console.readLine();
        return userNumber;
    }

    public void setUserNumber(String userNum) {
        int userNumber = Integer.parseInt(userNum);
        int divideNum = 100;
        userNumbers.clear();
        for (int i = 0; i < 3; i++) {
            userNumbers.add(userNumber / divideNum);
            userNumber %= divideNum;
            divideNum /= 10;
        }
    }

    public void catchInputException(String userNumber)
            throws IllegalArgumentException {
        if (userNumber.length() != 3) {
            throw new IllegalArgumentException();//사용할 때 try-catch문으로 throw처리
        }
        if (!userNumber.matches("^[1-9]*$")) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < 2; i++) {
            String str = userNumber.substring(i + 1, 2);
            if (str.contains(userNumber.substring(i, i + 1))) {
                throw new IllegalArgumentException();
            }
        }
    }

    public void correctAnswer() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        userNumber = Console.readLine();
        decideRestart(userNumber);
    }

    public void decideRestart(String userNum) {
        if (userNum.equals("1")) {
            restart = true;
            isAnswer = false;
        }
        if (userNum.equals("2")) {
            restart = false;
        }
        if (!(userNum.equals("1") || userNum.equals("2"))) {
            throw new IllegalArgumentException();
        }
    }

    public void checkUsersInputIsAnswer() {
        strike = 0;
        ball = 0;
        for (int i = 0; i < 3; i++) {
            if (computerNumbers.get(i) == userNumbers.get(i)) {
                ++strike;
            } else if (computerNumbers.contains(userNumbers.get(i))) {
                ++ball;
            }
        }
    }

    private void printGameResult() {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
            isAnswer = false;
        }
        if (strike != 0 && ball == 0) {
            System.out.println(strike + "스트라이크");
            isAnswer = false;
        }
        if (strike == 0 && ball != 0) {
            System.out.println(ball + "볼");
            isAnswer = false;
        }
        if (strike != 0 && ball != 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
            isAnswer = false;
        }
        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            isAnswer = true;
        }
    }

    public void gameStart() {
        printGameStart();
        do {
            createRandomNumber();
            guessAnswer();
            correctAnswer();
        } while (restart);
    }

    public void guessAnswer() {
        while (!isAnswer) {
            userNumber = getUserNumber();
            setUserNumber(userNumber);
            try {
                catchInputException(userNumber);
            } catch (IllegalArgumentException e) {
                return;
            }
            checkUsersInputIsAnswer();
            printGameResult();
        }
    }

    public void printGameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
}
