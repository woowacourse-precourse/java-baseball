package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        int ball = 0;
        int strike = 0;
        List<Integer> opponent = generateOpponent();
        List<Integer> player = receiveInputOfPlayer();

        checkGameOver(checkOpponentAndPlayer(opponent, player));
    }

    public static List<Integer> generateOpponent(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static List<Integer> receiveInputOfPlayer(){
        System.out.print("숫자를 입력해주세요 : ");
        String inputString = Console.readLine();
        checkLengthOfString(inputString);
        List<Integer> integerList = changeStringToIntegerList(inputString);
        checkDuplicationFromIntegerList(integerList);
        return integerList;
    }

    public static void checkLengthOfString(String checkString){
        if(checkString.length() != 3){
            throw new IllegalArgumentException("3자리의 입력값이 아닙니다.\n프로그램을 종료합니다.");
        }
    }

    public static void checkDuplicationFromIntegerList(List<Integer> checkList){
        List<Integer> newList = new ArrayList<>();
        for (Integer number : checkList) {
            if (!newList.contains(number)) {
                newList.add(number);
            }
        }
        if(!checkList.equals(newList)){
            throw new IllegalArgumentException("중복된 숫자가 입력되었습니다.\n프로그램을 종료합니다.");
        }
    }

    public static List<Integer> changeStringToIntegerList(String numberString){
        try {
            List<Integer> integerList = Arrays.stream(numberString.split("")).map(Integer::parseInt).collect(Collectors.toList());
            return integerList;
        }catch(IllegalArgumentException e){
            throw new IllegalArgumentException("숫자가 아닌 값이 입력되었습니다.\n프로그램을 종료합니다.");
        }
    }

    public static List<Integer> checkOpponentAndPlayer(List<Integer> opponent,List<Integer> player){
        List<Integer> ballAndStrike = new ArrayList<>(
                Arrays.asList(0,0)
        );
        for (int opponentNum = 0; opponentNum < opponent.size(); opponentNum++) {
            for (int playerNum = 0; playerNum < player.size(); playerNum++) {
                checkBallAndStrike(ballAndStrike,opponent,player,opponentNum,playerNum);
            }
        }
        return ballAndStrike;
    }

    public static List<Integer> checkBallAndStrike(List<Integer> ballAndStrike,List<Integer> opponent, List<Integer> player, int opponentNum, int playerNum){
        if(opponent.get(opponentNum)==player.get(playerNum)){
            if(opponentNum!=playerNum){
                ballAndStrike.set(0,ballAndStrike.get(0)+1);
            }else{
                ballAndStrike.set(1,ballAndStrike.get(1)+1);
            }
        }
        return ballAndStrike;
    }

    public static boolean checkGameOver(List<Integer> ballAndStrike){
        printBallAndStrike(ballAndStrike);
        if(ballAndStrike.get(1)==3){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }

    public static void printBallAndStrike(List<Integer> ballAndStrike){
        int ball = ballAndStrike.get(0);
        int strike = ballAndStrike.get(1);

        if(ball == 0 && strike == 0){
            System.out.println("낫싱");
        }
        if(ball != 0 && strike == 0){
            System.out.println(ball+"볼");
        }
        if(ball == 0 && strike != 0){
            System.out.println(strike+"스트라이크");
        }
        if(ball != 0 && strike != 0){
            System.out.println(ball+"볼 "+strike+"스트라이크");
        }
    }
}

