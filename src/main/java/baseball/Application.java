package baseball;

import static java.lang.System.out;

import domain.Computer;
import domain.Referee;
import domain.User;

public class Application {

    public static void main(String[] args) {
        User user = new User();
        Computer computer = new Computer();
        Referee referee = new Referee(computer, user);

        out.println("숫자 야구 게임을 시작합니다.");
        playBaseballGame(user, computer, referee);
    }

    private static void playBaseballGame(User user, Computer computer, Referee referee) {
        computer.createRandomNumbers();

        while (getRefereeStrike(referee) != 3) {
            user.init();
            out.print("숫자를 입력해주세요 : ");
            user.guessComputerNumbers();
            referee.init();
            referee.judge();

            out.println(referee.getBall() + "볼" + getRefereeStrike(referee) + "스트라이크");

            if (getRefereeStrike(referee) == 3) {
                out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            }
        }
    }

    private static int getRefereeStrike(Referee referee) {
        return referee.getStrike();
    }

}
