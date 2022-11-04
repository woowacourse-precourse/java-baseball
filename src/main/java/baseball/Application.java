package baseball;
import camp.nextstep.edu.missionutils.*;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다");

        while(true){
            List<Integer> computerNum=generateComputerNum();


        }
    }

    public static List<Integer> generateComputerNum(){
        List<Integer> computerNum=new ArrayList<>();
        while(computerNum.size()<3){
            int random=Randoms.pickNumberInRange(1,9);
            computerNum.add(random);
        }
        return computerNum;
    }



}
