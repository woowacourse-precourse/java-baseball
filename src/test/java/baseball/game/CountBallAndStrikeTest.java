package baseball.game;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CountBallAndStrikeTest {
    @Test
    public void count_One_Ball_No_Strike_Test() throws IOException {
        int notFound=-1;

        int Ball=1;
        int Strike=0;

        int ballCount=0;
        int strikeCount=0;
        int count=1;

        List<Integer> answer = List.of(Strike, Ball);
        List<Integer> expectedAnswer=new ArrayList<>();

        String computerPick="456";
        String userInput="637";
   ;
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

        expectedAnswer.add(strikeCount);
        expectedAnswer.add(ballCount);
        assertThat(expectedAnswer).isEqualTo(answer);
    }
    @Test
    public void count_One_Ball_One_Strike_Test() throws IOException {
        int notFound=-1;

        int Ball=1;
        int Strike=1;

        int ballCount=0;
        int strikeCount=0;
        int count=1;

        List<Integer> answer = List.of(Strike, Ball);
        List<Integer> expectedAnswer=new ArrayList<>();

        String computerPick="456";
        String userInput="657";

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

        expectedAnswer.add(strikeCount);
        expectedAnswer.add(ballCount);
        assertThat(expectedAnswer).isEqualTo(answer);
    }

    @Test
    public void count_Two_Ball_One_Strike_Test() throws IOException {
        int notFound=-1;

        int Ball=2;
        int Strike=1;

        int ballCount=0;
        int strikeCount=0;
        int count=1;

        List<Integer> answer = List.of(Strike, Ball);
        List<Integer> expectedAnswer=new ArrayList<>();

        String computerPick="456";
        String userInput="654";

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

        expectedAnswer.add(strikeCount);
        expectedAnswer.add(ballCount);
        assertThat(expectedAnswer).isEqualTo(answer);
    }
    @Test
    public void count_No_Ball_Two_Strike_Test() throws IOException {
        int notFound=-1;

        int Ball=0;
        int Strike=2;

        int ballCount=0;
        int strikeCount=0;
        int count=1;

        List<Integer> answer = List.of(Strike, Ball);
        List<Integer> expectedAnswer=new ArrayList<>();

        String computerPick="456";
        String userInput="457";

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

        expectedAnswer.add(strikeCount);
        expectedAnswer.add(ballCount);
        assertThat(expectedAnswer).isEqualTo(answer);
    }
    @Test
    public void count_No_Ball_Three_Strike_Test() throws IOException {
        int notFound=-1;

        int Ball=0;
        int Strike=3;

        int ballCount=0;
        int strikeCount=0;
        int count=1;

        List<Integer> answer = List.of(Strike, Ball);
        List<Integer> expectedAnswer=new ArrayList<>();


        String computerPick="456";
        String userInput="456";
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
        expectedAnswer.add(strikeCount);
        expectedAnswer.add(ballCount);
        assertThat(expectedAnswer).isEqualTo(answer);
    }
    @Test
    public void count_No_Ball_No_Strike_Test() throws IOException {
        int notFound=-1;

        int Ball=0;
        int Strike=0;

        int ballCount=0;
        int strikeCount=0;
        int count=1;

        List<Integer> answer = List.of(Strike, Ball);
        List<Integer> expectedAnswer=new ArrayList<>();

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
        expectedAnswer.add(strikeCount);
        expectedAnswer.add(ballCount);
        assertThat(expectedAnswer).isEqualTo(answer);
    }
}
