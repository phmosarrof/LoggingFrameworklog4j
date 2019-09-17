@Smoke @Functional 
Feature: To check my health bog's functionality

  Background: 
    Given I want to go to Home Page of my blog

  Scenario: Children Health
    When I Click the Children Health Menu
    Then I can navigate to the Children Health page sucessfully
@wip
  Scenario Outline: To verify my blog's recent post link
    When I Click the first "<link>" of the recent post
    Then I can navigate to the first recent "<post_page>" sucessfully
    """
    MyTest is successfull 
    """

    Examples: 
      | link                                                        | post_page                               |
      | Females Information to Mature Acne                          | Acne is a generally happening epidermis |
      | How To Quit Locks Loss                                      | Are you a man United Nations agency     |
      | Easy Guidelines To Quit Hair Loss                           | Ever wondered about methods in which    |
      | Acne Can Create Your Experience Look Ugly                   | A very prevalent issue that is          |
      | Fat loss Formula Both Diet program Information And For many | When you end up bent reducing your fat  |
