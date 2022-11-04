package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

class ComputerNumber {
    List<Integer> computerNumber;

    public ComputerNumber() {
        computerNumber = makeRandomNumber();
    }

    private List<Integer> makeRandomNumber() {
        List<Integer> numberList = new ArrayList<>();
        do {
            int newNumber = Randoms.pickNumberInRange(1, 9);
            if (numberList.contains(newNumber))
                continue;
            numberList.add(newNumber);
        } while (numberList.size() < 3);
        System.out.println(numberList);

        return numberList;
    }
}

class PlayerNumber {
    List<Integer> playerNumber;

    public PlayerNumber() {
        try{
            System.out.print("숫자를 입력해주세요 : ");
            List<Integer> playerNumber = playerInput();
        } catch(WrongInputException e) {
            System.out.println(e.getMessage());
        }
    }
}

class WrongInputException extends IllegalArgumentException{
    WrongInputException(String message) {
        super(message);
    }
}

class GameInit{
    List<Integer> computerNumber;
    List<Integer> playerNumber;
    public GameInit() {
        List<Integer> computerNumber = new ComputerNumber().computerNumber;
        List<Integer> playerNumber = new PlayerNumber().playerNumber;
    }

}

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        GameInit startGame = new GameInit();
    }
}
