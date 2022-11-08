package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
}

// 기능 요구 사항
// 1. docs/README.md에 작성

// 프로그래밍 요구 사항
// 1.JDK 11 버전 확인
// 2.프로그램 실행의 시작점은 Application의 main()
// 3.build.gradle 파일을 변경할 수 없고, 외부 라이브러리를 사용 금지
// 4.Java 코드 컨벤션 가이드를 준수하며 프로그래밍
// 5.프로그램 종료 시 System.exit()를 호출 금지
// 6.프로그램 구현이 완료되면 ApplicationTest의 모든 테스트의 성공 확인
// 7.프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 이름을 수정하거나 이동 금지

// 추가된 요구 사항
// 1.indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현 (2까지만 허용)
//   예를 들어 while문 안에 if문이 있으면 들여쓰기는 2
//   힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하는 것
// 2.3항 연산자 금지
// 3.함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들기
// 4.JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인
// 5.테스트 도구 사용법이 익숙하지 않다면 test/java/study를 참고하여 학습한 후 테스트를 구현

// 라이브러리
// 1.camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용하여 구현해야 한다.
// 2.Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.
// 3.사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.

// 과제 진행 요구 사항
// 1.미션은 java-baseball 저장소를 Fork & Clone해 시작
// 2.기능을 구현하기 전 docs/README.md에 구현할 기능 목록을 정리해 추가
// 3.Git의 커밋 단위는 앞 단계에서 docs/README.md에 정리한 기능 목록 단위로 추가
// 4.커밋 메시지 컨벤션 가이드를 참고해 커밋 메시지를 작성
// 5.과제 진행 및 제출 방법은 프리코스 과제 제출 문서를 참고
