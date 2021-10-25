Feature: Shopping Cart Experience

  Scenario: SETUP APPLICATION
    Given   browser loads the web app

  Scenario: USER NAVIGATES TO APPLICATION LANDING PAGE - VERIFY THAT USER LANDS ON MMYNTRA HOME PAGE
    Given   user is on landing page
    Then    page title should be "Online Shopping for Women, Men, Kids Fashion & Lifestyle - Myntra"

  Scenario: USER SEARCHES FOR PRODUCT ON APPLICATION - VERIFY THAT USER IS SHOWN PRODUCT UNDER SEARCH DROPDOWN
    Given   user searches for product "Men Teal Blue Regular Fit" on product page
    When    user selects "Roadster Men Teal Blue Off White Regular Fit Printed Casual Shirt" from product search
    Then    page title should be "Roadster Men Teal Blue Off White Regular Fit Printed Casual Shirt"

  Scenario: USER SELECTS PRODUCT TO VIEW DETAILS - VERIFY THAT USER IS SHOWN PRODUCT DETAIL PAGE
    When    user picks "Roadster Men Teal Blue Regular Fit Printed Casual Shirt" from available products
    Then    user is shown product details for "Men Teal Blue Regular Fit Printed Casual Shirt"

  Scenario: USER ENTERS PIN CODE TO CHECK PIN CODE SERVICEABILITY - VERIFY THAT PRODUCT DELIVERY MESSAGE SHOWN
    When    user enters pin code "403507"
    Then    verify user entered pin code is serviceable

  Scenario: USER SELECTS ADDS THE PRODUCT TO CART - VERIFY THAT PRODUCT ADDED TO CART
    When    user adds product "Roadster Men Teal Blue Regular Fit Printed Casual Shirt" to cart
    Then    verify product details added to cart

  Scenario: TEARDOWN APPLICATION
    Given   application teardown


#  Scenario: USER LOGS IN TO APPLICATION - VERIFY THAT USER HAS SUCCESSFULLY LOGGED IN
#    Given   user is on landing page
#    When    user logs in with his credentials
#    Then    user has successfully logged in