package baseball.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static java.lang.Math.*;

public class RandomNumber {
    public static boolean isSet(ArrayList<Integer> numList){
        Set<Integer> numSet = new HashSet<>(numList);
        return (numSet.size() == numList.size());
    }

    public static void main(){
        //1부터 9까지의 난수 생성
        ArrayList<Integer> RandomNumList= new ArrayList();
        for (int i=0; i < 3; i++){
            int ran_num = (int) floor((random() * 10));
        }
    }
}
