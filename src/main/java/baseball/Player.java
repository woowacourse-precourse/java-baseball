package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Player {
    private Validator validator;

    public List<Integer> getInput(){
        System.out.println(Message.INPUT_ASK.getMessage());
        String inputNum = Console.readLine();
        return validator.convertor(inputNum);
    }

    public String askRestart(){
        System.out.println(Message.RESTART.getMessage());
        return Console.readLine();
    }
}
