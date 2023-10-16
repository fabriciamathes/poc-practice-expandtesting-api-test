# poc-practice-expandtesting-api-test
Practice-expand-testing Tests

## 🎯 Geral

* Projeto responsável pela automação da API [practice.expandtesting](https://practice.expandtesting.com/notes/api/api-docs/).
* Este projeto entrega uma aplicação **Java** com **RestAssured**.

## 📄 **Pré-requisitos**
* Para que este projeto funcione de _maneira adequada_, deve-se seguir as seguintes orientações:
    * Ter instalado a **JDK11**;
    * Ter instalado o Gradle **7.5.1**;
    * Ter instalado uma IDE (preferencialmente **intellij**);

## ⚒️ Tecnologias Utilizadas
* Java (preferencialmente >= **11**)
* Gradle (preferencialmente > **7.5.1**)
* RestAssured **5.3.0**
* TestNG **7.7.0**
* Lombok **1.18.24**
* Test Results Reporter **v1.0.17**
* Allure-Report **2.22.1**
    * Os relatórios gerados pela Automação são salvos automaticamente na pasta **allure-results** na
      raiz do projeto.

### ⚙ Local

* #### Executando por tipos de testes - via terminal:

  | Tipo de teste                    | Comando                                                                                             |
  |:-------------------------------------------------------------------------------------------------------------------|:----------------------------------------------------------------------------------------------------|
  | **HealthCheck** | gradle test --tests **"healthcheck.*"** -i -Penv=`VARIAVEL_AMBIENTE`                                | 
  | **Contrato**   | gradle test --tests **"contrato.*"** -i -Penv=`VARIAVEL_AMBIENTE`  -PtestCycleName=`VARIAVEL_NOME`  |
  | **Funcionais**    | gradle test --tests **"funcional.*"** -i -Penv=`VARIAVEL_AMBIENTE`  -PtestCycleName=`VARIAVEL_NOME` |

* #### Executando todos os testes - via terminal:

  | Tipo de teste | Comando                                    | Descrição                             |
  |:--------------|:-------------------------------------------|:--------------------------------------|
  | **Todos**     | ./gradlew clean test                       | Executa **todos os tipos** de testes. |
