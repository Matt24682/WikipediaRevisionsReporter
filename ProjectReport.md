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

(Explain your solution to Challenge #3. If it is not complete, change
the subsection title above to "Incomplete" and explain how far you got
and where you got stuck.)

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

