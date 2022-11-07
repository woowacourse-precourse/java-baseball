package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;


public class Application {
    public static int opponent1;
    public static int opponent2;
    public static int opponent3;

    public static void initOpponentNumber(){
        // num1 ~ num3까지 랜덤한 숫자를 넣는다.
        opponent1 = Randoms.pickNumberInRange(1, 9);
        while (true){
            opponent2 = Randoms.pickNumberInRange(1, 9);
            if (opponent1 != opponent2) {
                break;
            }
        }
        while (true){
            opponent3 = Randoms.pickNumberInRange(1, 9);
            if (opponent2 != opponent3 && opponent1 != opponent3) {
                break;
            }
        }
    }

    public static int[] getUserNumber(){
        System.out.print("숫자를 입력해주세요 : ");
        String num = Console.readLine();

        if (num.length() != 3){
            throw new IllegalArgumentException("3자리수를 입력해주세요!");
        }

        try {
            Integer.parseInt(num);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("숫자로만 입력해주세요!");
        }

        return new int[]{
                num.charAt(0) - '0',
                num.charAt(1) - '0',
                num.charAt(2) - '0'
        };
    }

    public static boolean checkAnswer(int[] num){
        return (num[0] == opponent1 && num[1] == opponent2 && num[2] == opponent3);
    }

    public static void countStrikeBall(int[] num){
        int strikeCount = 0;
        int ballCount = 0;
        StringBuilder result = new StringBuilder();

        if (num[0] == opponent1){
            strikeCount++;
        } else if (num[0] == opponent2 || num[0] == opponent3) {
            ballCount++;
        }

        if (num[1] == opponent2){
            strikeCount++;
        } else if (num[1] == opponent3 || num[1] == opponent1){
            ballCount++;
        }

        if (num[2] == opponent3){
            strikeCount++;
        } else if (num[2] == opponent1 || num[2] == opponent2) {
            ballCount++;
        }

        if (ballCount == 0 && strikeCount == 0){
            result.append("낫싱");
        }

        if (ballCount > 0) {
            result.append(ballCount + "볼 ");
        }

        if (strikeCount > 0){
            result.append(strikeCount + "스트라이크");
        }
        System.out.println(result);
    }

    public static boolean restart(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String flag = Console.readLine();

        if (flag.contentEquals("1")){
            return true;
        } else if (flag.contentEquals("2")){
            return false;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static boolean gameStart(){
        initOpponentNumber();
        while (true){
            int[] userNum = getUserNumber();
            boolean correct = checkAnswer(userNum);
            countStrikeBall(userNum);
            if (correct){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                return restart();
            }
        }
    }

    public static void main(String[] args) throws IllegalArgumentException{
        while (gameStart()) {}
    }
}