package baseball.game;

import baseball.player.Player;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CountBallTest {
    static Player player = new Player();
    static Player opponent = new Player();

    @Test
    public void count_One_Ball_Test(){
        int ballCount=0;
        int oneBall=1;
        int notFound=-1;
        List<Integer> computerNumbers;
        String computerPick="456";
        GameTest.preparePlayer(opponent, computerPick);
        computerNumbers=opponent.getDigits();

        String userInput="124";
        GameTest.preparePlayer(player, userInput);

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

        GameTest.preparePlayer(opponent, computerPick);
        computerNumbers=opponent.getDigits();

        String userInput="624";
        GameTest.preparePlayer(player, userInput);

        for(int computerNumber:computerNumbers){
            if(player.getNumberPosition(computerNumber)!=opponent.getNumberPosition(computerNumber)&&player.getNumberPosition(computerNumber)!=notFound){
                ballCount+=1;
            }
        }

        assertThat(ballCount).isEqualTo(twoBall);
    }

}
