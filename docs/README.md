//1. 게임 시작 문구 <출력>
//2. 컴퓨터의 임의의 수 3자리 선택
//3. 숫자 3자리 입력 받기
//4. 입력한 수에 대한 결과 표시 출력
//5. 3스트라이크면 게임 종료 1(리셋)또는 2 입력
//6. 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.


//프로그래밍 요구 사항
-JDK 11 버전에서 실행 가능해야 한다. JDK 11에서 정상적으로 동작하지 않을 경우 0점 처리한다.
-프로그램 실행의 시작점은 Application의 main()이다.
-build.gradle 파일을 변경할 수 없고, 외부 라이브러리를 사용하지 않는다.
-Java 코드 컨벤션 가이드를 준수하며 프로그래밍한다.
-프로그램 종료 시 System.exit()를 호출하지 않는다.
-프로그램 구현이 완료되면 ApplicationTest의 모든 테스트가 성공해야 한다. 테스트가 실패할 경우 0점 처리한다.
-프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 이름을 수정하거나 이동하지 않는다.

//추가된 요구 사항
-indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
    예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
    힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
-3항 연산자를 쓰지 않는다.
-함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
-JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인한다.
    테스트 도구 사용법이 익숙하지 않다면 test/java/study를 참고하여 학습한 후 테스트를 구현한다.

//라이브러리
-camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용하여 구현해야 한다.
    Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.
    사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.

//사용 예시
List<Integer> computer = new ArrayList<>();
while (computer.size() < 3) {
    int randomNumber = Randoms.pickNumberInRange(1, 9);
    if (!computer.contains(randomNumber)) {
        computer.add(randomNumber);     
    }
}