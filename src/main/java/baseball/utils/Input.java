package baseball.utils;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;

public class Input {
  private String input;

  public Input(){
    this.input = Console.readLine();
  }

  public Integer toInt() {
    return Integer.valueOf(this.input);
  }

  public int[] toIntList() {
    String[] strList = input.split("");
   return Arrays.stream(strList).mapToInt(Integer::parseInt).toArray();
  }

  public String getInput() {
    return this.input;
  }
}
