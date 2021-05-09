## URL-Shortening?
* URL을 입력받아 짧게 줄여주고, Shortening된 URL을 입력하면 원래 URL로 리다이렉트하는 Service

<br/>

## 요구사항
* URL 입력폼 제공 및 결과 출력
* URL Shortening Key는 8 Character 이내로 생성
* 동일한 URL에 대한 요청은 동일한 Shortening Key로 응답
* 동일한 URL에 대한 요청 수 정보를 가져야 함(화면 제공 필수 아님)
* Shortening된 URL을 요청받으면 원래 URL로 리다이렉트
* Database 사용은 필수 아님

<br/>

## 개발환경
* Java (1.8)
* Spring Boot (2.4.5)
* Gradle (6.8.3)
* MySQL (8.0)
* lombok (1.18.6)
* html
* thymeleaf

<br/>

* IntelliJ
* junit (4.13.1)

<br/>

## 설치/빌드 방법

    $ git clone https://github.com/seonyeongLee/URL-Shortening.git
    
    $ ./gradlew bootrun
