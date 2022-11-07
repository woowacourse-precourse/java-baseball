package baseball.player;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Player {
    final int NUMBER_OF_TRIAL=3;
    final int RANGE_START_NUMBER=1;
    final int RANGE_END_NUMBER=9;

    List<Integer> initializeOpponent(){
        List<Integer> opponent = new ArrayList<>();
        while(opponent.size() < NUMBER_OF_TRIAL){
            int randomNumber = Randoms.pickNumberInRange(RANGE_START_NUMBER, RANGE_END_NUMBER);
            if (!opponent.contains(randomNumber)) {
                opponent.add(randomNumber);
            }
        }
        return opponent;
    }
}