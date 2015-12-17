Título: Preenchimento de Pedido

Narrativa:
Como um usuário
Desejo preencher um pedido
De modo que finalizar uma venda

Cenário: Verificar o saldo de produtos
Dado que o estoque tem 10 produtos
Quando eu verifico verifico que há a disponibilidade para vender 5 produtos
Então deve retornar "true"

Cenário: Pedido preenchido com sucesso
Dado que o estoque tem 10 produtos
Quando eu preencho um pedido com 3 produtos
Então deve ser retornado que o status de preenchimento do pedido é "true"