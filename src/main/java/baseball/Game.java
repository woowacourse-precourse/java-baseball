package baseball;

import baseball.util.GetRandomNumber;
import baseball.util.PlayGame;
import baseball.util.ValidateInput;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Game {

    GetRandomNumber getRandomNumber;
    ValidateInput validateInput;
    PlayGame playGame;

    public void readyToPlay() {
        validateInput = new ValidateInput();
        getRandomNumber = new GetRandomNumber();
        playGame = new PlayGame();
    }
    public String play() {

        readyToPlay();

        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> comRandomNumber = GetRandomNumber.getNumberList();

        while (true) {
            List<Integer> integerList = validateInput.validateInput();
            boolean isExactNumber = playGame.playWithComputer(integerList, comRandomNumber);
            if (isExactNumber) {
                break;
            }
        }
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String isRestart = Console.readLine();
        if (Integer.parseInt(isRestart) != 1 && Integer.parseInt(isRestart) != 2) {
            throw new IllegalArgumentException("1, 2가 아닌 입력이 들어왔습니다.");
        }
        return isRestart;





    }
}
