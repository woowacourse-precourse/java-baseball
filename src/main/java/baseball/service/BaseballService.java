package baseball.service;

import baseball.domain.Baseball;
import java.util.List;

public interface BaseballService {

    Baseball judge(List<Integer> numbers, List<Integer> goal);
}
