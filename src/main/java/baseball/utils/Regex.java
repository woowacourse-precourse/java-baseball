package baseball.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

  public static boolean getRegexMatcherResult(String expression, String target) {
    Pattern pattern = Pattern.compile(expression);
    Matcher matcher = pattern.matcher(target);

    return matcher.matches();
  }

}
