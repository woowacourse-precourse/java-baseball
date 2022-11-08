package baseball.util.number;

import java.util.List;
import baseball.view.InputView;

public class InputNumberGenerator implements NumberGenerator{
  @Override
  public List<Integer> generate(){
    return InputView.inputNumbers();
  }

}
