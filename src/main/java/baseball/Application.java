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
}


