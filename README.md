## <aside>🏁 **Goal:  "JPA를 활용한 upgrade 일정 관리 앱 서버 만들기"**</aside>


-  DB_CRUD_JWT_Project를 통해 얻을 수 있는 것 👍
    1. JPA를 활용하여 CRUD를 구현하고, 이를 통해 객체 지향적으로 데이터를 다룰 수 있어요.
    2. JPA를 활용하여 데이터베이스를 관리하고 영속성에 대해서 이해할 수 있어요.
    3. 회원가입, 로그인을 통해 인증/인가를 이해하고 JWT를 활용할 수 있어요.
    4. RestTemplate을 통해 외부 정보를 호출하고 활용할 수 있어요.
 

 ### <DB를 사용하고, CRUD와 JWT를 사용하는 과제입니다>
개인 입문과제로 만든 Custom_Sceduler를 스케일업 하여, CRUD만 구현한 Custom_Sceduler에, JPA로 DB를 관리하고, '영속성'을 고려해서 만드는 Sceduler 프로젝트 입니다.


<aside> 🔥 **다음을 고려하며 설계했습니다.** </aside>

- 모든 테이블은 고유 식별자(ID)를 가집니다.
- `3 Layer Architecture` 에 따라 각 Layer의 목적에 맞게 개발합니다.
- CRUD 필수 기능은 모두 데이터베이스 연결 및  `JPA`를 사용해서 개발합니다.
- `JDBC`와 `Spring Security`는 사용하지 않습니다.
- 인증/인가 절차는 `JWT`를 활용하여 개발합니다.
- JPA의 연관관계는 **`양방향`**으로 구현합니다.
  

#### <입문주차 개인괴제(Custom_Sceduler)링크>
https://github.com/ilmechaJu/Custom_Sceduler/blob/master/ReadMe.md


### API명세서 
## 일정 API
<img width="1366" alt="image" src="https://github.com/user-attachments/assets/b48c289c-8c75-4bd6-a128-d5ddbb7c00eb">


## 댓글 API
<img width="1364" alt="image" src="https://github.com/user-attachments/assets/39ea7dca-f0cf-40e4-82e4-48ec744cd53c">


## 유저 API
<img width="1357" alt="image" src="https://github.com/user-attachments/assets/d7e44c48-cd28-407a-bd96-71ca57b675ab">



