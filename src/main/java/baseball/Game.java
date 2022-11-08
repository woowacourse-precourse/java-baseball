package baseball;

import java.util.List;

public class Game {
    private Computer computer;
    private Hint hint;
    private Output output;

    public Game() {
        computer = new Computer();
        hint = new Hint();
        output = new Output();
    }

    public void playGame() {
        while (true) {
            List<Integer> answer = computer.decideAnswer();
            List<Integer> playerAnswer = Input.getInput();
            output.giveHint(playerAnswer, answer);
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
            return;
        }else if(value==GameMode.GAME_RESTART){
            playGame();
        }else{
            throw new IllegalArgumentException();
        }
    }

}
