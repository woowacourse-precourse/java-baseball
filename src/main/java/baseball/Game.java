package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Game {
    private final String USER_INPUT_ERROR = "숫자 1이나 2를 입력해야 합니다.";
    private final String RESTART_GAME = "1";
    private final String QUIT_GAME = "2";

    public void playGame() {
        List<Integer> ComputerNumList = Computer.NumList();
        //List<Integer> ComputerNumList = new ArrayList<>(Arrays.asList(1,2,3));

        int strike = 0;
        int ball;
        while (strike != 3) {
            String inputNum = Console.readLine();
            Player.CheckNum(inputNum);
            List<Integer> playerNumList = Player.NumList(inputNum);

            Count count = new Count();
            count.ballCount(ComputerNumList, playerNumList);
            strike = count.getStrike();
            ball = count.getBall();
            Message.HintMessage(strike, ball);
        }
    }

    public void startGame() {
        do {
            Message.StartMessage();
            playGame();
            Message.EndMessage();
            Message.RestartMessage();
        } while (EndSelect());
    }

    public boolean EndSelect() {
        String restartNum = Console.readLine();

        if(restartNum.equals(RESTART_GAME)) {
           return true;
        } else if(!restartNum.equals(QUIT_GAME)){
            throw new IllegalArgumentException(USER_INPUT_ERROR);
        }
        return false;
    }
}


