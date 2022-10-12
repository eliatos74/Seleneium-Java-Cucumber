# language: pt

Funcionalidade: Receber desconto da QAzando
  Eu como usuário da qazando
  quero receber um cupom de desconto
  para comprar um curso com valor reduzido

@gerar-cupom
  Cenario: Visualizar codigo de desconto
    Dado que estou no site qazando
    Quando eu preencho meu email
    E clico em ganhar cupom
    Então eu vejo o codigo de desconto

