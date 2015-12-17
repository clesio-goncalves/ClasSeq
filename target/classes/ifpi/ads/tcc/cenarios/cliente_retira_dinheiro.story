Título: Cliente retira dinheiro

Narrativa:
Como um cliente
Desejo retirar dinheiro de um caixa automático
De modo que eu não tenha que esperar numa fila de banco

Cenário: Conta está em crédito
Dado que a conta está em crédito
E o cartão é válido
E o caixa tem dinheiro suficiente
Quando o cliente solicita dinheiro
Então verifique que a conta foi debitada
E verifique que o dinheiro é entregue
E verifique que o cartão é devolvido

Cenário: Conta está negativa além do limite
Dado que a conta está negativa
E o cartão é válido
Quando o cliente requisitar o dinheiro
Então é exibida a seguinte mensagem: "Conta está negativa além do limite"
E o dinheiro não é entregue
E o cartão é devolvido

Dado que a conta está negativa
E o cartão é válido
Quando o cliente solicita dinheiro
Então verifique que uma mensagem de rejeição é mostrada
E o dinheiro não é entregue
E o cartão é devolvido