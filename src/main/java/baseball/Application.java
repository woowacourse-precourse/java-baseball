package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Application {
    private static int strikeCount = 0;
    private static int ballCount = 0;
    private static final int threeDigits = 999;

    public static void main(String[] args) throws IOException {
        List playerNumbers = new ArrayList();

        System.out.print("숫자를 입력해주세요 : ");
        String playerNumber = Console.readLine();
        for(int i =0; i<3; i++) {
            char numChar = playerNumber.charAt(i);
            playerNumbers.add(numChar);
        }

        isValidLength(playerNumbers);

        List computerNumbers = RandomNum();



        System.out.println("playerNumbers::"+playerNumbers);
        System.out.println("computerNumbers::"+computerNumbers);

        isStrike(playerNumbers, computerNumbers);
        isBall(playerNumbers, computerNumbers);

        if(ballCount == 0 && strikeCount > 0) {
            System.out.println(strikeCount+"스트라이크");

        } else if(ballCount > 0 && strikeCount ==0){
            System.out.println(ballCount+"볼");

        } else if(ballCount > 0 && strikeCount > 0) {
            System.out.println(ballCount+"볼 "+strikeCount+"스트라이크");

        } else if(ballCount ==0 && strikeCount ==0) {
            System.out.println("낫싱");

        } else if (strikeCount == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        }
    }

    public static List RandomNum(){
        List numList = new ArrayList<>();
        for(int i=0; i<3; i++) {
            int num = Randoms.pickNumberInRange(1, 9);
                if (numList.contains(num)) {
                    i--;
                } else if (!numList.contains(num)) {
                    numList.add(num);
                }
        }
        return numList;
    }

    public static void isValidLength(List playerNumber) {
        if(playerNumber.size() != 3) {
            throw new IllegalArgumentException("사용자의 숫자가 세자리보다 크거나 작다.");
        }
    }

    public static void isStrike(List playerNums, List computerNums) {
        for(int i=0; i<3; i++) {
            int playerNum = Integer.parseInt(String.valueOf(playerNums.get(i)));
            int computerNum = Integer.parseInt(String.valueOf(computerNums.get(i)));

            if (playerNum == computerNum) {
                strikeCount++;
            }
        }
    }

    public static void isBall(List playerNums, List computerNums) {
        for(int i=0; i<3; i++) {
            int playerNum = Integer.parseInt(String.valueOf(playerNums.get(i)));
            int computerNum = Integer.parseInt(String.valueOf(computerNums.get(i)));

            if(computerNums.contains(playerNum) && playerNum != computerNum) {
                ballCount++;
            }
        }
    }

}
