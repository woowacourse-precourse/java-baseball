# 야구게임 기능 요구사항



> ***게임 진행***
> - gameStart() 메서드 
> - [x] 입력을 받아 Int 배열로 저장
> - gameStartConditional(int[]) 메서드 
> - [x] 입력 배열의 크기와 중복제거한 입력 배열의 3인 경우에만 진행 그 외 상황 IllegalException
> - [x] 입력 배열의 중복을 제거하는 removeDuplicates 메서드 생성
> - getComputerNumbers() 메서드 
> - [x] 임의의 3자리 수를 뽑아 답 리스트에 저장
> - getScoreboard()메서드
> - [x] 입력 리스트의 각 인덱스가 답 리스트에 들어가 있는 경우에만 진행 그 외 상황 진행하지 않음
> - [x] 입력 리스트의 인덱스와 답 리스트의 인덱스를 비교 후 스트라이크, 볼 판단
> - printScoreboard() 메서드
> - [x] 배열리스트를 받아서 스트라이크, 볼 개수를 출력한다.
> - [x] 스트라이크, 볼이 0일 경우는 출력하지 않는다.
> - [x] 스트라이크가 3개일 시 정답 처리 후 게임 종료한다.

> ***게임 종료 및 실행***
> - gameBreak() 메서드 
> - [x] 입력값을 Integer 데이터로 변환
> - getBreakConditional() 메서드 
> - [x] 입력이 2가 들어오면 True 반환
> - [x] 입력이 1이면 false 반환
> - [x] 그 외 상황은 IllegalException 반환