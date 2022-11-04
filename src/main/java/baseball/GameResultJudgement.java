package baseball;

public class GameResultJudgement {
  private int maxLen;

  public GameResultJudgement() {
    this(3);
  }
  public GameResultJudgement(int maxLen) {
    this.maxLen = maxLen;
  }
  public int judgeStrike(String str1, String str2) {
    int count = 0;

    for (int i = 0; i < maxLen; i++) {
      if (str1.charAt(i) == str2.charAt(i)) {
        ++count;
      }
    }
    return count;
  }
}
