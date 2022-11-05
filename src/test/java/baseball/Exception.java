package baseball;

import java.util.HashSet;
import java.util.Set;

public class Exception {
  // 길이가 3이 아니면 - 추후 전역상수로 바꾸는게..
  public static boolean isRightLength(String userNumber) {
    if (userNumber.length() != 3)
      throw new IllegalArgumentException();
    return true;
  }

  //중복된 숫자가 있으면
  public static boolean isDuplicated(String userNumber) {
    Set<Character> set = new HashSet<>();

    for (int i = 0; i < userNumber.length(); i++)
      set.add(userNumber.charAt(i));
    if (userNumber.length() != set.size())
      throw new IllegalArgumentException();
    return true;
  }
}
