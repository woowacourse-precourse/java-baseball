package baseball;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application {
    static BaseBallGame baseBallGame;
    static RadomNumberCreator radomNumberCreator;
    static InputHandler inputHandler;
    static OutputHandler outputHandler;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {

        inputHandler = new InputHandler();
        outputHandler = new OutputHandler();
        baseBallGame = new BaseBallGame();
        radomNumberCreator = new RadomNumberCreator();

        outputHandler.printStart();
        while (true) {
            String comNum = radomNumberCreator.makeRandomNumber();


            baseBallGame.baseballGame(comNum);

            outputHandler.printRestart_orExit();
            int restart_orExit = inputHandler.getRestartNum();


            if (restart_orExit == 2) {
                break;
            } else if (restart_orExit != 1) {
                throw new IllegalArgumentException("1이나 2를 입력해야합니다.");
            }
        }
    }
}
