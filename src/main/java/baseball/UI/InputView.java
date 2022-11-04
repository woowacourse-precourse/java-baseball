package baseball.UI;
import baseball.model.Input;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private Input input;

    public void getBaseballInput(){
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        this.input = new Input(input);
    }

    public Input getInput() {
        return input;
    }
}
