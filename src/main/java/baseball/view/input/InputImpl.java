package baseball.view.input;


import camp.nextstep.edu.missionutils.Console;

public class InputImpl implements Input {

    @Override
    public String baseballInput() {
        return Console.readLine();
    }

    @Override
    public String endInput() {
        return Console.readLine();
    }

}
