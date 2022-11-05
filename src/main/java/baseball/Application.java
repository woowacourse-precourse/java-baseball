package baseball;

import camp.nextstep.edu.missionutils.*;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    static boolean status; // 컴퓨터 숫자 세팅 여부를 판단하기 위한 변수 ( 새 게임마다 컴퓨터 숫자 값이 바뀌어야 함으로 사용 )
    static String reset; // 첫 게임이 끝난 이후 다시 하기와 종료하기 문자를 받기위한 변수 ( 1 or 2 만 가능 ) 이외 숫자 문자 예외처리

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        gameStart();
    }

    public static void gameStart() {
        // 스트라이크, 볼, 낫싱을 문자열로 빌드하여 출력하기 위해 선언
        // 매번 초기화 되어 들어가야함
        StringBuilder stringBuilder;
        // 컴퓨터의 패를 담을 변수 선언, 초기값은 null
        List<Integer> computerNumber = null;
        // reset : 1 -> 반복, reset : 2 -> 종료 (나머지는 예외처리)
        reset = "1";
        while (reset.equals("1")) {
            // 게임 시작 1회만 호출 ( 게임 패 설정 )
            if (!status) {
                computerNumber = computerSetNumber();
            }
            // status -> true 변경 ( 이후 다시 컴퓨터 패가 설정되지 않도록 하기 위함 )
            status = true;
            // StringBuilder 는 매번 초기화 해서 누적해서 담기지 않도록 함
            stringBuilder = new StringBuilder();
            // 실행 함수 시작
            run(computerNumber, stringBuilder);
        }
    }

    public static List<Integer> computerSetNumber() {
        List<Integer> numberSetList = new LinkedList<>();
        // 숫자는 3개만 담겨야 하기 때문에 3회 반복
        for (int i = 0; i < 3; ) {
            int choiceNumber = Randoms.pickNumberInRange(1, 9);
            // 중복된 수를 제거하기 위함
            if (!numberSetList.contains(choiceNumber)) {
                numberSetList.add(choiceNumber);
                i++;
            }
        }
        return numberSetList;
    }

    public static void run(List<Integer> computerNumber, StringBuilder stringBuilder) {
        System.out.print("숫자를 입력해주세요 : ");
        String number = Console.readLine();
        // number 문자 값 체크 ( 중복된 수는 없는가?, 문자의 길이가 3 이상인가? )
        ExceptionCheck(number);
        char[] numberSplit = number.toCharArray();

        // 스트라이크, 볼, 낫싱의 카운트를 진행하고 나온 문자열을 대입
        String strikeCount = strike(computerNumber, numberSplit);
        String ballCount = ball(computerNumber, numberSplit);
        String notingCount = noting(computerNumber, numberSplit);

        // 해당이 없으면 ""으로 더해지고, 있다면 해당 값이 더해짐
        stringBuilder.append(notingCount);
        stringBuilder.append(ballCount);
        stringBuilder.append(strikeCount);

        // 볼, 스트라이크, 낫싱 여부 출력
        System.out.println(stringBuilder);
        if (stringBuilder.toString().equals("3스트라이크")) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            // reset -> 1, 2만 입력으로 받을 수 있음
            reset = Console.readLine();
            // 문자, 1 or 2를 제외한 숫자 예외처리 함수
            resetExceptionCheck();
            // 게임이 끝났기 때문에 status -> false 로 변경
            status = false;
        }
    }

    public static void resetExceptionCheck() {
        if ("1".contains(reset) || "2".contains(reset)) {
            return;
        }
        throw new IllegalArgumentException();
    }

    public static void ExceptionCheck(String number) {
        if (number.length() != 3) {
            throw new IllegalArgumentException();
        }
        // 중복 문자열 처리 구문
        List<Character> list = new LinkedList<>();
        for (char value : number.toCharArray()) {
            list.add(value);
        }
        list = list.stream().distinct().collect(Collectors.toList());
        if (list.size() != 3) {
            throw new IllegalArgumentException();
        }
    }

    public static String strike(List<Integer> computerNumber, char[] numberSplit) {
        int strikeCount = 0;
        for (int i = 0; i < 3; i++) {
            if (computerNumber.get(i) == Integer.parseInt(String.valueOf(numberSplit[i]))) {
                strikeCount++;
            }
        }
        if (strikeCount > 0) {
            return strikeCount + "스트라이크";
        }
        return "";
    }

    public static String ball(List<Integer> computerNumber, char[] numberSplit) {
        int ballCount = 0;
        for (int i = 0; i < 3; i++) {
            if (computerNumber.get(i) != Integer.parseInt(String.valueOf(numberSplit[i])) &&
                    computerNumber.contains(Integer.parseInt(String.valueOf(numberSplit[i])))) {
                ballCount++;
            }
        }
        if (ballCount > 0) {
            return ballCount + "볼 ";
        }
        return "";
    }

    public static String noting(List<Integer> computerNumber, char[] numberSplit) {
        int notingCount = 0;
        for (int i = 0; i < 3; i++) {
            if (!computerNumber.contains(Integer.parseInt(String.valueOf(numberSplit[i])))) {
                notingCount++;
            }
        }
        if (notingCount == 3) {
            return "낫싱";
        }
        return "";
    }
}
