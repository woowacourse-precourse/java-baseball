package baseball.service;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static utils.Converter.convertStringToIntegerList;

import utils.Validation;
import java.util.List;

public class UserNumberService {
    public static List<Integer> generate() {
        String inputNumber = readLine();

        Validation.validate(inputNumber);
        List<Integer> userNumbers = convertStringToIntegerList(inputNumber);

        return userNumbers;
    }
}
