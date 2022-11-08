package baseball;


import java.util.List;

public class Application {
    static BaseBallGame baseBallGame;
    static RadomNumberCreator radomNumberCreator;
    static InputHandler inputHandler;
    static OutputHandler outputHandler;

   public static void main(String[] args)  {

        inputHandler = new InputHandler();
        outputHandler = new OutputHandler();
        baseBallGame = new BaseBallGame();
        radomNumberCreator = new RadomNumberCreator();
        boolean restart = true;
        outputHandler.printStart();
        while (restart) {
            List<Integer> comNum = radomNumberCreator.makeRandomNumber();

            baseBallGame.baseballGame(comNum);

            outputHandler.printRestart_orExit();
            String restart_orExit = inputHandler.getRestartNum();

            if (restart_orExit.equals("2")) {
                restart=false;
            } else if (restart_orExit.equals("1")) {
                restart=true;
            }else{
                throw new IllegalArgumentException();
            }
        }
    }
}
