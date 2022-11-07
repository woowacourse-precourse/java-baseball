package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    List<Integer> value;

    Computer(){
        this.value=new ArrayList<>();
        while(this.value.size()<3){
            int randomNumber= Randoms.pickNumberInRange(1,9);
            if(!this.value.contains(randomNumber)){
                this.value.add(randomNumber);
            }
        }

    }
}
