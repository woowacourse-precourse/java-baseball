package baseball.domain;

import java.util.ArrayList;

import static java.lang.Math.*;

public class RandomNumber {
    public static void main(){
        //1부터 9까지의 난수 생성
        ArrayList<Integer> RandomNumList= new ArrayList();
        for (int i=0; i < 5; i++){
            int ran_num = (int) floor((random() * 10));
        }
    }
}
