package baseball.Players;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class User {
    public List<Integer> getInputNumbers() {
        String userNumbers = readLine();

        return toList(userNumbers);
    }

    public List<Integer> toList(String userNumbers) {
        List<Integer> userNumbersList = new ArrayList<>();

        String[] userNumbersArray = userNumbers.split("");

        for (String number : userNumbersArray) {
            userNumbersList.add(Integer.parseInt(number));
        }

        return userNumbersList;
    }
}
