package baseball.player;

import baseball.number.Number;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


public class Computer {
  private static final Integer NUMBER_SIZE = 3;
  private Set<Integer> computer = new LinkedHashSet<>();

  public Computer() {
    while (getSetSize() < NUMBER_SIZE) {
      Number randomNumber = new Number();
      computer.add(randomNumber.getNumber());
    }
  }

  public Integer getSetSize(){
    return this.computer.size();
  }

  public List<Integer> getComputerNumberList() {
    return List.copyOf(this.computer);
  }
}
