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
        while (true) {
            String comNum = radomNumberCreator.makeRandomNumber();

            // TODO: 사용자 수 입력 - 도메인테스트
            baseBallGame.baseballGame(comNum);
            outputHandler.printRestart_orExit();
            int restart_orExit = inputHandler.getRestartNum();

            if (restart_orExit == 2) {
                break;
            } else if (restart_orExit != 1) {
                System.out.println("잘못된 restartNum 입력하였습니다.");
                break;
            }
        }
    }
}
