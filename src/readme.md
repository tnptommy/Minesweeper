 Minesweeper Game

## Overview

This project is an implementation of the classic Minesweeper game in Java. The game involves a grid of cells, some of which contain mines. The objective is to uncover all the cells that do not contain mines without triggering any mines.

## Files

- **Guesses.java**: Manages the player's guesses and keeps track of the cells that have been revealed or flagged.
- **Location.java**: Represents a location on the minefield grid, storing the row and column coordinates.
- **Minefield.java**: Represents the minefield grid, initializes the grid with mines, and provides methods to interact with the grid.
- **Minesweeper.java**: The main class that ties together the various components of the game and handles user input and game logic.
- **Renderer.java**: Handles the rendering of the game state, displaying the minefield to the user.

## How to Run

1. **Compile the Java Files**: 
   ```sh
   javac Guesses.java Location.java Minefield.java Minesweeper.java Renderer.java
   ```

2. **Run the Game**:
   ```sh
   java Minesweeper
   ```

## Classes and Their Responsibilities

### Guesses.java

This class is responsible for managing the player's guesses. It tracks which cells have been revealed and which cells have been flagged as potential mines.

### Location.java

This class represents a specific location on the minefield grid. It stores the row and column of the cell and provides methods to access these coordinates.

### Minefield.java

This class represents the minefield. It initializes the grid with a specified number of mines and provides methods for interacting with the cells, such as revealing a cell or checking if a cell contains a mine.

### Minesweeper.java

This is the main class that drives the game. It handles user input, checks for win/loss conditions, and coordinates the interaction between the other classes.

### Renderer.java

This class is responsible for displaying the current state of the game to the player. It renders the minefield grid, showing which cells have been revealed, flagged, or remain hidden.

## Game Rules

1. **Objective**: Uncover all cells that do not contain mines.
2. **Revealing Cells**: If a cell containing a mine is revealed, the game is lost. If a cell does not contain a mine, it will show the number of neighboring cells that contain mines.
3. **Flagging Cells**: Players can flag cells they suspect contain mines. Flagging does not reveal the cell but marks it as a potential mine location.

## Development Notes

- **Initialization**: The minefield is initialized with a fixed number of mines randomly placed across the grid.
- **User Input**: The game handles user input for revealing cells and flagging potential mines.
- **Rendering**: The renderer updates the display after each user action to reflect the current state of the minefield.


## License

This project is open-source and available under the [MIT License](LICENSE).

