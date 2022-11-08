package baseball;

import java.util.*;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
public class Application {
    static boolean isPlaying = true;

    // 1. 랜덤 넘버 생성기.(input void, output List<Integer>)
    public static ArrayList<Integer> computerNumberMaker(){
        ArrayList<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    // 2. input들어온 수가 조건에 맞는가? (input String, output boolean)
    public static boolean isValidNumber(String inputNumberString){
        List<String> tempList = Arrays.asList(inputNumberString.split(""));
        Set<String> tempSet = new HashSet<>(tempList);

        try{
            Exception e = new IllegalArgumentException();
            if (!isDigit(inputNumberString)){
                throw e;
            }
            else if (inputNumberString.contains("0")) {
                throw e;
            }
            else if (inputNumberString.length() != 3) {
                throw e;
            }
            else if (tempSet.size() != inputNumberString.length()){
                throw e;
            }
            else {
                return true;
            }
        }
        catch (Exception e){
            throw new IllegalArgumentException(e);
        }
    }

    // +new 2-1. 들어온 수가 모두 정수인가?
    public static boolean isDigit (String inputNumberString){
        for (int i = 0; i < 3; i++) {
            if(inputNumberString.charAt(i) >= '9' || inputNumberString.charAt(i) <= '0')
                return false;
        }
        return true;
    }


    // 3. input들어온 수를 List로 (input int, output List<Integer>)
    public static ArrayList<Integer> inputNumberMaker(int inputNumber){
        ArrayList<Integer> user = new ArrayList<>();
        for(int i = 2; i >= 0; i --){
            user.add((int)(inputNumber / Math.pow(10,i)));
            inputNumber = (int)(inputNumber % Math.pow(10,i));
        }
        return user;
    }

    // 4-1. 스트라이크의 개수 (input List<Integer> usernumber, List<Integer> computernumber, output int)
    public static int strikeNumber(ArrayList<Integer> inputNumberList, ArrayList<Integer> computerNumber){
        int strike = 0;
        for(int i = 0; i < 3; i ++){
            if (inputNumberList.get(i).equals(computerNumber.get(i)))
                strike ++;
        }
        return strike;
    }

    // 4-2. 볼의 개수 (input List<Integer> usernumber, List<Integer> computernumber, output int)
    public static int ballNumber(ArrayList<Integer> inputNumberList, ArrayList<Integer> computerNumber){
        int ball = 0;
        for(int i = 0; i < 3; i ++){
            if (computerNumber.contains(inputNumberList.get(i)) && !inputNumberList.get(i).equals(computerNumber.get(i)))
                ball ++;
        }
        return ball;
    }

    // 5. 매회 player 가 input을 넣을때마다 출력해야 할 것들 만들어줄 함수 (input int strikenum, int ballnum, output String)
    public static String answerPrinter(int strikeNumber, int ballNumber){
        if (strikeNumber == 3){
            isPlaying = false;
            return "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
        }
        else if(strikeNumber == 0 && ballNumber == 0){
            return "낫싱";
        }
        else if (strikeNumber != 0 && ballNumber != 0) {
            return ballNumber + "볼 " + strikeNumber + "스트라이크";
        }
        else if (ballNumber != 0) {
            return  ballNumber + "볼";
        }
        else
            return strikeNumber + "스트라이크";
    }

    // +new 6. 정답을 맞추었을때 다시 isPlaying을 1로 만들어 주는 함수.
    public static void reStarter(int playerChoice){
        if(playerChoice == 1)
            isPlaying = true;
    }

    // 7. main 함수 꾸미기
    public static void main(String[] args) {
        ArrayList<Integer> computerNumber = computerNumberMaker();
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (isPlaying){
            System.out.print("숫자를 입력해주세요 : ");
            String tempStringInput = Console.readLine();
            if(!isValidNumber(tempStringInput))
                return;
            int inputRaw = Integer.parseInt(tempStringInput);
            ArrayList<Integer>playerInputList = inputNumberMaker(inputRaw);
            System.out.println(answerPrinter(strikeNumber(playerInputList,computerNumber),ballNumber(playerInputList,computerNumber)));
            if(!isPlaying){
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                int choice = Integer.parseInt(Console.readLine());
                reStarter(choice);
                computerNumber = computerNumberMaker();
            }
        }
    }
}