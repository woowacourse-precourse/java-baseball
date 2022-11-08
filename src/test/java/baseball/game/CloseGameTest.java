package baseball.game;

import baseball.player.Player;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CloseGameTest {
    static Player player = new Player();
    static Player opponent = new Player();
    @Test
    public void close_game_When_No_Ball_No_Strike_Test(){
        int ballCount=0;
        int strikeCount=0;
        int endingCondition=3;
        int notFound=-1;
        List<Integer> computerNumbers;
        String computerPick="637";
        GameTest.preparePlayer(opponent, computerPick);
        computerNumbers=opponent.getDigits();

        String userInput="458";
        GameTest.preparePlayer(player, userInput);

        for(int computerNumber:computerNumbers){
            if(player.getNumberPosition(computerNumber)!=opponent.getNumberPosition(computerNumber)&&player.getNumberPosition(computerNumber)!=notFound){
                ballCount+=1;
            }
            if(player.getNumberPosition(computerNumber)==opponent.getNumberPosition(computerNumber)){
                strikeCount+=1;
            }
        }
        assertThat(strikeCount).isNotEqualTo(endingCondition);
    }
    @Test
    public void close_game_When_No_Ball_Three_Strike_Test(){
        int ballCount=0;
        int strikeCount=0;
        int endingCondition=3;
        int notFound=-1;
        List<Integer> computerNumbers;
        String computerPick="458";
        GameTest.preparePlayer(opponent, computerPick);
        computerNumbers=opponent.getDigits();

        String userInput="458";
        GameTest.preparePlayer(player, userInput);

        for(int computerNumber:computerNumbers){
            if(player.getNumberPosition(computerNumber)!=opponent.getNumberPosition(computerNumber)&&player.getNumberPosition(computerNumber)!=notFound){
                ballCount+=1;
            }
            if(player.getNumberPosition(computerNumber)==opponent.getNumberPosition(computerNumber)){
                strikeCount+=1;
            }
        }
        assertThat(strikeCount).isEqualTo(endingCondition);
    }
}
