package baseball.game;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CountBallTest {
    @Test
    public void count_One_Ball_Test() throws IOException {
        int oneBall=1;
        int notFound=-1;

        int ballCount=0;
        int count=1;

        String computerPick="456";
        String userInput="124";

        List<Integer> computerNumbers= GameTestUtility.preparePlayer(computerPick);
        List<Integer> playerNumbers= GameTestUtility.preparePlayer(userInput);

        for(int computerNumber:computerNumbers){
            if(playerNumbers.indexOf(computerNumber)!=computerNumbers.indexOf(computerNumber)&&playerNumbers.indexOf(computerNumber)!=notFound){
                ballCount+=count;
            }
        }
        assertThat(ballCount).isEqualTo(oneBall);
    }
    @Test
    public void count_Two_Ball_Test() throws IOException {

        int twoBall=2;
        int notFound=-1;

        int ballCount=0;
        int count=1;

        String computerPick="456";
        String userInput="624";

        List<Integer> computerNumbers= GameTestUtility.preparePlayer(computerPick);
        List<Integer> playerNumbers= GameTestUtility.preparePlayer(userInput);

        for(int computerNumber:computerNumbers){
            if(playerNumbers.indexOf(computerNumber)!=computerNumbers.indexOf(computerNumber)&&playerNumbers.indexOf(computerNumber)!=notFound){
                ballCount+=count;
            }
        }
        assertThat(ballCount).isEqualTo(twoBall);
    }

}
