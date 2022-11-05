## 기능 요구 사항 분석
- 컴퓨터 플레이어는 '서로 다른 수로 이루어진' 세 자리의 수 abc를 저장한다.
- 게임 플레이어는 컴퓨터 플레이어가 제시한 수를 맞추기 위해 서로 다른 수로 이루어진 세 자리의 수 xyz를 입력한다.
- 게임 플레이어가 제시한 수를 분석하여 결과를 출력한다.
  - x, y, z 중 a, b, c와 같은 수가 있는지 확인한다.
  - 해당된다면 자리수도 같은지 확인한다.
  - 볼, 스트라이크, 낫싱으로 결과를 출력한다.
- 컴퓨터 플레이어의 수를 게임 플레이어가 맞출 경우 현재의 세트가 종료된다. 
- 현재의 세트가 끝난 후 게임 플레이어는 다음 세트를 진행하려면 1을, 진행하지 않고 게임을 종료하려면 2를 입력한다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException` 예외를 발생시키고 게임을 종료한다.
  - 서로 다른 수로 이루어진 세 자리의 수를 입력하지 않은 경우 
  - 한 세트가 끝난 후 게임 종료 여부 결정 시 1, 2가 아닌 다른 값올 입력할 경우

## 요구 사항 상세
-[X] DigitNumber enum
  - [X] `Map<Integer, Integer> generate3DigitNumberWithoutDuplication()`
    - 컴퓨터 플레이어가 저장할 세 자리의 수를 반환
    - 반환형은 Map<Integer, Integer>이고, Key는 number, Value는 Digit이다.
  - [X] `Map<Integer, Integer> convertNumberToMap(Integer)`
    - 게임 플레이어가 입력한 세 자리의 수를 Map으로 변환
    - 반환형은 Map<Integer, Integer>이고, Key는 number, Value는 Digit이다.

- [X] Judge Class
  - [X] `Result compare(Map<Integer, Integer>, Map<Integer, Integer>)`
    - 게임 플레이어가 입력한 세 자리의 수를 분석하여 결과를 반환
    - 파라미터로 Map<Integer, Integer>를 사용하고, 각각 컴퓨터 플레이어, 게임 플레이어가 입력한 수이다.
  - [X] `boolean isBall(Integer)` 
    - 게임 플레이어가 입력한 세 자리의 수 중 하나를 받아 컴퓨터 플레이어의 수와 비교
    - 컴퓨터 플레이어의 수가 인자로 받은 수를 포함하면 true, 그렇지 않으면 false를 반환
  - [X] `boolean isStrike(Integer, Integer)`
    - 게임 플레이어가 입력한 세 자리의 수 중 isBall의 결과가 true인 수와 index를 받아 컴퓨터 플레이어의 수와 비교
    - index가 동일하면 true, 그렇지 않으면 false를 반환
  - [X] `boolean isNothin(Result result)`
    - 비교 결과 ball과 strike의 개수가 모두 0이면 true, 그렇지 않으면 false 반환
  
- [ ] Game Class
  - [ ] ``

- [] Validator Class
  - [X] `void isRangeOf(Integer, Integer)`
    - 게임 플레이어가 입력한 수가 유효한 수인지 확인하는 메서드
    - 첫 번째 인자는 최대 자리의 수, 두 번째 인자는 게임 플레이어가 입력한 수이다.
    - 범위에 있지 않을 경우 `IllegalArgumentException` 예외를 던진다.
  - [] `void isRestartable(Integer)`
    - 게임 종료 이후 게임 플레이어가 1, 2 외의 다른 숫자를 입력했는지 확인하는 메서드
    - 적절한 커맨드가 아닌 경우 `IllegalArgumentException` 예외를 던진다.

- [X] View Class
  - [X] `void printStart()` 
    - 게임 시작 시 "숫자 야구 게임을 시작합니다." 출력
  - [X] `void printPlayerTurn()` 
    - 컴퓨터 플레이어가 세 자리의 수를 제시한 후 게임 플레이어에게 "숫자를 입력해주세요 : " 출력
  - [X] `void printNoting()`, `void printCorrect()`, `void printBallAndString(int, int)`
    - `void printNoting()` : "낫싱" 출력
    - `void printCorrect()` : "3개의 숫자를 모두 맞히셨습니다! 게임 종료"와 "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요." 출력
    - `void printBallAndString(int, int)` : 입력의 결과와 "숫자를 입력해주세요 : " 출력 

- [X] ResultType Enum
  - [X] BALL("볼")
  - [X] STRIKE("스트라이크")
  - [X] NOTHING("낫싱")

- [X] Result Class
  - [X] `Map<ResultType, Integer>`를 멤버 변수로 저장하여 결과를 View Class로 전달
  - [X] `void add(ResultType)`
    - 인자로 받은 ResultType에 대응되는 Value에 1 추가