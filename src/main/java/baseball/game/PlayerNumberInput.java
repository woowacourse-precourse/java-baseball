package baseball.game;

import baseball.data.PrintData;
import camp.nextstep.edu.missionutils.Console;

/**
 * 플레이어의 데이터 입력을 담당하는 클래스
 */

public class PlayerNumberInput {

    /**
     * 플레이어의 숫자 3개를 입력받음
     * @return 예외가 검출되지 않은 입력값
     */
    public String inputPlayerString(){
        try {
            PrintData.printStringData("INPUT_STRING");
            String playerString = Console.readLine();
            return playerString;
        }
        catch (Exception e){
            throw new IllegalArgumentException("입력이 없습니다");
        }
    }

    /**
     * 재시작단계에서 플레이어의 입력을 받음
     * @return 예외가 검출되지 않은 입력값
     */
    public String inputRestartString() {
        try {
            PrintData.printStringData("RESTART");
            PrintData.printLine();
            String restartString = Console.readLine();
            return restartString;
        }
        catch (Exception e){
            throw new IllegalArgumentException("입력이 없습니다");
        }
    }
}
