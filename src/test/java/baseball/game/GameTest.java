package baseball.game;

import baseball.computer.Computer;
import baseball.player.Player;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class GameTest {
    public static InputStream generateUserInput(String userInput){
        return new ByteArrayInputStream(userInput.getBytes());
    }
    @Test
    public void prepare_Computer_Test(){
        Computer computer = new Computer();
        computer.createRandomNumbers();
        assertThat(computer.getDigits()).isNotEmpty();
    }
    @Test
    public void prepare_Player_Test(){
        Player player = new Player();
        String userInput="456";
        InputStream in = generateUserInput(userInput);
        System.setIn(in);
        player.createNumbers();
        assertThat(player.getDigits()).isNotEmpty();
    }
    @Test
    public void count_One_Strike_Test(){
        int strikeCount=0;
        int oneStrike=1;
        List<Integer> computerNumbers;
        Player player = new Player();
        Player computer = new Player();

        String computerPick="456";
        InputStream inComputer = generateUserInput(computerPick);
        System.setIn(inComputer);
        computer.createNumbers();
        computerNumbers=computer.getDigits();

        String userInput="465";
        InputStream inPlayer = generateUserInput(userInput);
        System.setIn(inPlayer);
        player.createNumbers();

        for(int computerNumber:computerNumbers){
            if(player.getNumberPosition(computerNumber)==computer.getNumberPosition(computerNumber)){
                strikeCount+=1;
            }
        }

        assertThat(strikeCount).isEqualTo(oneStrike);
    }
    @Test
    public void count_Two_Strike_Test(){
        int strikeCount=0;
        int twoStrike=2;
        List<Integer> computerNumbers;
        Player player = new Player();
        Player computer = new Player();

        String computerPick="456";
        InputStream inComputer = generateUserInput(computerPick);
        System.setIn(inComputer);
        computer.createNumbers();
        computerNumbers=computer.getDigits();

        String userInput="457";
        InputStream inPlayer = generateUserInput(userInput);
        System.setIn(inPlayer);
        player.createNumbers();

        for(int computerNumber:computerNumbers){
            if(player.getNumberPosition(computerNumber)==computer.getNumberPosition(computerNumber)){
                strikeCount+=1;
            }
        }

        assertThat(strikeCount).isEqualTo(twoStrike);
    }
    @Test
    public void count_Three_Strike_Test(){
        int strikeCount=0;
        int threeStrike=3;
        List<Integer> computerNumbers;
        Player player = new Player();
        Player computer = new Player();

        String computerPick="456";
        InputStream inComputer = generateUserInput(computerPick);
        System.setIn(inComputer);
        computer.createNumbers();
        computerNumbers=computer.getDigits();

        String userInput="456";
        InputStream inPlayer = generateUserInput(userInput);
        System.setIn(inPlayer);
        player.createNumbers();

        for(int computerNumber:computerNumbers){
            if(player.getNumberPosition(computerNumber)==computer.getNumberPosition(computerNumber)){
                strikeCount+=1;
            }
        }

        assertThat(strikeCount).isEqualTo(threeStrike);
    }
}
