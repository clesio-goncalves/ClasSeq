Título: Consultar CNPJ

Narrativa:
Como um vendedor 
Desejo consultar os clientes com o CNPJ
De modo que conseguir negociar com ele estando melhor informado

Dado que o vendedor pesquisa o cliente
E inseri um CNPJ inválido
Quando apertar no botão "Consultar"
Ou clicar fora do campo de CNPJ
Então uma mensagem informando "CNPJ Inválido, por favor coloque um CNPJ válido." deve ser exibida

Dado que o vendedor pesquisa o cliente
E inseri um CNPJ válido
Quando apertar no botão "Consultar"
OU clicar fora do campo de CNPJ
Então será exibido uma tabela com uma única linha, contendo: o nome, CNPJ e status do cliente
E um botão chamado "Visualizar dados do cliente" será exibido junto a linha retornada
