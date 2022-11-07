package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class ReadNumber {
    Validation validation = new Validation();

    public List<String> readThreeNumberFromUser() {
        List<String> threeNumber = new ArrayList<>();

        System.out.print("숫자를 입력해주세요 : ");
        String inputNumberFromUser = Console.readLine();

        validation.validationIsNumber(inputNumberFromUser);

        return validation.validationDuplication(threeNumber, inputNumberFromUser);
    }
}
