## ❗기능 정의

### ✅ 기능 목록
1. 게임시작 문구 출력
   <br><br>
2. 상대방(컴퓨터): 서로 다른 3자리수 생성
    - `camp.nextstep.edu.missionutils.Randoms` 활용
    - 3자리수 생성(⭕)
      - `return ArrayList<Integer>`
    - 잘못된 값 생성(❌)
      - `IllegalArgumentException` 발생
         - 서로 다른 숫자?
   <br><br>
3. 사용자: 숫자 입력
    - `camp.nextstep.edu.missionutils.Console` 활용
    - 3자리수 입력(⭕)
        - `return ArrayList<Integer>`
    - 잘못된 값 입력(❌)
        - `IllegalArgumentException` 발생
            - 포함 문자?
            - 3자리 숫자?
            - 각 1~9 숫자?
            - 서로 다른 숫자?
              <br><br>
4. 상대방(컴퓨터) 숫자와 사용자 숫자 비교
    - `ArrayList<Integer>` 끼리 비교
        - 같은수 - 같은자리: 스트라이크
        - 같은수 - 다른자리: 볼
        - 모두 다른수: 낫싱
        - `return ArrayList<Integer>`
            - [볼의 개수, 스트라이크의 개수]
              <br><br>
5. 비교 결과값 출력
    - `ArrayList<Integer>` 활용
      <br><br>
6. 비교 결과값 통해 게임 상황 판단
    - 숫자 일치(⭕)
        - 게임 종료 문구 출력
        - 사용자: 숫자 입력
            - 게임 재시작(1) 입력(⭕)
                - `camp.nextstep.edu.missionutils.Console` 활용
                - 게임 재시작 문구 출력
                - 게임 재시작
                    - <u>2. 상대방(컴퓨터): 서로 다른 3자리수 생성</u>
            - 게임 종료(2) 입력(⭕)
                - `camp.nextstep.edu.missionutils.Console` 활용
                - 게임 종료
            - 잘못된 값 입력(❌)
                - `IllegalArgumentException` 발생
                    - 1 숫자?
                    - 2 숫자?

    - 숫자 일치(❌)
        - 입력받았던 숫자 초기화
        - <u>3. 사용자: 숫자 입력</u>

### ✅ 기능 구현 목록

#### 👀 baseball
1. ```
   Computer 클래스
    - Field: 
        - List<Integer> numbers
    - Method:
        - void setNumbers(): 서로 다른 3자리수 생성
        - List<Integer> getNumbers()
    ```
2. ```
   User 클래스
    - Field: 
        - List<Integer> numbers
    - Method:
        - void setNumbers() : 사용자 숫자 입력
        - List<Integer> getNumbers()
        - void clearNumbers() : 입력받았던 숫자 초기화
    ```
3. ```
   Game 클래스
    - Field: 
        - Computer computer
        - User user
    - Constructor:
        - computer, user 객체 할당
    - Method:
        - void printStart() : 게임시작 문구 출력
        - void startGame() : 게임시작
        - boolean isFinishGame() : 게임종료 하는지 판단
        - boolean isRestartGame() : 게임종료 또는 게임재시작 하는지 판단
   ```

#### 👀 util
1. ```
   Constants 클래스
    - int NUMBER_LENGTH = 3;
    - int MIN_NUMBER = 1;
    - int MAX_NUMBER = 9;
   
    - int RESTART = 1;
    - int FINISH = 2;
   
    - String GAME_START = "숫자 야구 게임을 시작합니다.";
    - String GAME_FINISH = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    - String GAME_RESTART = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    - String USER_INPUT = "숫자를 입력해주세요 : ";
    - String INPUT_WRONG = "잘못된 입력입니다.";
    ```
2. ```
   Rule 클래스
    - List<Integer> getResult : 상대방(컴퓨터) 숫자와 사용자 숫자 비교 결과값 얻기
        - boolean isBal : 볼 인지 판단
        - boolean isStrike : 스트라이크 인지 판단
    - void printResult : 비교 결과값 출력  
    - boolean isStrikeOut : 상대방(컴퓨터) 숫자와 사용자 숫자 일치하는지(3스트라이크) 판단

   ```
3. ```
   UserInput 클래스
   - boolean isValidUserInput
        - boolean hasNotCharacter : 사용자 입력에서 문자 존재하는지 판단
        - boolean isRightLength : 사용자 입력에서 숫자의 자릿수 올바른지 판단
        - boolean isRightRange : 사용자 입력에서 숫자의 범위가 올바른지 판단
        - boolean isNotDuplicate : 사용자 입력에서 중복되는지 판단
            - boolean isSame
   - boolean isValidGameStateInput 
        - boolean hasNotCharacter : 사용자 입력에서 문자 존재하는지 판단
        - boolean isValidRestart : 사용자 입력에서 재시작 값인지 판단
        - boolean isValidEnd : 사용자 입력에서 종료 값인지 판단
   ```
4. ```
   ComInput 클래스
   - boolean isValidComInput
        - boolean isNotDuplicate : Random 생성에서 중복되는지 판단
            - boolean isSame
   ```