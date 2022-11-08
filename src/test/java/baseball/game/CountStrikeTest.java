package baseball.game;

import baseball.computer.Computer;
import baseball.player.Player;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CountStrikeTest {
    static Player player = new Player();
    static Player opponent = new Player();

    @Test
    public void count_One_Strike_Test() throws IOException {
        int strikeCount=0;
        int oneStrike=1;

        String computerPick="456";
        String userInput="465";

        List<Integer> computerNumbers=GameTest.preparePlayer(computerPick);
        List<Integer> playerNumbers=GameTest.preparePlayer(userInput);

        for(int computerNumber:computerNumbers){
            if(playerNumbers.indexOf(computerNumber)==computerNumbers.indexOf(computerNumber)){
                strikeCount+=1;
            }
        }

        assertThat(strikeCount).isEqualTo(oneStrike);
    }
    @Test
    public void count_Two_Strike_Test() throws IOException {
        int strikeCount=0;
        int twoStrike=2;

        String computerPick="456";
        String userInput="457";

        List<Integer> computerNumbers=GameTest.preparePlayer(computerPick);
        List<Integer> playerNumbers=GameTest.preparePlayer(userInput);

        for(int computerNumber:computerNumbers){
            if(playerNumbers.indexOf(computerNumber)==computerNumbers.indexOf(computerNumber)){
                strikeCount+=1;
            }
        }
        assertThat(strikeCount).isEqualTo(twoStrike);
    }
    @Test
    public void count_Three_Strike_Test() throws IOException {
        int strikeCount=0;
        int threeStrike=3;

        String computerPick="456";
        String userInput="456";

        List<Integer> computerNumbers=GameTest.preparePlayer(computerPick);
        List<Integer> playerNumbers=GameTest.preparePlayer(userInput);

        for(int computerNumber:computerNumbers){
            if(playerNumbers.indexOf(computerNumber)==computerNumbers.indexOf(computerNumber)){
                strikeCount+=1;
            }
        }
        assertThat(strikeCount).isEqualTo(threeStrike);
    }
}
