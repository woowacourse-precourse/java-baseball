package baseball;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ExcepetionCase {
    public boolean ThreeNumberException(String playerNum) {
        if( !OnlyNumber(playerNum) || !NotDuplicate(playerNum) || !ThreeLength(playerNum) ) {
            return false;
        }
        return true;
    }



    public boolean ThreeLength(String playerNum) {

        if (playerNum.length() != 3) {
            return false;
        }
        return true;
    }
    public boolean OnlyNumber(String playerNum) {

        for (int i = 0; i < playerNum.length(); i++) {

            int ASCII = playerNum.charAt(i);

            if (ASCII >= 49 && ASCII <= 57) {
                return true;
            }

        }
        return false;
    }

    public boolean NotDuplicate(String playerNum) {

        List<Integer> listDuplicateCheck = new ArrayList<>();
        for (int i = 0; i < playerNum.length(); i++) {
            int ASCII = playerNum.charAt(i);

            if (ASCII < 49 || ASCII > 57) {
                return false;
            }


            listDuplicateCheck.add(ASCII);

        }
        for (int i = 0; i < 3 ;i ++){

            if(Collections.frequency(listDuplicateCheck,listDuplicateCheck.get(i)) != 1){

                return false;

            }


        }



        return true;

    }



}
