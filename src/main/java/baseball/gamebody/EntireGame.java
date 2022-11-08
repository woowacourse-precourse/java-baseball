package baseball.gamebody;

import java.util.List;
import java.util.Arrays;
import camp.nextstep.edu.missionutils.Console;

public class EntireGame extends PlayGame {
    public void fullGame(List<String> computerNumber) {
        while(true) {
            System.out.print("숫자를 입력해주세요 : ");
            String playerNumberString = Console.readLine();
            this.judgeException(playerNumberString);
            
            List<String> playerNumber = Arrays.asList(playerNumberString.split(""));
            
            if(playerNumber.equals(computerNumber)) {
                System.out.println("3스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                break;
            }

            this.plaingGame(playerNumber, computerNumber);
        }

    }
}