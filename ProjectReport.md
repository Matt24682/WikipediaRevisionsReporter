# Project Report

Matthew Johnson

## Challenge #1 Complete

To solve this challenge, within the configure method of the QueryEngineModule
class, I changed bind(QueryEngine.class).to(FakeQueryEngine.class) to
bind(QueryEngine.class).to(WikipediaQueryEngine.class). As a result, the program
can start taking live data from Wikipedia servers rather than using the fake result.
I also went ahead and suppressed a warning saying that I could remove the FakeQueryEngine class
since it was no longer being assigned or used for anything specific.

## Challenge #2 Complete

To solve this challenge, I started by creating a new module, FormatModule, and added it to the App 
class within the Injector. I then created a new interface that would require a string to be returned 
and would use a revision from the Revision class as its required argument. 
After that, I made a new class, called the AlternateFormatter, which is meant to format and return the 
revision as a string in a more user-friendly way. Finally, I configured the AlternateFormatter class
within FormatModule using bind(Formatter.class).to(AlternateFormatter.class), injected the Formatter interface within 
the WikipediaAnalyzer class, and removed the RevisionFormatter class call from the method, runQuery.

## Challenge #3 Complete

To solve this challenge, I created a variable called "revisionString" (that was of String type) that first
used the variable "response", generated from the QueryEngine interface, and used response.revisions()
to create the list of revisions.Then I converted the list to a stream using .stream() and continued by 
using .map() to where it would map each of the revisions to the formatter interface. As a result, a 
string would be returned, and I used .collect() with Collectors.joining("\n") inside to where it would 
combine all the string revisions into one string in which each revision was displayed on its own line.
The last step was to change the outputArea from outputting a stringBuilder to outputting the revisionString
variable.

## Reflection Question #1: Functional vs OO

(Write one or more paragraphs comparing and contrasting the iterative and functional  
approaches to string concatenation you explored in challenge #3. Which do you
prefer, and why?)

## Reflection Question #2: Polymorphism and Dependency Inversion

(Explain how polymorphism engendered dependency inversion in this little
application. Be clear and precise here, as this is, in part, an assessment of
your correct use of technical terminology.
Consider, for example, where exactly is polymorphism used?
Where exactly is a dependency inverted?)

