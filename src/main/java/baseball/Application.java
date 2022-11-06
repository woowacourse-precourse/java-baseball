package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;

public class Application {
    public static void main(String[] args) {
        List<Integer> computer = new ArrayList<>();
        getComputerNumber(computer);
        System.out.println("숫자 야구 게임을 시작합니다.");
        System.out.println(computer);

        List<Integer> user = new ArrayList<>();
        System.out.print("숫자를 입력해주세요 : ");
        String userNumber = Console.readLine();
        try {
            checkNumberLength(userNumber);
            checkAdequateNumber(userNumber);
            addUserNumber(user, userNumber);
        } catch (IllegalArgumentException e) {
            System.out.println("예외 발생");
            return;
        }

        Count c = new Count();

    }

    static void countBall(List<Integer> computer, List<Integer> user, Count c) {
        for (int i = 0; i < 3; i++) {
            if (computer.contains(user.get(i))) {
                c.ball++;
            }
        }
    }

    static void countStrike(List<Integer> computer, List<Integer> user, Count c) {
        for (int i = 0; i < 3; i++) {
            if (computer.get(i).equals(user.get(i))) {
                c.strike++;
                c.ball--;
            }
        }
    }


    static void addUserNumber(List<Integer> user, String userNumber) {
        for (int i = 0; i < userNumber.length(); i++) {
            int n = Character.getNumericValue(userNumber.charAt(i));
            if (checkOverlap(user, n)) {
                user.add(n);
            }
        }
    }

    static void checkAdequateNumber(String userNumber) throws IllegalArgumentException {
        for (int i = 0; i < userNumber.length(); i++) {
            int n = Character.getNumericValue(userNumber.charAt(i));
            if (n < 1 || n > 9) {
                throw new IllegalArgumentException();
            }
        }
    }

    static void getComputerNumber(List<Integer> computer) {
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    static void checkNumberLength(String userNumber) throws IllegalArgumentException {
        if (userNumber.length() != 3) {
            throw new IllegalArgumentException();
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

    void printCount() {
        if (this.ball == 0 && this.strike == 0) {
            System.out.println("낫싱");
        } else if (this.strike == 0) {
            System.out.printf("%d볼", this.ball);
        } else if (this.ball == 0) {
            System.out.printf("%d스트라이크", this.strike);
        } else if (this.strike == 3) {
            System.out.println("3스트라이크");
        } else {
            System.out.printf("%d볼 %d스트라이크", this.ball, this.strike);
        }
    }
}