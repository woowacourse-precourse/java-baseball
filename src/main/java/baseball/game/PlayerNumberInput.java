package baseball.game;

import camp.nextstep.edu.missionutils.Console;

/**
 * 플레이어의 데이터 입력을 담당하는 클래스
 */

public class PlayerNumberInput {
    public String inputPlayerString(){
        System.out.print("숫자를 입력해주세요 : ");
        try {
            String playerString = Console.readLine();
            System.out.print(playerString);
            return playerString;
        }
        catch (Exception e){
            throw new IllegalArgumentException("입력이 없습니다");
        }

    }
    public String inputRestartString() {
        try {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
            String restartString = Console.readLine();
            return restartString;
        }
        catch (Exception e){
            throw new IllegalArgumentException("입력이 없습니다");
        }
    }
}
