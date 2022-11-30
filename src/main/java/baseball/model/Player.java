package baseball.model;



import static baseball.controller.Separator.SEPARATOR;

import baseball.view.InputView;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public enum Player {
    PLAYER;

    private String readLine;

    public List<Integer> number() {

        return generateNumber();
    }


    private List<Integer> generateNumber() {
        return SEPARATOR.execute()
                .stream()
                .map(Character::getNumericValue)
                .collect(Collectors.toList());
    }

}
