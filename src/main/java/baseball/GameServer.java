package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class GameServer {
    private List<Integer> computerNumbers = new ArrayList<>();
    private List<Integer> userNumbers = new ArrayList<>();
    private boolean restart = false;
    private boolean isNothing = false;


    public void createRandomNumber() {
        while (computerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
    }

    public String getUserNumber() {
        String userNumber = Console.readLine();
        return userNumber;
    }

    public void setUserNumber(String userNum) {
        int userNumber = Integer.parseInt(userNum);
        int divideNum = 100;
        for (int i = 0; i < 3; i++) {
            userNumbers.add(userNumber / divideNum);
            userNumber /= divideNum;
            divideNum /= 10;
        }
    }

    public void catchInputException(String userNumber)
            throws IllegalArgumentException {
        if (userNumber.length() != 3) {
            throw new IllegalArgumentException();//사용할 때 try-catch문으로 throw처리
        }
        if (userNumber.matches("^[1-9]*$")) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < 2; i++) {
            String str = userNumber.substring(i + 1, 2);
            if (str.contains(userNumber.substring(i, i + 1))) {
                throw new IllegalArgumentException();
            }
        }
    }

    public void finishGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userNumber = Console.readLine();
        if (userNumber.equals("1")) {
            restart = true;
        }
        if (userNumber.equals("2")) {
            restart = false;
        }
        if (!(userNumber.equals("1") || userNumber.equals("2"))) {
            restart = false;
        }
    }

    public List<Integer> checkUsersInputIsAnswer() {
        int strike = 0;
        int ball = 0;
        List<Integer> numStrikeBall = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (computerNumbers.get(i) == userNumbers.get(i)) {
                ++strike;
            }
            if (computerNumbers.get(i) != userNumbers.get(i)) {
                ++ball;
            }
            if (strike == 0 && ball == 0) {
                isNothing = true;
            }
        }
        numStrikeBall.add(strike);
        numStrikeBall.add(ball);
        return numStrikeBall;
    }

    public void printGameResult(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        }
        if (strike != 0 && ball == 0) {
            System.out.println(strike + "스트라이크");
        }
        if (strike == 0 && ball != 0) {
            System.out.println(ball + "볼");
        }
        if (strike != 0 && ball != 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
        if(strike==3){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }

    public void printGameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

}
