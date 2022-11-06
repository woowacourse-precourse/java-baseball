package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static void printProgramStart(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printGameEnd(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static boolean isAnswerNumberValid(int answerNum){
        int hundred = answerNum / 100;
        int ten = (answerNum % 100) / 10;
        int one = answerNum % 10;

        if(hundred==0 || ten ==0 || one==0)
            return false;

        if(hundred==ten || hundred==one || ten==one)
            return false;

        return true;
    }

    public static int makeAnswerNumber(){
        int answerNum = Randoms.pickNumberInRange(123,987);

        while (!isAnswerNumberValid(answerNum))
            answerNum = Randoms.pickNumberInRange(123,987);

        return answerNum;
    }

    public static boolean isInteger(String inputValue){

        try{
            Integer.parseInt(inputValue);
            return true;
        } catch (IllegalArgumentException e){
            return false;
        }
    }

    public static boolean isInputValid(String inputValue){

        if(!isInteger(inputValue))
            return false;

        int inputNumber = Integer.parseInt(inputValue);

        if(inputNumber < 123 || inputNumber > 987)
            return false;

        if(!isAnswerNumberValid(inputNumber))
            // 랜덤 정답 숫자 유효성과 같은 제한조건을 검사
            return false;
        
        return true;
    }

    public static int tryAnswer(){
        int answerTrialNum;
        System.out.println("숫자를 입력해주세요 : ");
        String answerTrialInput = Console.readLine();

        if(!isInputValid(answerTrialInput))
            throw new IllegalArgumentException("정답 입력값 오류");

        answerTrialNum = Integer.parseInt(answerTrialInput);
        return answerTrialNum;
    }

    public static int countStrike(int answerNum, int hundred, int ten, int one){
        int strikeCnt = 0;

        if(hundred == answerNum/100)
            strikeCnt++;

        if(ten == (answerNum%100)/10)
            strikeCnt++;

        if(one == answerNum%10)
            strikeCnt++;

        return strikeCnt;
    }
}


