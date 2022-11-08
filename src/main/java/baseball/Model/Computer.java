package baseball.Model;

import baseball.View.Message;
import camp.nextstep.edu.missionutils.Randoms;

import static baseball.View.Constant.*;

public class Computer {
    Balls answer = new Balls();
    public int strikeCount, ballCount;

    public void randNumber() {
        while(answer.getSize() < MAX_LENGTH) {
            int num = Randoms.pickNumberInRange(MIN_DIGIT, MAX_DIGIT);
            answer.add(num);
        }
    }

    public void judge(Balls player) throws IllegalArgumentException {
        strikeCount = 0;
        ballCount = 0;
        for(int i = 0; i < MAX_LENGTH; i++) {
            if (answer.balls.get(i).equals(player.balls.get(i))) {
                strikeCount++;
            }
            else if (answer.balls.contains(player.balls.get(i))) {
                ballCount++;
            }
        }
        Message.printResultMessage(strikeCount, ballCount);
    }
}
