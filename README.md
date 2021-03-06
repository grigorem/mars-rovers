# Mars Rovers Challenge

## Task
A squad of robotic rovers are to be landed by NASA on a plateau on Mars.
A rover's position is represented by a combination of an x and y co-ordinates and a letter representing one of the four cardinal compass points.
The plateau is divided up into a grid to simplify navigation. An example position might be 0, 0, N, which means the rover is in the bottom left corner and facing North.
In order to control a rover, NASA sends a simple string of letters. The possible letters are 'L', 'R' and 'M'.
* 'L' and 'R' makes the rover spin 90 degrees left or right respectively, without moving from its current spot.
* 'M' means move forward one grid point, and maintain the same heading.

## Assumptions
* The plateau is finite (no wrap-up to the other side)
* The rovers can collide with each other
* All the commands from the command center are in a valid format
* Initial positions of rovers cannot be the same

## Tech stack

<table>
  <tr>
    <td>
      <img src="https://i.imgur.com/CNcQerw.jpg" alt="Java"/>
    </td>
    <td>
      <img src="https://i.imgur.com/tmQ1HQl.jpg" alt="JUnit"/>
    </td>
    <td>
      <img src="https://i.imgur.com/uYS4YpF.jpg" alt="IntelliJ Idea"/>
    </td>
    <td>
      <img src="https://i.imgur.com/KUwOVP7.jpg" alt="Docker"/>
    </td>
  </tr>
</table>

## How to run it in your IDE

### Prerequisites
1. Git (Installation guide: https://git-scm.com/book/en/v2/Getting-Started-Installing-Git)
2. Apache Maven (Installation guide: https://maven.apache.org/install.html)
3. JDK 1.8 (Installation guide: https://docs.oracle.com/en/java/javase/11/install/installation-jdk-microsoft-windows-platforms.html)

### Steps to run it
1. Clone the repository
```sh
git clone https://github.com/grigorem/mars-rovers.git
```
2. (Optional) Import the project in your preffered IDE (IntelliJ Idea Community Edition for me)
3. Run the maven test command in terminal/cmd, working directory being the cloned repository
```sh
mvn test
```

## How to run it as Docker image

### Prerequisites
1. Docker (https://docs.docker.com/docker-for-windows/install)

### Run it
1. Clone the image
```sh
docker pull grigorem/mars-rovers
```
2. Start the image
```sh
docker run -it grigorem/mars-rovers
```
3. Run the application
* Console interactive
```sh
java -cp mars-rovers-0.1.jar org.grigore.App
```
* From example files
```sh
java -cp mars-rovers-0.1.jar org.grigore.App /usr/local/mars-rovers/resources/example_1.txt
```
or
```sh
java -cp mars-rovers-0.1.jar org.grigore.App /usr/local/mars-rovers/resources/example_2.txt
```
