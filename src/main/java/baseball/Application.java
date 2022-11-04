package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static int random_num(){
        List<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        while(list.size()<3){
            int random = Randoms.pickNumberInRange(1,9);
            if(!list.contains(random)){
                list.add(random);
                sb.append(random);
            }
        }
        int answer = Integer.parseInt(String.valueOf(sb));
        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {

    }
}
