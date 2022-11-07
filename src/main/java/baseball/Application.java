package baseball;

import static java.lang.System.out;

import domain.Computer;
import domain.Referee;
import domain.User;

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
            playBaseballGame(user, computer, referee);
            playingStatus = user.isEndGame();
        } while (playingStatus == END_CODE);
    }

    private static void playBaseballGame(User user, Computer computer, Referee referee) {
        computer.init();
        computer.createRandomNumbers();

        do {
            user.init();
            out.print("숫자를 입력해주세요 : ");
            user.guessComputerNumbers();
            referee.init();
            referee.judge();

        } while (!isFinish(user, computer, referee));
    }

    private static boolean isFinish(User user, Computer computer, Referee referee) {

        int ballCnt = getRefereeBall(referee);
        int strikeCnt = getRefereeStrike(referee);

        if (ballCnt > 0 && strikeCnt == 0) {
            out.println(ballCnt + "볼");
        }

        if (strikeCnt > 0 && ballCnt == 0) {
            out.println(strikeCnt + "스트라이크");
        }

        if (ballCnt > 0 && strikeCnt > 0) {
            out.println(ballCnt + "볼 " + strikeCnt + "스트라이크");
        }

        if (ballCnt == 0 && strikeCnt == 0) {
            out.println("낫싱");
        }

        if (strikeCnt == SUCCESS_CODE) {
            user.init();
            referee.init();
            computer.init();
            out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }

        return false;
    }

    private static int getRefereeBall(Referee referee) {
        return referee.getBall();
    }

    private static int getRefereeStrike(Referee referee) {
        return referee.getStrike();
    }

}
