package baseball;

import java.util.List;

public class Count {
    int counter(List<Integer> computer, List<Integer> user){
        int strike = 0;
        int ball = 0;
        int out = 0;

        if (computer.get(0) == user.get(0)){
            strike += 1;
        } else if (computer.get(1) == user.get(0) || computer.get(2) == user.get(0)){
            ball += 1;
        } else {
            out += 1;
        }

        if (computer.get(1) == user.get(1)){
            strike += 1;
        } else if (computer.get(0) == user.get(1) || computer.get(2) == user.get(1)){
            ball += 1;
        } else {
            out += 1;
        }

        if (computer.get(2) == user.get(2)){
            strike += 1;
        } else if (computer.get(0) == user.get(2) || computer.get(1) == user.get(2)){
            ball += 1;
        } else {
            out += 1;
        }

        if (out == 3){
            System.out.println("낫싱");
        } else if(strike == 3){
            System.out.println("3스트라이크");
            return 1;
        } else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
        return 0;
    }
}
