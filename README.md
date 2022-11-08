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

---

# 기능 목록 (최종 업데이트: 2022.11.08)

## 어플리케이션 설계

## 1. 클래스 `GameManager`

### 클래스 설명
- 게임의 진행을 관리하는 클래스이다. 싱글턴 패턴으로 사용된다.
- 게임을 시작하고, 사용자로부터 입력을 받아 결과를 보여주고, 게임을 계속 진행하거나 종료한다.
- 단, 사용자 입력의 유효성을 검증하거나, 사용자 입력의 결과를 계산하는 등의 게임 진행 밖의 책임은 다른 클래스에 위임한다. 

### 멤버 변수
  - `private GameStatus gameStatus`: 현재 게임의 진행 상태를 나타내며, 실행 중(`PLAYING`)과 정지(`STOPPED`)로 구분된다.  
  - `private String computerNumber`: 게임의 각 회차(round)마다 사용자가 맞혀야 하는 컴퓨터 번호를 저장한다.

### 정적 변수
  - `private static GameManager gameManager`: 싱글턴 패턴으로 생성된 `GameManager` 인스턴스를 저장한다.

### 멤버 메서드
- **생성자**
  - `private GameManager()` 
- **싱글턴 인스턴스를 반환하는 기능**
  - `public GameManager getGameManager()`
  - 싱글턴 `GameManager` 인스턴스를 반환한다.
  - 어플리케이션이 시작될 때 `Program` 클래스의 `main` 함수에서 오직 한 번 호출된다.
- **게임을 실행하는 기능**
  - `public void runGame()`
  - 어플리케이션을 시작할 때, `main` 함수에서 호출되면서 게임을 개시한다.
  - 게임을 진행하기 위한 메서드(사용자 입력 받아오기, 입력값 검증 등)를 내부적으로 호출한다.
  - 사용자가 게임 완전 종료를 명령할 때까지 본 함수의 호출은 종료되지 않는다.
- **게임의 실행 상태를 확인하는 기능**
  - `private boolean isGamePlaying()`
  - 게임이 실행 중(`this.gameStatus == PLAYING`)일 경우 `true`를 반환한다.
  - 게임이 중지 상태(`this.gameStatus == STOPPED`)일 경우 `false`를 반환한다.
- **컴퓨터 번호를 생성하는 기능**
  - `private String generateComputerNumber()`
  - 게임의 각 회차(round)마다 사용자가 맞혀야 하는, 서로 다른 숫자 세 개로 된 번호를 생성한다.
- **새로운 컴퓨터 번호를 설정하는 기능**
  - `private void setComputerNumber(String computerNumber)`
  - 새로운 컴퓨터 번호를 인자로 받아 `this.ComputerNumber`에 설정한다.
  - 새로운 회차(round)가 시작될 때마다 호출된다.
- **사용자 번호 입력을 받아오는 기능**
  - `private String getPlayerNumber()`
  - 표준 입력 스트림(`System.in`)으로부터 사용자 입력을 받아온다.
  - 사용자가 입력한 번호는 `runGame` 메서드 내에서 유효성 검사를 위해 즉시 `PlayerNumberValidator` 클래스에 전달된다.
- **힌트 결과에 따라 게임 흐름을 제어하는 기능**
  - `private void processGameFlowAccordingToHint(String hint)`
  - 사용자 번호와 컴퓨터 번호를 대조한 결과가 `3스트라이크`가 아니면 현재 회차(round)가 계속 진행되도록 즉시 게임 흐름 제어를 `runGame`에 반환한다.
  - 만약 `3스트라이크`라면 사용자가 컴퓨터 번호를 맞췄음을 표준 출력 스트림에 알린다.
  - 그 후 `shouldPlayContinue` 메서드를 내부 호출하여 사용자가 게임을 계속 진행하길 희망하는지 확인한다.
  - 마지막으로 사용자의 게임 계속 여부를 `stopOrContinueGame` 메서드에 전달함으로써 게임 흐름 제어권을 옮긴다.   
