<div align = "center">
<h2> Curso Bacharelado em Sistemas de Informação
<br>Programação Orientada a Objetos 
  
<br>Projeto Final
<br> PetCare System 
</div>

### `📄Descrição do Projeto:`
### Integração de aplicação para Transferência e Troca de Informações em um Ambiente de Banco de Dados. O PetCare System é uma aplicação para gerenciamento de uma clínica veterinária, especialmente focado na administração de consultas médicas para animais de estimação. Ele oferece funcionalidades essenciais para o dia a dia da clínica, permitindo que veterinários, clientes e pets sejam registrados no sistema.

### **Objetivo:**
### O projeto tem como objetivo estabelecer uma comunicação entre o sistema criado e um banco de dados por meio de CRUD`S(Create, Read, Update e Delete), permitindo a transferência bidirecional de informações. A implementação visa facilitar a troca de dados e disponibilidade das informações.

### `⚙️Principais Funcionalidades:`

### 1. Cadastro de Entidades:
###   - Veterinários, clientes, consultas e animais de estimação podem ser cadastrados no sistema.
<div align = "center">
<img src="https://github.com/mw-bl/POO-Projeto-VetClinic/assets/115299182/9da4214a-c8ce-4520-aa1e-67a9fb34075c">
</div>
    
### 2. Agendamento de Consultas:
###  - Os clientes podem agendar consultas para seus animais de estimação.
###  - As consultas são associadas a veterinários específicos e pets.
<div align = "center">
<img src="https://github.com/mw-bl/POO-Projeto-VetClinic/assets/115299182/b76851bb-2bd4-4354-9594-14321c7ba8e7">
</div>

### 3. Gerenciamento de Pets:
###    - Informações detalhadas sobre os animais de estimação, como nome, espécie, raça, idade, etc.
###    - Associação entre pets e seus respectivos tutores (clientes).
<div align = "center">
<img src="https://github.com/mw-bl/POO-Projeto-VetClinic/assets/115299182/d2d2c73e-1a6e-42bd-bff8-8d9c79a775fe">
</div>

### 4. Consulta de Clientes:
###  - Visualização de todos os clientes registrados na clínica.
<div align = "center">
<img src="https://github.com/mw-bl/POO-Projeto-VetClinic/assets/115299182/5888c6c6-9d9d-4618-961c-4427d1ae582c">
</div>

### 5. Consulta de Veterinários:
###  - Visualização de todos os veterinários registrados na clínica.
<div align = "center">
<img src="https://github.com/mw-bl/POO-Projeto-VetClinic/assets/115299182/ba4037f6-4454-4036-8585-670fd98786e9">
</div>

### 6. Consulta de Consultas:
###   - Visualização de todas as consultas agendadas, incluindo detalhes como data, hora, veterinário, pet associado e notas.
<div align = "center">
<img src="https://github.com/mw-bl/POO-Projeto-VetClinic/assets/115299182/c110a88c-1655-452d-a1a8-3738fa9e3e30">
</div>

### `🛠️ Componentes Principais:`
### 1. **Interface de Usuário:**
###   - Desenvolvimento de uma interface simples pelo próprio terminal com loop e switch case para que o usuário possa interagir com o sistema.
<div align = "center">
<img src="https://github.com/mw-bl/POO-Projeto-VetClinic/assets/115299182/a9036ee0-ed8b-428e-a275-f60383f75b96">
</div>

### 3. **Comunicação com o Banco de Dados:**
###   - Estabelecimento de conexão eficiente com o banco de dados por meio do `JDBC (Java Database Connectivity)`.
###   - Desenvolvimento de funções JAVA que preparam instruções SQL para recuperar, inserir, atualizar e excluir informações no banco de dados.

### 4. **Manuseio de Erros e Exceções:**
###   - Implementação de verificações para o tratamento de erros e exceções por meio da classe de exceção `SQL Exception` para facilitar a identificação e tratamento de erros.

### `📈Resultados Esperados:`
### - Estabelecimento de uma solução eficaz para transferência e troca de informações entre o sistema e o banco de dados.
### - Melhoria na eficiência operacional, permitindo ao usuário acessar e manipular dados de forma interativa.

### `🧑🏽‍💻Tecnologias Utilizadas:`
### - Linguagem de programação `JAVA`.
### - Sistema de Gerenciamento de Banco de Dados relacional `MySQL`.

### `⚔️Desafios Superados:`
### - Identificação e resolução de problemas específicos no código durante o desenvolvimento.
### - Otimização de consultas para melhorar o desempenho.

### `🧠Guia de Instalação e Execução - PetCare System`
### Requisitos Prévios:
###  - Java Development Kit (JDK) instalado.
###  - MySQL Database instalado.

### Instruções:
###  - Clone o Repositório: `git clone https://github.com/mw-bl/POO-Projeto-VetClinic.git`

### Configure o Banco de Dados:
###  - Abra o script SQL fornecido `(database/script.sql)` e execute-o no MySQL Workbench para criar as tabelas necessárias.

### Configuração do JDBC:
###  - Baixe o conector do JDBC(versao 8.0.30) por este link: https://jar-download.com/artifacts/mysql/mysql-connector-java.
### No ECLIPSE:
###  - Build path->configurar build path
###  - Libraries->add external jar

### No VS CODE:
###  - Vá em `Java Projects` e em `Referenced Libraries` adicione o conector JDBC

### Abra o arquivo Conexao.java localizado na pasta src/db.
### Insira suas credenciais do MySQL (nome de usuário, senha, URL do banco de dados) nas variáveis USERNAME, PASSWORD e URL.
<div align = "center">
<img src="https://github.com/mw-bl/POO-Projeto-VetClinic/assets/115299182/5fc6a664-2ad9-40bd-9ebe-62aa7fe6139f">
</div>

### ``📊Conclusão:``
### O projeto resultou em uma solução eficaz para a comunicação entre o sistema e o banco de dados, proporcionando uma experiência eficiente para os usuários. A implementação cuidadosa garantiu a funcionalidade do sistema, atendendo às demandas estabelecidas no início do projeto.

<div align = "center">
<h3> Desenvolvido por:
  
<br> 👨🏽‍💻 Marcos Willian
<br> 👩🏻‍💻 Maria Eduarda Aires
</div>
