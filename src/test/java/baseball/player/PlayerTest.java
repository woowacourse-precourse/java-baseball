package baseball.player;
import baseball.computer.Computer;
import baseball.exception.InputException;
import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.w3c.dom.ls.LSInput;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class PlayerTest {
    public static InputStream generateUserInput(String userInput){
        return new ByteArrayInputStream(userInput.getBytes());
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
    @Test
    public void get_Index_From_Integer_List_Test(){
        Player player = new Player();
        List<Integer> playerNumbers;
        int firstElement;
        int firstIndex=0;
        int returnIndex;
        String userInput="456";
        InputStream in = generateUserInput(userInput);
        System.setIn(in);
        player.createNumbers();
        playerNumbers=player.getDigits();
        firstElement=playerNumbers.get(firstIndex);
        returnIndex=playerNumbers.indexOf(firstElement);

        assertThat(returnIndex).isEqualTo(firstIndex);
    }
    @Test
    public void get_Index_From_Integer_List_Not_Exist_Element_Test(){
        Player player = new Player();
        List<Integer> playerNumbers;
        int notExistsElement=0;
        int notExistsElementIndex=-1;
        int returnIndex;
        String userInput="456";
        InputStream in = generateUserInput(userInput);
        System.setIn(in);
        player.createNumbers();
        playerNumbers=player.getDigits();
        returnIndex=playerNumbers.indexOf(notExistsElement);

        assertThat(returnIndex).isEqualTo(notExistsElementIndex);
    }
}
