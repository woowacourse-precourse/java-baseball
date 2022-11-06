package baseball;

public class Game {

  private static final int ENDGAME = 2;
  private static final int STARTOFGAME = 0;
  private static final int NOTSTARTOFGAME = 1;
  private static final int PLAYAGAINMODE = 2;

  public static void startGame(int firstCheck) {
    User user = new User();
    Computer computer = new Computer();
    Referee referee = new Referee();
    if (firstCheck == STARTOFGAME) {
      computer.printGameStart();
    }
    playingMode(user, computer, referee);
  }

  private static void playingMode(User user, Computer computer, Referee referee) {
    while (true) {
      computer.printInputNumber();
      String RefereeResult = computer.printCalculateResult(
          referee.calculateAnswer(user.inputValue(1), computer.RandomValue));
      if (RefereeResult.equals("3스트라이크") && (checkContinueMode(user, computer) == ENDGAME)) {
        break;
      }
    }
  }

  private static int checkContinueMode(User user, Computer computer) {
    computer.printEndingMessage();
    if (user.inputValue(PLAYAGAINMODE).equals("1")) {
      Game game = new Game();
      game.startGame(NOTSTARTOFGAME);
    }
    return ENDGAME;
  }

}
