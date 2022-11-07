package baseball;

import static baseball.Constant.*;

public class Application {
    public Computer computer;
    public Gamer gamer;

    public Application(Computer computer, Gamer gamer) {
        this.computer = computer;
        this.gamer = gamer;
    }
    public static void main(String[] args) {
        Computer computer = new Computer();
        Gamer gamer = new Gamer();
        Application application = new Application(computer, gamer);
        System.out.print("숫자 야구 게임을 시작합니다.");
        computer.makeRandomNumber();
        while (true) {
            application.gamer.inputNumber();
            int ball_num = application.countBall();
            int strike_num = application.countStrike();
        }
    }
    public int countBall() {
        int ball = 0;
        if (computer.randomNumber.get(FIRST) == gamer.gamerNumber.get(SECOND) ||
                computer.randomNumber.get(FIRST) == gamer.gamerNumber.get(THIRD)) {
            ball++;
        }
        if (computer.randomNumber.get(SECOND) == gamer.gamerNumber.get(FIRST) ||
                computer.randomNumber.get(SECOND) == gamer.gamerNumber.get(THIRD)) {
            ball++;
        }
        if (computer.randomNumber.get(THIRD) == gamer.gamerNumber.get(FIRST) ||
                computer.randomNumber.get(THIRD) == gamer.gamerNumber.get(SECOND)) {
            ball++;
        }
        return ball;
    }
    public int countStrike() {
        int strike = 0;
        for (int i = 0; i < GAMEPLAY_SIZE; i++) {
            if (computer.randomNumber.get(i) == gamer.gamerNumber.get(i)) {
                strike ++;
            }
        }
        return strike;
    }
}
