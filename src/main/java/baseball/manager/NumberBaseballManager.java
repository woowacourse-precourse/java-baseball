package baseball.manager;

/**
 * 야구 게임 매니저로서 게임의 시작과 종료를 관리
 *
 * @version 1.0.0
 * @author chlskreh2
 */
public class NumberBaseballManager implements Manager{
    
    /**
     * 숫자 야구 게임 시작을 알리는 내용 출력
     */
    @Override
    public void printGameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    /**
     * 숫자 야구 게임 입력값을 원하는 내용 출력
     */
    @Override
    public void printInputGameValue() {
        System.out.println("숫자를 입력해주세요 : ");
    }
}
