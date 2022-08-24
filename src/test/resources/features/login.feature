Feature: Testar a funcionalidade de Login

  Scenario: Checar se o login é bem sucedido com credenciais válidas

    Given o usuário está na página de Login
    When o usuário preenche os campos de usuername e password
    And e aperta o botão de login
    Then o usuário é levado para a página inicial