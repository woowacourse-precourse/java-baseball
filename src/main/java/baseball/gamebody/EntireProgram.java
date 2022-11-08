package baseball.gamebody;

import camp.nextstep.edu.missionutils.Console;

public class EntireProgram extends EntireGame {
    public void baseballGame() {
        while(true) {
            this.fullGame(this.computerNumber());
            String endNumber = Console.readLine();
            this.restartJudgeException(endNumber);
            if(endNumber.equals("2")) {
                break;
            }
        }
    }
}
