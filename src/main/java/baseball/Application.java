package baseball;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {
    private static String makeRandomNumbers(){
        StringBuilder result = new StringBuilder();
        for(int i=0;i<3;i++){
            int iValue = (int)(Math.random() * 10);
            result.append(iValue);
        }
        return result.toString();
    }
    private static ArrayList<String> splitInputToArray(String input){
        ArrayList<String> result= new ArrayList<>();
        for(int i=0;i<input.length();i++){
            result.add(String.valueOf(input.charAt(i)));
        }
        return result;
    }
    public static String playBall(ArrayList<String> answer, String input){
        int strike = 0, ballHit = 0;
        System.out.println(answer);
        System.out.println(input);
        for(int i = 0;i<answer.size();i++){
            if(input.indexOf(answer.get(i)) == i){
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

    public static void main(String[] args) {
        Scanner inputObject = new Scanner(System.in);

        System.out.println("숫자 야구 게임을 시작합니다.");
        String answer = makeRandomNumbers();
        System.out.println(answer);

        String result = "";
        while(!result.equals("3스트라이크")){
            System.out.print("숫자를 입력해주세요 : ");
            String number = inputObject.nextLine();
            result = playBall(splitInputToArray(answer), number);
            System.out.println(playBall(splitInputToArray(answer), number));
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
