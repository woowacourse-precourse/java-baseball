package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    private void printStartStatement(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private static List<Integer> getRandomIntegers(int startValueInRange, int endValueInRange, int numberOfValues) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < numberOfValues; i++) {
            result.add(Randoms.pickNumberInRange(1, 9));
        }
        return result;
    }

    private static List<Integer> getIntegersThroughConsole(int startValueInRange, int endValueInRange, int numberOfValues) throws NumberFormatException{
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < numberOfValues; i++) {
            int input = Integer.parseInt(Console.readLine());
            if (input < startValueInRange || input > endValueInRange) {
                throw new NumberFormatException();
            }
            result.add(input);
        }
        return result;
    }

    private static boolean askIfUserPlayGameAgain()throws NumberFormatException{
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int userInput=Integer.parseInt(Console.readLine());
        if(userInput==1) {
            return true;
        }else if(userInput==2){
            return false;
        }else{
            throw new IllegalArgumentException();
        }
    }
    private static void printScore(Score result){
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
    private static Score calculateScore(List<Integer> computerInputs, List<Integer> userInputs){
        Score result=new Score();
        for(int i=0;i<userInputs.size();i++){
            int userInput=userInputs.get(i);
            ScoreCategory subResult= calculateScoreWithOneInteger(computerInputs,userInput,i);
            if(subResult== ScoreCategory.STRIKE){
                result.strike+=1;
            }else if(subResult== ScoreCategory.BALL){
                result.ball+=1;
            }else if(subResult== ScoreCategory.NOTHING){
                result.nothing+=1;
            }
        }
        return result;
    }

    private static ScoreCategory calculateScoreWithOneInteger(List<Integer> computerInputs, int userInput, int userInputIdx){
        for(int i=0;i<computerInputs.size();i++){
            int computerInput= computerInputs.get(i);
            if (computerInput==userInput&&i==userInputIdx){
                return ScoreCategory.STRIKE;
            } else if (computerInput == userInput) {
                return ScoreCategory.BALL;
            }
        }
        return ScoreCategory.NOTHING;
    }

    enum ScoreCategory {
        BALL, STRIKE, NOTHING
    }

    static class Score {
        int strike=0;
        int ball=0;
        int nothing=0;

        public boolean pass(){
            return strike==3;
        }
    }
}
