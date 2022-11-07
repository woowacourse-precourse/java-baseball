package baseball;

/**
 * Game 전체 주기를 관리하는 클래스. 게임의 재실행 및 종료와 같은 기능을 담당
 */
public class NumberBaseballGameApplication {

    /**
     * GameApplication 실행 메서드
     */
    void execute() {
        IntentionOfContinuingGame userIntention;

        IOManager.println("숫자 야구 게임을 시작합니다.");
        do {
            NumberBaseballGame numberBaseballGame = new NumberBaseballGame();
            numberBaseballGame.run();

            IOManager.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            userIntention = IntentionOfContinuingGame.getMatchIntention(IOManager.getNextInt());
        } while (userIntention.wantContinue());
    }
}
