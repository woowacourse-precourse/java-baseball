package baseball.player;
import baseball.exception.InputException;
import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class PlayerTest {
    @Test
    @DisplayName("check opponent makes 3 digit integer properly")
    public void initialize_computer_Test() {
        Player player = new Player();
        assertThat(player.initializeOpponent()).doesNotHaveDuplicates();
    }
    @Test
    @DisplayName("check player makes 3 digit integer properly")
    public void initialize_player_test(){
        String userInput="456";
        List<Integer> result=List.of(4,5,6); //result: [4,5,6]

        Player player = new Player();
        List<String> separatedUserInput = List.of(userInput.split(""));
        List<Integer> playerNumber = player.transform(separatedUserInput, Integer::parseInt);
        assertThat(playerNumber).isEqualTo(result);
    }

}
