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

    public void judge(Balls player) throws IllegalArgumentException {
        strike = 0;
        ball = 0;
        for(int i = 0; i < MAX_LENGTH; i++) {
            if (answer.balls.get(i).equals(player.balls.get(i))) {
                strike++;
            }
            else if (answer.balls.contains(player.balls.get(i))) {
                ball++;
            }
        }
//        printResult();
    }
}
