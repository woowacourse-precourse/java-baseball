package baseball.domain;

import java.util.List;

public interface GameRule<T> {

	void makeResultByGameRule(List<T> status);

	List<T> getResultByGameRule();
}
