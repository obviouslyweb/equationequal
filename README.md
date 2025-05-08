## Overview

**Project Title**: EquationEqual

**Project Description**: EquationEqual is a math equation quizzer, allowing you to test your knowledge on short math problems. The game will continue to prompt and quiz you on simple "number operator number" style math questions, asking you to fill in the missing number. You can customize the bounds of the problems generated, as well as reattempt missed problems. The bounds you set and any missed questions you have are saved to your computer, allowing you to return and reattempt between sessions.

**Project Goals**: Learn and understand the Java runtime envoirnment and utilize such knowledge to create a dynamic math equation game with save/load functionality.

## Instructions for Build and Use

Steps to build and/or run the software:

### Using Command Prompt, Terminal, or equivalent
1. Download the repository contents to your computer. You can either download the repository contents as a .ZIP file, or use git / GitHub Desktop to copy the repository to your device.
2. Open a Command Prompt, Terminal, or equivalent program on your device.
3. Navigate to the "equationequal" folder (using `cd` on Windows).
4. Type `java main.java` to start the program.

### Using Visual Studio Code
1. Download the repository contents to your computer. You can either download the repository contents as a .ZIP file, or use git / GitHub Desktop to copy the repository to your device.
2. Open Visual Studio Code, and open the folder containing the project.
3. Open `main.java` and press the Play button in the upper-right corner. The program will run using the terminal built into Visual Studio Code.

Instructions for using the software:

* Once the program has started, use your keyboard to input numbers to select your desired option. 
* Typing in `1` on the main menu will start the main equation game sequence. During this sequence, answer the questions provided by typing in the number of the missing (bracketed, "[]") number. You can stop the game by typing `end` at any time. Please note that the game **will go forever** until you end it. Once doing so, a results screen will be posted, and any key can be pressed to return to the menu.
* Typing in `2` on the main menu will start the game sequence, only using questions that you have missed in the main game sequence (through the `1` menu option). This mode will not work if you do not have any missed equations recorded.
* Typing in `3` on the main menu will take you to a small options menu. Inside, you can edit the bounds that the game will choose for numbers to generate equations from as well as clear the missed equation list (if any are present). Typing `0` in this menu will return you to the main menu.
* Typing in `0` on the main menu will quit the program.

## Development Environment 

To recreate the development environment, you need the following software and/or libraries with the specified versions:

* First thing here
*
*

## Useful Websites to Learn More

I found these websites useful in developing this software:

* [Java Tutorial - W3Schools](https://www.w3schools.com/java/default.asp)
* [Random Number Library in Java - GeeksforGeeks](https://www.geeksforgeeks.org/generating-random-numbers-in-java/)
* [Stack Overflow (various threads)](https://stackoverflow.com/questions)

## Future Work

The following items I plan to fix, improve, and/or add to this project in the future:

* [ ] Verify equation creation doesn't make impossible to guess questions ( instances like `[ ] * 0 = 0` and `0 * [ ] = 0`).
* [ ] Fix dividing handling ( ex. `4 / [] = 1`, inputting `4` is somehow incorrect).
* [ ] Implement the ability to set bounds to negative numbers.