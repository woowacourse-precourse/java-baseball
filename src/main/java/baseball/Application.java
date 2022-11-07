package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException {
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> computer = new ArrayList<>();

        while (true) {
            while (computer.size() < 3) {
                addComputerNumber(computer, getRandomNumber());
            }

            List<Integer> user = new ArrayList<>();
            System.out.print("숫자를 입력해주세요 : ");
            String userNumber = Console.readLine();
            checkNumberLength(userNumber);
            for (int i = 0; i < 3; i++) {
                int number = charToInt(userNumber.charAt(i));
                checkAdequateNumber(number);
                addUserNumber(user, number);
            }

            Count c = new Count();
            c.countBall(computer, user);
            c.countStrike(computer, user);

            int answer = c.printCount();
            if (answer == 1) {
                computer.clear();
            } else if (answer == 2) {
                break;
            }
        }
    }

    static void addComputerNumber(List<Integer> computer, int randomNumber) {
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber);
        }
    }

    static int getRandomNumber() {
        return Randoms.pickNumberInRange(1, 9);
    }

    static void checkNumberLength(String userNumber) throws IllegalArgumentException {
        if (userNumber.length() != 3) {
            throw new IllegalArgumentException();
        }
    }

    static int charToInt(char number) {
        return Character.getNumericValue(number);
    }

    static void checkAdequateNumber(int number) throws IllegalArgumentException {
        if (number < 1 || number > 9) {
                throw new IllegalArgumentException();
        }
    }

    static void addUserNumber(List<Integer> user, int number) throws IllegalArgumentException {
        if (checkOverlap(user, number)) {
            user.add(number);
        }
    }

    static boolean checkOverlap(List<Integer> list, int number) throws IllegalArgumentException {
        if (list.contains(number)) {
            throw new IllegalArgumentException();
        } else {
            return true;
        }
    }
}

class Count {
    int ball;
    int strike;

    Count() {
        ball = 0;
        strike = 0;
    }

    int getBall() {
        return this.ball;
    }

    void countBall(List<Integer> computer, List<Integer> user) {
        for (int i = 0; i < 3; i++) {
            if (computer.contains(user.get(i))) {
                this.ball++;
            }
        }
    }

    void countStrike(List<Integer> computer, List<Integer> user) {
        for (int i = 0; i < 3; i++) {
            if (computer.get(i).equals(user.get(i))) {
                this.strike++;
                this.ball--;
            }
        }
    }

    int printCount() {
        if (this.ball == 0 && this.strike == 0) {
            System.out.println("낫싱");
        } else if (this.strike == 0) {
            printBall(this.ball);
            System.out.println();
        } else if (this.ball == 0) {
            printStrike(this.strike);
            System.out.println();
            if (this.strike == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                return restartOrExit();
            }
        } else {
            printBall(this.ball);
            System.out.print(" ");
            printStrike(this.strike);
            System.out.println();
        }
        return 3;
    }

    void printBall(int ball) {
        System.out.printf("%d볼", ball);
    }

    void printStrike(int strike) {
        System.out.printf("%d스트라이크", strike);
    }

    static int restartOrExit() throws IllegalArgumentException {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int answer = Integer.parseInt(Console.readLine());
        if (answer != 2 && answer != 1) {
            throw new IllegalArgumentException();
        }
        return answer;
    }
}