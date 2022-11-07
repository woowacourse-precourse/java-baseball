package baseball;

import java.util.List;

public class StrikeBallCount {
    public static int strikeBall(List<Integer> computer, List<Integer> user){
        int strike, ball;
        strike = strikeCount(computer, user);
        ball = ballCount(computer, user);

        if(ball>0){
            System.out.print(ball + "볼");
        }
        if(strike >0){
            if(ball>0){
                System.out.print(" ");
            }
            System.out.print(strike + "스트라이크");
        }
        if(strike==0 && ball ==0){
            System.out.print("낫싱");
        }
        System.out.println();

        return strike;
    }

    public static int strikeCount(List<Integer> computer, List<Integer> user){
        int count =0;
        for(int i=0; i<3; i++){
            if(computer.get(i) == user.get(i)){
                count++;
            }
        }
        return count;
    }

    public static int ballCount(List<Integer> computer, List<Integer> user){
        int count =0;
        for(int i=0; i<3; i++){
            if(computer.get(i) != user.get(i) && computer.contains(user.get(i))){
                count++;
            }
        }
        return count;
    }
}
