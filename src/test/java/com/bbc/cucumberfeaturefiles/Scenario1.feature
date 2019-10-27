Feature: Defining personilized news topics on ABC News app

Scenario Outline: Selecting three different topics

	Given User launches BBC News App
	When he goes to My News page and adds the topics <topic1>, <topic2> and <topic3>
	Then he should see the personilized news feed for those topics
	
Examples:
|topic1			|topic2			|topic3		|
|Asia				|Australia	|India		|