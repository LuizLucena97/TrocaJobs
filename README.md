# Troca Jobs
API do projeto Troca jobs

## Tarefas

- [ ] CRUD de USUÁRIOS
- [ ] CRUD de SERVIÇOS
- [ ] CRUD de PORTFÓLIO

## Documentação da API

### Endpoint
- [Cadastrar usuário](#Cadastrar-usuário)
- [Listar dados do usuário](#Listar-dados-do-usuário)
- [Apagar conta do usuário](#Apagar-conta-do-usuário)
- [Editar dados do usuário](#Editar-dados-do-usuário)

### Cadastrar usuário

`POST` /usuario

Cria um novo usuário com os dados enviados no corpo da requisição

#### Corpo da Requisição

|campo|tipo|obrigatório|descrição|
|-----|----|:---------:|---------|
|imagem de perfil|string| ✔|Imagem de perfil do usuário|
|senha|string|✔|Senha de no mínimo 8 dígitos do usuário
|email|string|✔|Email do usuário
|nome|string|✔|Um nome curto para o serviço|
|sobrenome|string|✔|Sobrenome do usuário|
|telefone|int|✔|Número de telefone do usuário|
|profissão|string|✔|Profissão que aparecerá em buscas|
|localidade|string|✔|Estado e/ou cidade que aparecerá em buscas
|sobre mim|string|❌|Descrição sobre trabalho e o profissional
```js
    {
        "imagemPerfil": "29d2hv237tf3r79t",
        "senha": "senha123",
        "email" : "fulana@gmail.com",
        "nome": "Fulana",
        "sobrenome": "de tal",
        "telefone": "119400000000",
        "profissao": "manicure",
        "localidade": "São Paulo",
        "sobreMim": "Manicure apaixonada por unhas impecáveis e designs criativos."
    }


```

#### Exemplo de Resposta

```js
    {
        "id": 1,
        "imagemPerfil": "29d2hv237tf3r79t",
        "senha": "senha123",
        "email" : "fulana@gmail.com",
        "nome": "Fulana",
        "sobrenome": "de tal",
        "telefone": "119400000000",
        "profissao": "manicure",
        "localidade": "São Paulo",
        "sobreMim": "Manicure apaixonada por unhas impecáveis e designs criativos."
    }

```

#### Código de Status

|código|descrição|
|------|---------|
|200|A conta do usuário foi criada com sucesso
|403|Conta não foi criada pois a senha é inválida
|409|Conta não foi criada pois já existe um usuário com este endereço de email
|500|No geral são erros do servidor e não há nada para o cliente fazer


### Listar dados do usuário

`GET` /usuario/`{id}`

Retorna os dados do usuário com o `id` informado como parâmetro de path.

#### Exemplo de Resposta

```js
[
    // requisição para /usuario/1
    {
        "id": 1,
        "imagemPerfil": "29d2hv237tf3r79t",
        "senha": "senha123",
        "email" : "fulana@gmail.com",
        "nome": "Fulana",
        "sobrenome": "de tal",
        "telefone": "119400000000",
        "profissao": "manicure",
        "localidade": "São Paulo",
        "sobreMim": "Manicure apaixonada por unhas impecáveis e designs criativos."
    }
]

```

#### Código de Status

|código|descrição|
|------|---------|
|200|Os dados do usuário foram retornados com sucesso
|401|Acesso negado. Você deve se autenticar
|404|Não foi encontrado usuário com o `id` informado
|500|No geral são erros do servidor e não há nada para o cliente fazer

### Apagar conta do usuário

`DELETE` /usuario/`{id}`
Apaga a conta do usuário com o `id` especificado no parâmetro de path.

#### Código de Status

|código|descrição|
|------|---------|
|204|A conta do usuário foi apagada com sucesso.
|401|Acesso negado. Você deve se autenticar
|404|Não foi encontrado usuário com o `id` informado

### Editar dados do usuário

`PUT` /usuario/`{id}`

Altera dos dados do usuário especificado no id, utilizando as informações enviadas no corpo da requisição.


#### Corpo da Requisição

|campo|tipo|obrigatório|descrição|
|-----|----|:---------:|---------|
|imagem de perfil|string| ✔|Imagem de perfil do usuário|
|senha|string|✔|Senha de no mínimo 8 dígitos do usuário
|nome|string|✔|Um nome curto para o serviço|
|sobrenome|string|✔|Sobrenome do usuário|
|telefone|int|✔|Número de telefone do usuário|
|profissão|string|✔|Profissão que aparecerá em buscas|
|localidade|string|✔|Estado e/ou cidade que aparecerá em buscas
|sobre mim|string|❌|Descrição sobre trabalho e o profissional
```js
    {
        "imagemPerfil": "29d2hv237tf3r79t",
        "senha": "senha123",
        "email" : "fulana@gmail.com",
        "nome": "Fulana",
        "sobrenome": "de tal",
        "telefone": "119400000000",
        "profissao": "manicure",
        "localidade": "São Paulo",
        "sobreMim": "Manicure apaixonada por unhas impecáveis e designs criativos."
    }

```

#### Exemplo de Resposta

```js
    {
        "id": 1,
        "imagemPerfil": "29d2hv237tf3r79t",
        "senha": "senha123",
        "email" : "fulana@gmail.com",
        "nome": "Fulana",
        "sobrenome": "de tal",
        "telefone": "119400000000",
        "profissao": "manicure",
        "localidade": "São Paulo",
        "sobreMim": "Manicure apaixonada por unhas impecáveis e designs criativos."
    }

```

#### Código de Status

|código|descrição|
|------|---------|
|200|Dados do usuário editados com sucesso.
|400|Dados enviados são inválidos. Verifique o corpo da requisição.
|401|Acesso negado. Você deve se autenticar
|404|Não existe usuário com o `id` informado