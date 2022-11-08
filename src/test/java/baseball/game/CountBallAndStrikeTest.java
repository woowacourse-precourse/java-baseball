package baseball.game;

import baseball.player.Player;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CountBallAndStrikeTest {
    static Player player = new Player();
    static Player opponent = new Player();

    @Test
    public void count_One_Ball_No_Strike_Test(){
        int ballCount=0;
        int strikeCount=0;
        int oneBall=1;
        int noStrike=0;
        List<Integer> answer = List.of(noStrike, oneBall);
        List<Integer> expectedAnswer=new ArrayList<>();
        int notFound=-1;
        List<Integer> computerNumbers;
        String computerPick="456";

        GameTest.preparePlayer(opponent, computerPick);
        computerNumbers=opponent.getDigits();

        String userInput="637";
        GameTest.preparePlayer(player, userInput);

        for(int computerNumber:computerNumbers){
            if(player.getNumberPosition(computerNumber)!=opponent.getNumberPosition(computerNumber)&&player.getNumberPosition(computerNumber)!=notFound){
                ballCount+=1;
            }
            if(player.getNumberPosition(computerNumber)==opponent.getNumberPosition(computerNumber)){
                strikeCount+=1;
            }

        }
        expectedAnswer.add(strikeCount);
        expectedAnswer.add(ballCount);
        assertThat(expectedAnswer).isEqualTo(answer);
    }
    @Test
    public void count_One_Ball_One_Strike_Test(){
        int ballCount=0;
        int strikeCount=0;
        int Ball=1;
        int Strike=1;
        List<Integer> answer = List.of(Strike, Ball);
        List<Integer> expectedAnswer=new ArrayList<>();
        int notFound=-1;
        List<Integer> computerNumbers;
        String computerPick="456";
        GameTest.preparePlayer(opponent, computerPick);
        computerNumbers=opponent.getDigits();

        String userInput="657";
        GameTest.preparePlayer(player, userInput);

        for(int computerNumber:computerNumbers){
            if(player.getNumberPosition(computerNumber)!=opponent.getNumberPosition(computerNumber)&&player.getNumberPosition(computerNumber)!=notFound){
                ballCount+=1;
            }
            if(player.getNumberPosition(computerNumber)==opponent.getNumberPosition(computerNumber)){
                strikeCount+=1;
            }

        }
        expectedAnswer.add(strikeCount);
        expectedAnswer.add(ballCount);
        assertThat(expectedAnswer).isEqualTo(answer);
    }

    @Test
    public void count_Two_Ball_One_Strike_Test(){
        int ballCount=0;
        int strikeCount=0;
        int Ball=2;
        int Strike=1;
        List<Integer> answer = List.of(Strike, Ball);
        List<Integer> expectedAnswer=new ArrayList<>();
        int notFound=-1;
        List<Integer> computerNumbers;
        String computerPick="456";
        GameTest.preparePlayer(opponent, computerPick);
        computerNumbers=opponent.getDigits();

        String userInput="654";
        GameTest.preparePlayer(player, userInput);

        for(int computerNumber:computerNumbers){
            if(player.getNumberPosition(computerNumber)!=opponent.getNumberPosition(computerNumber)&&player.getNumberPosition(computerNumber)!=notFound){
                ballCount+=1;
            }
            if(player.getNumberPosition(computerNumber)==opponent.getNumberPosition(computerNumber)){
                strikeCount+=1;
            }

        }
        expectedAnswer.add(strikeCount);
        expectedAnswer.add(ballCount);
        assertThat(expectedAnswer).isEqualTo(answer);
    }
    @Test
    public void count_No_Ball_Two_Strike_Test(){
        int ballCount=0;
        int strikeCount=0;
        int Ball=0;
        int Strike=2;
        List<Integer> answer = List.of(Strike, Ball);
        List<Integer> expectedAnswer=new ArrayList<>();
        int notFound=-1;
        List<Integer> computerNumbers;
        String computerPick="456";
        GameTest.preparePlayer(opponent, computerPick);
        computerNumbers=opponent.getDigits();

        String userInput="457";
        GameTest.preparePlayer(player, userInput);

        for(int computerNumber:computerNumbers){
            if(player.getNumberPosition(computerNumber)!=opponent.getNumberPosition(computerNumber)&&player.getNumberPosition(computerNumber)!=notFound){
                ballCount+=1;
            }
            if(player.getNumberPosition(computerNumber)==opponent.getNumberPosition(computerNumber)){
                strikeCount+=1;
            }

        }
        expectedAnswer.add(strikeCount);
        expectedAnswer.add(ballCount);
        assertThat(expectedAnswer).isEqualTo(answer);
    }
    @Test
    public void count_No_Ball_Three_Strike_Test(){
        int ballCount=0;
        int strikeCount=0;
        int Ball=0;
        int Strike=3;
        List<Integer> answer = List.of(Strike, Ball);
        List<Integer> expectedAnswer=new ArrayList<>();
        int notFound=-1;
        List<Integer> computerNumbers;
        String computerPick="456";
        GameTest.preparePlayer(opponent, computerPick);
        computerNumbers=opponent.getDigits();

        String userInput="456";
        GameTest.preparePlayer(player, userInput);

        for(int computerNumber:computerNumbers){
            if(player.getNumberPosition(computerNumber)!=opponent.getNumberPosition(computerNumber)&&player.getNumberPosition(computerNumber)!=notFound){
                ballCount+=1;
            }
            if(player.getNumberPosition(computerNumber)==opponent.getNumberPosition(computerNumber)){
                strikeCount+=1;
            }

        }
        expectedAnswer.add(strikeCount);
        expectedAnswer.add(ballCount);
        assertThat(expectedAnswer).isEqualTo(answer);
    }
    @Test
    public void count_No_Ball_No_Strike_Test(){
        int ballCount=0;
        int strikeCount=0;
        int Ball=0;
        int Strike=0;
        List<Integer> answer = List.of(Strike, Ball);
        List<Integer> expectedAnswer=new ArrayList<>();
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
        expectedAnswer.add(strikeCount);
        expectedAnswer.add(ballCount);
        assertThat(expectedAnswer).isEqualTo(answer);
    }
}
