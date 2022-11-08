# 🚀숫자 야구

# 🚨 체크 리스트

---

- [Java 코드 컨벤션](https://github.com/woowacourse/woowacourse-docs/tree/master/styleguide/java) 가이드를 준수
- 기능 구현 후 **테스트 성공 여부** 확인
- **JDK 11 버전 확인**
- 프로그램 종료 시`System.exit()`호출 금지
- 구현이 완료되면 `ApplicationTest`의 모든 테스트가 성공 확인
- 요구 사항에 명시되어 있지않는 한 파일, 패키지 이름 수정, 이동 금지
- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
    - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
    - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- 3항 연산자를 쓰지 않는다.
- 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인한다.
- `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console` API를 사용하여 구현해야 한다.
    - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.
    - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.
    

# ✏️ 구현 기능 목록

---

- 게임시작
    - `숫자 야구 게임을 시작합니다.` 출력
    - 컴퓨터가 임의의 숫자 3개 선택
    - 입력값 받기
        - 사용자의 입력값
            - 잘못된 값을 입력하는 경우의 함수 → 클래스
                - 3자리 수 중 중복되는 값이 있는경우
                - 숫자가 아닌 다른 값이 입력되는 경우
                - 3자리 이외의 숫자를 입력한 경우
            - 숫자 입력 `숫자를 입력해주세요 : 123`
- 게임 진행
    - 같은 위치에 같은 숫자가 포함되어 있는 경우
        - 스트라이크 +1
    - 다른 위치에도 같은 숫자가 포함되어 있지 않는 경우
        - 볼 +1
    - 결과 문구 출력
        - 볼, 스트라이크 표시 `1볼 1스트라이크`
        - 모든 숫자를 맞힌 문구 `3개의 숫자를 모두 맞히셨습니다! 게임 종료`
    - 새 게임 진행 여부
        - `게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.`
        - 1 또는 2 입력
            - 1 또는 2가 입력되지 않은 경우
- 1이면 재시작 2이면 게임 종료
    
    

# ☑구현 확인

---

- [x]  게임시작
    - [x]  `숫자 야구 게임을 시작합니다.` 출력
    - [x]  컴퓨터가 임의의 숫자 3개 선택
    - [x]  입력값 받기
        - [x]  사용자의 입력값
            - [x]  잘못된 값을 입력하는 경우의 함수 → 클래스
                - [x]  세자리 수 인지 확인
                - [x]  숫자로 되어있는지 확인
                - [x]  3자리 수 중 중복되는 값이 없는지 확인
                - [x]  문자열을 리스트로 변환
            - [x]  숫자 입력 `숫자를 입력해주세요 : 123`
- [x]  게임 진행
    - [x]  같은 위치에 같은 숫자가 포함되어 있는 경우
        - [x]  스트라이크 +1
    - [x]  다른 위치에도 같은 숫자가 포함되어 있지 않는 경우
        - [x]  볼 +1
    - [x]  결과 문구 출력
        - [x]  볼, 스트라이크 표시 `1볼 1스트라이크`
        - [x]  모든 숫자를 맞힌 문구 `3개의 숫자를 모두 맞히셨습니다! 게임 종료`
    - [x]  새 게임 진행 여부
        - [x]  `게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.`
        - [x]  1 또는 2 입력
            - [x]  1 또는 2가 입력되지 않은 경우
- [x]  1이면 재시작 2이면 게임 종료