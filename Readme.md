# Sistema Bancário em Java 💰

Este é um projeto de sistema bancário simples desenvolvido em Java, que utiliza o PostgreSQL como banco de dados. O sistema permite realizar várias operações bancárias, incluindo o registro de clientes, contas, transações e a consulta de informações relacionadas.

## Funcionalidades

### 1. Registrar um Cliente 👤

O sistema permite registrar novos clientes com informações básicas, como nome, CPF, endereço e telefone.

### 2. Registrar uma Conta 🏦

É possível criar novas contas bancárias vinculadas a um cliente. As contas podem ser de diferentes tipos, como conta corrente, poupança, etc.

### 3. Registrar uma Transação 💸

Os clientes podem realizar transações, como depósitos, saques e transferências entre contas. Todas as transações são registradas para fins de registro e auditoria.

### 4. Verificar Transações de uma Conta Específica 📝

Os clientes podem verificar todas as transações associadas a uma conta específica, fornecendo o número da conta.

### 5. Verificar Contas de um Cliente 🧾

Os clientes podem listar todas as contas vinculadas à sua identidade, facilitando o acompanhamento de suas finanças.

## Como Configurar

1. Certifique-se de ter o PostgreSQL instalado e configurado no seu sistema.
2. Crie um banco de dados chamado "banco" no PostgreSQL.
3. Configure suas credenciais de acesso ao banco de dados no arquivo `application.properties` do projeto.

## Tecnologias Utilizadas

- Java
- PostgreSQL
- Maven

Este projeto foi desenvolvido para fins didáticos e pode ser personalizado e estendido de acordo com as necessidades específicas do seu banco.

