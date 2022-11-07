# 구현 기능 목록

- generateRandomNumbers
   - 인자: 없음
   - 내용: Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다. 정답은 3자리로 각 자리는 1~9 사이의 수로 구성, 중복X
   - ouput: List<Integer>


- getUserInput
    - 인자: int checkLength
    - 내용: camp.nextstep.missionutils.Console의 readline함수를 활용하여 \n까지 String 값을 validate 한 후 int로 리턴한다.
    - ouput: int


- validateUserInput
  - 인자: String userInput, int checkLength
  - 내용: 유저에게 입력받은 String이 요구사항에 부합하는지 체크한다. 
    - 길이가 checkLength와 같은지 체크
    - 숫자 중 0을 포함하는지 체크 
    - 정수가 아닌 문자를 변환할 경우 발생하는 NumberFormatException 체크
  - ouput: String
  

- getDigitList
  - 인자: int numbers
  - 내용: 정수를 각 자리 숫자로 나눠 위치에 맞게 배열에 추가 후 리턴한다. 
  - ouput: List<Integer>


- checkDuplicate
  - 인자: List<Integer> digits, int digit
  - 내용: 정수를 각 자리 숫자로 나타낸 배열에서 중복된 숫자가 존재하는지 확인한다. 존재하면 IllegalException 발생한다.
  - output: 없음


- compareAnswerWithInput
  - 인자: List<Integer> answerDigits, List<Integer> inputDigits
  - 내용: 정답과 유저 입력값 3자리를 비교해 [스트라이크 수, 볼 수] 계산 후 리턴한다.
    - ouput: List<Integer>


- printHint
    - 인자: List<Integer> comparedResult
    - 내용: 비교 결과로부터 스트라이크와 볼 수를 출력
      - 둘다 0일 경우 낫싱을 출력 후 false 리턴한다. 
      - 스트라이크 3개인 경우 정답 조건 만족시 새 게임 또는 종료 선택 메세지 출력 후 true 리턴한다.
      - 이외의 경우 볼과 스트라이크 수를 출력 후 false 리턴한다.
    - ouput: boolean


- toBeContinued
  - 인자: int userInput, List<Integer> answerDigits
  - 내용: 새 게임을 시작할지 종료할지 출력 후 입력 받은 값에 따라 게임 흐름 판단한다.
    - 1의 경우 answerDigits에 새로 생성한 리스트을 할당 후 리턴한다.
    - 2의 경우 answerDigits에 빈 리스트를 할당 후 리턴한다.
    - 이외의 경우 IllegalException 발생한다.
  - ouput: List<Integer>
  