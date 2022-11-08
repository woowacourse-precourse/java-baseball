package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static List<Integer> getRandomVal(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
    public static List<Integer> getRtn(List<Integer> computer, String tmp){
        int strike = 0;
        int ball = 0;


        if(tmp.length() != 3) {
            throw new IllegalArgumentException();
        }

        for(int i = 0; i < tmp.length(); i++){
            int cur = (int)(tmp.charAt(i) - '0');
            if(computer.get(i) == cur){
                strike++;
                continue;
            }else if(computer.contains(cur)){
                ball++;
                continue;
            }
        }
        List<Integer> res = new ArrayList<>();
        res.add(strike);
        res.add(ball);
        return res;
    }

    public static void main(String[] args) throws Exception {

    }
}
