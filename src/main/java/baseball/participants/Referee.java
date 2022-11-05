package baseball.participants;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Referee {
    public static boolean isGameInProgress;

    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        this.isGameInProgress = true;
    }

    public String startPitch() {
        System.out.println("3자리 숫자를 입력해주세요 : ");
        String pitch = readLine();
        return pitch;
    }

    public void judge(Pitcher  pitcher, Hitter hitter) {
    }

    public void endGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        this.isGameInProgress = false;
    }
}
