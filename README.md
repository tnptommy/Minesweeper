# Minesweeper Game

**Author:** Tommy Huynh

**November 2023**

## Introduction

Welcome to the classic Minesweeper game! This project is a simple yet engaging implementation of Minesweeper, a puzzle game where the objective is to clear a rectangular board containing hidden "mines" without detonating any of them. The game challenges your logical thinking and problem-solving skills as you deduce the locations of the mines based on numerical clues.

## How to Play

1. **Starting the Game:**
   - The game begins by prompting you to enter the dimensions of the minefield (width and height) and the number of mines to be placed.
   - Example input:
     ```
     Minefield width: 5
     Minefield height: 5
     Number of mines: 6
     ```

2. **Displaying the Minefield:**
   - The initial minefield is displayed with all locations hidden, represented by dots (·).
   - Example initial display:
     ```
       1 2 3 4 5 
     A · · · · · 
     B · · · · · 
     C · · · · · 
     D · · · · · 
     E · · · · · 
     ```

3. **Making a Guess:**
   - You make a guess by entering a location (e.g., "A2" or "d5").
   - The game checks if the guessed location is valid. If invalid, you'll be prompted to enter a new guess.

4. **Revealing Locations:**
   - If the guessed location contains a mine, the game reveals all mine locations and ends with the message "Boom! Game over."
   - If the guessed location does not contain a mine, the game updates the grid to show the number of adjacent mines (adjacency count) for that location.
   - If the guessed location has an adjacency count of 0, the game automatically reveals adjacent locations until all non-mine locations are shown.

5. **Continuing the Game:**
   - The game continues asking you to guess locations and updates the grid accordingly.
   - Example display after a guess:
     ```
     Guess a location: B1
       1 2 3 4 5 
     A · · · · · 
     B 2 · · · · 
     C · · · · · 
     D · · · · · 
     E · · · · · 
     ```

6. **Winning the Game:**
   - The game is won when all non-mine locations are successfully guessed.
   - The game reveals all mine locations and displays the message "Minefield cleared. Well done!"

## Example Gameplay

```
Minefield width: 5
Minefield height: 5
Number of mines: 6
  1 2 3 4 5 
A · · · · · 
B · · · · · 
C · · · · · 
D · · · · · 
E · · · · · 
Guess a location: B1
  1 2 3 4 5 
A · · · · · 
B 2 · · · · 
C · · · · · 
D · · · · · 
E · · · · · 
Guess a location: E1
  1 2 3 4 5 
A · · · · · 
B · · · · · 
C 1 2 · · · 
D 0 1 3 · · 
E 0 0 2 · · 
Guess a location: A1
  1 2 3 4 5 
A X 2 2 1 1 
B 2 X 3 X 1 
C 1 2 X 3 2 
D 0 1 3 X 2 
E 0 0 2 X 2 
BOOM! Game over.
```

Enjoy playing Minesweeper and test your logical thinking skills!
