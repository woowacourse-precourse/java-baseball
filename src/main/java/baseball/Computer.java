package baseball;

import java.util.List;

public class Computer {
    List<Integer> computerNumberList;

    void printStarting(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }


    List<Integer> addNumberIfNotList(List<Integer> computerNumberList, int randomNumber){
        if(!computerNumberList.contains(randomNumber)){
            computerNumberList.add(randomNumber);
        }
        return computerNumberList;
    }
}
