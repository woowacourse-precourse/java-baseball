package baseball.participants;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Referee {
    public static boolean isGameInProgress;
    private final String PLAY_AGAIN = "1";
    private final String TERMINATE = "2";

    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        this.isGameInProgress = true;
    }

    public void startPitch() {
        System.out.println("3자리 숫자를 입력해주세요 : ");
    }

    public void judge(Pitcher  pitcher, Hitter hitter) {
    }

    public String playAgainOrTerminate() {
        String againOrTerminate = readLine();
        while (!validatePlayAgain(againOrTerminate)) {
            System.out.println(PLAY_AGAIN + " 혹은 " + TERMINATE + "만 입력해주세요.");

            againOrTerminate = readLine();
        }
        if (againOrTerminate.equals(PLAY_AGAIN)) {
            System.out.println("게임을 다시 시작합니다.");
        }
        if (againOrTerminate.equals(TERMINATE)) {
            System.out.println("게임을 완전히 종료합니다.");
        }
        return againOrTerminate;
    }

    public void endGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        this.isGameInProgress = false;
    }

    private boolean validatePlayAgain(String againOrTerminate) {
        return againOrTerminate.equals(PLAY_AGAIN) || againOrTerminate.equals(TERMINATE);
    }
}
