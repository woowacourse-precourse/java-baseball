## 기능 요구사항

### Constants

- [ ]  `RESTART_NUM` : 1
- [ ]  `END_NUM` : 2
- [ ]  `GAME_INPUT_LENGTH` : 3
- [ ]  *`RESTART_INPUT_LENGTH` : 1*
- [ ]  Result class
    - [ ]  `BALL_WORD` : 볼
    - [ ]  `STRIKE_WORD` : 스트라이크
    - [ ]  `NOTHING_WORD` : 낫싱
- [ ]  Message class
    - [ ]  `START_MSG` : 숫자 야구 게임을 시작하겠습니다.
    - [ ]  `INPUT_MSG` : 숫자를 입력해주세요 :
    - [ ]  `END_MSG` : 3개의 숫자를 모두 맞히셨습니다! 게임 종료
    - [ ]  `RESTART_MSG` : 게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.

### 입출력 요구 사항

- 입력 요구 사항
    - [ ]  서로 다른 3자리의 수를 입력받는 함수
        - [ ]  예외 처리 함수
            - [ ]  입력된 문자열의 길이가 3이 아닐 경우
            - [ ]  입력된 문자열이 숫자가 아닌 경우
            - [ ]  입력된 문자열에 중복된 숫자가 있는 경우
    - [ ]  게임이 끝난 경우 재시작/종료를 구분하는 1과 2 중 하나의 수를 입력받는 함수
        - [ ]  예외 처리 함수
            - [ ]  입력된 문자열의 길이가 1이 아닐 경우
            - [ ]  입력된 문자열이 숫자가 아닌 경우
            - [ ]  입력된 문자열이 1 또는 2가 아닌 경우

- 출력 요구 사항
    - [ ]  볼, 스트라이크 개수를 출력하는 함수

### 기능 요구 사항

- [ ]  전체 게임을 관리하는 메인 함수
- [ ]  한 게임을 관리하는 함수
- 게임 진행
    - [ ]  1에서 9까지 서로 다른 임의의 수 3개를 선택, 배열로 변환 함수
    - [ ]  플레이어가 입력한 3자리의 수를 배열 형태로 변환하는 함수
    - [ ]  스트라이크 개수를 판별하는 함수
    - [ ]  두 사용자 간의 겹치는 숫자의 개수를 판별하는 함수
- 게임 종료
    - [ ]  게임이 끝난 경우 입력받은 문자열에서 게임 재시작/종료를 판별하는 함수

### 테스트케이스

- [ ]  게임 재시작 테스트
- [ ]  “n볼 n스트라이크” 출력 테스트
- [ ]  “n볼” 출력 테스트
- [ ]  “n스트라이크” 출력 테스트
- [ ]  “낫싱” 출력 테스트
- [ ]  컴퓨터 중복 숫자 처리 테스트
- [ ]  플레이어 입력 길이 3자리 미만일 때 `IllegalArgumentException` 테스트
- [ ]  플레이어 입력 길이 3자리 초과일 때 `IllegalArgumentException` 테스트
- [ ]  플레이어 입력 문자열에 0 있을 때 `IllegalArgumentException` 테스트
- [ ]  플레이어 입력 문자열에 숫자가 아닌 문자가 있을 때 `IllegalArgumentException` 테스트
- [ ]  플레이어 입력 문자열에 중복 문자 있는 경우 `IllegalArgumentException` 테스트
- [ ]  재시작/종료 입력 시 1,2가 아닌 다른 숫자 입력할 경우 `IllegalArgumentException` 테스트
- [ ]  재시작/종료 입력 시 숫자가 아닌 문자 입력할 경우 `IllegalArgumentException` 테스트

## 프로그래밍 요구사항

- [ ]  Java 코드 컨벤션 가이드 적용 (우테코)
- [ ]  indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현
- [ ]  3항 연산자를 사용 금지
- [ ]  함수(또는 메서드)가 한 가지 일만 실행
- [ ]  JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인

### 라이브러리

- [ ]  사용자가 입력하는 값 : `camp.nextstep.edu.missionutils.Console`의 `readLine()`
- [ ]  Ramdom 값 추출 : `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`

```java
List<Integer> computer = new ArrayList<>();
while (computer.size() < 3) {
    int randomNumber = Randoms.pickNumberInRange(1, 9);
    if (!computer.contains(randomNumber)) {
        computer.add(randomNumber);
    }
}
```