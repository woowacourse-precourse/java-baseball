package baseball.game;

import baseball.player.Player;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CountBallTest {
    static Player player = new Player();
    static Player opponent = new Player();

    @Test
    public void count_One_Ball_Test() throws IOException {
        int ballCount=0;
        int oneBall=1;
        int notFound=-1;

        String computerPick="456";
        String userInput="124";
        List<Integer> computerNumbers=GameTest.preparePlayer(computerPick);
        List<Integer> playerNumbers=GameTest.preparePlayer(userInput);

        for(int computerNumber:computerNumbers){
            if(playerNumbers.indexOf(computerNumber)!=computerNumbers.indexOf(computerNumber)&&playerNumbers.indexOf(computerNumber)!=notFound){
                ballCount+=1;
            }
        }
        assertThat(ballCount).isEqualTo(oneBall);
    }
    @Test
    public void count_Two_Ball_Test() throws IOException {
        int ballCount=0;
        int twoBall=2;
        int notFound=-1;

        String computerPick="456";
        String userInput="624";
        List<Integer> computerNumbers=GameTest.preparePlayer(computerPick);
        List<Integer> playerNumbers=GameTest.preparePlayer(userInput);

        for(int computerNumber:computerNumbers){
            if(playerNumbers.indexOf(computerNumber)!=computerNumbers.indexOf(computerNumber)&&playerNumbers.indexOf(computerNumber)!=notFound){
                ballCount+=1;
            }
        }
        assertThat(ballCount).isEqualTo(twoBall);
    }

}
