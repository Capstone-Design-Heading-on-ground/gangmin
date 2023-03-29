# gangmin
기본 환경설정 방법.
------------------
### 1. Git Repositories 복제하기

#### 1. 로컬 워크스페이스 생성
![develop-1.png](./images/develop-1.png)
#### 2. Window > Show View > Other... 선택
![develop-2.png](./images/develop-2.png)
#### 3. Git Repositories 선택
![develop-3.png](./images/develop-3.png)
#### 4. Clone a Git repository 선택
![develop-4.png](./images/develop-4.png)
#### 5. URI에 레포지토리 주소 입력
![develop-5.png](./images/develop-5.png)
```
비밀번호 대신 토큰을 발급받아서 사용할 것
```
#### 6. Next >
![develop-6.png](./images/develop-6.png)
#### 7. Finish
![develop-7.png](./images/develop-7.png)
#### 8. import Project
![develop-10.png](./images/develop-10.png)
#### 9. Projects from Git
![develop-11.png](./images/develop-11.png)
#### 10. Existing local repository
![develop-12.png](./images/develop-12.png)
#### 11. Select a Git Repository
![develop-13.png](./images/develop-13.png)
#### 12. Import existing Eclipse projects
![develop-14.png](./images/develop-14.png)
#### 13. Import Projects
![develop-15.png](./images/develop-15.png)
#### 14. Import된 프로젝트를 Project Explorer 에서 확인
![develop-16.png](./images/develop-16.png)
#### 15. Server 추가
![develop-17.png](./images/develop-17.png)
#### 16. Tomcat v9.0 Server 선택
![develop-18.png](./images/develop-18.png)
#### 17. Available에 있는 프로젝트를 Configured로 Add
![develop-19.png](./images/develop-19.png)
#### 18. Build Path
![develop-20.png](./images/develop-20.png)
#### 19. unbound로 표시되면 해당항목 Remove
![develop-21.png](./images/develop-21.png)
#### 20. Add External JARs...
![develop-22.png](./images/develop-22.png)
#### 21. Tomcat이 저장되있는 폴더의 lib
![develop-23.png](./images/develop-23.png)
#### 22. servlet-api.jar 파일 선택
![develop-24.png](./images/develop-24.png)
#### 23. Apply and Close
![develop-25.png](./images/develop-25.png)


### 2. DataBase 설정
#### 1. DataBase 설치
	https://www.oracle.com/database/technologies/xe-prior-release-downloads.html
#### 2. DataBase 환경설정
	https://cmleo.tistory.com/19
### 2-1. sqldeveloper 설치
	https://www.oracle.com/database/sqldeveloper/technologies/download/
#### 3. Oracle 접속 후 TABEL 생성
![develop-26.png](./images/develop-26.png)
```
CREATE TABLE MEMBER(
 mkey NUMBER(8) PRIMARY KEY,
 mid VARCHAR(45) UNIQUE NOT NULL,
 mpw VARCHAR(45) NOT NULL,
 mname VARCHAR(45) NOT NULL,
 mnickname VARCHAR(45) NOT NULL,
 mhp VARCHAR(45) NOT NULL,
 maddress VARCHAR(45),
 mmail VARCHAR(45),
 mtime date default sysdate,
 mbirthday VARCHAR(45),
 madmin NUMBER(1)
);
```
#### 4. SEQUENCE 생성
```
CREATE SEQUENCE tmp_seq START WITH 1 INCREMENT BY 1 MAXVALUE 100 CYCLE NOCACHE;
```
#### 5. Servers > Tomcat v9.0 > context.xml
![develop-27.png](./images/develop-27.png)
#### 6. Source 탭 선택
![develop-28.png](./images/develop-28.png)
#### 7. Source 탭 맨 밑쪽에 다음과 같은 코드 추가
![develop-29.png](./images/develop-29.png)
```
    <Resource
        name="jdbc/oracle"
        auth="Container"
        type="javax.sql.DataSource"
        driverClassName="oracle.jdbc.driver.OracleDriver"
        url="jdbc:oracle:thin:@localhost:1521:XE"
        username="scott"
        password="tiger"
        maxActive="50"
        maxWait="-1"
     />
```
	username과 password는 환경설정때 자신이 사용했던 계정정보 입력

