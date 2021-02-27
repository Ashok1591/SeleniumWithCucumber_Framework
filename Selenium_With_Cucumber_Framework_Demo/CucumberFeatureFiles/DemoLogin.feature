Feature: Test Login page functionality

Background: User should be on login page
	Given User is on login page
	

@sanity	
Scenario: Successful Login with valid credentials
	Given Page title should be "Account Login"
	When User enters User Email as "ashokleela1521@gmail.com" and Password as "Selenium12345"
	And Click on login
	Then User should be redirected on "My Account"