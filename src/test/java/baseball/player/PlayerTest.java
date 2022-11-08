package baseball.player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.io.*;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class PlayerTest {
    static final String DELIMITER="";
    public static InputStream generateUserInput(String userInput){
        return new ByteArrayInputStream(userInput.getBytes());
    }
    @Test
    @DisplayName("check player makes 3 digit integer properly")
    public void initialize_player_test(){
        String userInput="456";
        List<Integer> result=List.of(4,5,6); //result: [4,5,6]

        Player player = new Player();
        List<String> separatedUserInput = List.of(userInput.split(DELIMITER));
        List<Integer> playerNumber = player.transform(separatedUserInput, Integer::parseInt);
        assertThat(playerNumber).isEqualTo(result);
    }
    @Test
    public void get_Index_From_Integer_List_Test() throws IOException {

        int firstElement;
        int firstIndex=0;
        int returnIndex;

        Player player = new Player();

        String userInput="456";
        InputStream in = generateUserInput(userInput);
        System.setIn(in);
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String userNumbers = bf.readLine();
        List<Integer> playerNumbers =player.transform(Arrays.asList(userNumbers.split(DELIMITER)), Integer::parseInt);
        firstElement=playerNumbers.get(firstIndex);
        returnIndex=playerNumbers.indexOf(firstElement);

        assertThat(returnIndex).isEqualTo(firstIndex);
    }
    @Test
    public void get_Index_From_Integer_List_Not_Exist_Element_Test() throws IOException {
        Player player = new Player();

        int notExistsElement=0;
        int notExistsElementIndex=-1;
        int returnIndex;
        String userInput="456";
        InputStream in = generateUserInput(userInput);
        System.setIn(in);
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String userNumbers = bf.readLine();
        List<Integer> playerNumbers =player.transform(Arrays.asList(userNumbers.split(DELIMITER)), Integer::parseInt);
        returnIndex=playerNumbers.indexOf(notExistsElement);

        assertThat(returnIndex).isEqualTo(notExistsElementIndex);
    }
}
