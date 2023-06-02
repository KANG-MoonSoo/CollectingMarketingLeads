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
- EC2(Elastic Compute Cloud)
  - 가상 서버를 프로비저닝하여 수평 확장 가능한 애플리케이션 인프라를 구축합니다.
  - 인스턴스 수를 동적으로 늘리거나 줄여 트래픽 변동에 대응합니다.
- ELB(Elastic Load Balancer)
  - 인바운드 트래픽을 여러 EC2 인스턴스로 분산시켜 로드 밸런싱을 수행합니다.
  - 수평 확장된 인스턴스들 사이에서 트래픽을 공평하게 분배하여 성능과 가용성을 향상시킵니다.
- AutoScailing Group
  - 트래픽 변동에 따라 EC2 인스턴스의 수를 동적으로 조절하여 수평 확장을 구현합니다.
  - 인스턴스의 수를 자동으로 늘리거나 줄여서 애플리케이션의 성능과 가용성을 유지합니다.
- Code Pipe Line
  - 애플리케이션의 지속적인 통합 및 배포 파이프라인을 자동화하여 수평 확장을 지원합니다.
  - 소스 코드 변경, 빌드, 테스트, 배포 과정을 자동화하여 신속하고 일관된 배포를 수행합니다.

위 서비스를 이용하여 수평 확장 인프라를 구축하게 된다면

1. AMI(Amazon Machine IMage)선택
- EC2인스턴스를 시작하기 전에 AMI를 선택합니다. 이 AMI는 EC2인스턴스를 실행하기 위한 기본 이미지로 사용됩니다.

2. 인스턴스 구성
- 선택한 AMI를 기반으로 EC2인스턴스를 구성합니다. 이때 수평 확장을 위해 여러 개의 인스턴스를 시작할 수 있습니다. 인스턴스 유형, 용량, 보안 그룹 등을 구성합니다.
3. 로드 밸런서 구성
- ELB를 사용하여 로드 밸런서를 구성합니다. 로드 밸런서는 인바운드 트랙픽을 EC2인스턴스로 분산시키는 역할을 합니다. 로드 밸런서 유형과 구성에 따라 필요한 설정을 수행합니다.
4. Auto Scaling 그룹 구성
- Auto Scaling을 사용하여 인스턴스 수를 자동으로 조절하는 Auto Scaling그룹을 구성합니다. 그룹에서 인스턴스의 최소 및 최대 개수, 확장 및 축소 정책 등을 설정합니다. Auto Scaling 그룹은 트래픽 변동에 따라 인스턴스를 자동으로 조정하여 수평 확장을 가능하게 합니다.
5. 애플리케이션 배포 파이프라인 구성
- Code Pipe Line을 사용하여 애플리케이션의 지속적인 통합 및 배포 파이프라인을 구성합니다. Code Pipe Line은 소스 코드 변경, 빌드, 테스트, 배포 통합 등의 단계를 자동으로 처리하여 애플리케이션 업데이트를 수행합니다.
6. 스케일 아웃 이벤트 설정 
- Auto Scaling그룹의 스케일 아웃 이벤트를 설정하여 트래픽 증가에 따라 자동으로 인스턴스를 추가합니다. 예를 들어 CPU 사용률이 특정 임계값을 초과하면 스케일 아웃 이벤트가 트리거되어 새로운 인스턴스를 시작합니다.
7. 로깅 및 모니터링
- 인프라의 성능을 모니터링하고 문제를 식별하기 위해 Amazon Cloud Watch와 같은 서비스를 사용할 수 있습니다. 또한 로그를 중앙 집중화하여 분석하고 문제 해결을 위한 정보로 활용할 수 있습니다.
