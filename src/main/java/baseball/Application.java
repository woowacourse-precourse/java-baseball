package baseball;

import java.util.*;

public class Application {

    public static Scanner scanner = new Scanner(System.in);
    public static int threeStrikesIdentifier = 0;

    public static void main(String[] args) {
        processBaseballGame();
    }

    public static void processBaseballGame() {
        threeStrikesIdentifier = 0;
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> computer = getComputersValue();

        while(threeStrikesIdentifier == 0) {
            System.out.print("숫자를 입력해 주세요 : ");
            ballStrikeCountFromCurrentInput(computer, scanner.nextInt());
        }
    }

    public static List<Integer> getComputersValue() {
        List<Integer> computer = new ArrayList<>();

        while(computer.size() < 3) {
            int randomInt = (int) (Math.random() * 10);
            if(randomInt != 0 && !computer.contains(randomInt)) {
                computer.add(randomInt);
            }
        }
        return computer;
    }


   public static List<Integer> getPlaceValuesFromNum(int num)  {
        int count = 0;
        List<Integer> placeValuesFromNum = new ArrayList<>();
        for(int temp = num; temp > 0; temp /= 10, count++) {
            if(temp % 10 == 0)  throw new IllegalArgumentException("자릿수에 0이 존재할 수 없습니다.");
            placeValuesFromNum.add(temp % 10);
        }

       Set<Integer> placeValuesSet = new HashSet<>(placeValuesFromNum);
        // Set은 중복을 허용하지 않기 때문에 List을 Set으로 저장했을 때 이전과 size가 달라졌다면 중복이 존재한다는 뜻입니다.
        if(placeValuesSet.size() != placeValuesFromNum.size()) {
            throw new IllegalArgumentException("세 자릿수 각각은 서로 달라야 합니다.");
        }

        if(count == 3)  return placeValuesFromNum;
        else throw new IllegalArgumentException("세 자릿수를 입력해주세요.");
   }

    public static void ballStrikeCountFromCurrentInput(List<Integer> computer, int user) {
        List<Integer> usersInputList = getPlaceValuesFromNum(user);

        int strike = 0;
        int ball = 0;

        for(int idx = 0; idx < computer.size(); idx++) {
            int computersValue = computer.get(idx);
            int usersValue = usersInputList.get(idx);

            if(computersValue == usersValue)    strike++;
            else if(computer.contains(usersValue))    ball++;
        }
        printResult(strike, ball);
    }

    private static void printResult(int strike, int ball) {
        if(strike == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            exitOrRestart();
        }

        else {
            String output =
                    (strike == 0 && ball == 0)? "낫싱" :
                            (strike == 0 && ball > 0)? ball + "볼" :
                                    (strike > 0 && ball == 0)? strike + "스트라이크"
                                            : ball + "볼 " + strike + "스트라이크";
            System.out.println(output);
        }
    }

    private static void exitOrRestart() {
        threeStrikesIdentifier = 1;
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int response = scanner.nextInt();
        switch(response) {
            case 1: processBaseballGame();
                    break;

            case 2: scanner.close();
                    return;

            default : throw new IllegalArgumentException("1 또는 2만 입력 가능합니다.");
        }

    }
}
