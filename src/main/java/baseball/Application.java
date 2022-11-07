package baseball;

import static java.lang.System.out;

import domain.Computer;
import domain.Referee;
import domain.User;
import java.util.Scanner;

public class Application {

    public static final int END_CODE = 1;
    public static final int SUCCESS_CODE = 3;

    public static void main(String[] args) {
        User user = new User();
        Computer computer = new Computer();
        Referee referee = new Referee(computer, user);

        out.println("숫자 야구 게임을 시작합니다.");

        int playingStatus;
        do {
            Scanner scanner = new Scanner(System.in);
            playBaseballGame(user, computer, referee, scanner);
            playingStatus = user.isEndGame(scanner);
        } while (playingStatus == END_CODE);
    }

    private static void playBaseballGame(User user, Computer computer, Referee referee, Scanner scanner) {
        computer.createRandomNumbers();

        while (true) {
            user.init();
            out.print("숫자를 입력해주세요 : ");
            user.guessComputerNumbers(scanner);
            referee.init();
            referee.judge();

            if (getRefereeBall(referee) > 0 && getRefereeStrike(referee) == 0) {
                out.println(getRefereeBall(referee) + "볼");
            }

            if (getRefereeStrike(referee) > 0 && getRefereeBall(referee) == 0) {
                out.println(getRefereeStrike(referee) + "스트라이크");
            }

            if (getRefereeBall(referee) > 0 && getRefereeStrike(referee) > 0) {
                out.println(getRefereeBall(referee) + "볼 " + getRefereeStrike(referee) + "스트라이크");
            }

            if (getRefereeBall(referee) == 0 && getRefereeStrike(referee) == 0) {
                out.println("낫싱");
            }

            if (getRefereeStrike(referee) == SUCCESS_CODE) {
                user.init();
                referee.init();
                computer.init();
                out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

    private static int getRefereeBall(Referee referee) {
        return referee.getBall();
    }

    private static int getRefereeStrike(Referee referee) {
        return referee.getStrike();
    }

}
