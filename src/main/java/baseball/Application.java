package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

class ComputerNumber {
    List<Integer> computerNumber;

    public ComputerNumber() {

    }
}

class PlayerNumber {
    List<Integer> playerNumber;

    public PlayerNumber() {
    }
}

class GameInit{
    public GameInit() {
        ComputerNumber computerNumber = (ComputerNumber) new ComputerNumber().computerNumber;
        PlayerNumber playerNumber = (PlayerNumber) new PlayerNumber().playerNumber;
    }

}

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        GameInit startGame = new GameInit();
    }
}
