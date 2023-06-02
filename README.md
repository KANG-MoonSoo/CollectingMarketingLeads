# CollectingMarketingLeads
수평 확장이 가능한 마케팅 리드 수집 백엔드 시스템 개발

## 프로젝트 소개
동접자가 수천만명에 달할 것으로 예상되는 마케팅 이벤트 페이지를 통해 전달되는 고객 정보를 수집할 백엔드 서비스 입니다.

이 이벤트 페이지는 아래의 정보를 수집해 전달합니다.
- 이름  
- 이메일  
- 국가코드 + 전화번호 
- 개인정보 수집 동의 여부

이름, 이메일, 국가코드 + 전화번호는 Stirng타입이고 이메일은 이메일의 폼을 지켜주셔야 합니다. 개인정보 수집 동의 여부는 Boolean입니다.

Swagger Ui 주소 : http://localhost:8080/swagger-ui.html

## Stacks

<img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white"> <img src="https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=Spring&logoColor=white"> <img src="https://img.shields.io/badge/Spring Boot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white"> <img src = "https://img.shields.io/badge/spring data JPA-6DB33F?style=for-the-badge&logo=spring data JPA&logoColor=white">

## 수평 확장 인프라 설계
수평 확장 인프라의 핵심은 트래픽이 변화 할 때 마다 인프라의 크기를 변화 시키는 것입니다. 

이를 위해 다음과 같은 사항들이 요구 됩니다.
- 기본적으로 애플리케이션을 구동할 수 있는 컴퓨팅 리소스 필요.
- 트래픽에 따라서 컴퓨팅 리소스의 가로 확장(인스턴스 대수 증가)을 담당.
- 늘어난 컴퓨팅 리소스에 대해서 요청을 분산 시킬 수 있는 로드 밸런싱

그리고 컴퓨팅 리소스가 수시로 변경되는 상황 속에서, 애플리케이션이 수정 되었을때, 이미 확장된 시스템에 수동으로 일일히 반영 할 수는 없기 때문에,
애플리케이션이 패치가 이루어질 경우, 확장된 인프라에 자동으로 애플리케이션 변경점을 전달 할 수 있어야 합니다.
- 지속적 전달

위 요구 사항을 해결 하기 위해서는 AWS에서는 아래와 같은 서비스들을 제공 하고 있습니다.
- EC2
- ELB
- AutoScailing Group
- Code Pipe Line
###

