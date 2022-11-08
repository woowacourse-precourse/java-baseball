package baseball;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class PlayBaseballGame {
     Integer total;
     Integer strike;
     Integer ball;
     List<Integer> RandomNum;
     List<Integer> UserNum;

    public void playGame(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        System.out.print("숫자를 입력해주세요 :");
        String userInput = Console.readLine();
        this.UserNum = getUserNum(userInput);
        countStrike();
        countTotal();
        countBall();
        compareNumber();
        endGame(strike);
    }
    public void RandomNum(){
        while(RandomNum.size() < 3){
            int num = Randoms.pickNumberInRange(1,9);
            if (!RandomNum.contains(num)){
                RandomNum.add(num);
            }
        }
    }

//    public void checkUserInput(String userInput){
//        if (userInput.length() != 3){
//            new throw IllegalArgumentException();
//        }
//
//        for (int i = 0; i < userInput.length(); i++){
//            if(userInput.charAt(i) == 0){
//                new throw IllegalArgumentException();
//            }
//        }
//
//        // 각 자리 숫자 비교해서 달라야함
//    }

    public void countTotal(){
        this.total = 0;
        for (int i = 0; i < RandomNum.size(); i++){
            if (RandomNum.contains(UserNum.get(i))){
                total++;
            }
        }
    }

    public void countStrike(){
        this.strike = 0;
        for (int i = 0; i < RandomNum.size(); i++){
            if (UserNum.get(i) == RandomNum.get(i)){
                strike++;
            }
        }
    }

    public void countBall(){
        this.ball = 0;
        ball = total - strike;
    }


    public static List<Integer> getUserNum(String userInput){
        List<Integer> userNum = new ArrayList<>();
        for (int i = 0; i < userInput.length(); i++){
            userNum.add(Character.getNumericValue(userInput.charAt(i)));
        }

        return userNum;
    }

    public void compareNumber(){
        if (ball != 0 && strike != 0){
            System.out.println(ball+"볼 "+strike+"스트라이크");
        }

        if (ball == 0 && strike != 0){
            System.out.println(strike+"스트라이크");
        }

        if (ball == 0 && strike == 0){
            System.out.println("낫싱");
        }
    }

    public void endGame(Integer strike){
        if (strike == 3){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String answer = Console.readLine();

            // 재시작
            if (answer.equals("1")){
            }
            // 종료
            if (answer.equals("2")){
            }
            throw new IllegalArgumentException("올바른 숫자가 아닙니다. 1 또는 2를 입력하세요.");
        }
    }
}
