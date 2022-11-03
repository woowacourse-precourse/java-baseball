package baseball;

public class Application {
    //잘못된 입력을 받을 경우
    public static void IllegalInput(int input) {
        //입력이 3자리의 숫자가 아님
        if(String.valueOf(input).length()!=3){
            throw new IllegalArgumentException("올바른 값을 입력해주세요.");
        }
    }

    public static void main(String[] args) {
        System.out.print("숫자 야구 게임을 시작합니다.");
    }
}


//구현 목록
//잘못된 입력을 처리하는 함수
//입력과 값이 맞는 경우인지를 확인하는 함수
//게임 시작 문구를 출력하는 함수 -> 다 맞으면 함수 다시 출력
