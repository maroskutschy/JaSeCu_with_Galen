Feature: Login to Linton

  Scenario: Successful Login to Linton with default credentials
     Given I validate page using Galen Framework "loginLinton" file
     When I populate values: username "xxx" , password "yyy"
     Then I validate page using Galen Framework "loginLinton_with_inserted_text" file
     When I click on signIn Button
     And Linton Welcome Page is successfully displayed






