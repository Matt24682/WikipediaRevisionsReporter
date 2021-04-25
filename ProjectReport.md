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
class within the Injector. I then created a new interface, Formatter, that would require a string to be returned 
and would use a revision from the Revision class as its required parameter. 
After that, I made a new class, called the AlternateFormatter, which is meant to format and return the 
revision as a string, displayed in a more user-friendly way. Finally, I configured the AlternateFormatter class
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

Originally, the program used a "for" loop that took each revision in the list of revisions and formatted it before
placing it into a string builder to be displayed. The new approach that I took to remove the loop was to instead 
convert the revision list into a stream, map each revision to the formatter (which in turn would return a string),
collect and join each string together (in a way that gave each revision its own line), and set the entire process to 
one variable (of String type) that could be placed in the outputArea. Overall, I still hold a slight preference toward
using the iterative ("for" loop) approach because it was one of the things that I was taught when I first started 
programming to where it is what I'm more familiar with. However, I can definitely see the benefit of the functional 
approach, and if I work with it more often, I may eventually prefer the functional approach because while they both 
accomplish the same task, the functional approach can not only do the same thing as the iterative approach in one line
of code, but it can also make the code a bit cleaner and clearer to read.

## Reflection Question #2: Polymorphism and Dependency Inversion

Polymorphism engendered dependency inversion in a couple of different places throughout this program.

One case where polymorphism occurs is with the Formatter interface. Originally, the WikipediaAnalyzer class
called on RevisionFormatter to format the revision and return it as a string directly back to the WikipediaAnalyzer 
class. Instead, the WikipediaAnalyzer class, uses the Formatter interface, in which the RevisionFormatter would 
implement the interface instead of using what was given directly from the WikipediaAnalyzer. In the end, both the 
RevisionFormatter (along with the AlternateFormatter) and the WikipediaAnalyzer depend on the interface. The 
dependency inversion occurs with the RevisionFormatter/AlternateFormatter classes because originally, they didn't 
depend on anything, but now they depend on the interface since they implement it (hence reversing the flow
of execution).

A similar case where polymorphism could apply is with the QueryEngine interface. Instead of WikipediaAnalyzer 
directly calling the FakeQueryEngine or WikipediaQueryEngine, it uses the interface, while the 
FakeQueryEngine and WikipediaQueryEngine implement the interface. As a result, all three of the classes depend on 
QueryEngine, when if they weren't using an interface, the FakeQueryEngine and the WikipediaQueryEngine wouldn't have 
had to depend on anything (hence also showing dependency inversion and the reversal of the flow of execution).