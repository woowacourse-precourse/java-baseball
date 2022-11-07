package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Scanner scanner = new Scanner(System.in);
        
        int nextProgress = 1;  //숫자 야구 게임을 재시작 또는 종료를 판단하는 변수
        while (nextProgress == 1) {
            System.out.println("숫자 야구 게임을 시작합니다.");

            List<Integer> computer = getRandomInteger();

            //랜덤 computer 수 맞추는 메서드 호출
            guessComputerInteger(computer, scanner);

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            //다음 진행을 어떻게 할지 입력, 1인 경우 숫자 야구 게임 다시 시작, 2인 경우 종료
            nextProgress = scanner.nextInt();

            //1, 2 이외의 값을 입력할 경우 IllegalArgumentException 예외처리
            checkValidNextProgressNumber(nextProgress);
        }
        System.out.println("게임 종료");
    }
    
    private static List<Integer> getRandomInteger() {
        List<Integer> result = new ArrayList<>();
        while (result.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            //서로 다른 3자리수를 저장
            if (!result.contains(randomNumber)) {
                result.add(randomNumber);
            }
        }
        return result;
    }

    private static void guessComputerInteger(List<Integer> computer, Scanner scanner) throws IllegalArgumentException {
        int exact = 0;  //1이면 3스트라이크로 종료, 0이면 이어서
        while (exact == 0) {
            System.out.print("숫자를 입력해주세요 : ");
            int inputNumber = scanner.nextInt();

            //각자리수 리스트 반환 메서드 호출
            List<Integer> eachDigitsList = getEachDigitsList(inputNumber);

            //올바른 수를 입력했는지 체크, 올바르지 않으면 IllegalArgumentException 예외처리

            //세자리 수가 안되거나 초과하는 경우, 네각자리 수 중 0이 포함되거나 경우, 각자리 수 중 중복되는 수가 있는 경우
            // IllegalArgumentException 던짐
            checkValidInputNumber(eachDigitsList);

            exact = matchWithInput(computer, eachDigitsList);
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    /**
     * 입력받은 수를 각 자리수 리스트로 반환하는 메서드
     */
    private static List<Integer> getEachDigitsList(int inputNumber) {
        List<Integer> result = new ArrayList<>();

        while (inputNumber > 0) {
            result.add(0, inputNumber % 10);
            inputNumber = inputNumber / 10;
        }
        return result;
    }

    private static void checkValidInputNumber(List<Integer> eachDigitsList) throws IllegalArgumentException {
        if (eachDigitsList.size() < 3 || eachDigitsList.size() > 3) {
            throw new IllegalArgumentException("Invalid Argument");
        }

        List<Integer> duplicateCheckList = new ArrayList<>();
        for (Integer check : eachDigitsList) {
            if (check == 0) {
                throw new IllegalArgumentException("Invalid Argument");
            }
            if (duplicateCheckList.contains(check)) {
                throw new IllegalArgumentException("Invalid Argument");
            }
            duplicateCheckList.add(check);
        }
    }

    /**
     * eachDigitsList와 computer 리스트를 비교해서 매칭 결과를 반환하는 메서드
     */
    private static int matchWithInput(List<Integer> computer, List<Integer> eachDigitsList) {
        if (computer.equals(eachDigitsList)) {
            System.out.println("3스트라이크");
            return 1;
        }

        int countStrike = 0;
        int countBall = 0;
        List<Integer> candidateBall = new ArrayList<>();    //볼일수도 있는 후보 리스트

        for (int i = 0; i < 3; i++) {
            if (computer.get(i) == eachDigitsList.get(i)) {
                countStrike++;
                continue;
            }
            candidateBall.add(computer.get(i));
        }

        for (Integer candidate : eachDigitsList) {
            if (candidateBall.contains(candidate)) {
                countBall++;
            }
        }

        if (countStrike == 0 && countBall == 0) {
            System.out.println("낫싱");
        }
        if (countStrike == 0 && countBall != 0) {
            System.out.println(countBall + "볼");
        }
        if (countStrike != 0 && countBall == 0) {
            System.out.println(countStrike + "스트라이크");
        }
        if (countStrike != 0 && countBall != 0) {
            System.out.println(countBall + "볼 " + countStrike + "스트라이크");
        }

        return 0;
    }

    private static void checkValidNextProgressNumber(int nextProgress) throws IllegalArgumentException {
        List<Integer> nextProgressList = List.of(1,2);
        if (!nextProgressList.contains(nextProgress)) {
            throw new IllegalArgumentException("Invalid Argument");
        }
    }

}
