package baseball.game;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CloseGameTest {
    @Test
    public void close_game_When_No_Ball_No_Strike_Test() throws IOException {
        int endingCondition=3;
        int notFound=-1;

        int ballCount=0;
        int strikeCount=0;
        int count=1;

        String computerPick="637";
        String userInput="458";

        List<Integer> computerNumbers= GameTestUtility.preparePlayer(computerPick);
        List<Integer> playerNumbers= GameTestUtility.preparePlayer(userInput);

        for(int computerNumber:computerNumbers){
            if(playerNumbers.indexOf(computerNumber)!=computerNumbers.indexOf(computerNumber)&&playerNumbers.indexOf(computerNumber)!=notFound){
                ballCount+=count;
            }
            if(playerNumbers.indexOf(computerNumber)==computerNumbers.indexOf(computerNumber)){
                strikeCount+=count;
            }
        }
        assertThat(strikeCount).isNotEqualTo(endingCondition);
    }
    @Test
    public void close_game_When_No_Ball_Three_Strike_Test() throws IOException {
        int endingCondition=3;
        int notFound=-1;

        int ballCount=0;
        int strikeCount=0;
        int count=1;

        String computerPick="458";
        String userInput="458";

        List<Integer> computerNumbers= GameTestUtility.preparePlayer(computerPick);
        List<Integer> playerNumbers= GameTestUtility.preparePlayer(userInput);

        for(int computerNumber:computerNumbers){
            if(playerNumbers.indexOf(computerNumber)!=computerNumbers.indexOf(computerNumber)&&playerNumbers.indexOf(computerNumber)!=notFound){
                ballCount+=count;
            }
            if(playerNumbers.indexOf(computerNumber)==computerNumbers.indexOf(computerNumber)){
                strikeCount+=count;
            }
        }
        assertThat(strikeCount).isEqualTo(endingCondition);
    }
}
