package baseball;

public class Referee {

  public static String Answer;

  public static String calculateAnswer(String userInput, String randNum) {
    int ball;
    int strike;

    ball = calculateBall(userInput, randNum);
    strike = calculateStrike(userInput, randNum);
    if (strike == 0 && ball == 0) {
      return "낫싱\n";
    }
    if (ball != 0 && strike != 0) {
      return (ball + "볼 " + strike + "스트라이크\n");
    } else if (ball != 0 && strike == 0) {
      return (ball + "볼\n");
    } else if (ball == 0 && strike != 0) {
      return (strike + "스트라이크\n");
    }
    return "";
  }

  private static int calculateBall(String userInput, String randNum) {
    int strikeNum = calculateStrike(userInput, randNum);
    int ballNum = 0;
    for (int i = 0; i < 3; i++) {
      if (randNum.indexOf(userInput.charAt(i)) != -1) {
        ballNum++;
      }
    }
    return (ballNum - strikeNum);
  }

  private static int calculateStrike(String userInput, String randNum) {
    int strikeCnt = 0;
    for (int i = 0; i < 3; i++) {
      if (userInput.charAt(i) == randNum.charAt(i)) {
        strikeCnt++;
      }
    }
    return strikeCnt;
  }

  public static void testReferee(String userInput, String randNum) {
    System.out.println(calculateAnswer(userInput, randNum));
  }
}