- **사용자의 게임의 계속 진행 희망 여부를 확인하는 기능**
  - `private boolean shouldPlayContinue()`
  - 표준 입력 스트림으로부터 사용자의 게임 계속 진행 희망 여부를 받아와서 확인한다.
  - 사용자가 계속 진행을 선택했으면(`1`을 눌렀으면) `true`, 아니라면(`2`를 눌렀으면) `false`를 반환한다.
  - 사용자가 잘못된 입력(`1` 또는 `2` 외의 입력)을 전달했을 경우 `IllegalArgumentException`을 발생시킨다.
- **사용자의 게임 계속 진행 희망 여부에 따라 게임 진행 상태를 변경하는 기능**
  - `private void stopOrContinueGame(boolean shouldGameContinue)`
  - 사용자가 게임 중지를 선택했을 경우 `changeGameStatusToStop`을 내부 호출하여 게임 진행 상태를 변경한다.
  - 사용자가 게임 계속 진행을 선택했을 경우, 새 회차(round)를 진행하기 위해 `generateComputerNumber`와 `setComputerNumber`를 차례로 호출하여 새로운 컴퓨터 번호를 지정한다.
- **게임의 진행 상태를 중지로 변경하는 기능**
  - `private void changeGameStatusToStop()`
  - 게임의 진행 상태(`this.gameStatus`)를 중지(`STOPPED`)로 변경한다.

---

## 2. 클래스 `PlayerNumberValidator`

### 클래스 설명
  - `GameManager`가 사용자로부터 받은 번호가 게임에서 허용하는 형식인지 확인하는 클래스이다.
  - 본 클래스의 모든 메서드는 정적이며, 인스턴스 또한 생성할 수 없다.

### 동작 (정적 메서드)
  - **사용자 입력이 유효하지 않으면 예외를 발생시키는 기능**
    - `public static void throwIllegalArgumentExceptionIfPlayerNumberNotValid(String playerNumberOrNull)`
    - 내부에서 `isPlayerNumberValid` 메서드를 릴레이 호출한다. 그 값이 `true`면 즉시 반환한다. 
    - `false`면 `IllegalArgumentException`을 발생시켜 호출자에 `throw`한다. 
  - **사용자 입력이 유효한 형식인지 확인하는 기능**
    - `private static boolean isPlayerNumberValid(String playerNumberOrNull)`
    - 사용자가 입력한 사용자 번호가 유효한 형식인지 확인한다.
    - 이를 위해서 아래 세 개 메서드를 도우미 함수로 사용한다.
  - **사용자 입력의 길이가 유효한지 확인하는 기능**
    - `private static boolean isPlayerNumberLengthValid(String playerNumber)`
    - 사용자 번호의 길이가 게임에서 유효하다고 취급하는 길이인지 확인한다.
    - 유효한 길이의 값은 열거형 `GameConstant`의 `VALID_NUMBER_LENGTH`의 `value` 멤버 변수에 지정되어 있다.
  - **문자열의 한 문자가 1~9 범위 숫자인지 확인하는 기능**
    - `private static boolean isNumericLiteralBetweenOneAndNine(char c)`
    - 사용자 번호의 한 문자가 1에서 9의 양 끝을 포함하는 사이의 숫자인지 확인한다.
    - 인자 `char c`가 1~9 사이 숫자면 `true`, 그렇지 않으면 `false`를 반환한다.
  - **숫자 중복 여부를 확인하는 기능**
    - `private static boolean isDuplicateNumericLiteral(char numericLiteral, boolean[] checkArray)`
    - 사용자 번호의 한 숫자가 이미 앞쪽에서 그 존재가 확인된 숫자인지 확인한다.
    - 호출 시 전달되는 인자 `numericLiteral`은 1~9 사이의 숫자라고 전제한다. 

---

## 3. 클래스 `ResultEvaluator`

### 클래스 설명
- 컴퓨터 번호와 사용자 번호를 대조하여 결과(볼 및 스트라이크 개수)를 계산하고, 그 결과를 '힌트' 문자열로 반환하는 클래스이다.
- 본 클래스의 모든 메서드는 정적이며, 인스턴스 또한 생성할 수 없다.

### 동작 (정적 메서드)
- **'힌트'를 반환하는 기능**
  - `public static String getHint(String computerNumber, String playerNumber)`
  - 내부적으로 `getScore`를 호출하여 점수를 계산하고, 이 점수를 `translateScoreToHint`를 통해 일정한 형식의 문자열(예: "3스트라이크", "낫싱", "1볼 2스트라이크" 등)로 변환하여 호출자에 반환한다.
  - 이 함수의 호출자인 `GameManager`는 반드시 **유효한** 컴퓨터 번호와 **유효한** 사용자 번호를 인자로 전달해야 한다.
