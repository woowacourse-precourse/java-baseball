package baseball;

import baseball.dto.NumListDto;
import baseball.model.Computer;
import baseball.view.PrintConsole;
import baseball.controller.ReceiveConsole;
import java.util.List;

public class Application {
    private static final int PLAYING_GAME=0;
    private static final int RESTART_GAME = 1;
    private static final int END_GAME = 2;
    private static int choiceEndGame;

    public static void main(String[] args) {
        if (choiceEndGame == RESTART_GAME) {
        }else{
            PrintConsole.startGame();
        }

        choiceEndGame = PLAYING_GAME;

        Computer computer = new Computer();
        computer.generateRandomNumList();
        System.out.println("computer.getRandomNum() = " + computer.getRandomNum());

        while (choiceEndGame!= END_GAME){
            PrintConsole.receiveNum();
            NumListDto numListDto;
            numListDto = ReceiveConsole.receiveNumIncludeAllException();
            List<Integer> usersNum = numListDto.getNumList();

            computer.compareUsersNum(usersNum);
            PrintConsole.printResult(computer);

            if (computer.isThreeStrike()) {
                PrintConsole.endGame();
                choiceEndGame = ReceiveConsole.choiceGameContinue();
            }

            switch (choiceEndGame) {
                case PLAYING_GAME:
                    computer.resetCompareComponent();
                    break;
                case RESTART_GAME:
                    main(args);
                    break;
                case END_GAME:
                    break;
            }
        }
    }
}
