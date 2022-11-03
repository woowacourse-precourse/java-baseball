package baseball.component;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballGameController {



    private List<Integer> readPlayerNumbers(){
        System.out.print("숫자를 입력해주세요 : ");
        String playerInputString = Console.readLine();

        List<Integer> playerNumbers = new ArrayList<>();
        for(int index = 0; index < playerInputString.length(); index++){
            int number = Character.getNumericValue(playerInputString.charAt(index));
            playerNumbers.add(number);
        }

        return playerNumbers;
    }

    private void printBallStrikeCountScore(List<Integer> score){

        int ballCount = score.get(0);
        int strikeCount = score.get(1);

        if(ballCount==0 && strikeCount==0){
            System.out.println("낫싱");
            return;
        }

        StringBuilder stringBuilder = new StringBuilder();
        if(ballCount != 0) {
            stringBuilder.append(ballCount);
            stringBuilder.append("볼 ");
        }
        if(strikeCount != 0) {
            stringBuilder.append(strikeCount);
            stringBuilder.append("스트라이크 ");
        }
        stringBuilder.delete(stringBuilder.length()-1, stringBuilder.length());

        System.out.println(stringBuilder.toString());
    }

    private boolean canPlayNextGame(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String nextGamePlayerInput = Console.readLine();

        if(nextGamePlayerInput.equals("1")){
            return true;
        }
        return false;
    }

    private List<Integer> generateThreeRandomNumbers(){
        List<Integer> randomNumbers = new ArrayList<>();
        while(randomNumbers.size() < 3){
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
        return randomNumbers;
    }
}
