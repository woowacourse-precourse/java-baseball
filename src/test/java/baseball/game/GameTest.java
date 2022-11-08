package baseball.game;

import baseball.computer.Computer;
import baseball.player.Player;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class GameTest {
    static Computer computer = new Computer();
    static Player player = new Player();
    static Player opponent = new Player();
    public static InputStream generateUserInput(String userInput){
        return new ByteArrayInputStream(userInput.getBytes());
    }
    public static void preparePlayer(Player player, String numbers){
        InputStream inPlayer = generateUserInput(numbers);
        System.setIn(inPlayer);
        player.createNumbers();
    }
    @Test
    public void prepare_Computer_Test(){
        computer.createRandomNumbers();
        assertThat(computer.getDigits()).isNotEmpty();
    }
    @Test
    public void prepare_Player_Test(){

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

        String computerPick="456";
        preparePlayer(opponent, computerPick);
        computerNumbers=opponent.getDigits();
        System.out.println(computerNumbers);
        String userInput="465";
        preparePlayer(player, userInput);

        for(int computerNumber:computerNumbers){
            if(player.getNumberPosition(computerNumber)==opponent.getNumberPosition(computerNumber)){
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

        String computerPick="456";
        preparePlayer(opponent, computerPick);
        computerNumbers=opponent.getDigits();

        String userInput="457";
        preparePlayer(player, userInput);

        for(int computerNumber:computerNumbers){
            if(player.getNumberPosition(computerNumber)==opponent.getNumberPosition(computerNumber)){
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
        String computerPick="456";
        preparePlayer(opponent, computerPick);
        computerNumbers=opponent.getDigits();

        String userInput="456";
        preparePlayer(player, userInput);

        for(int computerNumber:computerNumbers){
            if(player.getNumberPosition(computerNumber)==opponent.getNumberPosition(computerNumber)){
                strikeCount+=1;
            }
        }

        assertThat(strikeCount).isEqualTo(threeStrike);
    }
    @Test
    public void count_One_Ball_Test(){
        int ballCount=0;
        int oneBall=1;
        int notFound=-1;
        List<Integer> computerNumbers;
        String computerPick="456";
        preparePlayer(opponent, computerPick);
        computerNumbers=opponent.getDigits();

        String userInput="124";
        preparePlayer(player, userInput);

        for(int computerNumber:computerNumbers){
            if(player.getNumberPosition(computerNumber)!=opponent.getNumberPosition(computerNumber)&&player.getNumberPosition(computerNumber)!=notFound){
                ballCount+=1;
            }
        }

        assertThat(ballCount).isEqualTo(oneBall);
    }
    @Test
    public void count_Two_Ball_Test(){
        int ballCount=0;
        int twoBall=2;
        int notFound=-1;
        List<Integer> computerNumbers;
        String computerPick="456";
        preparePlayer(opponent, computerPick);
        computerNumbers=opponent.getDigits();

        String userInput="624";
        preparePlayer(player, userInput);

        for(int computerNumber:computerNumbers){
            if(player.getNumberPosition(computerNumber)!=opponent.getNumberPosition(computerNumber)&&player.getNumberPosition(computerNumber)!=notFound){
                ballCount+=1;
            }
        }

        assertThat(ballCount).isEqualTo(twoBall);
    }

}
