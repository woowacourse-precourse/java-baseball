package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

class Game{
    private List<Integer> computerNum = new ArrayList<>();
    String userInput;
    private List<Integer> userNum = new ArrayList<>();

    public Game(){
        while (computerNum.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNum.contains(randomNumber))
                computerNum.add(randomNumber);
        }
    }

    public List<Integer> getGameNums(){
        return computerNum;
    }

    void start(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    void setUserInput() {
        userInput = Console.readLine();
        checkUserInput();
    }

    void checkUserInput() throws IllegalArgumentException{
        if (userInput.length() != 3)
            throw new IllegalArgumentException("게임 종료");

        for (int i = 0; i < userInput.length(); i++) {
            int userChar = (int)userInput.charAt(i);
            if (userChar<=0 | userChar>9)
                throw new IllegalArgumentException("게임 종료");
            userNum.add((int) userInput.charAt(i));
        }
    }
}

public class Application {
    public static void GameController() {
        Game game = new Game();
        game.setUserInput();
    }

    public static void main(String[] args) {
    }
}
