# 스프링 부트와 AWS로 혼자 구현하는 웹 서비스


## 프로젝트 개발 환경

* Java 8
* Gradle 7.x
* Spring Boot 2.1.x


## 목차

<details>
<summary>01장 인텔리제이로 스프링 부트 시작하기</summary>
</details>

<details>
<summary>02장 스프링 부트에서 테스트 코드를 작성하자</summary>
</details>

<details>
<summary>03장 스프링 부트에서 JPA로 데이터베이스르 다뤄보자</summary>

* jpa : 자바 어플리케이션에서 관계형 데이터베이스를 사용하는 방식을 정의한 인터페이스
* spring data jpa : spring에서 JPA를 편리하게 사용할 수 있도록 지원하는 프로젝트 (구현체, 저장소 교체 용이)
* 스프링 웹 계층 

![image](https://user-images.githubusercontent.com/57280699/208279039-f99c1eb5-465f-4561-92d6-d9e785af84eb.png)

* 더티체킹 : JPA에서는 트랜잭션이 끝나는 시점에 변화가 있는 모든 엔티티 객체를 데이터베이스에 자동으로 반영
* JPA Auditing : 엔티티는 해당 데이터의 수정,생성 시간이 포함되어 있는데 그것을 관리하는 기능

</details>

<details>
<summary>04장 머스테치로 화면 구성하기</summary>

* 머스테치 : 수많은 언어를 지원하는 가장 심플한 템플릿 엔진
* Querydsl : 쿼리를 자바코드로 작성할 수 있게 도와주는 기술이다. Spring Data JPA로 해결하지 못하는 복잡한 쿼리/동적 쿼리를 해결할 수 있다.

</details>

<details>
<summary>05장 스프링 시큐리티와 OAuth2.0으로 로그인 기능 구현하기</summary>

* OAuth : 별도의 회원가입 없이 로그인을 제공하는 서비스. 외부 서비스에서도 인증을 가능하게 하고 그 서비스의 API를 이용하게 해주는 것이다.

</details>

<details>
<summary>06장 AWS 서버 환경구성</summary>

* EC2 : AWS에서 제공하는 성능, 용량 등을 유동적으로 사용할 수 있는 서버이다. 
* AMI : EC2인스턴스를 시작하는데 필요한 정보를 이미지로 만들어 둔 것으로 인스턴스라는 가상머신에 운영체제 등을 설치할 수 있도록 구워넣은 이미지

</details>

<details>
<summary>07장 AWS에 데이터베이스 환경구성</summary>

* RDS : AWS에서 지원하는 클라우드 기반 관게형 데이터베이스
</details>

<details>
<summary>08장 서버에 프로젝트 배포하기</summary>

</details>

<details>
<summary>09장 코드가 푸시되면 자동으로 배포 - Travis CI배포 자동화</summary>

* CI (지속적인 통합) 
: 버전관리 시스템(SVN, GIT)에 PUSH가 되면 자동으로 테스트와 빌드가 수행되어 안정적인 배포 파일을 만드는 과정

* CD (지속적인 배포) 
: 빌드 결과를 자동으로 운영 서버에 무중단 배포까지 진행되는 과정

* Travis CI : 깃허브에서 제공하는 무료 CI서비스
* AWS S3 : AWS에서 제공하는 일종의 파일서버

</details>

<details>
<summary>10장 24시간 365일 중단없는 서비스 만들기</summary>

* 엔진엑스 : 웹서버, 리버스 프록시, 캐싱, 로드밸런싱, 미디어 스트리밍 등을 위한 오픈소스 
</details>

<details>
<summary>11장 1인 개발시 도움이 될 도구와 조언들</summary>
</details>
