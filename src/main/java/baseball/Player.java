package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static constants.GameConstant.*;

public class Player {
    public String getPlayerNumber(){
        System.out.print(INPUT_NUMBER_MESSAGE);
        String playerNumber = readLine();
        BaseballGame.validateInputNumber(playerNumber);
        return playerNumber;
    }

    public int getRestartOrEndNumber(){
        System.out.println(RESTART_OR_END_MESSAGE);
        String playerNumber = readLine();
        BaseballGame.validateNumberOrNotNumber(playerNumber, RESTART_OR_END_PATTERN);
        BaseballGame.validateNumberLength(playerNumber, RESTART_OR_END_NUMBER_LENGTH);
        return Integer.parseInt(playerNumber);
    }
}