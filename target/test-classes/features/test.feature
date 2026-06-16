Feature: ParaBank Authentication Tests

  @TC_002
  Scenario: TC_002 - Successfully login with registered account credentials
    Given open site
    And pre register user
    When login with registered credentials
    Then user is logged in successfully

  @TC_003
  Scenario: TC_003 - Verify account balance is displayed after login
    Given open site
    And pre register user
    When login with registered credentials
    Then balance shown

  @TC_004
  Scenario: TC_004 - Complete end-to-end sign-up and sign-in flow
    Given open site
    When register
    Then user is logged in successfully
    And balance shown
