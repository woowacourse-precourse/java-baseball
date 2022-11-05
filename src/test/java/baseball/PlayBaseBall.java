package baseball;

public class PlayBaseBall {
  public static void playGame() {
    PrintOut.startMessage();
    String computer = CreateRandomNumber.numberMaker();
    int strike = 0;
    while (true)
    {
      if (strike != 3) {
        PrintOut.inputMessage();
        String user = UserScanner.input();
        strike = Hint.strikeCount(computer, user);
        if (Exception.isValidNumber(user))
          PrintOut.scoreMessage(Hint.ballAndStrike(computer, user));
      }
      if (strike == 3)
        PrintOut.continueMessage();
      if (strike == 3 && !ContinueOrStop.choice(UserScanner.input()))
        break;
      else if (strike == 3) {
        strike = 0;
        computer = CreateRandomNumber.numberMaker();
      }
    }
  }
}
