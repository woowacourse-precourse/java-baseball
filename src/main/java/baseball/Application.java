package baseball;

import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static int checkForSameNumbers(int[] numberArray, int i){
        int result = i;
        for(int j = 0; j < i; j++){
            if(numberArray[result] == numberArray[j]){
                result--;
            }
        }
        return result;
    }
    public static String makeRandomNumbers(){
        StringBuilder result = new StringBuilder();
        int[] numberArray = new int[3];

        for(int i = 0;i < 3;i++){
            numberArray[i] = Randoms.pickNumberInRange(1, 9);
            i = checkForSameNumbers(numberArray, i);
        }

        for(int number: numberArray){
            result.append(number);
        }
        return result.toString();
    }
    public static ArrayList<String> splitInputToArray(String input){
        ArrayList<String> result= new ArrayList<>();
        for(int i=0;i<input.length();i++){
            result.add(String.valueOf(input.charAt(i)));
        }
        return result;
    }
    public static String playBall(ArrayList<String> answer, ArrayList<String> input){
        int strike = 0, ballHit = 0;
        for(int i = 0; i<answer.size();i++){
            if(answer.get(i).equals(input.get(i))){
                strike += 1;
                continue;
            }
            if(input.contains(answer.get(i))){
                ballHit += 1;
            }
        }

        String result = "";
        if(strike == 0 && ballHit == 0){
            result += "낫싱";
        }
        else if(strike == 0){
            result += ballHit + "볼";
        } else if(ballHit == 0){
            result += strike + "스트라이크";
        } else{
            result += ballHit + "볼 " + strike + "스트라이크";
        }

        return result;
    }

    public static void playGame(){
        String answer = makeRandomNumbers();
        String result = "";

        while(!result.equals("3스트라이크")){
            System.out.print("숫자를 입력해주세요 : ");
            String number = Console.readLine();
            if(number.length() > 3){
                throw new IllegalArgumentException();
            }
            result = playBall(splitInputToArray(answer), splitInputToArray(number));
            System.out.println(playBall(splitInputToArray(answer), splitInputToArray(number)));
        }
    }
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        int continueGame = 0;
        while(continueGame == 0){
            playGame();
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int newNumber = Integer.parseInt(Console.readLine());
            if(newNumber == 2){
                continueGame = 1;
            }
        }
    }
}
