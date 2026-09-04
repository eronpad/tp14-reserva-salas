# Sistema de Reserva de Salas

Programa simples em Java, via terminal, para reservar salas de estudo/reunião em horários específicos.

## Funcionalidades

- Exibir a grade de horários com o status de cada sala (livre/ocupado)
- Reservar uma sala em um horário disponível
- Consultar os horários de uma sala específica
- Cancelar uma reserva existente

## Como executar

Compile e rode o `Main.java`:

```bash
javac Main.java
java Main
```

O programa vai pedir:
1. O número da sala (1 a 4)
2. O horário desejado (1 a 6)
3. Se o horário estiver livre, o nome de quem está reservando

## Estrutura de dados

As reservas são armazenadas em uma matriz de Strings:

```java
static String[][] reservas = new String[5][6];
```

- **Primeiro índice → sala** (1 a 4, o índice 0 não é usado)
- **Segundo índice → horário** (0 a 5, representando os horários abaixo)

Cada posição `reservas[sala][horario]` guarda:
- `null` se o horário estiver livre
- o nome do responsável, se estiver reservado

## Salas e horários disponíveis

| Sala   | Índice |
|--------|--------|
| Sala 1 | 1      |
| Sala 2 | 2      |
| Sala 3 | 3      |
| Sala 4 | 4      |

| Horário | Índice |
|---------|--------|
| 12:00   | 0      |
| 12:30   | 1      |
| 13:00   | 2      |
| 13:30   | 3      |
| 14:00   | 4      |
| 14:30   | 5      |

## Estrutura do projeto

```
.
├── Main.java     # Toda a lógica do programa (única classe)
└── README.md
```

## Possíveis melhorias

- Menu com loop para reservar/cancelar várias vezes sem reiniciar o programa
- Persistir as reservas em arquivo (para não perder ao fechar)
- Validar entradas inválidas (sala/horário fora do intervalo)
