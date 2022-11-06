package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }


    private static List<Integer> getRandomValues(int startValueInRange, int endValueInRange, int numberOfValues) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < numberOfValues; i++) {
            result.add(Randoms.pickNumberInRange(1, 9));
        }
        return result;
    }

    private static List<Integer> getValuesThroughConsole(int startValueInRange, int endValueInRange, int numberOfValues) throws NumberFormatException{
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < numberOfValues; i++) {
            int input = Integer.parseInt(Console.readLine());
            if (input < 0 || input > 9) {
                throw new NumberFormatException();
            }
            result.add(input);
        }
        return result;
    }

    private static void printResultOfPlayingGame(ResultOfPlayingGame result){
        if(result.nothing==3){
            System.out.println("낫싱");
            return;
        }
        if(result.ball>0){
            System.out.printf("%d볼 ",result.ball);
        }
        if(result.strike>0){
            System.out.printf("%d스트라이크",result.strike);
        }
        System.out.println();
    }

    // indent 수준이 2 초과되지 않도록 한다.
    // 그러려면 기능을 쪼개어 함수로 만들어야 한다.
    // 하나의 사용자 입력 정수값과 3개의 컴퓨터 입력 정수값을 받아, ball 인지 strike 인지 확인하는 함수를 만든다.
    private static ResultOfPlayingGame getBaseballResult(List<Integer> computerInputs, List<Integer> userInputs){
        ResultOfPlayingGame result=new ResultOfPlayingGame();
        for(int i=0;i<userInputs.size();i++){
            int userInput=userInputs.get(i);
            ResultOfPlayingGameWithOneIntegerValue subResult=playGameWithOneIntegerValue(computerInputs,userInput,i);
            if(subResult==ResultOfPlayingGameWithOneIntegerValue.STRIKE){
                result.strike+=1;
            }else if(subResult==ResultOfPlayingGameWithOneIntegerValue.BALL){
                result.ball+=1;
            }else if(subResult==ResultOfPlayingGameWithOneIntegerValue.NOTHING){
                result.nothing+=1;
            }
        }
        return result;
    }

    private static ResultOfPlayingGameWithOneIntegerValue playGameWithOneIntegerValue(List<Integer> computerInputs, int userInput, int userInputIdx){
        for(int i=0;i<computerInputs.size();i++){
            int computerInput= computerInputs.get(i);
            if (computerInput==userInput&&i==userInputIdx){
                return ResultOfPlayingGameWithOneIntegerValue.STRIKE;
            } else if (computerInput == userInput) {
                return ResultOfPlayingGameWithOneIntegerValue.BALL;
            }
        }
        return ResultOfPlayingGameWithOneIntegerValue.NOTHING;
    }

    enum ResultOfPlayingGameWithOneIntegerValue{
        BALL, STRIKE, NOTHING
    }

    static class ResultOfPlayingGame{
        int strike;
        int ball;
        int nothing;

        ResultOfPlayingGame(){
            strike=0;
            ball=0;
            nothing=0;
        }
        public boolean pass(){
            return strike==3;
        }
    }
}
