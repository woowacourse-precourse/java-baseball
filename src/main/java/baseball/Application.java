package baseball;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;


public class Application {
    public static void main(String[] args) {

        String numberPresentedByPlayer = ""; // User로부터 입력받을 숫자를 저장할 변수
        List<String> threeNumber = new ArrayList<>(); // 컴퓨터가 선택한 3개의 수를 저정할 리스트

        while (true) {
            System.out.println("숫자 야구 게임을 시작합니다.");
            threeNumber = createThreeNumbers(); // 컴퓨터가 서로 다른 3개의 수를 선택
            System.out.println(threeNumber);
            numberPresentedByPlayer = receiveUserInput(); // 게임플레이어로 부터 숫자를 입력받고 변수에 저장
            System.out.println(numberPresentedByPlayer);
            // 입력받은 데이터에 대한 예외처리
            if (!checkValidForInputThreeNumber(numberPresentedByPlayer)) {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            } else {

            }

            break;
        }
    }

    // user로부터 3개의 숫자를 입력받는 메서드
    public static String receiveUserInput(){

        Scanner receivedUserInput = new Scanner(System.in); // Scanner 클래스를 통해 시스템의 입력장치로부터 읽은 Scanner 생성하여 변수에 저장

        //BufferedReader receiveInput = new BufferedReader(new InputStreamReader(System.in));

        //입력 데이터 읽기
        System.out.print("숫자를 입력해주세요 : ");
        String numbers = receivedUserInput.nextLine();
        return numbers;

    }

    // 컴퓨터가 1에서 9까지 서로 다른 임의의 수 3개를 선택하는 메서드
    public static List<String> createThreeNumbers(){
        List<String> threeNumbersOfComputer = new ArrayList<>();
        Random random = new Random();
        while (true) {
            if (threeNumbersOfComputer.size() == 3){
                break;
            }
            else{
                int selectedNumberByComputer =  random.nextInt(9)+1;
                String selectedNumberByComputerStringType = String.valueOf(selectedNumberByComputer);
                // 생성된 난수가 이미 이전에 생성됐던 수가 아니라면 선택하기 (서로 다른 3개의 수이므로)
                if (!threeNumbersOfComputer.contains(selectedNumberByComputerStringType)){
                    threeNumbersOfComputer.add(String.valueOf(selectedNumberByComputerStringType));
                }
            }
        }
        return threeNumbersOfComputer;
    }

    // 게임플레이어로부터 입력받은 3자리 숫자에 대한 예외처리 메서드
    public static Boolean checkValidForInputThreeNumber(String input) {
        if (!(input.length() == 3)) { // 입력받은 숫자 문자열의 길이가 3이 아니라면
            System.out.println("잘못된 형식의 입력입니다. 입력하신 데이터는 3개의 숫자가 아닙니다.");
            System.out.println("'456', '147'과 같은 형식으로 3자리의 숫자를 입력해주세요.");
            return false;
        }
        for (int index = 0; index < input.length(); index++) {
            int number = Character.getNumericValue(input.charAt(index));
            if (!Character.isDigit(input.charAt(index))) {
                System.out.println("입력하신 데이터에 숫자가 아닌 것이 존재합니다.");
                System.out.printf("\'%s\'는 숫자가 아닙니다.\n", String.valueOf(input.charAt(index)));
                System.out.println("'456', '147'과 같은 형식으로 3자리의 숫자를 입력해주세요.");
                return false;
            } else if (!(1 <= number && 9 >= number)) {
                System.out.println("입력하신 숫자는 입력 범위를 초과합니다.");
                System.out.println("1부터 9까지의 숫자 중 하나의 숫자들로 이루어진 3자리 숫자를 입력해주세요.");
                return false;
            }

        }
        return true;
    }

//numberPresentedByPlayer = receivedUserInput.nextLine();
}
