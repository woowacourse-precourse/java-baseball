package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args){
        while(true){
            //int strike = 0;
            //int ball = 0;

            System.out.println("숫자 야구 게임을 시작합니다.");

            // 1. 3자리 수 랜덤 생성 - Randoms의 pickNumberInRange()사용
            List<Integer> numbers = new ArrayList<>();
            while (numbers.size() < 3) {
                generateRandomNumber(numbers);
            }

            for(int i=0; i<numbers.size(); i++)
                System.out.println("랜덤 넘버: "+numbers.get(i));

            while(true){
                boolean breaker = false;
                int strike=0, ball=0, nothing=0;

                // 잘못된 값 입력시 IllegalArgumentException()를 throw
                String player = illegalInput();

                // 2. 스트라이크 볼 낫싱 판별
                List<Integer> ballList = strikeBallNothing(numbers, player);
                ball = ballList.get(0);
                strike = ballList.get(1);
                nothing = ballList.get(2);

                System.out.println("ball: "+ball+", "+"strike: "+strike+", "+ "nothing: "+ nothing);
                // 3. 종료 조건 - 3자리 수를 모두 맞힌경우
                if(strike == 3){
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                    String continueOrExit = Console.readLine();
                    if(Integer.parseInt(continueOrExit) == 2)
                        breaker = true;
                }
                if(breaker == true)
                    break;

                /*if(strike == 0 && ball == 0)
                    System.out.print("낫싱");*/

            }

        }
    }
    // 랜덤 넘버를 생성하는 메소드
    static void generateRandomNumber(List<Integer> numbers){
        int randomNumber = Randoms.pickNumberInRange(1, 9);

        // 각 수는 서로 다른 수
        if (!numbers.contains(randomNumber)) {
            numbers.add(randomNumber);
        }
    }

    static String illegalInput(){
        System.out.print("숫자를 입력해주세요 : ");
        String player = Console.readLine();         // Console의 readLine() 사용

        // 잘못된 입력 - IllegalArgumentException 발생
        if(player.isEmpty() || !player.chars().allMatch(Character::isDigit)
                || player.length() > 3){
            throw new IllegalArgumentException();
        }
        return player;
    }

    // 스트라이크, 볼, 낫싱 횟수를 리턴
    static List<Integer> strikeBallNothing(List<Integer> numbers, String player){
        List<Integer> baseballList = new ArrayList<>();

        for(int i=0; i<numbers.size(); i++)
            baseballList.add(0);

        int ball=baseballList.get(0), strike=baseballList.get(1), nothing= baseballList.get(2);
        //boolean breaker = false;
        for(int i=0; i<numbers.size(); i++){

            int playerNumbers = Integer.parseInt(String.valueOf(player.charAt(i)));

            if(numbers.get(i) == playerNumbers){
                strike++;
                baseballList.set(1, strike);
                //prevStrike += strike;
                //System.out.print(strike+"스트라이크 ");
            }
            else if(player.indexOf(Integer.toString(numbers.get(i))) != -1){
                ball++;
                baseballList.set(0, ball);
                System.out.println(baseballList.get(0));

            }
        }

        // ball, strike 모두 없는 경우에만 nothing
        if(ball == 0 && strike == 0){
            nothing++;
            baseballList.set(2, nothing);
        }

        return baseballList;

    }
}
