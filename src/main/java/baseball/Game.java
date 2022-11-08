package baseball;

import java.util.List;

class Game {
    List<Integer> computerNumber, userNumber;

    void start() {
        Computer computer = new Computer();
        this.computerNumber = computer.computerNumber();
        User user = new User();

        System.out.println("숫자를 입력해주세요 : ");

        user.input(); user.exception();
        this.userNumber = user.userNumber();
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
        } else if(computerNumber.get(1).equals(userNumber.get(0)) || computerNumber.get(1).equals(userNumber.get(2))) {
            cnt++;
        } else if(computerNumber.get(2).equals(userNumber.get(0)) || computerNumber.get(2).equals(userNumber.get(1))) {
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
