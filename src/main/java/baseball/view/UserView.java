package baseball.view;

import baseball.model.Validation;
import camp.nextstep.edu.missionutils.Console;

public class UserView {

    private static final Validation validation = new Validation();

    public UserView(){ }

    public String UserAnswer(){
        System.out.print("숫자를 입력해주세요 : ");

        String input = Console.readLine();

        if(!validation.CheckString(input)){
            throw new IllegalArgumentException();
        }

        return input;
    }



}
