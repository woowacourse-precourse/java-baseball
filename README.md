# 2주차 미션 - 숫자 야구

## 🔍 기능 목록
### 1. 정답 숫자인 computerNumber를 생성
- ComputerNumber 리스트를 1~9사이 숫자로 초기화
- 랜덤한 숫자들간의 중복은 허용X

### 2. 사용자의 입력을 받아 문자열로 반환하는 기능
- 게임을 진행하면서 매번 사용자의 입력을 받아야 한다
- 즉 여러 함수에서 각각 Scanner를 통해 입력을 받는것보다 입력을 받은 뒤 문자열로 반환해주는 함수를 추가한다 
  
### 2. 사용자의 숫자를 입력 받는다, 이때 밑의 예외사항을 검사
- 입력한 숫자가 3자리수가 아닌 경우 예외 반환
- 1~9사이의 숫자를 입력하지 않은 경우 예외 반환

  
### 3. 입력 숫자에 대한 스트라이크, 볼, 낫싱, 정답 검사
- 입력한 수의 스트라이크 개수를 반환
- 입력한 수의 볼 개수를 반환
- 입력한 수가 낫싱일 경우 true 낫싱이 아닐경우 false 반환
- 입력한 수의 스트라이크 개수가 3이면 정답으로 처리

### 4. 볼, 스트라이크, 낫싱, 정답 경우에 따라 힌트 메세지를 만들어주는 기능  
- 0이 포함된 경우는 메세지로 만들지 않는다  
ex) 0볼, 0스트라이크;


### 5. 사용자의 입력이 정답인 경우 사용자의 요청에 따라 게임을 재시작하거나 종료

