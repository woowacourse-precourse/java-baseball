package baseball.model;

import static baseball.model.Number.*;
import static java.util.stream.Collector.*;
import static java.util.stream.Collectors.*;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;

public class Player {

    public List<Integer> generateNumber(String readLine) {

        return (List<Integer>) separateReadLine(readLine)
                .stream()
                .map(Character::getNumericValue)
                .collect(toList());
    }

    private static List<Character> separateReadLine(String readLine) {
        List<Character> separate = new ArrayList<>();
        for (int index = 0; index < LENGTH.getNumber(); index++) {
            char eachNumber = readLine.charAt(index);
            separate.add(eachNumber);
        }
        return separate;
    }

}
