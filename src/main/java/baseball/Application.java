package baseball;
import java.util.*;
import camp.nextstep.edu.missionutils.*;


public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BaseballGame Game = new BaseballGame();
        List<Integer> computerNumberList = Game.makeRandomNumber();
        System.out.println(computerNumberList);
        System.out.println("-----------------");
        while (true) {

            List<Integer> resultList = new ArrayList<>();
            List<Integer> userNumberList = new ArrayList<>();

            int number = sc.nextInt();
            resultList.add(number);

            if(Game.switchGameStatus(number)) break;
            if(Game.checkErrorNumber(number)) break;

            userNumberList = Game.splitNumber(number);

            System.out.println(userNumberList);

            List<Integer> checkList =Game.compareList(computerNumberList,userNumberList);
            Game.printResult(checkList);

        }
    }

}

class BaseballGame {

    void GameStart();
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

    List<Integer> compareList(List<Integer> computerNumberList, List<Integer> userNumberList) {
        int strikeCount = 0;
        int ballCount = 0;

        List<Integer> checkList = new ArrayList<>();

        strikeCount += countStrike(strikeCount, computerNumberList, userNumberList);

        for (int computerIdx = 0; computerIdx<computerNumberList.size(); computerIdx++) {
            ballCount += countBall(computerIdx,ballCount, computerNumberList, userNumberList);
        }

        checkList.add(strikeCount);
        checkList.add(ballCount);

        return checkList;
    }


    int countStrike(int strikeCount, List<Integer> computerNumberList, List<Integer>userNumberList){
        int idx = 0;
        while(idx<computerNumberList.size()){
            if(computerNumberList.get(idx) == userNumberList.get(idx)){
                strikeCount++;
            }
            idx++;
        }
        return strikeCount;
    }

    int countBall(int computerIdx,int ballCount,List<Integer> computerNumberList,List<Integer>userNumberList){
        for(int userIdx = 0; userIdx<userNumberList.size();userIdx++){
            if(computerIdx != userIdx && computerNumberList.get(computerIdx) == userNumberList.get(userIdx)){
                ballCount++;
            }
        }
        return ballCount;
    }

    void printResult(List<Integer>checkList){
        System.out.printf("%d볼 %d스트라이크",checkList.get(0),checkList.get(1));
    }
}


