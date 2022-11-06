package baseball;

public class PlayBaseBall {
  public static void playGame() {
    PrintOut.startMessage();
    String computer = CreateRandomNumber.numberMaker();
    int strike = 0;
    while (true)
    {
      PrintOut.inputMessage();
      String user = UserScanner.input();
      strike = Hint.strikeCount(computer, user);
      if (Exception.isValidNumber(user)) {
        PrintOut.scoreMessage(Hint.ballAndStrike(computer, user));
      }
      if (strike == Constant.MAX_STRIKE) {
        PrintOut.endMessage();
        PrintOut.continueMessage();
        if (!ContinueOrStop.choice(UserScanner.input())) {
          break;
        }
        strike = 0;
        computer = CreateRandomNumber.numberMaker();
      }
    }
  }
}
