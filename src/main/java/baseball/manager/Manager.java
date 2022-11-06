package baseball.manager;

/**
 * 게임의 매니저로서 게임의 시작과 종료를 관리
 *
 * @version 1.0.0
 * @author chlskreh2
 */
public interface Manager {

    /**
     * 게임 시작을 알리는 내용 출력
     */
    void printGameStart();

    /**
     * 입력값을 원하는 내용 출력
     */
    void printInputGameValue();
}
