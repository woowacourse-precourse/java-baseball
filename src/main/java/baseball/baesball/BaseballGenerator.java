package baseball.baesball;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public interface BaseballGenerator {
     String SPLIT_VALUE = "";
     Baseball generateBaseball();

     default List<Integer> parseFrom(String baseball) {
          String[] baseballs = baseball.split(SPLIT_VALUE);
          return Arrays.stream(baseballs)
                  .map(Integer::parseInt)
                  .collect(Collectors.toUnmodifiableList());
     }
}
