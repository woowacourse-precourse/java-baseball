package baseball;

import camp.nextstep.edu.missionutils.Console;
import constant.Texts;

import java.util.ArrayList;
import java.util.List;

public class User {
    private static List<Integer> number;

    public User() {
        number = new ArrayList<>();
    }

    public void makeUserNumber() {
        clear();
        System.out.print(Texts.USER_INPUT_NUMBER);
        String number = Console.readLine();

        Checker checker = new Checker();
        checker.checkLegalNumber(number);

        for (String s : number.split("")) {
            this.number.add(Integer.parseInt(s));
        }

    }

    public List<Integer> getNumber() {
        List<Integer> copyNumber = new ArrayList<>();
        for (int i : number) copyNumber.add(i);
        return copyNumber;
    }

    private void clear() {
        number.clear();
    }
}
