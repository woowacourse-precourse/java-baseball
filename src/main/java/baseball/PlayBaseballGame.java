package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = Console.readLine();
        checkUserInput(userInput);
        this.RandomNum = getRandomNum();
        this.UserNum = getUserNum(userInput);
        countStrike();
        countTotal();
        countBall();
        compareNumber();
        endGame(strike);
    }
    public static List<Integer> getRandomNum(){
        List<Integer> RandomNum = new ArrayList<>();
//        RandomNum.add(4);
//        RandomNum.add(5);
//        RandomNum.add(6);
        while(RandomNum.size() < 3){
            int num = Randoms.pickNumberInRange(1,9);
            if (!RandomNum.contains(num)){
                RandomNum.add(num);
            }
        }
        return RandomNum;
    }

    public void checkUserInput(String userInput){
        if (userInput.length() != 3){
            throw new IllegalArgumentException("3자리 숫자를 입력하세요");
        }

        if (userInput.contains("0")){
            throw new IllegalArgumentException("0 이 아닌 ");
        }


        // 각 자리 숫자 비교해서 달라야함 (숫자가 서로 달라야 한다)
    }

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

    public String compareNumber(){
        if (ball != 0 && strike != 0){
            return (ball+"볼 "+strike+"스트라이크");
        }

        if (ball == 0 && strike != 0){
            return (strike+"스트라이크");
        }

        if (ball != 0 && strike == 0){
            return (ball+"볼");
        }

        return ("낫싱");

    }

    public void endGame(Integer strike){

        if (strike == 3){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String answer = Console.readLine();

            if (answer.equals("1")){
                playGame();
            }
            if (answer.equals("2")){
                System.out.println("게임 종료");

            }
            throw new IllegalArgumentException("올바른 숫자가 아닙니다. 1 또는 2를 입력하세요.");

        }
    }
}
