package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumUtil {
    public static List<Integer> generateRandomNum(){
        List<Integer> ComputerNum = new ArrayList<>();
        while(ComputerNum.size() < 3){
            Random random = new Random();
            int randomNum = random.nextInt(9) + 1;

            if(ComputerNum.contains(randomNum)){
                continue;
            }else {
                ComputerNum.add(randomNum);
            }
        }
        return ComputerNum;
    }
}
