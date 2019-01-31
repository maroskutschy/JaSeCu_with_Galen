Feature: Login to Facebook

  #@Login
  #Scenario: Successful Login to Facebook with specified credentials
  #  When I successfully login to facebook with email "jasecuframework@gmail.com" and password "Jasecu12"
    #When I successfully login to facebook with email "XXX" and password "Jasecu12"
   # Then Facebook Welcome Page is successfully displayed

  Scenario: Successful Login to Facebook with default credentials
    #Given I open browser for Galen Framework ""
    And I validate page using Galen Framework "login2" file
    And I populate values: email "jasecuframework@gmail.com" , password "Jasecu12"
    And I validate page using Galen Framework "login2_with_inserted_text" file
    When I successfully login to facebook with default credentials
    Then Facebook Welcome Page is successfully displayed
    #And I validate page using Galen Framework "login2.gspec" file


#  Scenario Outline: Unsuccessful Login to Facebook
#    When I unsuccessfully login to facebook with email "<email>" and password "<password>"
#    Then Because of "<reason of problem>" Incorrect Login Page is displayed with following message "<message>"
#
#    Examples:
#      |reason of problem               |email                      |password   |message                                                                                     |
#      |Incorrect password              |jasecuframework@gmail.com  |JasecuXX12X|The password you’ve entered is incorrect. Forgot Password?X                                  |
#      |Incorrect email or phone number |jasecuxxframeworkx         |Jasecu12   |The email or phone number you’ve entered doesn’t match any account. Sign up for an account. |
#      |Incorrect email                 |xyzadsfasd@gmail.com       |Jasecu12   |The email you’ve entered doesn’t match any account. Sign up for an account.                 |
#      |Incorrect email and password    |xyzadsfasd@gmail.com       |JasecuXX12X|The email you’ve entered doesn’t match any account. Sign up for an account.                 |





    ####
    #####