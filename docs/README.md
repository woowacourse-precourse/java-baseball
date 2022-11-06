# 📖 기능 목록

- 숫자야구게임을 진행하는 객체 - `BullsAndCows`
    - 컴퓨터의 랜덤한 값(정답)을 생성한다.
    - 점수를 구한다.
    - 결과를 반환한다.
        - 볼, 스트라이크, 낫싱
    - 프로그램 종료조건을 검증한다.
        - 재시작
        - 종료


- 숫자야구게임 결과 값 - `ResultMessage`
    - 값
        - `STRIKE("스트라이크")`
        - `BALL("볼")`
        - `NOTHING("낫싱")`
    - 숫자를 넣었을 때 결과 문구로 반환해주는 기능
        - `of(int number)`
            - ex) BALL.of(1) return `"1볼"`
            - ex) STRIKE.of(2) return `"2스트라이크"`
            - ex) BALL.of(0) return `""`

# 🕹 BullsAndCows

숫자야구게임을 진행하는 객체입니다.

## Method

### public method

- `playGame()`
    - 숫자야구게임을 시작하는 함수

### private method

#### 🛠 유틸 함수

- `restart()`
    - 게임을 재시작하는 함수


- `createAnswerNumber()`
    - 컴퓨터의 값을 생성하는 함수


- `initCountValues()`
    - strikeCount, ballCount를 초기화하는 함수


- `isEnd()`
    - 게임이 끝났는지 구분하는함수
        - 3 스트라이크 면 게임이 끝난다.

#### ✏️ 결과값 반환함수

- `getResultMessageOfGuessNumber(String input)`
    - 입력값에 대해 숫자야구게임 결과를 반환하는 함수


- `getResultOfEndGame(String input)`
    - 입력값에 대해 재시작, 게임 종료를 구분하는 함수

#### 💯 점수 관련 함수

- `getStrikerNumber()`
    - 스트라이크 개수를 구하는 함수


- `getBallNumber()`
    - 볼 개수를 구하는 함수


- `getResultScore()`
    - 결과값을 형식에 맞춰 반환하는 함수


- `isStrikeByIndex(int index)`
    - 해당 index의 숫자가 스트라이크인지 구분하는 함수


- `isBallByIndex(int index)`
    - 해당 index의 숫자가 볼인지 구분하는 함수


- `isNothing()`
    - '낫싱'인지 구분하는 함수

#### ⚠️ 검증 함수

- `validateNumber(String input)`
    - 검증을 수행한다.
        - 숫자인지 검증 - `validateIsNumber(String input)`
        - 올바른 길이(3)인지 검증 - `validateLength(String input)`
        - 중복된 숫자가 존재하는지 검증 - `validateDuplicate(String input)`
    - **overloading** : `validateNumber(List<Integer> input)`

# 💬 ResultMessage

## 상수값

- `STRIKE("스트라이크")`
- `BALL("볼")`
- `NOTHING("낫싱")`

## Method

- `of(int number)`
    - number에 맞춰 결과값을 만든다.
    - 예시)
        - `STRIKE.of(3)` -> `3 스트라이크`
        - `BALL.of(2)` -> `2 볼`

# 💬 GameProgressMessage

## 상수값

- `GAME_PROGRESS_ASK_QUIT("게임 종료 이후 재시작, 종료를 물어보는 문구")`
- `GAME_PROGRESS_MESSAGE("게임 진행안내 문구")`
- `GAME_PROGRESS_RESTART("재시작")`
- `GAME_PROGRESS_END("게임 종료");`