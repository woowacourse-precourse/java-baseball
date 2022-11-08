package baseball.game;

import baseball.computer.Computer;
import baseball.player.Player;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CountStrikeTest {
    static Player player = new Player();
    static Player opponent = new Player();

    @Test
    public void count_One_Strike_Test(){
        int strikeCount=0;
        int oneStrike=1;
        List<Integer> computerNumbers;

        String computerPick="456";
        GameTest.preparePlayer(opponent, computerPick);
        computerNumbers=opponent.getDigits();
        System.out.println(computerNumbers);
        String userInput="465";
        GameTest.preparePlayer(player, userInput);

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
        GameTest.preparePlayer(opponent, computerPick);
        computerNumbers=opponent.getDigits();

        String userInput="457";
        GameTest.preparePlayer(player, userInput);

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

        GameTest.preparePlayer(opponent, computerPick);
        computerNumbers=opponent.getDigits();

        String userInput="456";
        GameTest.preparePlayer(player, userInput);

        for(int computerNumber:computerNumbers){
            if(player.getNumberPosition(computerNumber)==opponent.getNumberPosition(computerNumber)){
                strikeCount+=1;
            }
        }

        assertThat(strikeCount).isEqualTo(threeStrike);
    }
}
