package baseball.player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.io.*;

import java.util.Arrays;
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
    public void get_Index_From_Integer_List_Test() throws IOException {
        Player player = new Player();
        List<Integer> playerNumbers;
        int firstElement;
        int firstIndex=0;
        int returnIndex;
        String userInput="456";
        InputStream in = generateUserInput(userInput);
        System.setIn(in);
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String userNumbers = bf.readLine();
        List<Integer> transformedUserNumbers =player.transform(Arrays.asList(userNumbers.split("")), Integer::parseInt);
        firstElement=transformedUserNumbers.get(firstIndex);
        returnIndex=transformedUserNumbers.indexOf(firstElement);

        assertThat(returnIndex).isEqualTo(firstIndex);
    }
    @Test
    public void get_Index_From_Integer_List_Not_Exist_Element_Test() throws IOException {
        Player player = new Player();
        List<Integer> playerNumbers;
        int notExistsElement=0;
        int notExistsElementIndex=-1;
        int returnIndex;
        String userInput="456";
        InputStream in = generateUserInput(userInput);
        System.setIn(in);
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        //파일에서 입력받을 경우에는 new BufferedReader(new FileReader("ex.java"));

        //라인단위로 입력받기(Enter를 경계로)
        String userNumbers = bf.readLine();
        List<Integer> transformedUserNumbers =player.transform(Arrays.asList(userNumbers.split("")), Integer::parseInt);
        returnIndex=transformedUserNumbers.indexOf(notExistsElement);

        assertThat(returnIndex).isEqualTo(notExistsElementIndex);
    }
}
