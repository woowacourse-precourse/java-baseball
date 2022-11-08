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
    public void play() {

        readyToPlay();

        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> comRandomNumber = GetRandomNumber.getNumberList();
        List<Integer> integerList = validateInput.validateInput();



    }
}
