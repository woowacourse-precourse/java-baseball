## 기능 목록

### 기능적 요구사항

- 입력
    - 입력값 검증
        - 3자리인지
        - 잘못된 값 입력 시 -> IllegalArgumentException()을 발생
    - 게임이 끝난 경우(컴퓨터 수를 맞춘 경우)
        - 1이면 재시작
        - 2이면 종료

- 게임
    - 컴퓨터의 랜덤 수 정의
    - 컴퓨터 수를 맞출 때까지 반복
        - 사용자의 수를 돌면서 컴퓨터 수 확인
        - 그에 맞는 볼/스트라이크/낫싱 return

### 비기능적 요구사항

- 테스트 케이스를 모두 통과할 것
- 종료 시 System.exit()를 호출 금지
- 삼항 연산자 사용 지양
- 코드의 depth는 최대 2.
- 함수는 한 가지 일만 하도록 동작
- 라이브러리 사용할 것
    - camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용하여 구현
    - Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 `pickNumberInRange(인자1, 인자2)`를 활용 ->
      인자1 ~ 인자2 사이의 숫자 한 개 뽑는 함수
    - 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 `readLine()`을 활용 -> 입력값 문자열로 받는 함수

## 커밋 컨벤션

- 영어로 작성
- `type: detail text` 형태로 작성
- type
    - feat (feature)
    - fix (featrue fix and bugfix)
    - docs (documentation)
    - style (formatting, missing semi colons, …)
    - refactor
    - test (when adding missing tests)
