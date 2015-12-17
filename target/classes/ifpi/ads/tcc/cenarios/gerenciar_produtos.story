Título: Gerenciar produtos

Narrativa:
Como um usuário
Desejo criar, editar, apagar e visualizar produtos
De modo que gerenciar produtos

Cenário: Visualizar os produtos
Dado que eu tenho os produtos iPad, iPhone
Quando eu vou para a lista de produtos
Então eu devo ver iPad
E eu devo ver iPhone

Cenário: Criar um produto
Dado que eu não tenho produtos cadastrados
E que eu esteja na lista de produtos
Quando eu clico novo
E eu preencho o Nome do produto com iPad
E eu preencho o Preço do produto com 499.0
E eu aperto criar
Então eu devo ver "Produto criado com sucesso"
E eu devo ver iPad

Cenário: Editar um produto
Dado que eu tenho o produto iPad
E que eu esteja na lista de produtos
Quando eu clico editar
E eu preencho o Nome do produto com iPhone
E eu preencho o Preço do Produto com 199.0
E eu aperto atualizar
Então eu devo ver "Produto atualizado com sucesso"
E eu devo ver iPhone

Cenário: Apagar um produto
Dado que eu tenho os produtos iPad, iPhone
E que eu esteja na lista de produtos
Quando eu clico deletar
Então eu não devo ver iPad
E eu devo ver iPhone