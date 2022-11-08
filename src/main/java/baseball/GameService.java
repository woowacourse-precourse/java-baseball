package baseball;

import java.util.List;

public class GameService {
    private final Game game;

    public GameService() {
        game = new Game();
    }

    public void playGame() {
        Computer computer = game.getComputer();
        Hint hint = game.getHint();
        Output output = game.getOutput();
        while (true) {
            List<Integer> answer = computer.decideAnswer();
            List<Integer> playerAnswer = Input.getInput();
            output.giveHint(hint.compareNumber(playerAnswer, answer));
            if (hint.getStrike() == Range.DIGIT) {
                askGameRestart();
                break;
            }
        }
    }

    private void askGameRestart(){
        Output.askRestart();
        int value = Input.getRestart();
        if(value == GameMode.GAME_END){
            Output.endGame();
        }else if(value==GameMode.GAME_RESTART){
            playGame();
        }else{
            throw new IllegalArgumentException();
        }
    }

}
