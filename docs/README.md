### 기능구현 목록

1. Service 클래스: 게임 로직을 구현한 클래스
   - 상대방(컴퓨터)의 수를 반환하는 메서드 (getComNumInput)
   - 상대방의 수와 유저의 수를 비교하여 스트라이크/볼을 계산하는 메서드 (calculateScore)
     - 상대방(컴퓨터)의 수와 인덱스를 Hashmap에 key, val 형태로 저장하는 메서드 (setComputerData)
     - 유저의 수를 한자리씩 순회하면서 컴퓨터의 수와 겹치는게 있는지 확인하여 아래 메서드를 호출하는 메서드 (checkMapContainsString)
       - 인덱스가 같으면 strike를 증가시키는 메서드를, 그렇지 않으면 ball을 증가시키는 메서드를 호출하는 메서드: (compareIdxAndIncreaseScore)
         - 타입에 따라 strike 또는 ball을 증가시키는 메서드 (increaseScore)


2. View 클래스: 입/출력을 담당하는 클래스
   - 사용자의 입력을 받아오는 메서드, 유효하지 않으면 Error 던짐 (getUserInput)
     - 사용자 입력이 유효한지 확인하는 메서드 (validateUserInput)
   - 사용자의 재시작 응답을 받아오는 메서드, 유효하지 않으면 Error 던짐 (getUserResponse)
     - 사용자 응답이 유효한지 확인하는 메서드 (validateUserResponse)
   - 처음 게임 시작할때 메시지를 출력하는 메서드 (printInitMsg)
   - 매 턴마다 숫자를 입력하는 메시지를 출력하는 메서드 (printInputMsg)
   - 성공적으로 숫자를 맞췄을 시 메시지를 출력하는 메서드 (printSuccessMsg)
   - 재시작을 원하는지 물어보는 메시지를 출력하는 메서드 (printRestartMsg)
   - 사용자가 추측한 숫자에 대한 답을 출력하는 메서드 (printResultMsg)


3. Application 클래스: main 함수로 게임 실행
4. Score 클래스: 점수 객체를 생성하는 클래스