package baseball.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.game.Game;
import baseball.player.Player;
import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class GameControllerTest {
    static Player player = new Player();
    Player opponent = new Player();
    public static InputStream generateUserInput(String userInput){
        return new ByteArrayInputStream(userInput.getBytes());
    }
    public static List<Integer> preparePlayer(String numbers) throws IOException {
        InputStream inPlayer = generateUserInput(numbers);
        System.setIn(inPlayer);
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String userNumbers = bf.readLine();
        return player.transform(Arrays.asList(userNumbers.split("")), Integer::parseInt);
    }
    @Test
    public void check_Game_Condition_Ongoing_Test() throws IOException {

        final int NOT_Found=-1;
        final int END_CONDITION=3;

        int strikeCount=0;
        int ballCount=0;

        String answer="678";
        String guess="678";

        List<Integer> opponentNumbers=preparePlayer(answer);
        List<Integer> playerNumbers=preparePlayer(guess);

        for(int computerNumber:opponentNumbers){
            if(playerNumbers.indexOf(computerNumber)!=opponentNumbers.indexOf(computerNumber)&&playerNumbers.indexOf(computerNumber)!=NOT_Found){
                ballCount+=1;
            }
            if(playerNumbers.indexOf(computerNumber)==opponentNumbers.indexOf(computerNumber)){
                strikeCount+=1;
            }
        }
        assertThat(strikeCount).isEqualTo(END_CONDITION);
    }
    @Test
    public void check_Game_End_Test() throws IOException {
        final int NOT_Found=-1;
        final int END_CONDITION=3;
        int strikeCount=0;
        int ballCount=0;

        String answer="678";
        String guess="678";

        List<Integer> opponentNumbers=preparePlayer(answer);
        List<Integer> playerNumbers=preparePlayer(guess);
        for(int computerNumber:opponentNumbers){
            if(playerNumbers.indexOf(computerNumber)!=opponentNumbers.indexOf(computerNumber)&&playerNumbers.indexOf(computerNumber)!=NOT_Found){
                ballCount+=1;
            }
            if(playerNumbers.indexOf(computerNumber)==opponentNumbers.indexOf(computerNumber)){
                strikeCount+=1;
            }
        }
        assertThat(strikeCount).isEqualTo(END_CONDITION);
    }
    @Test
    public void restart_OR_END_GAME_TEST()throws IOException{
        int userChoice;
        String userInput="1";
        int restart=1;
        InputStream inPlayer = generateUserInput(userInput);
        System.setIn(inPlayer);
        userChoice= Integer.parseInt(Console.readLine());
        assertThat(userChoice).isEqualTo(restart);
    }
    public static void isWrongInput(int state){
        if(state<1 || state>2){
            throw new IllegalArgumentException();
        }
    }
    @Test
    public void restart_OR_END_GAME_Fail_TEST() throws IOException {
        int userChoice;
        String userInput="3";
        InputStream inPlayer = generateUserInput(userInput);
        System.setIn(inPlayer);
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        userChoice= Integer.parseInt(bf.readLine());
        assertThatThrownBy(()->isWrongInput(userChoice)).isInstanceOf(IllegalArgumentException.class);
    }
}
