public static 공통  

게임 기능 메서드  
int makeRandomNum() : 랜덤 수를 뽑는 메서드  
int strike(int 입력값) : 스트라이크 개수를 반환  
int ball(int 입력값): 볼 개수를 반환

유효성 검사
boolean validation() : 사용자의 입력값을 받아 유효한 값인지 검사  
=> Randoms 활용

>머릿속으로 생각한 전체 구조(바뀔 수 있음)  
>>유효성 검사  
>>랜덤수 뽑기  
>>while(스트라이크가 3일때까지)  
>>>if(strike!=0 && ball!=0)  
> elseif(strike==0 && ball!=0)   
> elseif(strike!=0 && ball==0)  
> => Console.readLine(), 해당하는 메시지 반환  
> 
>>if(strike==3)  
> 메시지 출력  
> switch(Console.readLine())  
> case1: main()  
> case2: 종료 => Console.isClosed() 활용

*메서드 단위로 테스트 코드 작성
    


