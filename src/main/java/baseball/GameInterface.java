package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class GameInterface {

    public void gameStart() {
        Computer computer = new Computer();
        List<Integer> computerNumber = computer.getComputerNumber();
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            Player player = new Player();
            List<Integer> playerNumber = player.getPlayerRandomNumber();
            String result = BaseBall.checkNumber(playerNumber, computerNumber);
            System.out.println(result);

            if (result.equals("3스트라이크")) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                int exitOrGo = Integer.parseInt(Console.readLine());
                if (exitOrGo == 2) {
                    break;
                }
                computerNumber = computer.getComputerNumber();
            }
        }
    }
}
