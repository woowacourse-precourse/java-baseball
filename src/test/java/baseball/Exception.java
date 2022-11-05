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

  //숫자가 아닌 다른게 들어올 경우
  public static boolean isNumber(String userNumber) {
    for (int i = 0; i < userNumber.length(); i++)
    {
      if (!Character.isDigit(userNumber.charAt(i)))
        throw new IllegalArgumentException();
    }
    return true;
  }

  // 모든 조건을 만족했을 때 true 반환
  public static boolean isValidNumber(String userNumber) {
    return (isRightLength(userNumber) && isDuplicated(userNumber) && isNumber(userNumber));
  }

  public static boolean isValidButton(String button) {
    return (isNumber(button) && button.length() == 1);
  }
}
