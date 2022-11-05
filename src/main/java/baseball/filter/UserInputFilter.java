package baseball.filter;

import java.util.List;

public interface UserInputFilter<T> {

	boolean checkUserInput(String userInput, int size, T min, T max) throws IllegalStateException;

	List<T> bindingResult(String userInput, int size);
}
