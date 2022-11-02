package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Integer> computer=GetNumberBaseball();

        // TODO: 프로그램 구현
    }
    public static List<Integer> GetNumberBaseball(){

        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            CheckDuplicate(randomNumber,computer);
        }
        return computer;
    }
    public static void CheckDuplicate(int randomNumber,List<Integer> computer){
        if(!computer.contains(randomNumber)){
            computer.add(randomNumber);
        }
    }
}

