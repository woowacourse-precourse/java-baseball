package baseball;

import java.io.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static String computerRandomNumber(){
        String [] number = new String[3];
        StringBuffer numbers = new StringBuffer();
        for(int i=0; i<number.length; i++){
            String num = String.valueOf(pickNumberInRange(1,9));
            if(!num.equals(number[i])) {
                number[i] = num;
                numbers.append(num);
            }
        }
        return numbers.toString();
    }

    public void gameStartMessage (){
        Console console = System.console();
        System.out.println("숫자 야구 게임을 시작합니다.");
        System.out.println("숫자를 입력 해 주세요.");
    }

    public void inputUserPickNumber(String userPickNumber){
        Console console = System.console();
        String userPicNumber = console.readLine();

    }
    public static void arrUserNumber(String userPickNumber, List<String >listUserNumber ){
        for(int i = 0; i<userPickNumber.length(); i++) {
            char splitNumber = userPickNumber.charAt(i);
           listUserNumber.add(String.valueOf(splitNumber));
        }
    }


    public static int howManyStrike (String userNumber, String answerNumber){
        int strikeCount = 0;

        for(int i = 0; i<userNumber.length();i++){
            char userNum = userNumber.charAt(i);
            char answerNum = answerNumber.charAt(i);
            if(userNum == answerNum){
                strikeCount ++;
            }
        }return strikeCount;
    }

    public static int howManyBall(String userNumber, String answerNumber){
        int ballCount = 0;
        for(int i = 0 ; i<userNumber.length()-1; i++){
            char userNum = userNumber.charAt(i);
            char answerNum = answerNumber.charAt(i+1);
            if(userNum == answerNum){
                ballCount++;
            }
        }return ballCount;
    }












}

