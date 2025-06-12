
# 🧠 Java OOP Exercise - Exercício de Orientação a Objetos

Este repositório contém a resolução de um exercício prático de **programação orientada a objetos**, desenvolvido com o objetivo de aprofundar conhecimentos fundamentais da linguagem **Java** e seus recursos modernos.

## 🚀 Tecnologias Utilizadas

- **Java 17** (Oracle)
- **IntelliJ IDEA** (IDE)

## 📚 Objetivos e Aprendizados

Esse projeto foi essencial para consolidar a compreensão de diversos conceitos importantes da orientação a objetos e da linguagem Java. Abaixo, listei os principais aprendizados com exemplos reais extraídos do código-fonte:

---

### 🧩 Entidades

As entidades representam os objetos centrais do sistema, como `Worker`, `Department` e `HourContract`.

```java
public class Worker {
    private String name;
    private WorkerLevel level;
    private Double baseSalary;
    private Department department;
    private List<HourContract> contracts = new ArrayList<>();
}
```

---

### 🔗 Composição de Entidades

A classe `Worker` contém um objeto `Department` e uma lista de `HourContract`, demonstrando composição.

```java
private Department department;
private List<HourContract> contracts = new ArrayList<>();
```

---

### 🗂️ Organização de Classes

As classes estão bem separadas por responsabilidade no pacote `entities`, e a lógica principal no pacote `application`.

```
src/
├── application/
│   └── Program.java
├── entities/
│   ├── Department.java
│   ├── HourContract.java
│   ├── Worker.java
│   └── enums/
│       └── WorkerLevel.java
```

---

### 🧾 Enum

O enum `WorkerLevel` representa os níveis de um trabalhador, facilitando a leitura e evitando valores mágicos.

```java
public enum WorkerLevel {
    JUNIOR,
    MID_LEVEL,
    SENIOR;
}
```

Uso no código:

```java
WorkerLevel workerLevel = WorkerLevel.valueOf(scanner.nextLine().toUpperCase().replace(" ", "_"));
```

---

### 📋 List<\> e 🔄 Stream API

A classe `Worker` armazena contratos em uma `List<HourContract>` e usa a **Stream API** para filtrar contratos por mês e ano:

```java
List<HourContract> newList = contracts.stream()
    .filter(contract ->
        contract.getDate().getYear() == year &&
        contract.getDate().getMonthValue() == month
    )
    .toList();
```

---

### 🔣 Condicionais (`if`) e Repetições (`for`)

A lógica de repetição está presente ao inserir contratos para o trabalhador:

```java
for (int i = 0; i < contractsValue; i++) {
    // leitura dos dados do contrato
}
```

E há condicionais dentro da `Stream` e em outros trechos do código, como ao filtrar por data.

---

### 🛠️ Métodos e Construtores

**Construtores**:

```java
public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
    this.name = name;
    this.level = level;
    this.baseSalary = baseSalary;
    this.department = department;
}
```

**Método** de cálculo de rendimento:

```java
public Double income(Integer year, Integer month) {
    List<HourContract> newList = contracts.stream()
        .filter(contract ->
            contract.getDate().getYear() == year &&
            contract.getDate().getMonthValue() == month)
        .toList();

    Double incomeSum = baseSalary;
    for (HourContract contract : newList) {
        incomeSum += contract.totalValue();
    }

    return incomeSum;
}
```

---

### 📆 Manipulação de Datas

A biblioteca `java.time` (API moderna de data e hora do Java) foi utilizada para tratar datas de contratos e cálculos mensais de renda.

```java
DateTimeFormatter dateFormartter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
YearMonth incomeDate = YearMonth.parse(incomeDateString, DateTimeFormatter.ofPattern("MM/yyyy"));
```

Uso na filtragem por ano e mês:

```java
contract.getDate().getYear() == year &&
contract.getDate().getMonthValue() == month
```

Essa abordagem oferece mais segurança e clareza do que as antigas classes `Date` e `Calendar`.

---

## 📝 Considerações

Esse exercício foi fundamental para solidificar a compreensão dos pilares da orientação a objetos em Java, além de proporcionar contato prático com recursos mais modernos da linguagem, como a Stream API. O projeto também reforçou boas práticas de organização de código, composição de entidades e uso de enums.

---
