package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Map;

import static baseball.view.Display.*;

public class Controller {
    public void printRoundStart() {
        printInitMessage();
    }

    public String printAndInputNumber() {
        printInputNumberMessage();
        String input = Console.readLine();
        // TODO input 유효성 검증 코드 작성
        return input;
    }

    public void printRoundResult(Map<String,Integer> resultMap) {
        int ball = resultMap.get("ball");
        int strike = resultMap.get("strike");

        if(ball==0 && strike==0) {
            printNothingMessage();
            return;
        }
        if(ball>0) {
            printBallMessage(ball);
        }
        if(strike>0){
            printStrikeMessage(strike);
        }
    }
}
