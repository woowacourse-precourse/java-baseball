package baseball.data;

import java.util.List;

/**
 * 플레이어와 컴퓨터의 숫자를 비교해서 볼과 스트라이크를 판단.
 */
public class NumberReferee {

    public int checkStrike(List<Integer> player, List<Integer> computer){
        int strike = 0;

        for(int number = 0; number < player.size(); number ++ ){
            if(player.get(number).equals(computer.get(number))){
                strike++;
            }
        }
        return strike;
    }

    public int checkBall(List<Integer> player, List<Integer> computer){
        int strike = checkStrike(player, computer);
        int ball = 0;

        for(Integer number : player){
            if(computer.contains(number)){
                ball++;
            }
        }
        return (ball - strike);
    }
}
