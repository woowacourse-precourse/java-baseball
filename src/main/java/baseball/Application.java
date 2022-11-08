package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


public class Application {
    public static void main(String[] args) throws IllegalStateException {
        Game game = new Game();
        while(game.play()){}
    }
}


        //1~9까지서로 다른수로 이루어진 3자리수를 맞추는 게임
        //컴퓨터가 상대방.
        //게임시작 문구 출력
        // 출력 : (숫자 야구 게임을 시작합니다.)

        //반복(
        //컴퓨터가 1~9까지 서로다른 임의의수 3개 선택
        // 출력 : (숫자를 입력해주세요 :)
        //플레이어는 서로다른3개의수 입력후
        // 스트라이크 볼 낫싱 확인
        // 출력 :1볼 1스트라이크
        // 출력 :낫싱)
        //3스트라이크 의 경우
        // 출력 :3개의 숫자를 모두 맞히셨습니다! 게임종료

        //종료후 게임을 다시하거나 1. 완전히 종료 2. 할수있음
        //사용자가 잘못된 값 입력할경우 IllegalArgumentException 발생후 에플 종료

        //요구사항 들여쓰기 는 2까지만 허용
        //3항 연산자 사용 금지
        //함수가 한가지 일만 하도록 만들기
        // 만들 클래스.. 컴퓨터클레스 인스턴스 변수 1~9숫자 , list사용시 size 3? 넘어가면 예외발생
        // 컴퓨터 메서드 1.서로다른 임의의수 3개 생성,2.플레이어 입력한 수와 임의의 수 비교 ,3.입력수가 저장수와 같을때 문자 출력
        //


