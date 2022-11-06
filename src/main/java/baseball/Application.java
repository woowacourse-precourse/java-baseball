package baseball;

import java.util.ArrayList;
import java.util.List;

/**
 * BaseballInput : 숫자 세개를 각기 다른 instance로 생성
 */
public class Application {

    static class BaseballInput {

        private Integer first;
        private Integer second;
        private Integer third;


        private void validate(String inputData) {
            String message = "잘못된 입력입니다.";
            try {
                if (inputData.length() != 3) {
                    throw new IllegalArgumentException();
                }
                boolean chk[] = new boolean[10];

                for (int i = 0; i < inputData.length(); i++) {
                    char currentChar = inputData.charAt(i);
                    if (currentChar < '0' || currentChar > '9') {
                        throw new IllegalArgumentException();
                    }
                    if (chk[currentChar - '0']) {
                        message = "중복된 수 입력입니다.";
                        throw new IllegalArgumentException();
                    }
                    chk[currentChar-'0'] = true;
                }

            } catch (Exception e) {
                throw new IllegalArgumentException(message);
            }


        }


        BaseballInput(String inputData) {
            validate(inputData);
            this.first = inputData.charAt(0)-'0';
            this.second = inputData.charAt(1)-'0';
            this.third = inputData.charAt(2)-'0';
        }

        public Integer getFirst() {
            return first;
        }

        public Integer getSecond() {
            return second;
        }

        public Integer getThird() {
            return third;
        }
    }

    List<Integer> inputValidate(String inputData) {
        List<Integer> list = new ArrayList<>();
        try {
            int inputValue = Integer.parseInt(inputData);
            while (inputValue != 0) {
                list.add(inputValue % 10);
                inputValue /= 10;
            }


        } catch (Exception e) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }


        return list;


    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현


    }
}
