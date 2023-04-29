# CSE231s: Advanced Computer Programming
## Lab6: Exception handling
In this lab we want to sort some containers according to their shortnames. The files should be of extension arxml and so the modified files will be of the same extension.

We made Class Containers with setters,getters,overridden to String and compare to be able to sort the containers according to the String"short name"later on in the main.

We made 2 classes for Exception handling:
EmptyFileException: to make sure that the input file is not empty.
NotValidExtension: to make sure that the input file is of type "arxml"

In the main:

- After taking the input from the user, we try to read the file making sure it's not empty, otherwise the EmptyFileException is thrown and also making sure it's of type "arxml" , otherwise a message identifying the problem whether it's because of the no content or extension appears to the user.

In case we have a non-empty arxml file:

- We try to read the first line searching for the string"container" to get the UUID number.., save it
then we do the same with short-name and long-name

- After each container we make a new object and adjust its datafields through setters of class Containers, the created objects are the contents of the arraylist which is helpful for containers sorting.

- We sort the containers where we compare according to the overridden method compareTo in Class Containers and display the new sorted modified file to the user using the override toString in Class Containers
