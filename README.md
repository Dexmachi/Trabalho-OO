# 📌 **Sistema de Gerenciamento de Clínica Médica**  

## 🏛️ Universidade de Brasília (UnB)  
📍 **Faculdade do Gama (FGA)**  
📚 **Curso:** Orientação a Objetos  
👨‍🏫 **Professor:** André Luiz Peron Martins Lanna  

---

## 📖 **Descrição do Projeto**  
Este projeto tem como objetivo desenvolver um **Sistema de Gerenciamento de Clínica Médica** utilizando **Java** e aplicando os principais conceitos de **Orientação a Objetos (OO)**, como **modularidade, encapsulamento, herança, polimorfismo e tratamento de exceções personalizadas**.  

O sistema permite gerenciar **pacientes, médicos, consultas, exames, prescrições e pagamentos**, garantindo regras de um sistema de gerenciamento, como:  
✔ **Agendamento de consultas** considerando disponibilidade de médicos e pacientes.  
✔ **Cadastro e histórico médico** de pacientes e médicos.  
✔ **Prescrição e controle** de exames e medicamentos.  
✔ **Gestão de pagamentos** e bloqueio de pacientes com pendências financeiras.  
✔ **Adicionar mais informaçãoaqui** -mais info?-.  

---

## 🎯 **Funcionalidades Principais**  

### 🔹 **1. Cadastro e Gestão de Usuários**  
✅ **Pacientes**: Nome, CPF, Data de Nascimento, Histórico Médico.  
✅ **Médicos**: Nome, CPF, Data de Nascimento, CRM, Especialidade, Histórico Médico.  
✅ **Regras**: CRUD completo e bloqueio de cadastros duplicados por CPF.  

### 🔹 **2. Agendamento de Consultas**  
✅ CRUD completo para consultas médicas.  
✅ Restrições:  
   - Médico deve estar disponível.  
   - Paciente não pode ter outra consulta no mesmo horário.  
   - Especialidade do médico deve ser compatível.  
✅ Informações obrigatórias: Data, Hora, Duração, Status, Paciente, Médico, Exames e Medicamentos, Valor.  

### 🔹 **3. Prescrição de Exames e Medicamentos**  
✅ Médicos podem prescrever exames e medicamentos.  
✅ CRUD completo para exames e prescrições.  
✅ Atributos principais: Tipo, Datas, Resultado, Custo, Validade.  

### 🔹 **4. Gestão de Pagamentos**  
✅ Cada consulta/exame tem um valor associado.  
✅ Pacientes com pendências financeiras não podem agendar novas consultas.  

### 🔹 **5. Tratamento de Exceções Personalizadas**  
✅ `HorarioIndisponivelException` → Quando um médico já tem uma consulta no horário solicitado.  
✅ `PagamentoPendenteException` → Quando um paciente tenta agendar sem quitar débitos anteriores.  
✅ `EspecialidadeInvalidaException` → Quando um médico não possui a especialidade requerida.  

---

## 🔧 **Requisitos Técnicos**  
✅ **Encapsulamento** → Uso de atributos privados e getters/setters.  
✅ **Herança e Polimorfismo** → Implementação de sobrecarga, sobrescrita e uso de Generics.  
✅ **Modularidade** → Código organizado em pacotes:  
   - `entidades` → Classes principais (Paciente, Médico, Consulta, Exame, Pagamento, etc.).  
   - `servicos` → Regras de negócio (agendamentos, pagamentos, notificações).  
   - `excecoes` → Classes de exceções personalizadas.  
✅ **Diagrama UML** → Representação gráfica das classes e suas relações.

---

## 🖼️ **Diagrama UML**  
📌 **A UML do sistema está disponível na seção de documentação.**  

---

## 👥 **Colaboradores**  
1. [Nome do Colaborador 1]  
2. [Nome do Colaborador 2]  
3. [Nome do Colaborador 3]  
4. [Nome do Colaborador 4]  

---

## 📎 **Links Importantes**  
📄 **Relatório Completo (PDF):** [Clique aqui](#)  
🎥 **Vídeo Demonstrativo:** [Clique aqui](#)  

---

🚀 **Este projeto foi desenvolvido com foco em boas práticas de programação e conceitos sólidos de Orientação a Objetos!**
