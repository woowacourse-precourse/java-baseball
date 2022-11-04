package baseball.domain;

import baseball.util.GameValidator;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BaseBall implements Game {

    private final List<Integer> computerNumbers;
    private final List<Integer> playerNumbers = new ArrayList<>(GameValidator.GAME_NUMBER_LENGTH);

    public BaseBall() {
        computerNumbers = Randoms.pickUniqueNumbersInRange((int) GameValidator.START_RANGE,
            (int) GameValidator.END_RANGE, GameValidator.GAME_NUMBER_LENGTH);
    }

    @Override
    public void play() {
        playerInput();
    }

    private void playerInput() {
        String playerInput = Console.readLine();
        GameValidator.validate(playerInput);
        storePlayerNumbers(playerInput);
    }

    private void storePlayerNumbers(String playerInput) {
        playerNumbers.clear();
        playerNumbers.addAll(
            playerInput.chars()
                .boxed()
                .collect(Collectors.toList())
        );
    }
}
