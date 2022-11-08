package baseball;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ExcepetionCase {

    public boolean ThreeNumberException(int playerNum) {

        if (playerNum > 1000) {
            return false;
        }

        List<Integer> listPlayer = new ArrayList<>();

        while(playerNum>0){

            listPlayer.add(playerNum%10);
            playerNum /= 10;
        }

        for (int i = 0; i < 3 ;i ++){

            if(Collections.frequency(listPlayer,listPlayer.get(i)) != 1){

                return false;

            }


        }

        return true;
    }

    public boolean ResultNumberException(int resultNum) {

        // 1 혹은 2가 아닌 숫자가 들어왔을 때,




        return false;
    }

}
