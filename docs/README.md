# 💻 흐름
- 상대방(컴퓨터)의 숫자를 만들고, 게임을 시작한다.
- 사용자의 숫자를 입력받는다.
- 숫자에 대한 결과를 알려준다.
  - 만약 3스트라이크라면, 게임 종료 문구를 출력하고 추가 진행 여부를 묻는다.
- 게임 추가 진행 여부에 따라 게임을 재개하거나 종료한다.

# 💡필요한 기능
- [x] (Computer) 컴퓨터의 숫자를 생성하는 기능
- [x] (Computer) 입력에 대한 유효성을 확인하는 기능
- [x] (User) 사용자의 입력을 받는 기능
- [x] (User) 입력에 대한 유효성을 확인하는 기능
- [x] (User) 게임의 추가 진행 여부 확인을 위해 사용자 입력을 받는 기능
- [x] (Result) 숫자 야구 결과(점수)를 받아 결과를 enum으로 반환하는 기능
  - 점수가 음수거나, 정의한 enum에 없는 경우 `IllegalArgumentException`
- [x] (Status) 사용자의 옵션에 따라 게임의 상태를 반환하는 기능
  - 옵션이 enum에 없는 경우 `IllegalArgumentException`

## 🔧 리팩토링
1. TODO 2, 3, 5 기준으로 메소드 추출
   - [x] `initGame()`
   - [x] `playGameUntil3S()`
   - [x] `changeStatusByOption()`
2. 메소드의 indent에 따른 메소드 추가 추출
   - [x] `calculateScore()`, `computeScoreIndex()`
3. `Application`에 존재하는 로직을 모두 `Game` 클래스로 이동
   - `Application`에는 `Game.startGame()`만 존재
4. `Game`에 존재하는 점수 계산 로직을 `Calculator` 클래스로 이동
5. 불필요한 `try-catch` 제거 및 `IllegalArgumentException` 처리에 사용하는 `String` 수정
   - `User` 클래스에서 예외를 던질 때 메세지를 함께 전달하기 위해 `User` 클래스로 이동
     - 숫자 입력 예외 메세지와 옵션 입력 예외 메세지 분리
   - `Result`와 `Status`에서 예외 발생 시 사용하는 메세지 **final화**
6. 전체 메소드명 및 필드명 수정
7. `User` 클래스에서 `gameNumber`, `gameOption` 필드 제거
   - `setGameNumber()`, `setGameOption()` 메소드 수정
8. `Computer` 클래스에서 `numbers` 필드 제거
   - `setNumberIndexMap()`이 `setNumbers()`를 인자로 받아 사용하도록 수정
9. 전체 메소드 인자 전달 구조 및 메세지 출력문 위치 변경

## 📝 테스트
테스트 코드는 **생성한 클래스별로 묶어서 작성**한다.

**Result**
- [x] `getResultByCode()`에 전달되는 인자가 잘못된 경우에 대한 검증

**Status**
- [x] `getStatusByGameOption()`에 전달되는 인자가 잘못된 경우에 대한 검증

# 🗝 필요한 자료 구조
- 컴퓨터 숫자의 각 자리별 인덱스를 저장하는 `Map<Character, Integer>`
- 게임 결과를 표현하는 `enum Result class`
  - 총 10가지 경우가 가능하다. 
  - `THREESTRIKE`, `TWOSTRIKE`, `ONESTRIKE`, `ONEBALLTWOSTRIKE`, `TWOBALLONESTRIKE`, `ONEBALLONESTRIKE`, `THREEBALL`, `TWOBALL`, `ONEBALL`, `NOTHING`
- 게임의 상태를 표현하는 `enum Status class`
  - 새 게임 진행 : `PROCEEDING(0)`, `RESTART(1)`, 게임 중단 : `EXIT(2)`
- `컴퓨터` 클래스, `사용자` 클래스
  - `컴퓨터` 클래스 : `List<Integer> numbers`, `Map<Character, Integer> numberIndexMap`, `setNumbers()`, `setNumberIndexMap()`, `getNumberIndexMap()`
  - `사용자` 클래스 : `String number`, `int gameOption`, `setGameNumber()`, `isValidNumber()`, `setGameOption()`, `isValidOption()`

❓고민해본 것
- **컴퓨터 숫자의 각 자리별 인덱스**를 미리 저장해둬야 할 것 같았다. 
  - 매번 사용자 입력이 들어올 때마다 컴퓨터의 숫자를 직접 조회하지 않고, 이를 표현해놓은 자료구조로부터 확인할 수 있도록 해야 했다.
  - 이 과정에서 `int[]` 배열을 사용해 숫자별 인덱스를 저장해두려 했는데, 배열이 아닌 Java API를 활용하기 위해 `List<Integer>`로 바꿨다.
  - 하지만, `List`를 사용하면 10개의 entry를 가지고 있어야 하는데, `Map`을 사용하면 3개의 entry만 가지고 있으면 될 것이라 판단해 `Map<Character, Integer>`를 사용하는 방향으로 수정했다.
- **컴퓨터 숫자와 입력 숫자의 숫자 야구 결과를 도출**해내는 과정에 있어서 어떤 구조로 결과를 표현해야 할 지 고민해보았다.
  - 총 나올 수 있는 경우는 9가지이다. 따라서 `if-else 구조`보다는 `enum`을 사용하라는 리팩토링 구조를 본 기억이 나서 이를 도입해보려 했다.
- **어떤 역할**을 클래스로 만들고, 각 클래스는 **어떤 책임**을 수행해야 할까?
  - 이 고민에 대해서는 **컴퓨터 클래스, 사용자 클래스**를 생성하는 것으로 결정했다. 결정한 이유는 다음과 같다.
  - 컴퓨터 클래스와 사용자 클래스는 **게임 진행자**와 **게임 참가자**라는 역할을 수행한다고 판단했다.
    - 우선 두 클래스 모두 게임에 참가하기에 유효한 숫자를 만들어 준비할 책임이 있다.
    - 하지만 이 두 역할을 일반화하여 하나의 클래스로 만들지 않은 이유는 다음과 같다.
      - 컴퓨터 클래스는 정답이 되는 숫자를 가지고, 실질적으로 게임을 진행하면서 게임의 상태와 결과를 저장할 책임이 있다고 판단했다.
      - 사용자 클래스는 단순히 숫자를 입력하고 게임의 결과를 받는 역할을 수행하기에 두 역할이 동일하지 않다고 판단했다.
- 사용자 클래스가 `gameNumber`와 `gameOption`을 저장하고 있어야 할까?
  - 입력이 정상적인지 확인한 후, 바로 결과 계산으로 사용되거나 게임 상태 변화에 사용되고 더 이상 필요가 없다.
  - 따라서 굳이 저장하고 있을 필요가 없다고 생각했다. 따라서 `Calculator`와 같은 유틸 클래스가 된다.
- 위와 같은 맥락에서 컴퓨터 클래스의 `numbers` 역시도 저장할 필요가 없다고 판단했다.