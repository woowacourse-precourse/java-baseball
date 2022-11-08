package baseball.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.LIST;

import baseball.computer.Computer;
import baseball.game.Game;
import baseball.player.Player;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GameControllerTest {
    public static InputStream generateUserInput(String userInput){
        return new ByteArrayInputStream(userInput.getBytes());
    }
    public static void preparePlayer(Player player, String numbers){
        InputStream inPlayer = generateUserInput(numbers);
        System.setIn(inPlayer);
        player.createNumbers();
    }
    Game game = new Game();
    Player player = new Player();
    Player opponent = new Player();

    @Test
    public void check_Game_Condition_Ongoing_Test(){
        
        final int NOT_Found=-1;
        final int END_CONDITION=3;

        int strikeCount=0;
        int ballCount=0;

        String answer="678";
        String guess="687";

        preparePlayer(opponent, answer);
        List<Integer> computerNumbers=opponent.getDigits();
        preparePlayer(player, guess);
        for(int computerNumber:computerNumbers){
            if(player.getNumberPosition(computerNumber)!=opponent.getNumberPosition(computerNumber)&&player.getNumberPosition(computerNumber)!=NOT_Found){
                ballCount+=1;
            }
            if(player.getNumberPosition(computerNumber)==opponent.getNumberPosition(computerNumber)){
                strikeCount+=1;
            }
        }
        assertThat(strikeCount).isNotEqualTo(END_CONDITION);
    }
    @Test
    public void check_Game_End_Test(){
        final int NOT_Found=-1;
        final int END_CONDITION=3;
        int strikeCount=0;
        int ballCount=0;

        String answer="678";
        String guess="678";

        preparePlayer(opponent, answer);
        List<Integer> computerNumbers=opponent.getDigits();
        preparePlayer(player, guess);
        for(int computerNumber:computerNumbers){
            if(player.getNumberPosition(computerNumber)!=opponent.getNumberPosition(computerNumber)&&player.getNumberPosition(computerNumber)!=NOT_Found){
                ballCount+=1;
            }
            if(player.getNumberPosition(computerNumber)==opponent.getNumberPosition(computerNumber)){
                strikeCount+=1;
            }
        }
        assertThat(strikeCount).isEqualTo(END_CONDITION);
    }
}
