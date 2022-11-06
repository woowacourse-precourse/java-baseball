package baseball.Players;

import baseball.Utils.MessagePrinter;
import baseball.Validation.Validation;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class User {

    private Validation validate;

    public User() {
        this.validate = new Validation();
    }
    public List<Integer> getInputNumbersList() {
        String userNumbers = readLine();

        validate.checkUserInputNumbers(userNumbers);

        return convertUserNumbersStringToList(userNumbers);
    }

    public List<Integer> convertUserNumbersStringToList(String userNumbers) {
        List<Integer> userNumbersList = new ArrayList<>();

        String[] userNumbersArray = userNumbers.split("");

        for (String number : userNumbersArray) {
            userNumbersList.add(Integer.parseInt(number));
        }

        return userNumbersList;
    }

    public boolean isUserWantsNewGame() {
        MessagePrinter print = new MessagePrinter();

        print.toContinue();

        String continueNumber = readLine();

        while (!validate.isContinueNumber(continueNumber)) {
            print.toContinue();
            continueNumber = readLine();
        }

        if (continueNumber.equals("1")) {
            return true;
        }

        return false;
    }
}
