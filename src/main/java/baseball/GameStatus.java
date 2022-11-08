package baseball;

import java.util.List;

public class GameStatus {
    Boolean nothing = true;

    Integer ball = 0;

    Integer strike = 0;

    public void saveNumberStatus(int[] inputNumbers, List<Integer> computer){
        for(int i = 0 ; i < inputNumbers.length; i++){
            if( computer.contains( inputNumbers[i] ) ){ //해당 숫자가 정답에 없다.
                this.nothing = false;
            }
        }

        if(!this.nothing){
            for(int i = 0 ; i < inputNumbers.length; i++){
                if(i == computer.indexOf(inputNumbers[i])){ //스트라이크인 경우
                    this.strike++;
                } else if (computer.contains(inputNumbers[i])) {
                    this.ball++; //볼인 경우
                }
            }
        }

    }
}
