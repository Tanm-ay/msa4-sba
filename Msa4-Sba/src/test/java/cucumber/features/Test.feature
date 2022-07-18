Feature: Gillette Test
@one
Scenario Outline: Click on Mach3 under Products and verify result product

Given <driverType> driver is initialized
And User navigates to <site> website homepage
When User hovers over Products
And Clicks on Mach3
Then <text> should be present on results page

Examples:
|driverType		|site			|text					|
|Chrome			|Gillette		|Gillette MACH3 Turbo	|

Scenario Outline: Search in search box and verify the result heading

Given <driverType> driver is initialized
And User navigates to <site> website homepage
When User clicks on search button
And Enters <text> into search box
Then <text2> should be displayed on top of results page

Examples:
|driverType		|site			|text		|text2				|
|Chrome			|Gillette		|Razor		|Results For "Razor"|

Scenario Outline: Click Styling footer link and verify result style text

Given <driverType> driver is initialized
And User navigates to <site> website homepage
When User clicks Styling link in footer section
Then <text3> should be present under style articles

Examples:
|driverType		|site			|text3									|
|Chrome			|Gillette		|Facial Hair Styles: The Anchor Beard	|
