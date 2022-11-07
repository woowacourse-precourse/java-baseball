package baseball;
import java.util.*;
import camp.nextstep.edu.missionutils.*;


public class Application {
    public static void main(String[] args) throws Exception {
        while (true) {
            Scanner sc = new Scanner(System.in);
            BaseballGame Game = new BaseballGame();

            List<String> resultList = new ArrayList<>();
            List<Integer> numberList = new ArrayList<>();
            List<Integer> computerNumberList = Game.makeRandomNumber();

            int number = sc.nextInt();

            if(Game.switchGameStatus(number)) break;
            if(Game.checkErrorNumber(number)) break;

            numberList = Game.splitNumber(number);

            System.out.println(computerNumberList);
            System.out.println(numberList);
        }
    }

}

class BaseballGame {
    //숫자 3개를 임의로 추출 하고 컴퓨터에 해당하는 변수에 할당하는 기능
    List<Integer> makeRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    boolean switchGameStatus(int number){
        if (number == 2) {
            return true;
        } else {
            return false;
        }
    }

    boolean checkErrorNumber(int number){
        try{
            if(number/10>100){
                throw new IllegalArgumentException();
            }
        }catch(IllegalArgumentException e){
            return true;
        }
        return false;
    }

    List<Integer> splitNumber(int number) {
        List<Integer> list = new ArrayList<>();
        while (number > 0) {
            int div = number % 10;
            list.add(div);
            number = number / 10;
        }
        Collections.reverse((list));
        return list;
    }
//
//    void compareList(List<Integer> computerNumberList, List<List<Integer>> userNumberList) {
//        int stikeCount = 0;
//        int ballCount = 0;
//        for (int userIndex = 0; userIndex < userNumberList.size(); userIndex++) {
//            stikeCount += countStike(stikeCount, computerNumberList, userNumberList.get(userIndex));
//            ballCount += countBall(ballCount, computerNumberList, userNumberList.get(userIndex));
//        }
//
//        System.out.println(stikeCount);
//        System.out.println(ballCount);

    }

//
//    int countBall(int ballCount, List<Integer> computerNumberList, List<Integer> userNumberList) {
//        for (int i = 0; i < userNumberList.size(); i++) {
//            if (computerIndex != i && computerNumberList.get(computerIndex) == userNumberList.get(i)) {
//                ballCount++;
//            }
//        }
//
//        return ballCount;
//    }
//
//    int countStike(int stikeCount, List<Integer> computerNumberList, List<Integer> userNumberList) {
//        for (int i = 0; i < userNumberList.size(); i++) {
//            if (computerNumberList.get(i) == userNumberList.get(i)) {
//                stikeCount++;
//            }
//        }
//        return stikeCount;
//    }


