package baseball;

import java.util.List;

public class PrintOutput {
    public void print(List<Integer> countStrBallList) {
        if (countStrBallList.get(0) + countStrBallList.get(1) == 0) {
            System.out.println("낫싱");
        } else if (countStrBallList.get(0) == 3){
            System.out.println(countStrBallList.get(0) + "스트라이크");
        }
        else if (countStrBallList.get(1) == 3) {
            System.out.println(countStrBallList.get(1) + "볼");
        }
        else {
            System.out.println(countStrBallList.get(0) + "볼 " + countStrBallList.get(1) + "스트라이크");
        }
    }
}
