[기능 구현 목록]

[game]
- getscore
  : 볼과 스트라이크 개수 계산
  같은자리에 같은 숫자 = 스트라이크
  자리는 다르지만 숫자 포함 = 볼
  하나도 못 맞췄을 때 = 낫싱
  숫자 똑같이 맞췄을 때 = "3 스트라이크"
- getHintMessage
  : getScore에서 계산된 점수를 바탕으로 메세지 출력
    - 볼 -스트라이크 / 낫싱 / 3스트라이크
- ThreeStrike
  : 스트라이크 개수 = 3 이면 true 반환, 게임 종료 조건으로 사용
- playGame
  : 게임 진행 순서대로 메소드 호출

[InputNUmber]
- userInputNumber
  : 사용자에게 숫자를 입력 받음
  "숫자를 입력 해 주세요" 출력 후 'readLine()'으로 입력값 받음. 
   입력받은 숫자 리스트에 저장. 

[AnswerNumber]
- RandomNumber
  : 정답 숫자를 랜덤으로 1-9사이에서 3개 출력 후 리스트에 저장. 
   랜덤숫자는 'pickNumberInRange()' 활용
- restartNumberValidator
  : 사용자가 게임을 재시작하기를 원할 시 새로 생성되는 랜덤값이 이전 값과 중복인지 확인
- saveAnswerNumber
  : 정답으로 출력되는 랜덤값 리스트로 저장

[InputNumberValidator]
- 사용자 입력 숫자사이에 , 가 들어가는 경우
- 사용자가 숫자를 3자리 이상 입력했을 경우
- 사용자가 숫자를 1-9외 범위로 입력했을 경우
- 사용자 입력 숫자 사이에 공백이 있을 경우

[AnswerNumberValidator]
- 컴퓨터가 이전과 같은 숫자를 랜덤으로 뽑았을 경우
→ 게임할때마다 컴퓨터 숫자를 리스트에 저장하고 시작시 비교하기


   