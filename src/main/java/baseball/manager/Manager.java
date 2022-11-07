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

    /**
     * 사용자에게 입력값 받기
     */
    String inputGameValue();

    /**
     * 사용자에게 입력받은 결과값 출력
     */
    void printCorrectResult(String resultValue);

    /**
     * 게임 종료 후 게임 다시 시작, 종료 문구 출력
     */
    void printRetryOrCloseProgram();

    /**
     * 게임 다시 시작, 종료 중 어떤 걸 원하는지 입력 값 받기
     */
    String inputRetryOrCloseProgram();
}
