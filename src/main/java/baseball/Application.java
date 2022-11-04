package baseball;

import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static int THE_NUMBER_OF_BALLS = 3;

    // main()메서드에서 값을 받아 처리하는 클래스
    public static class model {

        private List<Integer> computerNumberList = new ArrayList<>();
        private List<Integer> inputNumberList = new ArrayList<>();
        private int strikeCounting;
        private int ballCounting;
        private int THE_NUMBER_OF_BALLS = 3;

        public void proceedGame (String inputString) {
            discoverInputNumberException(inputString);
            splitNumber(inputNumberList, inputString);
            distinguishStrike();
            distinguishBall();

        }

        // 스트라이크를 구별하는 메서드
        public void distinguishStrike() {
            int methodInStrikeCounting = 0;

            for (int i = 0; i < THE_NUMBER_OF_BALLS; i++) {
                if (inputNumberList.get(i).equals(computerNumberList.get(i))) {
                    methodInStrikeCounting += 1;
                }
            }

            strikeCounting = methodInStrikeCounting;
        }

        // 볼을 구별하는 메서드
        public void distinguishBall() {
            int methodInBallCounting = 0;

            for (int i = 0; i < THE_NUMBER_OF_BALLS; i++) {
                if (computerNumberList.contains(inputNumberList.get(i))) {
                    methodInBallCounting += 1;
                }
            }

            ballCounting = methodInBallCounting - strikeCounting;
        }

        // 컴퓨터의 3자리 숫자를 설정하는 메서드
        public void makeComputerNumber() {

            while (computerNumberList.size() < THE_NUMBER_OF_BALLS) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);

                if (!computerNumberList.contains(randomNumber)) {
                    computerNumberList.add(randomNumber);
                }
            }
        }

        // 사용자가 입력한 3자리 숫자를 리스트로 분리하는 메서드
        public void splitNumber(List<Integer> inputNumberList, String inputNumber) {

            for (int k = 0; k < 3; k++) {
                inputNumberList.add(Character.getNumericValue(inputNumber.charAt(k)));
            }
        }

        // 게임종료 시 다시 시작할지 결정하는 메서드
        public boolean decideRestart(String decidedRestartString) {
            discoverRestartNumberException(decidedRestartString);
            int decidedRestart = Integer.parseInt(decidedRestartString);

            if (decidedRestart == 1) return true;
            else return false;
        }

        // 입력된 3자리 숫자 중에서 중복된 숫자가 있는지 확인하는 메서드
        public boolean seekDuplicatedNumber (String inputNumber) {
            HashSet<Character> inputNubmerInSet = new HashSet<>();

            for (int p = 0; p <THE_NUMBER_OF_BALLS; p++) {
                inputNubmerInSet.add(inputNumber.charAt(p));
            }

            return inputNubmerInSet.size() < THE_NUMBER_OF_BALLS;
        }

        // 3자리 숫자를 입력할 때 예외 발생시키는 메서드
        public void discoverInputNumberException(String inputNumber) throws IllegalArgumentException {

            // 주어진 숫자가 3자리가 아닌 경우 예외 발생
            if (inputNumber.length() != THE_NUMBER_OF_BALLS) {
                throw new IllegalArgumentException();
            }

            // 주어진 숫자가 서로 다르지 않은 경우 예외 발생
            if (seekDuplicatedNumber(inputNumber)) {
                throw new IllegalArgumentException();
            }

            // 각 숫자가 1~9가 아닌 경우 예외 발생
            for (int l = 0; l < inputNumber.length(); l++) {
                if (inputNumber.charAt(l) < 49 || inputNumber.charAt(l) > 57) {
                    throw new IllegalArgumentException();
                }else if (inputNumber.charAt(l) == '0') {
                    throw new IllegalArgumentException();
                }

            }
        }

        // 재시작 결정 시에 입력되는 숫자의 예외를 발생시키는 메서드
        public void discoverRestartNumberException (String decideRestartString) throws IllegalArgumentException{
            if (!decideRestartString.equals("1") && !decideRestartString.equals("2")) throw new IllegalArgumentException();
        }

    }

    // model에서 처리된 값을 출력하는 클래스
    public static class view {
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

        view baseballView = new view();

        while (true) {
            model baseballModel = new model();

            System.out.println("숫자 야구 게임을 시작합니다.");
            baseballModel.makeComputerNumber();

            while (baseballModel.strikeCounting < THE_NUMBER_OF_BALLS) {
                String inputString = Console.readLine();
                baseballModel.proceedGame(inputString);
                baseballView.printResult(baseballModel.ballCounting, baseballModel.strikeCounting);
                baseballModel.inputNumberList.clear();
            }

            baseballModel.strikeCounting = 0;
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String decidedRestartString =  Console.readLine();

            if (!baseballModel.decideRestart(decidedRestartString)) break;

            baseballModel.computerNumberList.clear();
        }
    }
}
