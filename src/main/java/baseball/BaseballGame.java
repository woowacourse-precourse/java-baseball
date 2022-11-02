package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static baseball.Computer.NUM_LIMIT_LENGTH;
import static baseball.Message.START_GAME;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseballGame {
    private Computer computer;
    private int strike;
    private int ball;
    List<Integer> userInput = new ArrayList<>(NUM_LIMIT_LENGTH);

    public BaseballGame(Computer computer) {
        this.computer = computer;
        this.strike = 0;
        this.ball = 0;
    }

    public void start() {
        while (strike < NUM_LIMIT_LENGTH) {
            System.out.println(START_GAME);


        }
    }

    private void checkInputData() {
        if (userInput.size() != 3) {
            throw new IllegalArgumentException("3자리 숫자를 입력해야 합니다. 다시 입력해주세요.");
        }
        if (userInput.contains(0)) {
            throw new IllegalArgumentException("1부터 9까지의 숫자만을 입력할 수 있습니다. 다시 입력해주세요");
        }
        Set<Integer> duplicate = new HashSet<>(userInput);
        if(duplicate.size()!= userInput.size()){
            throw new IllegalArgumentException("중복된 숫자가 있어서는 안됩니다. 서로 다른 숫자로 다시 입력해주세요.");
        }
    }


}
