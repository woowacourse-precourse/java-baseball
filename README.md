# 숫자 야구 과제 (이충안)

### 과제 진행 관련 자료
- [문제 내용(우테코 Github Repository)](https://github.com/woowacourse-precourse/java-onboarding)
- [공부한 내용(Notion)](https://brass-thrush-37b.notion.site/2-605811a6d6b64da8aa8d0bc372b9242d)
- [회고록(velog)](https://velog.io/@gwichanlee/%EC%9A%B0%ED%85%8C%EC%BD%94-4%EA%B8%B0-%ED%94%84%EB%A6%AC%EC%BD%94%EC%8A%A4-2%EC%A3%BC%EC%B0%A8-%ED%9A%8C%EA%B3%A0)

## 🔍 설계에서 신경쓴 점

### 확장성 고려
- 숫자 야구 게임에서 3자리가 아닌 다른 자릿수에서도 확장해서 만들 수 있도록 함
    - 예시) 4자리 숫자야구, 5자리 숫자 야구
- 다른 게임 형식으로도 확장할 수 있도록 함
    - 예시) 숫자 UpDown, 숫자 맞추기
- Input, Output 방식을 확장할 수 있도록 함

### 도메인 분리
- 우선적으로 구현해야 할 기능 목록을 전부 생각함
- 현실세계와 대응하여 도메인을 분리함
- 도메인마다 적절한 책임을 부여하여 도메인별로 기능을 구현함
- 이외 한 Class에서 역할이 많을 경우, 다른 Class로 기능을 분리함

### 관련 Markdown 문서
- [구현했던 과정](./docs/PROCESS.md)
- [구현 기능 목록](./docs/README.md) : 최대한 작업 단위로 나누려고 노력함

## 🔍 구현에서 신경쓴 점

### Convention
- 우테코에서 제공하는 Convention을 지키려 노력함
  - [Coding Covention 정리](https://brass-thrush-37b.notion.site/Coding-Convention-d1f89bdfb8954e4d914d89d294a934e9)
  - [Git Convention 정리](https://brass-thrush-37b.notion.site/Git-Convention-99cb6513d4a4446a8a9ddf268fbd0e44)

### 메서드 구현
- 최대한 하나의 메서드에는 하나의 기능만 넣기 위해 노력함
- 주석 사용을 최대한 안하고, 메서드 이름이나 변수 이름 만으로도 코드를 이해할 수 있게 노력함
- java stream을 이용해 최대한 주어진 API를 이용해 간결하게 표현하려고 노력함
- 예시 (BaseballResponse.java의 일부 코드)
    ```java
    private int countStrike(List<Integer> answer, List<Integer> candidate) {
        return (int) IntStream.range(0, answer.size())
                .filter(index -> answer.get(index) == candidate.get(index))
                .count();
    }

    private int countBall(List<Integer> answer, List<Integer> candidate) {
        return (int) IntStream.range(0, candidate.size())
                .filter(index -> isInListAndIndexNotMatched(answer, candidate.get(index), index))
                .count();
    }

    private boolean isInListAndIndexNotMatched(List<Integer> list, int number, int index) {
        return IntStream.range(0, list.size())
                .filter(listIndex -> listIndex != index)
                .filter(listIndex -> list.get(listIndex) == number)
                .count() != 0;
    }
    ```

### 유닛 테스트
- 최대한 단위 기능마다 유닛 테스트를 구현함
- Mockito를 사용하여 테스트 대상과 다른 객체의 결과에 의해 영향을 받지 않으려 함
- 리팩토링 후에는 단위 테스트 통과를 항상 확인함

---
# 과제 요구 사항
- 아래의 요구 사항들을 지키기 위해 최대한 노력하였음

## 🚀 기능 요구 사항

기본적으로 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.

- 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 낫싱이란 힌트를 얻고, 그 힌트를 이용해서 먼저 상대방(컴퓨터)의 수를 맞추면 승리한다.
    - 예) 상대방(컴퓨터)의 수가 425일 때
        - 123을 제시한 경우 : 1스트라이크
        - 456을 제시한 경우 : 1볼 1스트라이크
        - 789를 제시한 경우 : 낫싱
- 위 숫자 야구 게임에서 상대방의 역할을 컴퓨터가 한다. 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다. 게임 플레이어는 컴퓨터가 생각하고 있는 서로 다른 3개의 숫자를 입력하고, 컴퓨터는 입력한 숫자에 대한
  결과를 출력한다.
- 이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.
- 게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.

### 입출력 요구 사항

#### 입력

- 서로 다른 3자리의 수
- 게임이 끝난 경우 재시작/종료를 구분하는 1과 2 중 하나의 수

#### 출력

- 입력한 수에 대한 결과를 볼, 스트라이크 개수로 표시

```
1볼 1스트라이크
```

- 하나도 없는 경우

```
낫싱
```

- 3개의 숫자를 모두 맞힐 경우

```
3스트라이크
3개의 숫자를 모두 맞히셨습니다! 게임 종료
```

- 게임 시작 문구 출력

```
숫자 야구 게임을 시작합니다.
``` 

#### 실행 결과 예시

```
숫자 야구 게임을 시작합니다.
숫자를 입력해주세요 : 123
1볼 1스트라이크
숫자를 입력해주세요 : 145
1볼
숫자를 입력해주세요 : 671
2볼
숫자를 입력해주세요 : 216
1스트라이크
숫자를 입력해주세요 : 713
3스트라이크
3개의 숫자를 모두 맞히셨습니다! 게임 종료
게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.
1
숫자를 입력해주세요 : 123
1볼
...
```

---

## 🎯 프로그래밍 요구 사항

- JDK 11 버전에서 실행 가능해야 한다. **JDK 11에서 정상적으로 동작하지 않을 경우 0점 처리한다.**
- 프로그램 실행의 시작점은 `Application`의 `main()`이다.
- `build.gradle` 파일을 변경할 수 없고, 외부 라이브러리를 사용하지 않는다.
- [Java 코드 컨벤션](https://github.com/woowacourse/woowacourse-docs/tree/master/styleguide/java) 가이드를 준수하며 프로그래밍한다.
- 프로그램 종료 시 `System.exit()`를 호출하지 않는다.
- 프로그램 구현이 완료되면 `ApplicationTest`의 모든 테스트가 성공해야 한다. **테스트가 실패할 경우 0점 처리한다.**
- 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 이름을 수정하거나 이동하지 않는다.

### 추가된 요구 사항

- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
    - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
    - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- 3항 연산자를 쓰지 않는다.
- 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인한다.
    - 테스트 도구 사용법이 익숙하지 않다면 `test/java/study`를 참고하여 학습한 후 테스트를 구현한다.

### 라이브러리

- `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console` API를 사용하여 구현해야 한다.
    - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.
    - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.

#### 사용 예시

```java
List<Integer> computer = new ArrayList<>();
while (computer.size() < 3) {
    int randomNumber = Randoms.pickNumberInRange(1, 9);
    if (!computer.contains(randomNumber)) {
        computer.add(randomNumber);
    }
}
```

---

## ✏️ 과제 진행 요구 사항

- 미션은 [java-baseball](https://github.com/woowacourse-precourse/java-baseball) 저장소를 Fork & Clone해 시작한다.
- **기능을 구현하기 전 `docs/README.md`에 구현할 기능 목록을 정리**해 추가한다.
- **Git의 커밋 단위는 앞 단계에서 `docs/README.md`에 정리한 기능 목록 단위**로 추가한다.
    - [커밋 메시지 컨벤션](https://gist.github.com/stephenparish/9941e89d80e2bc58a153) 가이드를 참고해 커밋 메시지를 작성한다.