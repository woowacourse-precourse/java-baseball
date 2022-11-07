package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        int startSwitch = 1;
        List<Integer> computerNumbersList = getRandomThreeNumbers();
        while (startSwitch == 1) {
            System.out.println(computerNumbersList);
            System.out.print("숫자를 입력해주세요 : ");
            String stringUserNumber = Console.readLine();
            handleInputException(stringUserNumber);
            int userNumber = Integer.parseInt(stringUserNumber);
            List<Integer> userNumbersList = getUserNumberList(userNumber);
            if (getResult(computerNumbersList, userNumbersList)) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                startSwitch = getStartSwitch();
                computerNumbersList = getRandomThreeNumbers();
            }
        }
    }

    public static boolean hasDuplication(String s){
        for(char c : s.toCharArray()){
            if(s.chars().filter(ch -> ch == c).count() > 1){
                return true;
            }
        }
        return false;
    }

    public static boolean hasOtherNumbersOrChars(String s){
        for(char c : s.toCharArray()){
            if(!Character.isDigit(c)){
                return true;
            } else if(c == '0'){
                return true;
            }
        }
        return false;
    }

    public static void handleInputException(String stringUserNumber){
        if(hasDuplication(stringUserNumber)){
            throw new IllegalArgumentException();
        } else if(stringUserNumber.length() > 3){
            throw new IllegalArgumentException();
        } else if (hasOtherNumbersOrChars(stringUserNumber)){
            throw new IllegalArgumentException();
        }
    }

    public static int getStartSwitch(){
        String stringStartSwitch = Console.readLine();
        if(!Objects.equals(stringStartSwitch, "1") && !Objects.equals(stringStartSwitch, "2")) {
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(stringStartSwitch);
    }

    public static List<Integer> getRandomThreeNumbers() {
        List<Integer> numberList = new ArrayList<>();
        while (numberList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numberList.contains(randomNumber)) {
                numberList.add(randomNumber);
            }
        }
        return numberList;
    }

    public static boolean getResult(List<Integer> computerNumbersList, List<Integer> userNumbersList) {
        int strikeCount = 0;
        int ballCount = 0;
        for (int i = 0; i < 3; i++) {
            if (Objects.equals(computerNumbersList.get(i), userNumbersList.get(i))) {
                strikeCount++;
            }
            if (!Objects.equals(computerNumbersList.get(i), userNumbersList.get(i))
                    && computerNumbersList.contains(userNumbersList.get(i))) {
                ballCount++;
            }
        }
        printResult(strikeCount, ballCount);
        return strikeCount == 3;
    }

    public static void printResult(int strikeCount, int ballCount) {
        if (strikeCount != 0 && ballCount != 0) {
            System.out.println(strikeCount + "스트라이크 " + ballCount + "볼");
        } else if (strikeCount != 0) {
            System.out.println(strikeCount + "스트라이크");
        } else if (ballCount != 0) {
            System.out.println(ballCount + "볼");
        } else {
            System.out.println("낫싱");
        }
    }

    public static List<Integer> getUserNumberList(int userNumber) {
        List<Integer> userNumbersList = new ArrayList<>();
        while (userNumber > 0) {
            userNumbersList.add(userNumber % 10);
            userNumber /= 10;
        }
        Collections.reverse(userNumbersList);
        return userNumbersList;
    }
}
