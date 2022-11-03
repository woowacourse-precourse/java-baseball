package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }
    public static List<Integer> convert(String input){
        List<Integer> convertResult = new ArrayList<>();
        for(int i = 0;i<input.length();i++){
            Integer element = Integer.parseInt(input.substring(i,i+1));
            convertResult.add(element);
        }
        return convertResult;
    }


}
