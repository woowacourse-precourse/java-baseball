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
}
