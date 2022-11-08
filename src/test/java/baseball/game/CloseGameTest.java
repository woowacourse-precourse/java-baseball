package baseball.game;

import baseball.player.Player;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CloseGameTest {
    static Player player = new Player();
    static Player opponent = new Player();
    @Test
    public void close_game_When_No_Ball_No_Strike_Test() throws IOException {
        int ballCount=0;
        int strikeCount=0;
        int endingCondition=3;
        int notFound=-1;
        String computerPick="637";
        String userInput="458";

        List<Integer> computerNumbers=GameTest.preparePlayer(computerPick);
        List<Integer> playerNumbers=GameTest.preparePlayer(userInput);

        for(int computerNumber:computerNumbers){
            if(playerNumbers.indexOf(computerNumber)!=computerNumbers.indexOf(computerNumber)&&playerNumbers.indexOf(computerNumber)!=notFound){
                ballCount+=1;
            }
            if(playerNumbers.indexOf(computerNumber)==computerNumbers.indexOf(computerNumber)){
                strikeCount+=1;
            }
        }
        assertThat(strikeCount).isNotEqualTo(endingCondition);
    }
    @Test
    public void close_game_When_No_Ball_Three_Strike_Test() throws IOException {
        int ballCount=0;
        int strikeCount=0;
        int endingCondition=3;
        int notFound=-1;
        String computerPick="458";
        String userInput="458";

        List<Integer> computerNumbers=GameTest.preparePlayer(computerPick);
        List<Integer> playerNumbers=GameTest.preparePlayer(userInput);

        for(int computerNumber:computerNumbers){
            if(playerNumbers.indexOf(computerNumber)!=computerNumbers.indexOf(computerNumber)&&playerNumbers.indexOf(computerNumber)!=notFound){
                ballCount+=1;
            }
            if(playerNumbers.indexOf(computerNumber)==computerNumbers.indexOf(computerNumber)){
                strikeCount+=1;
            }
        }
        assertThat(strikeCount).isEqualTo(endingCondition);
    }
}
