package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args){
        List<Integer> numbers;
        int strike, ball;

        System.out.println("숫자 야구 게임을 시작합니다.");

        while(true){

            // 1. 3자리 수 랜덤 생성 - Randoms의 pickNumberInRange()사용
            numbers = generateRandomNumber();

            while(true){

                System.out.print("숫자를 입력해주세요 : ");
                String player = Console.readLine();         // Console의 readLine() 사용

                // 잘못된 값 입력시 IllegalArgumentException()를 throw
                illegalInput(player, strToList(player));

                // 2. 스트라이크 볼 낫싱 판별
                List<Integer> ballList = strikeBallNothing(numbers, player);
                ball = ballList.get(0);
                strike = ballList.get(1);

                // 출력과 종료 조건 메소드 분리
                printBallCount(ball, strike);           // 출력
                if(strike == 3)
                    break;
            }

            if(hasEnded(strike)){                   // 종료 조건 확인
                //System.out.println("게임을 종료합니다.");
                break;
            }

        }
    }
    // 랜덤 넘버를 생성하는 메소드
    static List<Integer> generateRandomNumber(){
        List<Integer> numbers = new ArrayList<>();

        while(numbers.size() < 3){
            int randomNumber = Randoms.pickNumberInRange(1, 9);         // 1~9사이 랜덤 넘버 생성

            // 각 수는 서로 다른 수
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }

    static List<String> strToList(String player){

        List<String> playerNum = new ArrayList<>();

        for(int i=0; i<player.length(); i++){
            String num = String.valueOf(player.charAt(i));
            playerNum.add(num);
        }
        return playerNum;
    }

    // 잘못된 입력 - IllegalArgumentException 발생
    static void illegalInput(String player, List<String> playerNum){

        // 길이가 3이 아닌 경우
        if(player.length() != 3){
            System.out.println("세 자리 숫자를 입력해주세요!");
            throw new IllegalArgumentException();
        }

        // 숫자가 아닌 입력이 들어온 경우
        if(player.chars().noneMatch(Character::isDigit)){
            System.out.println("숫자를 입력해주세요!");
            throw new IllegalArgumentException();
        }

        // 중복된 숫자가 입력으로 들어온 경우 - list.stream().distinct().count(): 중복값 제외 count
        else if(playerNum.stream().distinct().count() != playerNum.size()){
            System.out.println("서로 다른 숫자를 입력해주세요!");
            throw new IllegalArgumentException();
        }
    }

    // 스트라이크, 볼, 낫싱 횟수를 리턴
    static List<Integer> strikeBallNothing(List<Integer> numbers, String player){
        List<Integer> baseballList = new ArrayList<>();

        for(int i=0; i<numbers.size(); i++)
            baseballList.add(0);

        int ball=baseballList.get(0), strike=baseballList.get(1);

        for(int i=0; i<numbers.size(); i++){

            int playerNumbers = Integer.parseInt(String.valueOf(player.charAt(i)));

            if(numbers.get(i) == playerNumbers){
                strike++;
                baseballList.set(1, strike);
            }
            else if(player.contains(Integer.toString(numbers.get(i)))){
                ball++;
                baseballList.set(0, ball);
                System.out.println(baseballList.get(0));

            }
        }

        return baseballList;
    }

    // 2. 스트라이크, 볼, 낫싱 횟수를 출력
    static void printBallCount(int ball, int strike){
        if(ball != 0 && strike != 0)
            System.out.println(ball + "볼 "+strike+"스트라이크");
        else{
            if(ball != 0)
                System.out.println(ball + "볼");
            else if(strike != 0)
                System.out.println(strike + "스트라이크");
            else
                System.out.println("낫싱");
        }

    }
    // 종료 조건을 확인하는 메소드 - 모든 수를 맞히고 2를 입력
    static boolean hasEnded(int strike){
        // 3. 종료 조건 - 3자리 수를 모두 맞힌경우
        if(strike == 3){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String continueOrExit = Console.readLine();
            if(Integer.parseInt(continueOrExit) == 2)
                return true;
        }
        return false;
    }
}
