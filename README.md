# 𝙵𝚒𝚗𝚊𝚗𝚌𝚢
___
## Java SpringBoot MVC web application, that helps with home  expenses management
___
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-%23005C0F.svg?style=for-the-badge&logo=Thymeleaf&logoColor=white)
![HTML5](https://img.shields.io/badge/html5-%23E34F26.svg?style=for-the-badge&logo=html5&logoColor=white)
![CSS3](https://img.shields.io/badge/css3-%231572B6.svg?style=for-the-badge&logo=css3&logoColor=white)
![Bootstrap](https://img.shields.io/badge/bootstrap-%23563D7C.svg?style=for-the-badge&logo=bootstrap&logoColor=white)
![JavaScript](https://img.shields.io/badge/javascript-%23323330.svg?style=for-the-badge&logo=javascript&logoColor=%23F7DF1E)
![Chart.js](https://img.shields.io/badge/chart.js-F5788D.svg?style=for-the-badge&logo=chart.js&logoColor=white)
![AWS](https://img.shields.io/badge/AWS-%23FF9900.svg?style=for-the-badge&logo=amazon-aws&logoColor=white)
![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)
![Jenkins](https://img.shields.io/badge/link.enumerableentity.financy.jenkins-%232C5263.svg?style=for-the-badge&logo=link.enumerableentity.financy.jenkins&logoColor=white)
![Git](https://img.shields.io/badge/git-%23F05033.svg?style=for-the-badge&logo=git&logoColor=white)
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)
___
## Used Java technologies

+ ### Java 11 (Amazon Corretto 11.0.14 JDK)
+ ### SpringBoot v2.6.0
  + #### starter-web
  + #### starter-data-jpa
  + #### starter-thymeleaf
  + #### starter-security
  + #### starter-test
  + #### devtools
+ ### Spring Framework v5.3.13 
+ ### Thymeleaf v3.0.12
+ ### Hibernate v5.6.1.Final
+ ### H2 in-memory database v1.4.200 for development
+ ### MariaDB database v10.6.5 for production
+ ### JUnit v5.8.1
+ ### Mockito v4.0.0
+ ### Apache Maven v3.8.1
+ ### Jenkins v2.319.2 

<h3 align="center">Dashboard</h3>
<img src="https://enumerable-entity.s3.eu-central-1.amazonaws.com/Dashboard.jpg"/>

## Requirements for Run

+ Installed Java Runtime - [11](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html) or higher
+ Free TCP port -  8080

## Requirements for Build
+ Installed Java Runtime - [11](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html) or higher
+ Installed [Apache Maven](https://maven.apache.org/download.cgi)

## Run example
### Run already compiled package
1. Download package from GitHub packages repository under [link.enumearble-entity.financy](https://github.com/enumerable-entity/Financy/packages/) group id.
- #### Windows OS
    - Double-click on downloaded package with `*.jar` extension.
      >In this case, there is no visible reaction happen. But in task manager should appear "*Java(TM) Platform SE binary*" process.
      That mean that application is, probably, **up-and-run**
    - Or, open terminal in folder that contains the `package` and type command :
      ```sh
      java -jar .\financy-{version}.jar
      ```
- #### GNU/Linux based OS
    - Open terminal in folder that contains the `package` and type command :
      ```sh
      java -jar financy-{version}.jar
      ```
## Build executable `jar` example
1. In root directory of project, that contains `pom.xml` file, open terminal and run Maven task
    ```sh
    mvn package
    ```
   Compiled and ready to run artifact will be placed under `target` directory.
## Accessing to app UI
### For accessing to application UI, open your web browser and go to `localhost:8080`

## Contact
[My GitHub](https://github.com/enumerable-entity/)

Artur Babii – [@LinkedIn](https://www.linkedin.com/in/cloneable/) – artur.babii@yahoo.com

Distributed under the ![APM](https://img.shields.io/apm/l/vim-mode) See ``LICENSE`` for more information.

<!-- Markdown link & img dfn's -->
[npm-image]: https://img.shields.io/npm/v/datadog-metrics.svg?style=flat-square
[npm-url]: https://npmjs.org/package/datadog-metrics
[npm-downloads]: https://img.shields.io/npm/dm/datadog-metrics.svg?style=flat-square
[travis-image]: https://img.shields.io/travis/dbader/node-datadog-metrics/master.svg?style=flat-square
[travis-url]: https://travis-ci.org/dbader/node-datadog-metrics

