package baseball;

public class PlayBaseBall {
  static ContinueOrStop continueOrStop = new ContinueOrStop();

  public static void playGame() { //싱글톤
    PrintOut.startMessage();
    String computerNumber = CreateRandomNumber.numberMaker(); //computerNumber
    while (true) //게임 테이블 / 내부의 턴 횟수 구분
    {
      PrintOut.inputMessage(); //requsetInput~
      String user = UserScanner.input();
      int strike = Hint.strikeCount(computerNumber, user);
      if (InputValidator.isValidNumber(user)) {  // void형식
        PrintOut.scoreMessage(Hint.ballAndStrike(computerNumber, user)); // ball-strike 의존성
      }
      if (strike == Constant.MAX_STRIKE) {
        PrintOut.endMessage();
        PrintOut.continueMessage(); //ask, request ~~~
        if (!ContinueOrStop.choice(UserScanner.input())) { //choice 이름 /  과정이 눈에 보이게 //
          break;
        }
        computerNumber = CreateRandomNumber.numberMaker();
      }
    }
  }
}
