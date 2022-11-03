package baseball;

import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static class model {

        private List<Integer> computerNumberList = new ArrayList<>();
        private List<Integer> inputNumberList = new ArrayList<>();
        int strikeCounting;
        int ballCounting;

        public void proceedGame (String inputString) {
            discoverInputNumberException(inputString);
            splitNumber(inputNumberList, inputString);
            distinguishStrike();
            distinguishBall();

        }

        public void distinguishStrike() {
            int methodInStrikeCounting = 0;

            for (int i = 0; i < 3; i++) {
                if (inputNumberList.get(i).equals(computerNumberList.get(i))) {
                    methodInStrikeCounting += 1;
                }
            }

            strikeCounting = methodInStrikeCounting;
        }

        // 수정 필요 중복된 값을 처리 못 함
        public void distinguishBall() {
            int methodInBallCounting = 0;

            for (int i = 0; i < 3; i++) {
                if (computerNumberList.contains(inputNumberList.get(i))) {
                    methodInBallCounting += 1;
                }
            }

            ballCounting = methodInBallCounting - strikeCounting;
        }

        public void makeComputerNumber() {

            while (computerNumberList.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);

                if (!computerNumberList.contains(randomNumber)) {
                    computerNumberList.add(randomNumber);
                }
            }
        }

        public void splitNumber(List<Integer> inputNumberList, String inputNumber) {

            for (int k = 0; k < 3; k++) {
                inputNumberList.add(Character.getNumericValue(inputNumber.charAt(k)));
            }
        }

        public boolean decideRestart(String decidedRestartString) {
            discoverRestartNumberException(decidedRestartString);
            int decidedRestart = Integer.parseInt(decidedRestartString);

            if (decidedRestart == 1) return true;
            else return false;
        }

        public boolean seekDuplicatedNumber (String inputNumber) {
            HashSet<Character> inputNubmerInSet = new HashSet<>();
            for (int p = 0; p < inputNumber.length(); p++) {
                inputNubmerInSet.add(inputNumber.charAt(p));
            }
            if (inputNubmerInSet.size() < 3) return true;
            else return false;
        }

        public void discoverInputNumberException(String inputNumber) throws IllegalArgumentException {

            if (inputNumber.length() != 3) {
                throw new IllegalArgumentException();
            }

            if (seekDuplicatedNumber(inputNumber)) {
                throw new IllegalArgumentException();
            }

            for (int l = 0; l < inputNumber.length(); l++) {
                if (inputNumber.charAt(l) < 49 || inputNumber.charAt(l) > 57) {
                    throw new IllegalArgumentException();
                }else if (inputNumber.charAt(l) == '0') {
                    throw new IllegalArgumentException();
                }

            }
        }

        public void discoverRestartNumberException (String decideRestartString) throws IllegalArgumentException{
            if (!decideRestartString.equals("1") && !decideRestartString.equals("2")) throw new IllegalArgumentException();
        }

    }

    public static class view {
        public void printResult(int ballCounting, int strikeCounting) {
            if (strikeCounting == 3) {
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
            while (baseballModel.strikeCounting < 3) {
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
