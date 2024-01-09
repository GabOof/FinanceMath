# Projeto final POOII

## Nome do Projeto: Finance Math

## Grupo: Arthur Segheto, Gabrielle Fonseca, Maria Eduarda, Pedro Arthur

## Padrões de projeto utilizados:

### GOF

#### Singleton

O padrão Singleton foi implementado no projeto para garantir que apenas uma instância da classe `Conexao` seja criada durante a execução do programa. Isso é particularmente útil quando se trata de estabelecer uma conexão com o banco de dados, pois evita a sobrecarga de recursos e garante uma abordagem mais eficiente.

**Arquivos Modificados:**

O padrão Singleton foi implementado no arquivo `Conexao.java`. Nesse arquivo, foram feitas alterações para garantir que a classe `Conexao` tenha apenas uma instância e que essa instância seja acessível globalmente.

**Funcionamento do Padrão no Projeto:**

1. **Conexao.java:**
   - Foi adicionado um método estático `getInstance` que retorna a instância única da conexão. Se essa instância ainda não existir ou estiver fechada, uma nova conexão é criada.
   - A variável `conn` foi marcada como estática para armazenar a única instância da conexão.

2. **CarteiraDAO.java:**
   - No construtor da classe `CarteiraDAO`, a instância única da conexão é obtida usando o método estático `Conexao.getInstance()`.

**Benefícios do Padrão Singleton no Projeto:**

- **Eficiência:** Garante que apenas uma instância da conexão seja criada, evitando a sobrecarga de recursos.
- **Centralização da Lógica de Conexão:** A lógica de criação da conexão está centralizada na classe `Conexao`, facilitando a manutenção e garantindo consistência em todo o projeto.
- **Acesso Global:** A instância única da conexão pode ser acessada globalmente, simplificando a obtenção da conexão em diferentes partes do código.

Ao implementar o Singleton, o projeto ganha em eficiência, organização e manutenibilidade, garantindo uma abordagem robusta para a gestão de conexões com o banco de dados.

#### Observer

O padrão Observer foi utilizado para notificar os interessados sobre as mudanças na entidade "Carteira".

**Arquivos Modificados:**

O padrão Observer foi implementado nas classes CarteiraDAO.java, CarteiraLogger.java e CarteiraObserver.java

**Funcionamento do Padrão no Projeto:**

1. **CarteiraDAO.java:**

A classe CarteiraDAO desempenha o papel de um Data Access Object (DAO) no contexto do aplicativo. Suas principais funções incluem interagir com o banco de dados para realizar operações relacionadas à entidade Carteira, como inserção, exclusão e consulta de registros. Além disso, a classe oferece métodos para calcular o total de ganhos, o total de gastos e listar os registros da carteira. 

2. **CarteiraLogger.java:**

A classe CarteiraLogger implementa a interface Observer. Uma classe que implementa Observer é capaz de receber notificações de um objeto observado. O método update da interface Observe é chamado sempre que o objeto observado (CarteiraDAO, neste caso) notifica seus observadores. 

3. **CarteiraObserver.java:**

A interface CarteiraObserver define um conjunto de métodos que uma classe pode implementar para agir como um observador de mudanças em uma instância da classe Carteira ou em valores de ganhos e gastos.Essa interface fornece um mecanismo genérico para observar mudanças em diferentes aspectos da carteira, como a própria carteira, ganhos ou gastos. 

**Benefícios do Padrão Observer no Projeto:**

- **Desacoplamento:** Promove o desacoplamento entre objetos observados e observadores. Isso significa que o sujeito (objeto observado) não precisa ter conhecimento direto dos observadores, reduzindo a dependência e permitindo a extensão do sistema sem modificar o código existente. 
- **Notificação Eficiente:** Facilita a notificação eficiente de mudanças de estado. Os observadores são automaticamente atualizados quando ocorrem alterações no sujeito, garantindo que recebam informações em tempo real.

#### Factory Method

O Factory Method foi implementado no projeto para abstrair a criação de objetos CarteiraDAO, tornando mais fácil de modular e manter o projeto.

**Arquivos Modificados**

O padrão Factory Method foi implementado nas classes CarteiraDAOFactory.java e DAOFactory.java

**Funcionamento do Padrão no projeto**

1. **CarteiraDAOFactory.java**

O padrão Factory Method é utilizado na classe CarteiraDAOFactory.java para criar instâncias de CarteiraDAO.
Na classe CarteiraDAOFactory.java, é implementada a interface DAOFactory e sobrescreve-se o método createDAO(). Este método, quando chamado, retorna uma nova instância de CarteiraDAO.

2. **DAOFactory.java**

O método createDAO() é o "método de fábrica" no padrão Factory Method. Ele é responsável por criar e retornar uma instância de um objeto DAO. Isso é deixado para as classes concretas de fábrica decidirem.

**Benefícios do padrão Factory Method no projeto:**

- **Abstração da lógica de criação de objetos:** O padrão Factory Method abstrai a lógica de criação de objetos, o que torna o código mais limpo e fácil de entender. No projeto, por exemplo, a criação de objetos CarteiraDAO é abstraída na classe CarteiraDAOFactory.

- **Flexibilidade:** O padrão Factory Method permite que alteremos a classe de objetos que são criados sem alterar o código que usa esses objetos. Por exemplo, se quiséssemos mudar a implementação de CarteiraDAO, precisariamos alterar apenas o método createDAO() na classe CarteiraDAOFactory.  

- **Promove o princípio da responsabilidade única:** Cada fábrica é responsável por criar um tipo específico de objeto, o que está alinhado com o princípio da responsabilidade única. Isso torna o código mais modular e fácil de manter.  

- **Facilita o teste unitário:** Como a criação de objetos é centralizada em fábricas, podemos substituir facilmente essas fábricas durante o teste unitário para criar objetos mock.  

- **Promove o uso de composição em vez de herança:** O padrão Factory Method favorece a composição em vez da herança, o que pode tornar o código mais flexível e menos propenso a problemas associados à herança, como o problema do diamante.

### GRASP

#### MVC (Model-View-Controller)

O projeto adota uma abordagem simplificada do padrão MVC (Model-View-Controller), onde a responsabilidade do controller é incorporada nas próprias telas.

**Arquivos Modificados:**
'Menu1', 'FrameApp', 'CadastroView'

**Funcionamento do MVC Simplificado**

- **Telas como Controllers:**
Cada tela (Menu1, FrameApp, CadastroView) atua como um controlador para sua própria lógica de controle.

- **Interligação com o Modelo:**
As telas são responsáveis por interagir diretamente com o modelo (CarteiraDAO.java) para obter ou modificar dados.

- **Comunicação Direta:**
A comunicação entre a visão e o modelo é feita diretamente pelas telas, simplificando a estrutura do código.

**Vantagens do MVC Simplificado no Projeto**

- **Simplicidade:**
Simplifica a estrutura do projeto ao integrar a lógica de controle diretamente nas telas.

- **Adequado para Projetos Menores:**
É uma abordagem eficaz para projetos mais simples, onde a complexidade do MVC completo não é necessária.

- **Agilidade no Desenvolvimento:**
Facilita o desenvolvimento rápido e ágil, adequado para pequenos projetos ou protótipos.

**Exemplo de Uso**

- **Lógica de Controle Embutida:**
Cada tela (Menu1, FrameApp, CadastroView) contém a lógica de controle necessária para suas operações específicas.

- **Interconexão Simples:**
A comunicação direta entre a visão e o modelo é simplificada pela falta de um controller centralizado.

