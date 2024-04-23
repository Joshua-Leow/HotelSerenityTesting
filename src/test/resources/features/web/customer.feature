Feature: Customer features

    Rule: Not logged in
    Background:
        Given User is on the landing page

    Scenario: Verify the display on the Landing Page
        Then User should see Dashboard page elements

    Scenario: Verify the display on the Rooms Page
        When User clicks Rooms
        Then User should see Rooms page elements

    Scenario: Verify the display on the Amenities Page
        When User clicks Amenities
        Then User should see Amenities page elements