package baseball.view;

import baseball.domain.Validator;
import camp.nextstep.edu.missionutils.Console;
public class BaseBallInput implements UserInput{
    public String getInput(){
        String input = Console.readLine();
        Validator.validate(input);
        return input;
    }

    public int getEndGameInput(){
        return Integer.parseInt(Console.readLine());
    }
}
