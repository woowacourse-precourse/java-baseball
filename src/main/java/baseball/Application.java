package baseball;

import java.util.ArrayList;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int randomNumber = ready();
        int inputNumber = set();
        start(randomNumber, inputNumber);
        int continueCheck = Answer.retry();//재시작 여부

        while (continueCheck ==1){
            randomNumber = ready();
            inputNumber = set();
            start(randomNumber, inputNumber);
            continueCheck = Answer.retry();
            if(continueCheck==2){
                break;
            }
        }
        //System.out.println("게임이 완전히 종료되었습니다.");
    }

    private static int start(int randomNumber, int inputNumber) {
        int strike = 0;
        while (strike != 3){
            ArrayList<Integer> result = Game.getScore(randomNumber, inputNumber);
            getScoreMessage(result);
            strike = result.get(1);
            if(strike==3){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
            inputNumber = keepGoing();
        }
        return strike;
    }

    private static int keepGoing() {
        System.out.print("숫자를 입력해주세요 : ");
        int inputNumber = Number.rangeCheck(); //입력한 숫자 예외 확인
        return inputNumber;
    }

    private static void getScoreMessage(ArrayList<Integer> result) {
        if(result.get(0)!=0 && result.get(1)==0){
            System.out.println(result.get(0) + "볼");
        }
        if(result.get(0)!=0 && result.get(1)!=0){
            System.out.println(result.get(0) + "볼 "+result.get(1)+"스트라이크");
        }
        if(result.get(0)==0 && result.get(1)!=0){
            System.out.println(result.get(1) + "스트라이크");
        }
        if(result.get(0)==0 && result.get(1)==0){
            System.out.println("낫싱");
        }
    }

    private static int ready() {
        int randomNumber = GameSetting.getRandomNumber();
        System.out.println(randomNumber);
        System.out.println("숫자 야구 게임을 시작합니다.");
        return randomNumber;
    }

    private static int set(){
        System.out.print("숫자를 입력해주세요 : ");
        int inputNumber = Number.rangeCheck(); //입력한 숫자 예외 확인
        return inputNumber;
    }

}
