package baseball;

import java.util.List;

public interface Observer {
    List<Hint> compare(List<Integer> list);
}
