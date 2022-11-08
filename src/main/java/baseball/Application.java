package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

        //1. 컴퓨터 수 생성하기
        private static final int DIGITS = 3;
        private static final int RANDOM_MIN = 1;
        private static final int RANDOM_MAX = 9;

        public static List<Integer> createComputerNumber () {
            List<Integer> computerNumber = new ArrayList<>();
            while (computerNumber.size() < DIGITS) {
                int randomNumber = Randoms.pickNumberInRange(RANDOM_MIN, RANDOM_MAX);
                if (!computerNumber.contains(randomNumber)) {
                    computerNumber.add(randomNumber);
                }
            }
            return computerNumber;
        }

    }