- **컴퓨터 번호와 사용자 번호를 대조하여 점수를 계산하는 기능**
  - `private static Score getScore(String computerNumber, String playerNumber)`
  - 컴퓨터 번호와 사용자 번호를 대조하여 볼과 스트라이크 개수를 계산한다.
  - 계산된 값을 기반으로 `Score` 타입 개체를 생성 및 반환한다.
- **특정 숫자의 '스트라이크' 여부를 판단하는 기능**
  - `private static int isStrikeOrNot(String computerNumber, String playerNumber, int index)`
  - 사용자 번호의 특정 색인(`index`)에 위치한 숫자가, 컴퓨터 번호의 같은 색인에 위치할 경우, `스트라이크`라는 의미로 `1`을 반환한다. 그렇지 않을 경우, `0`을 반환한다. 
- **특정 숫자의 '볼' 여부를 판단하는 기능**
  - `private static int isBallOrNot(String computerNumber, String playerNumber, int index)`
  - 사용자 번호의 특정 색인(`index`)에 위치한 숫자가, 컴퓨터 번호의 특정 색인(`index`)을 **제외한** 나머지 색인 어딘가에 존재할 경우, `볼`이라는 의미로 `1`을 반환한다. 그렇지 않을 경우, `0`을 반환한다.
- **점수를 힌트 문자열로 변환하는 기능** 
  - `private static String translateScoreToHint(Score score)`
  - `Score` 타입의 점수를 인자로 받아 이를 일정 형식의 힌트 문자열로 변환한다.
    - 볼의 개수가 `n`, 스트라이크 개수가 `m`일 경우 `n볼 m스트라이크` 형식의 문자열로 변환된다.
    - `n`과 `m` 중 어느 하나만 0일 경우, 0인 쪽은 문자열로 나타내지 않는다.
    - 예를 들어 볼이 0개이며 스트라이크가 2개일 경우, `2스트라이크` 문자열로 변환한다.
    - `n`과 `m` 모두 0일 경우, `낫싱` 문자열을 반환한다. 

---

## 4. 클래스 `Score` (DTO 클래스)

### 클래스 설명
- 각 회차의 컴퓨터 번호와 사용자 입력 번호를 대조한 결과를 저장하는 DTO(Data Transfer Object) 클래스이다.

### 상태 (멤버 변수)
  - `private final int numBalls`: 사용자가 획득한 '볼' 개수
  - `private final int numStrikes`: 사용자가 획득한 '스트라이크' 개수

### 동작 (멤버 메서드)
- **생성자**
  - `public Score(int numBalls, int numStrikes)`
  - 컴퓨터 번호와 사용자 입력 번호를 대조한 결과(볼과 스트라이크 개수)를 매개변수로 받아 새로운 인스턴스를 생성 및 반환한다.
- **사용자 점수에서 '볼' 개수를 반환하는 기능**
  - `public int getBallCount()`
  - 인스턴스에 저장된 볼 개수를 반환한다.
- **사용자 점수에서 '스트라이크' 개수를 반환하는 기능**
  - `public int getStrikeCount()`
  - 인스턴스에 저장된 스트라이크 개수를 반환한다.

---

## 5. 열거형 `GameStatus`

### 클래스 설명
- 게임의 진행 상황을 나타내는 열거형 클래스이다.
### 값
- `PLAYING`: 게임이 진행 중임을 뜻하는 값이다.
- `STOPPED`: 게임이 완전 종료(실행 중지) 상태임을 뜻하는 값이다.

---

## 6. 열거형 `GameConstant`

### 클래스 설명
- 어플리케이션 전체에서 공통적으로 사용되는 값을 정의한 열거형 클래스이다.
- 열거형의 각 값은 실제 `int` 값을 나타내는 `value`를 멤버 변수로 가진다.  
### 값
  - `VALID_NUMBER_LENGTH`: 유효한 컴퓨터/사용자 번호의 길이를 나타내는 값이다.
    - 실제 정수 값은 기본 `3`으로 설정되어 있다.