package baseball.service;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputService {
  public List<Integer> getPlayerNumbers() {
    String playerInput = readLine();
    return Stream.of(playerInput.split(""))
        .mapToInt(Integer::parseInt)
        .boxed()
        .collect(Collectors.toList());
  }
}
