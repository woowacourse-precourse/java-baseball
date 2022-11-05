package Controller;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static List<Integer> get_ThreeRandomNumbers(){
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static boolean blank_Check(String input){
        if(input=="") return true;

        return false;
    }
    public static boolean redundant_Check(String input) {
        for (int index = 0; index < 2; index++) {
            for (int j = index + 1; j < 3; j++) {
                if (input.charAt(index) == input.charAt(j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean length_check(String input){
        if(input.length()!=3) return false;

        return true;
    }
    public static boolean zeroOrNumber_check(String input){
        if(!input.matches("[1-9]")) return true;
        return false;
    }


}
