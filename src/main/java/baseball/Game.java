package baseball;

import baseball.util.GetRandomNumber;
import baseball.util.ValidateInput;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Game {

    GetRandomNumber getRandomNumber;
    ValidateInput validateInput;

    public void readyToPlay() {
        validateInput = new ValidateInput();
        getRandomNumber = new GetRandomNumber();
    }
    public void play() {

        readyToPlay();

        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> comRandomNumber = GetRandomNumber.getNumberList();
        String input = Console.readLine();
        List<Integer> integerList = validateInput.validateInput(input);
        System.out.println("숫자를 입력해주세요 : "+input);


    }
}
