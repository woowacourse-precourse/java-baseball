package baseball.manager;

import camp.nextstep.edu.missionutils.Console;

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

    /**
     * 사용자에게 숫자 야구 게임 입력값 받기
     */
    @Override
    public String inputGameValue() {
        return Console.readLine();
    }

    /**
     * 사용자에게 입력받은 숫자 야구 게임 결과값 출력
     */
    @Override
    public void printCorrectResult(String resultValue) {
        System.out.println(resultValue);
    }

    /**
     * 게임 종료 후 게임 다시 시작을 원할 시 1, 종료 원할 시 2 문구 출력
     */
    @Override
    public void printRetryOrCloseProgram() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    /**
     * 게임 다시 시작을 원할 시 1, 종료 원할 시 2 중 어떤 걸 원하는지 입력 값 받기
     */
    @Override
    public String inputRetryOrCloseProgram() {
        return Console.readLine();
    }
}
