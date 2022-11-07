package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    static List<Integer> answer = new ArrayList<>();    // 컴퓨터에서 랜덤으로 정해진 정답 숫자
    static List<Integer> current = new ArrayList<>();   // 사용자가 입력한 값

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while(true){
            generateAnswer();
            while(true){
                System.out.print("숫자를 입력해주세요: ");
                checkValidInput(Console.readLine());
                boolean result = checkResult();
                if(result){
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
            }
            boolean exit = checkExitGame();
            if(exit) break;
        }
    }

    public static void generateAnswer(){
        while(true){
            if(answer.size() == 3) break;
            int randomInt = Randoms.pickNumberInRange(1, 9);
            if(!answer.contains(randomInt)) answer.add(randomInt);
        }
    }

    public static void checkValidInput(String input){
        System.out.println();
        checkCorrectLength(input);  // input 길이가 3인지 확인
        checkNumber(input); // input 전부 숫자인지 확인
        checkUniqueNumber();    // input 각 숫자가 서로 다른지 확인
    }

    public static boolean checkResult(){
        int strike = checkStrike();
        int ball = checkBall(strike);
        printResult(ball, strike);
        return strike == 3; // strike=3 이면 모든 숫자를 다 맞췄으므로 종료, 아니라면 계속 진행
    }

    public static boolean checkExitGame(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        try{
            int userChoice = Integer.parseInt(input);
            if(userChoice == 1) return false;  // 1을 입력하면 재시작
            if(userChoice == 2) return true; // 2를 입력하면 게임 종료
        }catch(NumberFormatException nfe) {throw new IllegalArgumentException();}
        return false;
    }

    public static void checkNumber(String input){
        try{
            for(int i=0; i<input.length(); i++){
                int value = Integer.parseInt(input.substring(i, i+1));
                current.add(value);
            }
        }catch(NumberFormatException nfe){throw new IllegalArgumentException();}
    }

    public static void checkCorrectLength(String input){
        if(input.length() != 3){
            throw new IllegalArgumentException();
        }
    }

    public static void checkUniqueNumber(){
        for(int i=0; i<current.size(); i++){
            int value = current.get(i);
            if(current.indexOf(value) != current.lastIndexOf(value)) throw new IllegalArgumentException();  // 리스트에 값이 여러 개 존재한다는 의미이므로 IllegalArgumentException 발생
        }
    }

    public static int checkBall(int strike){
        int ball = 0;
        for(int i=0; i<current.size(); i++){
            if(answer.contains(current.get(i))) ball++;
        }
        return ball-strike;
    }

    public static int checkStrike(){
        int strike = 0;
        for(int i=0; i<current.size(); i++){
            if(current.get(i).intValue() == answer.get(i).intValue()) strike++;
        }
        return strike;
    }

    public static void printResult(int ball, int strike){
        if(ball != 0 && strike != 0) System.out.println(ball + "볼 " + strike + "스트라이크");
        if(ball != 0 && strike == 0) System.out.println(ball + "볼");
        if(ball == 0 && strike != 0) System.out.println(strike + "스트라이크");
        if(ball == 0 && strike == 0) System.out.println("낫싱");
    }

}
