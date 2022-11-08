package baseball.game;

import baseball.printer.PrintData;
import camp.nextstep.edu.missionutils.Console;

/**
 * 플레이어의 데이터 입력을 담당하는 클래스
 */

public class PlayerNumberInput {
    public String inputPlayerString(){
        try {
            PrintData.printData("INPUT_STRING");
            String playerString = Console.readLine();
            return playerString;
        }
        catch (Exception e){
            throw new IllegalArgumentException("입력이 없습니다");
        }

    }
    public String inputRestartString() {
        try {
            PrintData.printData("RESTART");
            PrintData.printLine();
            String restartString = Console.readLine();
            return restartString;
        }
        catch (Exception e){
            throw new IllegalArgumentException("입력이 없습니다");
        }
    }
}
