package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 출력: 숫자 야구 게임을 시작합니다.
        startGame();
    }
    private static void startGame(){
        String correctNumber = settingNumber();
        askAndAnswerLoop(correctNumber);
    }
    private static String settingNumber(){
        String randomNumber = "123";
        // 컴퓨터의 숫자 3개 만들기.
        return randomNumber;
    }

    private static void askAndAnswerLoop(String correctNumber){
        String askNumber;
        boolean loop = true;
        while (loop) {
            askNumber = getNumber();
            loop = compareOfNumber(correctNumber, askNumber);
        }
        // 종료문구 출력
        if (askRetry()){
            startGame();
        }
    }

    private static String getNumber(){
        String askNumber = "";
        //사용자에게 숫자 3개 입력받고 예외 검사
        return askNumber;
    }

    private static boolean compareOfNumber(String correctNumber, String askNumber){
        // 비교하며, 몇 볼, 몇 스트라이크 or 낫싱 인지 출력
        // 만약 3스트라이크면 false 반환
        return true;
    }

    private static boolean askRetry(){
        // 입력받기
        return false;
    }
}
