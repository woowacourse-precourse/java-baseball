package baseball.domain.player;

import baseball.utils.Input;
import baseball.utils.Regex;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class User {
  public static final String USER_INPUT_ERROR_MESSAGE = "유저가 입력하는 숫자는 한 자리 이상 세 자리 이하, 각각은 1에서 9사이의 숫자여야 합니다.";
  public static final String USER_DUPLICATE_INPUT_ERROR_MESSAGE = "유저가 입력하는 각각의 숫자는 서로 중복되지 않습니다.";

  private Set<Integer> user = new LinkedHashSet<>();

  public User() {
    init();;
  }

  /*
   * [TEST]
   * 1. 유저가 입력하는 숫자가 1 ~ 9 사이의 숫자 스트링이 아닐 때 오류 발생
   * 2. 유저가 입력하는 숫자가 한 자리 이상 세 자리 이하가 아닐 때 오류 발생
   * 3. 숫자가 아닌 스트링일 때 오류 발생
   * 4. 유저가 입력한 숫자 중 중복된 값이 있을 때 오류 발생
   */
  public User(String input){
    init();
    validateInputValue(input);
  }

  private void init(){
    user.clear();
  }

  public void createUserInput(){
    init();
    Input input = new Input();
    putInputValueInList(input.toIntList());
    validateInputValue(input.getInput());
  }

  public void validateInputValue(String input) {
    if(!isMatcherResult(input)){
      throw new IllegalArgumentException(USER_INPUT_ERROR_MESSAGE);
    }

    if(!isDistinctInputValue(input)){
      throw new IllegalArgumentException(USER_DUPLICATE_INPUT_ERROR_MESSAGE);
    }
  }

  private boolean isMatcherResult(String input) {
    return Regex.getRegexMatcherResult( "^[1-9]{1,3}$", input );
  }

  private boolean isDistinctInputValue(String input){
   return this.user.size() == input.length();
  }

  private void putInputValueInList(List<Integer> numList){
    user.addAll(numList);
  }

  public List<Integer> getNumberList(){
    return List.copyOf(this.user);
  }

}
