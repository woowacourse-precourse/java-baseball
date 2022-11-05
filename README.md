## 기능 목록
  - [x] `숫자 야구 게임을 시작합니다.` View를 보여준다.
  - [x] 상대는 컴퓨터이며, 컴퓨터가 3개의 숫자를 랜덤으로 뽑는다.
  - [x] 숫자를 입력 받는 View 보여준다.
  - [x] 숫자를 입력 받는다.
  - [x] 사용자가 입력한 숫자가 얼마나 일치하는지 판단한다.
  - [x] 사용자가 입력한 숫자의 일치 여부에 따라 View를 보여준다.
  - [x] 3개의 숫자를 다 맞힐때까지 반복한다.
  - [x] 만약 3개의 숫자를 모두 다 맞힌다면 `3개의 숫자를 모두 맞히셨습니다! 게임 종료` View를 보여준다.
  - [x] `게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.` View를 보여준다.
  - [x] 1을 누른다면 게임을 재시작한다.
  - [x] 2를 누른다면 게임을 종료한다.

## 예외 처리
- [ ] 입력한 숫자가 3개인가
- [ ] 숫자만 입력했는가
- [ ] 1부터 9까지의 숫자만 입력했는가
- [ ] 게임 종료 여부를 물을 때 1 또는 2만 입력헀는가
- [ ] 컴퓨터가 서로 다른 3개의 수를 뽑았는가

## 요구 사항
* `indent(인덴트, 들여쓰기)` `depth`를 `3`이 넘지 않도록 구현한다. `2까지만 허용`한다.
* 예를 들어 `while문` 안에 `if문`이 있으면 들여쓰기는 `2`이다.
* `힌트` : `indent(인덴트, 들여쓰기)` `depth`를 줄이는 좋은 방법은 `함수(또는 메서드)`를 `분리`하면 된다.
* `3항 연산자`를 쓰지 않는다.
* `함수(또는 메서드)`가 `한 가지 일`만 하도록 최대한 작게 만들어라.
* `JUnit 5`와 `AssertJ`를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 `테스트 코드`로 확인한다.
* 테스트 도구 사용법이 익숙하지 않다면 `test/java/study`를 참고하여 학습한 후 테스트를 구현한다.
* `JDK 11` 버전에서 실행 가능해야 한다. JDK 11에서 정상적으로 동작하지 않을 경우 0점 처리한다.
* `build.gradle`을 변경할 수 없고, `외부 라이브러리`를 사용하지 않는다.
* 프로그램 종료 시 `System.exit()`를 호출하지 않는다.
* 프로그램 구현이 완료되면 `ApplicationTest`의 모든 테스트가 성공해야 한다. 테스트가 실패할 경우 0점 처리한다.
* 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 이름을 `수정`하거나 `이동`하지 않는다.
