package baseball;

public class PlayBaseBall {
  public static void playGame() {
    PrintOut.startMessage();
    String computer = CreateRandomNumber.numberMaker();
    int strike = 0;
    while (true)
    {
      if (strike != Constant.MAX_STRIKE) {
        PrintOut.inputMessage();
        String user = UserScanner.input();
        strike = Hint.strikeCount(computer, user);
        if (Exception.isValidNumber(user))
          PrintOut.scoreMessage(Hint.ballAndStrike(computer, user));
      }
      if (strike == Constant.MAX_STRIKE)
        PrintOut.continueMessage();
      if (strike == Constant.MAX_STRIKE && !ContinueOrStop.choice(UserScanner.input()))
        break;
      else if (strike == Constant.MAX_STRIKE) {
        strike = 0;
        computer = CreateRandomNumber.numberMaker();
      }
    }
  }
}
