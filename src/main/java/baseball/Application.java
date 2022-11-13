package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class Application {
    static final int REPLAY = 1;
    static final int EXIT = 2;
    public static void main(String[] args) {
        String numberPresentedByPlayer = "";
        List<String> threeNumber = new ArrayList<>(); // 컴퓨터가 선택한 3개의 수를 저정할 리스트
        String whetherToReplay = "";

        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            threeNumber = createThreeNumbers(); // 컴퓨터가 서로 다른 3개의 수를 선택
            while (true) {
                System.out.print("숫자를 입력해주세요 : ");
                numberPresentedByPlayer = receiveUserInput();
                // 입력받은 데이터에 대한 예외처리
                if (!checkValidForInputThreeNumber(numberPresentedByPlayer)) {
                    throw new IllegalArgumentException("잘못된 입력입니다.");
                } else {
                    int theNumberOfStrikes = calculateTheNumberOfStrikes(threeNumber, numberPresentedByPlayer);
                    int theNumberOfBalls = calculateTheNumberOfBalls(threeNumber, numberPresentedByPlayer);
                    if (outputFinalResultAndWhetherAllMatches(theNumberOfStrikes, theNumberOfBalls)) {
                        break;
                    }
                }
            }
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            whetherToReplay = receiveUserInput();
            if (!checkValidForInputWhetherReplay(whetherToReplay)) {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            } else {
                if (Integer.valueOf(whetherToReplay) == REPLAY) {
                    continue;
                } else if (Integer.valueOf(whetherToReplay) == EXIT) {
                    break;
                }
            }
        }
    }

    public static String receiveUserInput() {

        Scanner receivedUserInput = new Scanner(System.in);

        String numbers = receivedUserInput.nextLine();
        return numbers;
    }

    // 컴퓨터가 1에서 9까지 서로 다른 임의의 수 3개를 선택하는 메서드
    public static List<String> createThreeNumbers() {
        List<String> threeNumbersOfComputer = new ArrayList<>();
        Random random = new Random();
        while (true) {
            if (threeNumbersOfComputer.size() == 3) {
                break;
            } else {
                int selectedNumberByComputer = random.nextInt(9) + 1;
                String selectedNumber = String.valueOf(selectedNumberByComputer);
                // 생성된 난수가 이미 이전에 생성됐던 수가 아니라면 선택하기 (서로 다른 3개의 수이므로)
                if (!threeNumbersOfComputer.contains(selectedNumber)) {
                    threeNumbersOfComputer.add(String.valueOf(selectedNumber));
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
                System.out.println("'456', '147'과 같은 형식으로 3자리 숫자를 입력해주세요.");
                return false;
            } else if (!(1 <= number && 9 >= number)) {
                System.out.println("입력하신 숫자는 입력 범위를 초과합니다.");
                System.out.println("1부터 9까지의 숫자 중 하나의 숫자들로 이루어진 3자리 숫자를 입력해주세요.");
                return false;
            } else if (index == 0) {
                if (input.charAt(index) == input.charAt(index + 1) || input.charAt(index) == input.charAt(index + 2)) {
                    System.out.println("입력하신 숫자에는 중복되는 숫자가 존재합니다.");
                    System.out.println("서로 다른 3자리 숫자를 입력해주세요.");
                    return false;
                }
            } else if (index == 1) {
                if (input.charAt(index) == input.charAt(index + 1)) {
                    System.out.println("입력하신 숫자에는 중복되는 숫자가 존재합니다.");
                    System.out.println("서로 다른 3자리 숫자를 입력해주세요.");
                    return false;
                }
            }
        }
        return true;
    }

    public static int calculateTheNumberOfStrikes(List<String> computersThreeNumbers, String usersThreeNumbers) {
        int numberOfStrikes = 0;
        for (int index = 0; index < computersThreeNumbers.size(); index++) {
            int ComputersNumber = Integer.valueOf(computersThreeNumbers.get(index));
            int UsersNumber = Character.getNumericValue(usersThreeNumbers.charAt(index));
            if (ComputersNumber == UsersNumber) { // 같은 수가 같은 자리에 있으면
                numberOfStrikes += 1; // 스트라이크 수를 1증가
            }
        }
        return numberOfStrikes;
    }

    public static int calculateTheNumberOfBalls(List<String> computersThreeNumbers, String usersThreeNumbers) {
        int numberOfBall = 0;
        for (int index = 0; index < computersThreeNumbers.size(); index++) {
            //int ComputersNumber = Integer.valueOf(computersThreeNumber.get(index));
            String UsersNumber = String.valueOf(usersThreeNumbers.charAt(index));
            int indexOfUserNumberInComputersThreeNumbers = computersThreeNumbers.indexOf(UsersNumber);
            // 해당 자리의 User의 숫자가 컴퓨터의 3개의 숫자 중 하나이고, 같은 자리가 아니라면(다른 자리에 있으면)
            if (indexOfUserNumberInComputersThreeNumbers != -1 && indexOfUserNumberInComputersThreeNumbers != index) {
                numberOfBall += 1; // 스트라이크 수를 1증가
            }
        }
        return numberOfBall;
    }

    public static boolean outputFinalResultAndWhetherAllMatches(int numberOfStrikes, int numberOfBalls) {
        if (numberOfStrikes == 3) {
            System.out.printf("%d스트라이크\n", numberOfStrikes);
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        } else if (numberOfStrikes == 0 && numberOfBalls == 0) {
            System.out.println("낫싱");
        } else if (0 < numberOfStrikes && 3 > numberOfStrikes && numberOfBalls == 0) {
            System.out.printf("%d스트라이크\n", numberOfStrikes);
        } else if (numberOfStrikes == 0 && 0 < numberOfBalls && 3 >= numberOfBalls) {
            System.out.printf("%d볼\n", numberOfBalls);
        } else if (0 < numberOfStrikes && 3 > numberOfStrikes && 0 < numberOfBalls && 3 >= numberOfBalls) {
            System.out.printf("%d볼 %d스트라이크\n", numberOfBalls, numberOfStrikes);
        }
        return false;
    }

    public static Boolean checkValidForInputWhetherReplay(String input) {
        if (!input.matches("[+-]?\\d*(\\.\\d+)?")) {
            return false;
        }
        int Number = Integer.valueOf(input);
        if (!(Number == 1 || Number == 2)) {
            return false;
        }
        return true;
    }

}


