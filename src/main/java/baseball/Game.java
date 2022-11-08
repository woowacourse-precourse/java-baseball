package baseball;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

class Game {
    List<Integer> userNumber, computerNumber;
    User user = new User();
    Computer computer = new Computer();

    void init() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        System.out.println("숫자를 입력해주세요 : ");

        computerNumber = computer.computerNumber();

        play();
    }

    void play() {
        int restart = 1;

        while(restart == 1) {
            user.input();
            userNumber = user.userNumber();
            int strikeCount = strike(), ballCount = ball();

            if(nothing()) {
                System.out.println("낫싱");
                System.out.println("숫자를 입력해주세요 : ");
                continue;
            }

            if(strikeCount == 3) {
                System.out.println(strikeCount + "스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                restart = Integer.parseInt(readLine());
            } else {
                System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
                userNumber.clear();
            }

            if(restart != 1 && restart != 2) {
                throw new IllegalArgumentException();
            }

            if(strikeCount == 3 && restart == 1) {
                System.out.println("숫자를 입력해주세요 : ");

                computerNumber.clear();
                computerNumber = computer.computerNumber();
            }
        }
    }

    int strike() {
        int cnt = 0;

        for(int i = 0; i < 3; i++) {
            if(computerNumber.get(i).equals(userNumber.get(i))) {
                cnt++;
            }
        }

        return cnt;
    }

    int ball() {
        int cnt = 0;


        if(computerNumber.get(0).equals(userNumber.get(1)) || computerNumber.get(0).equals(userNumber.get(2))) {
            cnt++;
        }
        if(computerNumber.get(1).equals(userNumber.get(0)) || computerNumber.get(1).equals(userNumber.get(2))) {
            cnt++;
        }
        if(computerNumber.get(2).equals(userNumber.get(0)) || computerNumber.get(2).equals(userNumber.get(1))) {
            cnt++;
        }

        return cnt;
    }

    boolean nothing() {
        int strikeCount, ballCount;

        strikeCount = strike();
        ballCount = ball();

        if(strikeCount == 0 && ballCount == 0) {
            return true;
        }

        return false;
    }
}
