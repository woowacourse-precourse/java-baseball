# 미션 - 숫자 야구

## 🔍 진행 방식

- 미션은 **기능 요구 사항, 프로그래밍 요구 사항, 과제 진행 요구 사항** 세 가지로 구성되어 있다.
- 세 개의 요구 사항을 만족하기 위해 노력한다. 특히 기능을 구현하기 전에 기능 목록을 만들고, 기능 단위로 커밋 하는 방식으로 진행한다.
- 기능 요구 사항에 기재되지 않은 내용은 스스로 판단하여 구현한다.

## 📮 미션 제출 방법

- 미션 구현을 완료한 후 GitHub을 통해 제출해야 한다.
    - GitHub을 활용한 제출 방법은 [프리코스 과제 제출](https://github.com/woowacourse/woowacourse-docs/tree/master/precourse) 문서를 참고해
      제출한다.
- GitHub에 미션을 제출한 후 [우아한테크코스 지원](https://apply.techcourse.co.kr) 사이트에 접속하여 프리코스 과제를 제출한다.
    - 자세한 방법은 [제출 가이드](https://github.com/woowacourse/woowacourse-docs/tree/master/precourse#제출-가이드) 참고
    - **Pull Request만 보내고 지원 플랫폼에서 과제를 제출하지 않으면 최종 제출하지 않은 것으로 처리되니 주의한다.**

## 🚨 과제 제출 전 체크 리스트 - 0점 방지

- 기능 구현을 모두 정상적으로 했더라도 **요구 사항에 명시된 출력값 형식을 지키지 않을 경우 0점으로 처리**한다.
- 기능 구현을 완료한 뒤 아래 가이드에 따라 테스트를 실행했을 때 모든 테스트가 성공하는지 확인한다.
- **테스트가 실패할 경우 0점으로 처리**되므로, 반드시 확인 후 제출한다.

### 테스트 실행 가이드

- 터미널에서 `java -version`을 실행하여 Java 버전이 11인지 확인한다. 또는 Eclipse 또는 IntelliJ IDEA와 같은 IDE에서 Java 11로 실행되는지 확인한다.
- 터미널에서 Mac 또는 Linux 사용자의 경우 `./gradlew clean test` 명령을 실행하고,   
  Windows 사용자의 경우  `gradlew.bat clean test` 명령을 실행할 때 모든 테스트가 아래와 같이 통과하는지 확인한다.

```
BUILD SUCCESSFUL in 0s
```

---

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
- 과제 진행 및 제출 방법은 [프리코스 과제 제출](https://github.com/woowacourse/woowacourse-docs/tree/master/precourse) 문서를 참고한다.

<br>

---

## 기능 구현 목록

### 순서도

<details>
    <summary>자세히 보기 </summary>

### 전체 순서도

<div style="text-align: center;">
    <img src="https://k.kakaocdn.net/dn/cuPvdZ/btrQDFSw62b/PkUZkGg9yQoCO4tcvT3M0k/img.png" width="200">  <img src="https://k.kakaocdn.net/dn/lIIcG/btrQFZCBA7i/MgKyxEUQH3SMCNu1678Yi1/img.png" width="400">
</div>

### RandomNumberGenerator
<div style="text-align: center";>
    <img src="https://k.kakaocdn.net/dn/dSeV4f/btrQD9Z3FuN/IwKzA62SP2pYjMhDhDqvdk/img.png" width="200">
</div>

### HandleErrorForUserInput

<div style="text-align: center";>
    <img src="https://k.kakaocdn.net/dn/uK7P2/btrQJb3HFK4/afLnkwPek8qqGVpE2qJjFk/img.png" width="400">
</div>

### CountStrikesAndBalls
<div style="text-align: center";>
    <img src="https://k.kakaocdn.net/dn/cGLJ2G/btrQDvP2OiW/iXQVHukV9aohejVl183gz1/img.png" width="300">
</div>
</details>

### 각 모듈 별 기능과 상세 설명

<details>
    <summary> 자세히 보기</summary>

| 모듈 (메서드, 묶음 단위) | 기능 이름 | 상세 설명 |
| --- | --- | --- |
| #1. 정수 난수 배열 생성 모듈 | 1-1) 배열 초기화 | 총 3개의 정수를 담을 수 있는 길이 3의 정수 배열을 초기화한다. |
|  | 1-2) 정수 난수 생성 | camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange(1,9)을 이용해 정수 난수를 생성한다. |
|  | 1-3) 배열에 정수 난수 추가 | 난수 배열에 이미 포함되어 있지 않은 수이면서, 배열 길이가 3이 아니라면 추가한다. 포함되어 있는 수라면, 다시 난수를 생성하도록 한다. |
| #2. 사용자 숫자 입력 | 2-1) 사용자에게 숫자 입력 받기 | camp.nextstep.edu.missionutils.Console의 readLine() 을 이용해 사용자 입력을 받는다. |
| #3. 입력 값 에러 이벤트 처리 | 3-1) 정수 배열 초기화 | 사용자로부터 입력 받은 3자리의 정수를 담을 배열을 초기화한다. |
|  | 3-2) 정수 여부 확인 | 정수가 3자리 숫자인지 확인한다. 아니라면, IllegalArgumentException  |
|  | 3-3) 3자리 확인 | 정수가 3자리 숫자인지 확인한다. 아니라면, IllegalArgumentException  |
|  | 3-4) 서로 다른 수 확인 | 사용자가 입력한 서로 다른 세 자리 수가 모두 다른 수인지, 정수 배열에 포함되어 있는 수인지  확인한다. 동일한 수가 이미 있다면, IllegalArgumentException  |
|  | 3-5) 범위 확인 (1~9) | 각 3자리 수가 모두 1~9 사이의 숫자인지 확인한다. (0 포함 여부 확인) 아니라면, IllegalArgumentException  |
|  | 3-6) 배열에 정수 추가 | 위의 모든 조건들을 만족하면, 해당 정수를 배열에 추가한다. |
| #4. 숫자 맞히기 | 4-1) 스트라이크 개수 구하기 | 사용자가 입력한 수로 만든 정수 배열의 요소가 컴퓨터가 생성한 난수 배열의 3개 중 몇 개 포함되어 있는지 개수를 구한다. |
|  | 4-2) 스트라이크 개수 확인 | 개수가 0이라면 “낫싱”을 출력하고, 아니라면 스트라이크 개수 중 볼 개수를 구하도록 한다. |
|  | 4-3) 볼 개수 구하기 | 사용자가 입력한 수의 각 자리의 수가 난수 배열의 위치와 동일한 것의 개수를 구한다. 그 개수만큼 스트라이크 개수에서 뺀다. |
|  | 4-4) 볼, 스트라이크 개수 출력 | 볼의 개수가 b, 스트라이크 개수가 s일 때, “b볼, s스트라이크” 형식으로 출력한다. 스트라이트가 0이라면 볼만 출력하고, 볼이 0이라면 스트라이크만 출력한다. |
|  | 4-5) 볼 개수 확인 | 볼의 개수가 3이라면, “3개의 숫자를 모두 맞히셨습니다! 게임 종료 \n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요” 를 출력한다. |
| #5. 사용자 다음 명령 입력 | 5-1) 사용자에게 다음 명령 숫자 입력 받기 | camp.nextstep.edu.missionutils.Console의 readLine() 을 이용해 사용자 입력을 받는다. |
|  | 5-2) 입력 값 확인과 에러 처리 | 입력한 값이 1 또는 2인지 확인한다. 아니라면, IllegalArgumentException  |
|  | 5-3) 다시 게임 시작  | 입력 값이 2라면 다시 게임을 시작한다. (사용자에게 숫자를 입력 받는 기능부터 시작) |
|  | 5-4) 게임 종료 | 입력 값이 1이라면 게임을 종료한다. |
|  |  |  |

