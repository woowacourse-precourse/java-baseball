package baseball.utils;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Input {
  private String input;

  public Input(){
    this.input = Console.readLine();
  }

  public Integer toInt() {
    return Integer.valueOf(this.input);
  }

  public List<Integer> toIntList() {
    String[] strList = input.split("");
    int[] intList = Arrays.stream(strList).mapToInt(Integer::parseInt).toArray();
    return Arrays.stream(intList).boxed().collect(Collectors.toList());
  }

  public String getInput() {
    return this.input;
  }
}
