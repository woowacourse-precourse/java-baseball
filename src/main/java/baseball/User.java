package baseball;

import camp.nextstep.edu.missionutils.Console;
import constant.Texts;

import java.util.ArrayList;
import java.util.List;

public class User {
    List<Integer> number;
    public User() {
        number=new ArrayList<>();
    }
    public void makeUserNumber() {
        System.out.print(Texts.USER_INPUT_NUMBER);
        String input = Console.readLine();
        if (input.length() > 3) {
            throw new IllegalArgumentException(Texts.USER_INPUT_ILLEGAL_LENGTH+Texts.USER_INPUT_ILLEGAL);
        }
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(Texts.USER_INPUT_ILLEGAL);
        }
        for (String s : input.split("")) this.number.add(Integer.parseInt(s));
    }
}
