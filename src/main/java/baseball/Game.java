package baseball;

import com.sun.xml.internal.ws.api.ha.StickyFeature;
import java.util.ArrayList;
import java.util.List;

public class Selctor {


    private List<Integer> getComputerNumber(){

    }

    private int[] gamePlay(List<Integer> player, List<Integer> computer){
        int ball = 0;
        int strike = 0;

        for (int len = player.size(), i=0; i<len;i++){
            int play = player.get(i);

            if (computer.indexOf(play)!=i){
                ball++;
            }else if(computer.indexOf(play) == i){
                strike++;
            }
        }
        int[] result = new int[]{ball, strike};
        return result;
    }
    private String gameResult(List<Integer> player, List<Integer> computer){
        String game = " ";
        int[] result = gamePlay(player, computer);

        if (result[0]==0&&result[1]==0){
            game = "낫싱";
        }else{
            game = result[0]+"볼"+result[1]+"스트라이크";
        }

        return game;
    }


}
