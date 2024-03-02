# FlashShopCo
Documentação da API de uma loja de vendas onlines.


## Endpoints

- Produtos
    - [Listar Todas](#listar-todas)
    - [Detalhar](#detalhar-produtos)
    - [Cadastrar](#cadastrar-produto)
    - [Apagar](#apagar-produto)
    - [Editar](#editar-produto)

- Movimentações

---

### Listar Todas
`GET` /produtos

Retorna um array com todas as produtos cadastrados.

**Exemplo:**

```js
[
    {
        "id": 1,
        "nome": "MacBook",
        "valor": "20000.00",
        "imagem": "Computador"
        "quantidade": "15"
    }
]
```

**Códigos de Status**

| código | descrição | 
|--------|-----------|
|200|Dados retornados com sucesso

---

### Detalhar Produto

`GET` /produto/{id}

Retorna o produto com o `id` informado.

**Exemplo:**

```js
    {
        "id": 2,
        "nome": "AirPods",
        "valor": "900.00",
        "imagem": "Fone de Ouvido",
        "quantidade": "23"
    }
```
**Códigos de Status**

| código | descrição | 
|--------|-----------|
|200|Dados retornados com sucesso
|404| Id da produto não encontrado

---

### Cadastrar Produto
`POST` /produto

Insere um novo produto.

**Corpo da Requisição:**

|campo|tipo|obrigatório|descrição 
|-----|----|:-----------:|-----------|
|nome|string| ✅ |Um nome curto para a produto
|valor|double| ✅ |Valor do produto
|quantidade|int|✅|Quantidade do produto no estoque
|imagem|string|❌|Imagem do Produto

```js

    {
        "nome": "AirPods",
        "valor": "900.00",
        "imagem": "Fone de Ouvido",
        "quantidade": "23"
    }

```

**Exemplo de resposta:**

```js

    {
        "id": 2,
        "nome": "AirPods",
        "valor": "900.00",
        "imagem": "Fone de Ouvido",
        "quantidade": "23"
    }

```

**Códigos de Status**

| código | descrição | 
|--------|-----------|
|201|Produto criada com sucesso
|400|Erro de validação - verifique o corpo da requisição

---

### Apagar Produto

`DELETE` /produto/{id}

Apaga os dados da produto com o `id` informado.



**Códigos de Status**

| código | descrição | 
|--------|-----------|
|204|Produto apagada com sucesso
|404| Id da produto não encontrado

---
### Editar Produto

`PUT` /produto/{id}

Atualiza os dados da produto com o `id` informado.

|campo|tipo|obrigatório|descrição 
|-----|----|:-----------:|-----------|
|nome|string| ✅ |Um nome curto para a produto
|valor|double| ✅ |Valor do produto
|quantidade|int|✅|Quantidade do produto no estoque
|imagem|string|✅|Imagem do Produto

**Corpo da Requisição:**
```js

    {
    
        "nome": "AirPods",
        "valor": "900.00",
        "imagem": "Fone de Ouvido",
        "quantidade": "23"
    }

```

**Exemplo de resposta:**

```js

    {
        "id": 1,
        "nome": "AirPods",
        "valor": "900.00",
        "imagem": "Fone de Ouvido",
        "quantidade": "23"
    }

```

**Códigos de Status**

| código | descrição | 
|--------|-----------|
|200|Produto atualizada com sucesso
|400| A validação falhou - verifique o corpo da requisição
|404| Id da produto não encontrado
