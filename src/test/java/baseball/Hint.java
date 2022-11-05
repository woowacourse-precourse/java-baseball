package baseball;

public class Hint {
  // 컴퓨터와 유저의 수가 자리 상관없이 일치만 한다면 ballCount
  public static int ballCount(String computer, String userNumber) {
    int ball = 0;

    for (int i = 0; i < userNumber.length(); i++)
    {
      if (computer.contains(Character.toString(userNumber.charAt(i))))
        ball += 1;
    }
    return ball;
  }
}
