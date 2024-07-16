# mantis-automated-tests

Este projeto é uma suite de testes automatizados para a ferramenta Mantis, utilizando Java e Selenium e TestNG. O projeto segue o padrão de Page Object para organização dos elementos da página e ações.

## Índice

- [Estrutura do Projeto](#estrutura-do-projeto)
- [Requisitos](#requisitos)
  - [Instalando Java](#instalando-java)
  - [Instalando Maven](#instalando-maven)
  - [Instalando Git](#instalando-git)
- [Clonando o Repositório](#clonando-o-repositório)
- [Instalando as dependências do projeto](#instalando-dependências)
- [Executando os Testes](#executando-os-testes)
- [Licença](#licença)
- [Autor](#autor)

## Estrutura do Projeto

O projeto está organizado da seguinte forma:

         ├── src/

            └── test/
           
               └── java/
        
                   └── mantis/
        
                       ├── pages/
        
                       ├── elements/
        
                       ├── test/
        
                       ├── utils/
        
               └── resources/

         └── pom.xml

- [pages] Contém as classes que representam as páginas do Mantis.
- [elements] Contém as classes que encapsulam os elementos das páginas.
- [test] Contém as classes de teste que definem os cenários de teste usando TestNG.
- [utils] Contém classes utilitárias e helpers usadas nos testes.
- [resources] Contém arquivos de recursos como propriedades e dados de teste.

## Requisitos

Para executar este projeto, você precisará das seguintes ferramentas instaladas em seu sistema:

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Maven](https://maven.apache.org/)
- [Git](https://git-scm.com/)

### Instalando Java

1. Faça o download e instale o JDK a partir do site oficial da Oracle.
2. Verifique a instalação executando o comando:

   java -version

Deve retornar a versão instalada do Java.

### Instalando Maven

1. Faça o download e instale o Maven a partir do site oficial.
2. Verifique a instalação executando o comando:

  mvn -version

Deve retornar a versão instalada do Maven.

### Instalando Git

1 Faça o download e instale o Git a partir do site oficial.
2. Verifique a instalação executando o comando:

  git --version

Deve retornar a versão instalada do Git.

## Clonando o repositório

1. Clone o repositório do projeto para o seu ambiente local usando o comando:

  git clone https://github.com/Liscsb/mantis-automated-tests.git

## Instalando dependências

1. Antes de executar os testes, você precisa configurar as dependências do projeto. Instale as dependências através do Maven navegando até o diretório do projeto clonado e executando o comando: 

mvn clean install

## Executando os testes

1. Antes de executar os testes, note que as informações de Usuário e Senha são sensíveis e estão protegidas. Portanto, será necessário setar os seus valores nas variáveis de ambiente conforme exemplo a seguir:

  MANTIS_USERNAME = <your_username>
  MANTIS_PASSWORD = <your_password>

2. Feito isso, vá até o arquivo RunTests.java e execute-o.
3. Os relatórios gerados estarão disponíveis na pasta test-output gerada após a execução. Para fácil entendimento, procure pelo arquivo emailable-report.

## Licença

Este projeto está licenciado sob a Licença MIT - veja o arquivo LICENSE para mais detalhes.

## Autor: 

Lisandra C. S. Bernardo
