package baseball.view;

import baseball.exception.PlayerException;
import camp.nextstep.edu.missionutils.Console;

public class PlayerView {
    private static final String INPUT_REQUEST = "숫자를 입력해주세요 : ";
    String input;

    public PlayerView(){
        input = "";
    }

    public String getPlayerOpinion(){
        requestInput();
        readInput();
        return getInput();
    }

    private void requestInput(){
        System.out.print(INPUT_REQUEST);
    }

    private void readInput(){
        input = Console.readLine();
        PlayerException playerException = new PlayerException();
        playerException.checkException(input);
    }

    private String getInput(){
        return input;
    }
}
