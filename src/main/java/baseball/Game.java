package baseball;

import java.util.List;

public class Game {


    public void startGame(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void inputNumber(){
        System.out.println("숫자를 입력해주세요 :");
    }

    public void EndGame(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public int toStrike(List<Integer> toList, List<Integer> computer){

        int strikenum = 0;
        for(int i = 0; i < toList.size(); i++ ){
            if(computer.contains(toList.get(i))){
                strikenum++;
            }

        }
        return strikenum;
    }
}
