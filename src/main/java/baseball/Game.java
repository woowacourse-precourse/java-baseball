package baseball;

import baseball.view.InputView;
import baseball.view.OutputView;

import static baseball.constants.Constant.*;
import static baseball.constants.Exception.*;
import static baseball.constants.Message.*;

public class Game {

  private Player player;
  private Computer computer;

  public void setAnswer() {
    this.computer = new Computer();
    computer.setAnswer();
  }

  public void setGuess(String input) {
    this.player = new Player();
    player.setNumbers(input);
  }

  public String getHint(Player player, Computer computer) {
    Hint hint = new Hint(player, computer);
    return hint.getHint();
  }

  public void printHint(String hint) {
    System.out.println(hint);
  }

  public void guessNumber() {
    do {
      setGuess(InputView.getUserNumber());
      printHint(getHint(player, computer));
    } while (!is3Strike(getHint(player, computer)));
  }

  public boolean is3Strike(String hint) {
    return hint.equals(3+STRIKE_MESSAGE);
  }

  public void playGame() {
    setAnswer();
    guessNumber();
    OutputView.printEndMessage();
  }

  public boolean isRestart() {
    String restart = InputView.getRestartStatus();
    if (restart.equals(RESTART)) {
      return true;
    }
    else if (restart.equals(STOP)) {
      return false;
    }
    else {
      throw new IllegalArgumentException(INVALID_RESTART_INPUT_ERROR);
    }
  }

  public void playBaseballGame() {
    playGame();
    if (isRestart()) {
      playGame();
    }
  }

}
