package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import static baseball.constant.ConstantValue.*;

public class View {
    public View(){}

    public void initView(){
        System.out.println(GAME_START_MESSAGE);
    }
    public String gameView(){
        System.out.println(NUBMER_INPUT_MESSAGE);
        String inputNumber = Console.readLine();
        return inputNumber;
    }

}
