package baseball.util.number;

import java.util.List;
import baseball.view.InputView;

public class UserNumberGenerator implements NumberGenerator{
  @Override
  public List<Integer> generate(){
    return InputView.inputNumbers();
  }

}
