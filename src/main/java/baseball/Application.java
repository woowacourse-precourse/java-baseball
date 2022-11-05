package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static List<Integer> generateRandNum(){
        List<Integer> nums = new ArrayList<>();
        while(nums.size() < 3){
            int randNum = Randoms.pickNumberInRange(1, 9);
            if(!nums.contains(randNum)){
                nums.add(randNum);
            }
        }
        return nums;
    }

    public static List<Integer> parseString(String s){
        List<Integer> user = new ArrayList<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            user.add(c-'0');
        }
        return user;
    }

    public static void game(){
        List<Integer> computer = generateRandNum();
        while(true){
            String input = Console.readLine();
            List<Integer> user = parseString(input);
        }
    }


    public static void main(String[] args) {
        // TODO: 프로그램 구현

        while(true){
            game();
        }


    }
}
