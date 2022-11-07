package baseball;

import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static int THE_NUMBER_OF_BALLS = 3;

    // main()메서드에서 값을 받아 처리하는 클래스
    public static class Model {

        private final List<Integer> computerNumberList = new ArrayList<>();
        private final List<Integer> inputNumberList = new ArrayList<>();
        private int strikeCounting;
        private int ballCounting;

        // 입력값을 바탕으로 스트라이크와 볼을 찾아내는 게임 진행 메서드
        public void proceedGame (String inputString) {
            inputNumberList.clear();
            splitNumber(inputNumberList, inputString);
            getStrikeCounting();
            getBallCounting();
        }

        // 스트라이크를 구별하는 메서드
        public void getStrikeCounting() {
            int methodInStrikeCounting = 0;

            for (int i = 0; i < THE_NUMBER_OF_BALLS; i++) {
                if (inputNumberList.get(i).equals(computerNumberList.get(i))) {
                    methodInStrikeCounting += 1;
                }
            }

            strikeCounting = methodInStrikeCounting;
        }

        // 볼을 구별하는 메서드
        public void getBallCounting() {
            int methodInBallCounting = 0;

            for (int number: inputNumberList) {

                if (computerNumberList.contains(number)) {
                    methodInBallCounting += 1;
                }
            }

            ballCounting = methodInBallCounting - strikeCounting;
        }

        // 컴퓨터의 3자리 숫자를 설정하는 메서드
        public void getComputerNumber() {
            strikeCounting = 0;

            while (computerNumberList.size() < THE_NUMBER_OF_BALLS) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);

                if (!computerNumberList.contains(randomNumber)) {
                    computerNumberList.add(randomNumber);
                }
            }
        }

        // 사용자가 입력한 3자리 숫자를 리스트로 분리하는 메서드
        public void splitNumber(List<Integer> inputNumberList, String inputNumber) {

            for (char number: inputNumber.toCharArray()) {
                inputNumberList.add(Character.getNumericValue(number));
            }
        }

        // 게임종료 시 다시 시작할지 결정하는 메서드
        public boolean decideRestart(String decidedRestartString) {
            int decidedRestart = Integer.parseInt(decidedRestartString);

            if (decidedRestart == 1) return true;
            else return false;
        }

        // 3자리 숫자를 입력할 때 예외 발생시키는 메서드
        public void discoverInputNumberException(String inputNumber) throws IllegalArgumentException {
            checkNumberItem(inputNumber);
            checkNumberRange(inputNumber);
            checkDuplicatedNumber(inputNumber);
        }

        // 입력된 3자리 숫자 중에서 중복된 숫자가 있는지 확인하는 메서드
        public void checkDuplicatedNumber (String inputNumber) throws IllegalArgumentException{
            HashSet<Integer> inputNumberInSet = new HashSet<>();
            inputNumber.chars().forEach(number -> inputNumberInSet.add(number));

            if (inputNumberInSet.size() < THE_NUMBER_OF_BALLS) throw new IllegalArgumentException();
        }

        // 주어진 숫자가 3자리가 아닌 경우 예외 발생
        public void checkNumberItem (String inputNumber) throws IllegalArgumentException{

            if (inputNumber.length() != THE_NUMBER_OF_BALLS) {
                throw new IllegalArgumentException();
            }
        }

        // 입력된 3자리의 숫자가 1~9의 범위 내에 존재하는지 확인
        public void checkNumberRange (String inputNumber) throws  IllegalArgumentException{

            inputNumber.chars().forEach(number -> {
                if (number < 49 || number > 57) throw new IllegalArgumentException();
            });
        }

        // 재시작 결정 시에 입력되는 숫자의 예외를 발생시키는 메서드
        public void discoverRestartNumberException (String restartNumber) throws IllegalArgumentException{
            if (!restartNumber.equals("1") && !restartNumber.equals("2")) throw new IllegalArgumentException();
        }

        // 숫자 입력과 예외처리를 동시에 하는 메서드
        public  String inputBallAndRestartNumber () {
            String inputNumber = Console.readLine();

            if (strikeCounting == THE_NUMBER_OF_BALLS) discoverRestartNumberException(inputNumber);
            else discoverInputNumberException(inputNumber);

            return inputNumber;
        }

    }

    // model에서 처리된 값을 출력하는 클래스
    public static class View {
        public void printResult(int ballCounting, int strikeCounting) {

            if (strikeCounting == THE_NUMBER_OF_BALLS) {
                System.out.println("3스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            } else if (strikeCounting > 0 && ballCounting == 0) {
                System.out.printf("%d스트라이크\r\n", strikeCounting);
            } else if (strikeCounting == 0 && ballCounting > 0) {
                System.out.printf("%d볼\r\n", ballCounting);
            } else if (strikeCounting > 0 && ballCounting > 0) {
                System.out.printf("%d볼 %d스트라이크\r\n", ballCounting, strikeCounting);
            } else {
                System.out.println("낫싱");
            }
        }
    }

    public static void main(String[] args) {

        View view = new View();

        while (true) {
            Model model = new Model();

            System.out.println("숫자 야구 게임을 시작합니다.");
            model.getComputerNumber();

            while (model.strikeCounting < THE_NUMBER_OF_BALLS) {
                model.proceedGame(model.inputBallAndRestartNumber());
                view.printResult(model.ballCounting, model.strikeCounting);
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            if (!model.decideRestart(model.inputBallAndRestartNumber())) break;

        }
    }
}
