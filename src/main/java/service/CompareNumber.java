package service;

import domain.Number;

import java.util.List;
import java.util.Map;

public class CompareNumber {
    private final List<Number> userNumber;
    private final List<Number> computerNumber;

    public CompareNumber(List<Number> userNumber, List<Number> computerNumber) {
        this.userNumber = userNumber;
        this.computerNumber = computerNumber;
    }

    public boolean compare() {
        int strikeCount = 0;
        int ballCount = 0;
        for (int i = 0; i < 3; i++) {
            if (this.userNumber.get(i).equals(this.computerNumber.get(i))) {
                strikeCount++;
            } else if (userNumber.contains(computerNumber.get(i))) {
                ballCount++;
            }
        }
        if (strikeCount != 0 && ballCount != 0) {
            System.out.println(ballCount + "볼" + " " + strikeCount + "스트라이크");
        } else if (strikeCount != 0) {
            if(strikeCount == 3){
                System.out.println(strikeCount + "스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                return true;
            }
            System.out.println(strikeCount + "스트라이크");
        } else if (ballCount != 0) {
            System.out.println(ballCount + "볼");
        } else if(strikeCount == 0 && ballCount == 0){
            System.out.println("낫싱");
        }
        return false;
    }
}
