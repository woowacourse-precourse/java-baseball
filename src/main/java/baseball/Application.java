package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;

public class Application {
    private static List<Integer> targetNum = new ArrayList<>();
    private static int strike =0;
    public static int ball =0;

    public static void main(String[] args) {

        startMessage();
        createRandomTargetNum();
        getUserInput();
        if(!endGame()){
            main(args);
        }
    }

    private static void startMessage() {
        System.out.println("숫자야구 게임을 시작합니다.");
    }

    private static void createRandomTargetNum() {
        while (targetNum.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!targetNum.contains(randomNumber)) {
                targetNum.add(randomNumber);
            }
        }
    }

    private static void getUserInput()  {
        while(strike!=3){
            System.out.println("숫자를 입력해주세요 : ");
            String input = Console.readLine();
            List<String> inputNum = List.of(input.split(""));
            inputValidate(inputNum);
            getResult(inputNum);
            printResult();

        }
    }

    private static void printResult() {
        if(ball==0 && strike==0){
            System.out.println("낫싱");
        }else{
            System.out.println(ball+"볼 "+strike+"스트라이크");
        }
    }

    private static void getResult(List<String> inputNum) {
        strike = 0;
        ball = 0;
        for(int i=0; i<inputNum.size();i++){
            int toIntNum= Integer.parseInt(inputNum.get(i));
            if(targetNum.contains(toIntNum)){
                ball+=1;
            }
            if(targetNum.get(i) == toIntNum){
                strike +=1;
                ball-=1;
            }
        }
    }

    private static void inputValidate(List<String> inputNum) {
        if(inputNum.size() != 3){
            throw new IllegalArgumentException();
        }
        if(Set.copyOf(inputNum).size()!=3){
            throw new IllegalArgumentException();
        }
        if(inputNum.contains("0")){
            throw new IllegalArgumentException();
        }
    }

    private static boolean endGame() {
        endMessage();
        int option = Integer.parseInt(Console.readLine());
        optionValidate(option);

        if(option==1){
            init();
            return false;
        }
        return true;
    }

    private static void endMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    private static void init() {
        targetNum.clear();
        strike=0;
        ball=0;
    }

    private static void optionValidate(int option) {
        if(option !=1 && option !=2){
            throw new IllegalArgumentException();
        }
    }

}
