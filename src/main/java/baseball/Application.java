package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

class computer {
    List computerNumber(){
        List<Integer> computer = new ArrayList<>();
        while(computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if(!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}

class inputException extends computer {
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
        if(!a.equals("1") || !a.equals("2")) {
            throw new IllegalArgumentException("다시 시작하세요");
        }
    }
}

class playGame extends inputException {
    int nothing(List<String> playerNumber, List<String> computerNumber) {
        int overLapNumber = 0;
        for(String a : playerNumber) {
            if(computerNumber.contains(a)) {
                overLapNumber += 1;
            }
        }
        return overLapNumber;
    }
    
    void ballAndStrike(List<String> playerNumber, List<String> computerNumber) {
        int ball = 0;
        int strike = 0;
        
        for(String a : playerNumber) {
            if(computerNumber.contains(a)) {
                ball += 1;
            }
        }
        
        for(int i=0; i<3; i++) {
            if(playerNumber.get(i).equals(computerNumber.get(i))) {
                strike += 1;
            }
        }
        
        if(strike==0) {
            System.out.println(ball+ "볼");
        }else if(strike == ball) {
            System.out.println(strike+ "스트라이크");
        }else {
            ball -= strike;
            System.out.println(ball+ "볼 "+ strike+ "스트라이크");
        }
    }

    void plaingGame(List<String> playerNumber, List<String> computerNumber) {
        if(this.nothing(playerNumber, computerNumber)==0) {
            System.out.println("낫싱");
        }else {
            this.ballAndStrike(playerNumber, computerNumber);
        }
    }
}

class entireGame extends playGame {
    void fullGame(List<String> computerNumber) {
        while(true) {
            System.out.print("숫자를 입력해주세요 : ");
            String playerNumberString = Console.readLine();
            this.judgeException(playerNumberString);
            
            List<String> playerNumber = Arrays.asList(playerNumberString.split(""));
            
            if(playerNumber.equals(computerNumber)) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                break;
            }

            this.plaingGame(playerNumber, computerNumber);
        }

    }
}

public class Application {
    public static void main(String[] args) {
        
    }
}
