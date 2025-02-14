# 📌 **Sistema de Gerenciamento de Clínica Médica**

## 🏛️ Universidade de Brasília (UnB)  
📍 **Faculdade do Gama (FGA)**  
📚 **Curso:** Orientação a Objetos  
👨‍🏫 **Professor:** André Luiz Peron Martins Lanna  

---

## 👥 **Alunos**  
1. Caio Rocha de Oliveira - 232001371  
2. Lucas Machado Peres Ricarte - 232014093  
3. Alberto Côrtes Cavalcante - 232014610  
4. João Guilherme - 232014039  

---

## 📖 **Descrição do Projeto**  
O projeto consiste em um **Sistema de Gerenciamento de Clínica Médica** escrito em **Java**, aplicado com conceitos de **Orientação a Objetos (OO)**, como **encapsulamento, herança, polimorfismo**, além de boas práticas de modularização e tratamento de exceções.  

O sistema centraliza as seguintes funcionalidades:  
1. **Cadastro de médicos e pacientes**  
2. **Agendamento de consultas**  
3. **Prescrições e exames**  
4. **Menu interativo** que diferencia as ações de um médico ou paciente no sistema  
5. **Validações** e tratamento de erros (ex.: blocos em construtores, exceções personalizadas, etc.)

---

## 🖼️ **Diagrama UML**  
O diagrama UML está em desenvolvimento e será disponibilizado na pasta de documentação para visualizar a relação entre entidades como `Paciente`, `Medico`, `Consulta`, `CadastroMed`, `CadPac`, `CadConsul`, `CadPres` e `Menu`.

[CLIQUE AQUI](https://drive.google.com/drive/folders/1QoEI-NbRET1cxxU5YL1Cq9JUzfpoNRNA?usp=sharing)
---

## 🖼️ **Como executar o programa?**

📌 **Use a versão JDK 17!**

1. Clique em **Code**, selecione **Download Zip** e escolha a pasta de destino para baixar o arquivo.  
2. Descompacte o arquivo e abra a pasta `Pasta-exemplo` no seu editor de código (ou a pasta que você criou para o projeto).  
3. Instale e habilite os recursos necessários para desenvolvimento em Java no VS Code, por exemplo o [Java Extension Pack](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack).  
4. Na pasta `src`, localize o arquivo `Main.java`.  
5. Abra o arquivo e, com o botão direito do mouse, selecione **Run Java** para iniciar o programa.  

---

## 🎯 **Funcionalidades Principais**

### 1. Cadastro de Pacientes e Médicos  
- **Classe `Paciente`**:  
  - Estende `Pessoa` (contém atributos como nome, CPF e data de nascimento).  
  - Possui vínculo com `CadConsul` para acessar consultas do paciente.  
  - Métodos de acesso e manipulação do histórico ou dados do paciente.  
- **Classe `Medico`**:  
  - Também estende `Pessoa`.  
  - Atributos adicionais: CRM, especialidade.  
  - Métodos para prescrever medicamentos/exames, consultar histórico profissional, etc.  
- **Cadastro de Usuários**:  
  - **`CadPac`** gerencia a lista de pacientes (adicionar, remover, buscar, atualizar).  
  - **`CadastroMed`** gerencia a lista de médicos (adicionar, remover, buscar, atualizar).  

### 2. Agendamento de Consultas  
- **Classe `CadConsul`**:  
  - Controla a criação, exclusão e listagem de consultas.  
  - Verifica disponibilidade de médicos e pacientes (em expansão).  
  - Envolve validações e exceções personalizadas (como conflitos de horário).  

### 3. Prescrições e Exames  
- **Classe `CadPres`**:  
  - Armazena, cria e gerencia prescrições (exames, medicamentos, etc.).  
  - Está associada a `CadConsul` para vincular a prescrição com a consulta específica.  
  - Em desenvolvimento para exibir históricos detalhados de prescrições.  

### 4. Menu Interativo  
- **Classe `Menu`**:  
  - Apresenta opções diferentes para médico ou paciente (via `JOptionPane` ou console).  
  - Através de métodos como `iniciarMenu()`, `menuStaff()`, e `menuClientes()`, direciona o sistema para funcionalidades específicas (cadastrar, editar, remover, listar).  
  - Recebe instâncias de cadastro (`CadastroMed`, `CadPac`, `CadConsul`, `CadPres`) e as utiliza para as operações internas.  

### 5. Tratamento de Erros  
- **Erros de piloto** (ex.: `StackOverflowError`) normalmente ocorrem por construtores recursivos.  
- **Exceções personalizadas** podem ser criadas para tratar tentativas de cadastro duplicado, horários indisponíveis etc.  
- **Estrutura de validação** em cada classe de cadastro, para evitar inconsistências.

---

## 🔧 **Estrutura em Pacotes**

1. **Menu**  
   - `Menu.java` → Classe que gerencia a interação com o usuário (input e redirecionamento).  
2. **Cadastros**  
   - `CadPac.java`, `CadastroMed.java`, `CadConsul.java`, `CadPres.java` → Classes responsáveis pela lógica de cadastro, listagem e gestão de pacientes, médicos, consultas e prescrições.  
3. **Clientes**  
   - `Paciente.java` → Representa o paciente, contendo dados específicos e métodos associados.  
4. **Staff**  
   - `Medico.java` → Representa o médico, com informações adicionais como CRM e especialidade.
5. **Prescricoes**
    - `Consulta.java` armazena `Prescricoes.java` que por sua vez armazena `Exame.java`, `Medicamento.java` e `Tratamento.java`.

---

## 📎 **Links Importantes**  
📄 [Relatório do Projeto](https://drive.google.com/drive/folders/1Q75sfF1lBK0VQ9cw1dvMnUe_U_m1ezMk?usp=drive_link) (PDF)

---

## 💻 **Exemplos de Entradas e Funcionamento**

1. **Cadastro de um Paciente**  
   - Exemplo: `new Paciente("teste", "001", "25/02/2025", cadConsul)`.
   - Nome: teste, cpf: 001, data de nascimnto: 25/02/2025.
   - Em seguida, `cadPac.cadastrarPac(paciente)` insere o registro no sistema.  

2. **Cadastro de um Médico**  
   - Exemplo: `new Medico("Jorge", "001", "25/02/2025", "001", "consulta")`.
   - Nome: Jorge, CRM: 001, data de nascimnto: 25/02/2025, cpf: 001
   - Em seguida, `cadM.cadastrarMed(medico)` armazena o médico.  

3. **Agendamento de uma Consulta**  
   - Através de `cadConsul.criarConsulta(medico, paciente, data, horario)`, relacionando médico e paciente.  
   - Futuras expansões vão validar conflitos de horário ou disponibilidade de agenda.  

4. **Execução do Programa** (via classe `Main`)  
   - Instancia objetos de cadastro: `CadastroMed`, `CadPac`, `CadConsul`, `CadPres`.  
   - Chama `Menu.iniciarMenu()` para fornecer interface de decisão ao usuário.  

Use esses exemplos para testar e validar o comportamento de cada parte do sistema.  

---

