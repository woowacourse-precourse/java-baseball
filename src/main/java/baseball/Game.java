package baseball;

public class Game {

  private static final int ENDGAME = 2;

  public static void startGame(int firstCheck) {
    User user = new User();
    Computer computer = new Computer();
    if (firstCheck == 0) {
      computer.printGameStart();
    }
    Referee referee = new Referee();
    playingMode(user, computer, referee);
  }

  private static void playingMode(User user, Computer computer, Referee referee) {
    while(true) {
      computer.printInputNumber();
      String RefereeResult = computer.printCalculateResult(referee.calculateAnswer(user.inputValue(1), computer.RandomValue));
      if (RefereeResult.equals("3스트라이크")) {
        if (checkContinue(user, computer) == ENDGAME) {
          break;
        }
      }
    }
  }
  private static int checkContinue(User user, Computer computer) {
    computer.printEndingMessage();
    if (user.inputValue(2).equals("1")) {
      Game game = new Game();
      game.startGame(1);

    }
    return ENDGAME;
  }

}
