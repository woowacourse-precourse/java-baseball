package baseball;

import IOController.InputOutputController;
import IOController.ScreenOutput;
import IOController.KeyboardInput;

public class Game {

    private static final int ENDGAME = 1;
    private static final int PLAYAGAINMODE = 2;
    private static final int PLAYINGMODE = 1;

    public Game() {
        ScreenOutput.printGameStart();
    }

    public int startAndPlayAgain(InputOutputController ioController) {
        Referee.generateRandom();
        progress(ioController);
        return checkContinueMode(ioController);
    }

    private static void progress(InputOutputController ioController) {
        while (true) {
            //Screen.printInputNumber();
            ioController.outputInputMessage();
            //String RefereeResult = Screen.printCalculateResult( Referee.calculateAnswer(User.inputValue(1)));
            String RefereeResult = ioController.outputResultMessage( Referee.calculateAnswer(ioController.inputGet(PLAYINGMODE)));
            if (RefereeResult.equals("3스트라이크")) {
                break;
            }
        }
    }
/// 지금 inputValue에서 원래 게임 실행 중 모드, 게임 한번 더 모드에 대한 인자가 중간에 사라져버려서 신경안쓰면 큰일난다.
    private static int checkContinueMode(InputOutputController ioController) {
        ioController.outputEndingMessage();
        //Screen.printEndingMessage();
        if (ioController.inputGet(PLAYAGAINMODE).equals("1")) {
            return PLAYAGAINMODE;
        }
        return ENDGAME;
    }

}
