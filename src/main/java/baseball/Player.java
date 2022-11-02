package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Player extends Result {
    List<Integer> balls;
    Player(){
        balls = new ArrayList<>();
        while (balls.size() < DIGIT) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!balls.contains(randomNumber))
                balls.add(randomNumber);
        }
        System.out.println(balls);
    }
    Player(String input){
        if(input.length() != DIGIT)
            throw new IllegalArgumentException("[Input] 입력의 길이는 "+DIGIT+"만 가능");
        balls = new ArrayList<>();
        for (int i = 0; i < DIGIT; i++) {
            int userNumber = input.charAt(i) - '0';
            if (balls.contains(userNumber))
                throw new IllegalArgumentException("[Input] 서로 다른 숫자만 입력 가능");
            else if (!(1<=userNumber&&userNumber<=9))
                throw new IllegalArgumentException("[Input] 1~9 사이 숫자만 입력 가능");
            balls.add(userNumber);
        }
    }
    public int printCompareTo(Player pitcher){
        int nStrike = 0;
        int nBall = 0;

        for(int i = 0; i < this.balls.size(); i++){
            if(Objects.equals(this.balls.get(i), pitcher.balls.get(i)))
                nStrike++;
            else if(this.balls.contains(pitcher.balls.get(i)))
                nBall++;
        }

        return printResult(nStrike, nBall);
    }
}