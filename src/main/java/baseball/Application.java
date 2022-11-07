package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

class computer {
    int computerNumber(){
        ArrayList<Integer> computer = new ArrayList<>();
        while(computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if(!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        int number = computer.get(0)*100 + computer.get(1)*10 + computer.get(2);
        return number;
    }
}

class inputException {
    void judgeNotNumber(String a) {
        try {
            Integer.parseInt(a);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력하세요");
        }
    }
    
    void judgeIncludeZero(String a) {
        if (a.contains("0")) {
            throw new IllegalArgumentException("1부터 9까지의 숫자를 입력하세요");
        }
    }

    void judgeRange(String a) throws IllegalArgumentException {
        int i = Integer.parseInt(a);
        if (i<100 || i >999) {
            throw new IllegalArgumentException("세 개의 숫자를 입력하세요");
        }
    }

    void judgeDifferentNumber(String a) {
        int i = Integer.parseInt(a);
        int firstNumber = i/100;
        int secondNumber =  (i - 100*firstNumber)/10;
        int lastNumber = i - 100*firstNumber - 10*secondNumber;
        if (firstNumber == secondNumber || secondNumber == lastNumber || lastNumber == firstNumber) {
            throw new IllegalArgumentException("서로 다른 숫자를 입력하세요");   
        }
    }

    void judgeException(String a) {
        this.judgeNotNumber(a);
        this.judgeIncludeZero(a);
        this.judgeRange(a);
        this.judgeDifferentNumber(a);
    }

    void restartJudgeException(String a) {
        this.judgeNotNumber(a);
        int i = Integer.parseInt(a);
        if(i!=1 || i!=2) {
            throw new IllegalArgumentException("다시 시작하세요");
        }
    }
}

public class Application {
    public static void main(String[] args) {
    
    }
}
