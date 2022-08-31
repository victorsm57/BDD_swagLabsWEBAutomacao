@smoke
Feature: Testar a funcionalidade de Login

  Scenario Outline: Checar se o login é bem sucedido com credenciais válidas

    Given o usuário está na página de Login
    When o usuário preenche os campos de <username> e <password>
    And e aperta o botão de login
    Then o usuário é levado para a página inicial

    Examples:

      | username | password |
      | standard_user | secret_sauce |
      | problem_user | secret_sauce |


    Scenario Outline: Checar se o login é negado com credenciais inválidas

      Given o usuário inválido está na página de Login
      When o usuário inválido preenche os campos de <usernameInválido> e <passwordInválido>
      And o usuário aperta o botão de login
      Then o usuário é impedido de seguir em frente

      Examples:

      | usernameInválido | passwordInválido |
      | sjsaisjsn        | sjsndjdjdjd      |
      | sjsjsjsjsjsj     | sjsjsjs          |