</details>

### 각 기능에 대한 테스트들

<details>
    <summary>자세히 보기 </summary>

| 테스트 대상 기능번호 | 테스트 이름  | 입력 값 예시 | 예상 결과 / 에러처리 |
| --- | --- | --- | --- |
| 3-2 | 정수 외에 다른 문자를 포함하는 수 | 34Y, hello, 2B1, 3B, AB, A | IllegalArgumentException |
| 3-3 | 3자리 수가 아닌 수 | 12, 2444 | IllegalArgumentException |
| 3-4 | 동일한 숫자 발견 | 799, 252, 112 | IllegalArgumentException |
| 3-5 | 0을 포함한 수 | 980, 012, 305 | IllegalArgumentException |
| 4-1 스트라이크 개수 구하기 (정답: 123) | 3스트라이크 | 231, 312 | s: 3 |
|  | 1볼 2스트라이크 | 132, 321, 213 | s: 3 |
|  | 2볼 1스트라이크 | 127, 623, 193 | s: 3 |
|  | 3볼 | 123 | s: 3 |
|  | 2스트라이크 | 612, 219 | s: 2 |
|  | 1스트라이크 | 871, 762, 651 | s: 1 |
|  | 0스트라이크 | 876, 954 | 0 “낫싱” 출력 |
| 4-2 볼 개수 구하기 (정답: 123) | 1볼 2스트라이크 | 132, 321, 213 | s: 2, b: 1 |
|  | 2볼 1스트라이크 | 127, 623, 193 | s: 1, b: 2 |
|  | 3볼 | 123 | b: 3 |
| 5-2 사용자 다음 명령  | 1과 2가 아닌 정수, 문자열, 문자 | 0, 3, 142, ‘y’, ‘hello’, 24 | IllegalArgumentException |
| 5-3 게임 재시작 | 2인 경우 재시작 | 2 | “숫자를 입력하세요 : “ 부터 시작 |
| 5-3 게임 종료 | 1인 경우 종료 | 1 |  |

</details>