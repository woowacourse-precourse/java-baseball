<<<<<<< HEAD
## 컴퓨터(상대방) 클래스 - 판별자

### fields
- 랜덤 생성된 서로 다른 3가지 숫자 리스트

### methods
0. 랜덤 3가지 숫자 생성 메소드<br /><br />
1. 게임 메소드<br /><br />
    1.  같은 숫자인지 확인하는 메소드<br>
        `true→1.2 메소드`, `false→ nothing`
    <br><br>
    2.  자리에 있는지 확인하는 메소드<br>
        `true → strike ++` , `false → ball ++`
    <br><br>
    3. 3 strike인지 확인하는 메소드<br>
       `true → 2.1. 종료 메소드`, `false → player 숫자 재입력`
    <br><br>
2. 종료 메소드<br><br>
    1. 게임 종료 후 재시작/종료 입력 받는 기능 <br>
       `1 → restart`, `2→ 게임 종료, other → 2.1. 메소드 재호출`


## Player 클래스

### fields
- 입력한 서로 다른 3가지 숫자 리스트

### methods
1. 서로 다른 3자리 수를 입력 받아 저장하는 기능<br><br>
2. 잘못된 입력 값인지 확인하는 기능<br><br>
    1. `true` → `IllegalArgumentException 발생 시킨 후 종료`<br><br>
        1. 숫자의 자리수가 3이 아닐 경우<br>
        2. 입력값이 숫자가 아닌 값이 포함됐을 경우<br>
        3. 자연수가 아닐 경우<br><br>
    2. `false` → `게임 메소드로`
=======
- 컴퓨터(상대방) 클래스 - 판별자
  - fields
  
          랜덤 생성된 서로 다른 3가지 숫자 리스트
  - methods 
    1. 게임 메소드

           1.1. 같은 숫자인지 확인하는 메소드
                 true→1.2 메소드, false→ nothing

           1.2. 같은 자리에 있는지 확인하는 메소드
                 true → strike ++ , false → ball ++

           1.3. 3 strike인지 확인하는 메소드
                 true → 2.1. 종료 메소드, false → player 숫자 재입력

    2. 종료 메소드
         
           2.1. 게임 종료 후 재시작/종료 입력 받는 기능
                 1 → restart, 2→ 게임 종료, other → 2.1. 메소드 재호출


- Player 클래스
  - fields
  
         입력한 서로 다른 3가지 숫자 리스트
  - methods
    1. 서로 다른 3자리 수를 입력 받아 저장하는 기능
    2. 잘못된 입력 값인지 확인하는 기능           
         
           true → IllegalArgumentException 발생 시킨 후 종료
    
                  2.1. 숫자의 자리수가 3이 아닐 경우
                  2.2. 입력값이 숫자가 아닌 값이 포함됐을 경우
                  2.3. 자연수가 아닐 경우
           
           false → 게임 메소드로
>>>>>>> opponent
