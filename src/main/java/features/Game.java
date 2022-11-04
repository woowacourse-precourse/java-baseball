package features;

import static features.Hint.getCountBall;
import static features.Hint.getCountNothing;
import static features.Hint.getCountStrike;
import static features.Player.createComputerNumber;
import static features.Print.victory;

import java.util.Map;

public class Game implements Factory{

    private static final String GAME_START = "숫자 야구 게임을 시작합니다.";
    private static final String GAME_OVER = "게임을 재시작하려면 1, 종료하려면 2를 입력해주세요."
    private static final int STRIKE = 3;


    // 게임 진행 기능
    while(STRIKE==false){

        inputUserNumber();
        loopHint(inputUserNumber(), createComputerNumber());
        printResult();

    }

    // 게임 종료 기능
    if(STRIKE==true){

        printResult();
        victory();
        return  GAME_OVER;

    }

    @Override
    public Map<Integer, Character> inputUserNumber() {
        Map<Integer, Character> inputResult = inputUserNumber();
        return inputResult;
    }

    @Override
    public void loopHint(Map<Integer, Character> userNumber, Map<Integer, Character> computerNumber) {
        userNumber = inputUserNumber();
        computerNumber = createComputerNumber();
    }

    @Override
    public String printResult() {
        return printResult();
    }
}