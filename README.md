# Library Database with Swift UI
A group project with code contributions from
Charlie Cox and Joseph Antholzner

Using the Swift library we created a simulation of a libraries creation a storing of new library items and library card holders.

# UML Diagram
![alt text](https://github.com/BryanPKS/Library-Database-UI/blob/main/Library%20Class%20Diagram.png)

# Internal Database
Every entity in the library is under the Items super class.
It has the relevant data so we can store new items and allow them to be checked out by our patrons.
There are subsets of the main Items class with their own special attributes.
For instance, Reference books may not be checked out and best sellers have a smaller checkout window then the normal books.
All of the books are stored in their own text document with the attributes showing their individual classes they are a part of.

Users have their personal information along with a list of items they have currently rented and their accrued debts.
Children have a lower limit to the books that they can checkout aswell.
