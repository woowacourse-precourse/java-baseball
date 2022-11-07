package baseball.gameController;

import baseball.dataStorage.DataStorage;
import baseball.game.Game;
import baseball.tool.Signal;
import baseball.tool.TextPrinter;

public class GameController {
  DataStorage dataStorage = new DataStorage();

  public void BaseballGame() throws IllegalArgumentException{
    TextPrinter.printStartMessage();
    Game game=new Game();
    while(game.tryGame()!= Signal.QUIT);


  }
}
