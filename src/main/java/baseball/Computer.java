package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import static baseball.Constant.MAX_LENGTH;

public class Computer {
    Balls answer = new Balls();
    int strike, ball;

    public void randNumber() {
        while(answer.getSize() < 3) {
            int num = Randoms.pickNumberInRange(1, 9);
            answer.add(num);
        }
    }
}
