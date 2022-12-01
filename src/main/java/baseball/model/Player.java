package baseball.model;



import static baseball.controller.Separator.SEPARATOR;


import baseball.view.InputView;
import java.util.List;
import java.util.stream.Collectors;

public enum Player {
    PLAYER;

    private String readLine;

    Player() {
        this.readLine = new InputView().putReadLine();
    }

    public List<Integer> number() {

        return SEPARATOR.execute(readLine)
                .stream()
                .map(Character::getNumericValue)
                .collect(Collectors.toList());

    }

}
