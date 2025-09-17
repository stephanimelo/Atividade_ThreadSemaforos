# Simulações em Java - Cavaleiros e Aeroporto

Este repositório contém duas simulações feitas em Java que demonstram conceitos de concorrência, threads e sincronização.

---

## 1. Simulação dos 4 Cavaleiros no Corredor

### Descrição

4 cavaleiros caminham por um corredor, simultaneamente, de 2 a 4 m por 50 ms. O corredor é
escuro, tem 2 km e em 500 m, há uma única tocha. O cavaleiro que pegar a tocha, aumenta sua
velocidade, somando mais 2 m por 50 ms ao valor que já fazia. Em 1,5 km, existe uma pedra
brilhante. O cavaleiro que pegar a pedra, aumenta sua velocidade, somando mais 2 m por 50 ms
ao valor que já fazia (O cavaleiro que já detém a tocha não poderá pegar a pedra). Ao final dos 2
km, os cavaleiros se deparam com 4 portas e, um por vez pega uma porta aleatória (que não pode
repetir) e entra nela. Apenas uma porta leva à saída. As outras 3 tem monstros que os devoram.

### Como funciona a simulação

- Cada cavaleiro é uma thread que se move simultaneamente.
- O acesso para pegar a tocha e a pedra é controlado para que apenas um cavaleiro consiga pegar cada item.
- A velocidade de cada cavaleiro é ajustada conforme os itens que ele obtém.
- No final, portas são escolhidas aleatoriamente e o resultado é exibido.

---

## 2. Simulação do Aeroporto com Duas Pistas de Decolagem

### Descrição

Um aeroporto tem 2 pistas (norte e sul) e, em cada pista, apenas um avião pode fazer a decolagem.
O procedimento de decolagem tem 4 fases (taxiar, decolagem e afastamento da área). A fase de
manobra pode durar de 300 a 700 milissegundos A fase de taxiar, de 500 a 1000 milissegundos. A
fase de decolagem, de 600 a 800 milissegundos. A fase de afastamento, de 300 a 800 milissegundos.
O aeroporto reúne, por ciclo, 12 aeronaves que podem decolar pela pista norte ou pela pista sul
(decisão aleatória) mas, apenas 2 aviões podem circular pela área de decolagem ao mesmo tempo.
Fazer uma aplicação em Java que resolva o problema.

### Como funciona a simulação

- Cada avião é representado por uma thread que passa pelas 4 fases.
- Sincronização é feita para garantir que as regras de acesso à pista e à área de decolagem sejam respeitadas.
- O uso de semáforos controla o número máximo de aviões na área e em cada pista.
