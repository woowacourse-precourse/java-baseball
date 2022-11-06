package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Player extends BaseballNumber{

    @Override
    public boolean isValidBaseballNumber (String playerInput){
        List<Integer> playerNumber = this.changePlayerInputToList(playerInput);

    }

    public List<Integer> changePlayerInputToList(String playerInput) {
        return Stream.of(playerInput.split("")).map(Integer::parseInt).collect(Collectors.toList());
    }

}
