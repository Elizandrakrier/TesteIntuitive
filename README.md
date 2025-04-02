### Projeto - Teste Intuitive

Este projeto realiza uma análise de dados de operadoras de saúde com importação no PostgreSQL, consultas analíticas e uma API Flask com busca textual nas operadoras ativas.

## Estrutura

```
projeto-teste-intuitive/
├── Backend/
│   ├── app.py
│   ├── operadoras.csv
│   └── requirements.txt
├── Banco_de_Dados/
│   ├── demonstracao.sql
│   ├── operadoras.sql
│   └── instrucoes_postgres.txt
├── colecao_postman.json
```

---

1. Executar a API
2. Crie um ambiente virtual
3. Instale as dependências:
4. Inicie o servidor Flask

A API estará disponível em: [http://127.0.0.1:5050](http://127.0.0.1:5050)

---

## Como testar a API

Importe a collection no Postman.

Use a rota:
```
[GET /buscar?termo=unimed](http://127.0.0.1:5050/buscar?termo=unimed)
```

Ela retornará os dados das operadoras que contém o termo pesquisado no nome.


