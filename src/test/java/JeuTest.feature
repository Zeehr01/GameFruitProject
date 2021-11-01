Feature: Ajouter un jeu dans un salon

  En tant qu'utilisateur je veux pouvoir ajouter un jeu dans un salon

  Scenario: Ajouter un jeu au salon
    Given  un jeu
    When l'utilisateur ajoute le jeu dans le salon
    Then le jeu apparait dans la liste

  Scenario: Ajouter un autre jeu au salon
    Given  un autre jeu
    When l'utilisateur ajoute un autre le jeu dans le salon
    Then le jeu apparait dans la liste des jeux du salon


  Scenario: Supprimer un jeu d'un salon
    Given un jeu
    When l'utilisateur supprime un jeu dans le salon
    Then le jeu n'apparaît pas dans le salon


  Scenario: Créer plusieurs salons de jeu
    Given un salon
    When l'utilisateur ajoute un salon de jeu
    Then le salon est ajouté à la liste des salons

  Scenario: Supprimer un salon de jeu
    Given un salon
    When l'utilisateur supprime un salon de jeu
    Then le salon sera supprimé de la liste de la plateforme

  Scenario: Ajouter des joueurs dans un salon
    Given un joueur
    When l'utilisateur ajouter un joueur dans un salon
    Then le joueur est ajouté dans le salon

  Scenario: Supprimer des joueurs d’un salon
    Given un joueur
    When l'utilisateur supprime un joueur
    Then le joueur est retiré de la liste