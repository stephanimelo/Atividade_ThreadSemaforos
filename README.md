# Simulações em Java - Cavaleiros e Aeroporto

Este repositório contém duas simulações feitas em Java que demonstram conceitos de concorrência, threads e sincronização.

---

## 1. Simulação dos 4 Cavaleiros no Corredor

### Descrição

Quatro cavaleiros caminham simultaneamente por um corredor de 2 km. Cada cavaleiro anda inicialmente entre 2 a 4 metros a cada 50 ms. No corredor:

- A 500 metros há uma única tocha. O cavaleiro que pegar a tocha aumenta sua velocidade em +2 metros por 50 ms.
- A 1,5 km há uma pedra brilhante. O cavaleiro que pegar a pedra (e que não tenha a tocha) aumenta sua velocidade em +2 metros por 50 ms.
- Ao final dos 2 km, os cavaleiros encontram 4 portas. Cada cavaleiro escolhe uma porta aleatória (sem repetição). Apenas uma porta leva à saída; as outras três têm monstros que devoram os cavaleiros.

### Como funciona a simulação

- Cada cavaleiro é uma thread que se move simultaneamente.
- O acesso para pegar a tocha e a pedra é controlado para que apenas um cavaleiro consiga pegar cada item.
- A velocidade de cada cavaleiro é ajustada conforme os itens que ele obtém.
- No final, portas são escolhidas aleatoriamente e o resultado é exibido.

---

## 2. Simulação do Aeroporto com Duas Pistas de Decolagem

### Descrição

Simulação de um aeroporto que possui duas pistas (norte e sul). O processo de decolagem envolve 4 fases:

- Manobra: dura entre 300 e 700 ms.
- Taxiar: dura entre 500 e 1000 ms.
- Decolagem: dura entre 600 e 800 ms.
- Afastamento da área: dura entre 300 e 800 ms.

Regras do aeroporto:

- Cada pista permite a decolagem de apenas um avião por vez.
- Apenas 2 aviões podem circular na área de decolagem simultaneamente.
- Por ciclo, 12 aviões são simulados e cada um escolhe aleatoriamente entre a pista norte ou sul para decolar.

### Como funciona a simulação

- Cada avião é representado por uma thread que passa pelas 4 fases.
- Sincronização é feita para garantir que as regras de acesso à pista e à área de decolagem sejam respeitadas.
- O uso de semáforos controla o número máximo de aviões na área e em cada pista.
