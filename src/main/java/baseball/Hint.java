package baseball;

public class Hint {
  // 컴퓨터와 유저의 수가 자리 상관없이 일치만 한다면 ballCount
  public static int ballCount(String computer, String userNumber) {
    int ball = 0;

    for (int i = 0; i < userNumber.length(); i++)
    {
      if (computer.contains(Character.toString(userNumber.charAt(i)))) {
        ball += 1;
      }
    }
    return ball;
  }

  // 같은 index로 돌면서, 같은 수를 갖고 있다면 strikeCount
  public static int strikeCount(String computer, String userNumber) {
    int strike = 0;

    for (int i = 0; i < computer.length(); i++) {
      if (computer.charAt(i) == userNumber.charAt(i)) {
        strike += 1;
      }
    }
    return strike;
  }

  // idx 상관 없이 같은 값을 지닌 ball - idx 일치 && value 일치하는 strike == ball 개수
  public static int[] ballAndStrike(String computer, String userNumber) {
    int ballScore = ballCount(computer, userNumber);
    int strikeScore = strikeCount(computer, userNumber);

    return new int[] {ballScore - strikeScore, strikeScore};
  }
}
