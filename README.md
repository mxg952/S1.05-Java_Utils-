# S1.05 - Java Utils

## Level 1

**Exercise 1**  
Create a class that lists the contents of a given directory in alphabetical order.
```
java -cp bin src/main/level1/ex1/model/DirectoryList.java <directory path>
```

**Exercise 2**  
Extend the previous class to recursively list the entire directory tree, printing the contents alphabetically per level, 
indicating whether each item is a directory (D) or file (F), along with its last modified date.
```
java -cp bin src/main/level1/ex2/model/DirectoryTree.java <directory path>
```

**Exercise 3**  
Modify the previous exercise to save the output to a TXT file instead of printing it to the console.
```
java -cp bin src/main/level1/ex3/model/DirectoryTreeWriter.java <directory path>
```

**Exercise 4**  
Add functionality to read any TXT file and display its contents on the console.
```
java -cp bin main/level1/ex4/model/FileReader
```
**Exercise 5**  
Serialize a Java object to a `.ser` file and then deserialize it back.
```
java -cp bin src/main/level1/ex5/model/Serializer.java
java -cp bin src/main/level1/ex5/model/Deserializer.java
```
## Level 2

**Exercise 1**  
Parameterize all methods from Level 1, Exercise 3 using a configuration file (Java Properties or Apache Commons Configuration). 
Parameters include the directory to read and the name/location of the output TXT file.
```
java -cp bin main/level2/model/DirectoryTreeWriter
```


## Technologies Used
* Java
* IntelliJ
* Git

## Requirements
* Java 17
* IntelliJ (optional)

## Installation

1. Clone the repository:
```
https://github.com/mxg952/S1.05-Java_Utils-.git
```
2. Open the project with IntelliJ IDEA.

## Contributions
The project ignores `.idea/`, `.out/`, `.iml`.

1. Fork the repository
2. Create a new branch: `git checkout -b feature/NewFeature`
3. Make your changes and commit them: `git commit -m 'Add New Feature'`
4. Push the changes to your branch: `git push origin feature/NewFeature`
5. Open a pull request
