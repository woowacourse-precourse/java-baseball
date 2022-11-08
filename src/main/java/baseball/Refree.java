package baseball;

import java.util.List;

public class Refree {
  private static final int DIGIT_LENGTH = 3;
  public static int countStrike(List<Integer> answerList, List<Integer> userInputList) {
    int strike = 0;
    for (int i = 0; i < DIGIT_LENGTH; i++) {
      int answer = answerList.get(i);
      int userInput = userInputList.get(i);

      if (answer == userInput)
        strike++;
    }

    return strike;
  }

  public static int countBall(List<Integer> answerList, List<Integer> userInputList) {
    int ball = 0;
    for (int i = 0; i < DIGIT_LENGTH; i++) {
      int answer = answerList.get(i);
      int userInput = userInputList.get(i);

      if (answer != userInput && answerList.contains(userInput))
        ball++;
    }

    return ball;
  }

  public static void printResult(int strike, int ball) {
    String result = "";

    if (strike == 0 && ball == 0) result = "낫싱";

    if (ball > 0) result += String.format("%d볼 ", ball);
    if (strike > 0) result += String.format("%d스트라이크", strike);
    result = result.trim();

    System.out.println(result);
  }
}
