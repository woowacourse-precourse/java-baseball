package domain;

import camp.nextstep.edu.missionutils.Console;
import constant.Messages;

import java.util.ArrayList;
import java.util.List;

public class User {
    public Numbers input() {
//        String userInput = Console.readLine();
        String userInput = "1234";
        List<Number> list = new ArrayList<>();

        for (int i = 0; i < userInput.length(); i++) {
            list.add(new Number(userInput.charAt(i) - '0'));
        }

        new Numbers(list).isValidSize(list);
        new Numbers(list).isDuplicate(list);

        return new Numbers(list);
    }
}
