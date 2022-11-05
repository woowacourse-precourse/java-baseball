package baseball;

import java.util.ArrayList;
import java.util.List;

public class GameResultJudgement {
  private int maxLen;

  public GameResultJudgement() {
    this(3);
  }
  public GameResultJudgement(int maxLen) {
    this.maxLen = maxLen;
  }
  public char[] judgeStrikeBallNothing(String str1, String str2) {

    char[] result = new char[3];

    for (int i = 0; i < maxLen; i++) {
      char ch = str2.charAt(i);
      if (!(str1.charAt(i) == str2.charAt(i)) && str1.contains(ch+"")) {
        ++result[1];
      } else if (str1.charAt(i) == str2.charAt(i)) {
        ++result[0];
      }
    }
    if (result[0] == 0 && result[1] == 0) {
      ++result[2];
    }
    return result;
  }
}
