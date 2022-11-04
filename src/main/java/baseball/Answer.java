package baseball;

import java.util.List;

public class Answer {

  private static final int FIRST_NUM = 0;
  private static final int SECOND_NUM = 1;
  private static final int THIRD_NUM = 2;

  private static List<Character> answer; // random number

  public Answer(List<Character> answer) {
    Answer.answer = answer;
  }

  public void compare(BaseBallNumber number) {
    String new_number = number.toString();
    int ballCount = 0;
    int strikeCount = 0;
    for (int i = 0; i < 3; i++) {
      if ((answer.get(i) == new_number.charAt(i))) {
        strikeCount++;
      } else if ((answer.contains(new_number.charAt(i)))) {
        ballCount++;
      }
    }
    if (ballCount != 0 && strikeCount == 0) {
      System.out.println(ballCount + "볼");
    } else if (ballCount == 0 && strikeCount != 0) {
      System.out.println(strikeCount + "스트라이크");
    } else if (ballCount != 0 && strikeCount != 0) {
      System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
    } else if ((answer.get(FIRST_NUM) != new_number.charAt(FIRST_NUM)) &&
        (answer.get(SECOND_NUM) != new_number.charAt(SECOND_NUM)) &&
        (answer.get(THIRD_NUM) != new_number.charAt(THIRD_NUM))) {
      System.out.println("낫싱");
    }
    if (strikeCount == 3) {
      // end_game
    }
  }
}
