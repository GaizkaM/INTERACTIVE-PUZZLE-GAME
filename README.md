# Interactive Puzzle Game

This project implements an interactive puzzle game where users can solve graphical puzzles and store their performance history. The application was developed as the final project for the **Programming II** course using Java and Swing for graphical interfaces.

## 📖 Description

The main goal of the application is to provide an engaging puzzle-solving experience. Users can play, view their performance history, and customize the game settings. Key features include:
- **Puzzle Creation**: Generates a randomized puzzle from an image.
- **Scorekeeping**: Records user scores along with their names and dates.
- **Customization**: Allows users to select the image directory for puzzles.

### 🛠 Features

1. **New Game**:
   - Users input their name and the puzzle's horizontal and vertical subdivisions.
   - A puzzle is generated using a randomly selected image from a specified directory.
   - Objective: Rearrange the puzzle pieces to form the complete image.
   - Scoring: Users earn points equal to the number of pieces in the puzzle.

2. **Abandon Game**:
   - Users can abandon a game, receiving 0 points. The resolved image is displayed.

3. **General History**:
   - Displays a list of all previously played games with player names, scores, and dates.

4. **Selective History**:
   - Allows users to filter game history by player name.

5. **Change Image Directory**:
   - Users can select a new directory for puzzle images using a file chooser.

6. **Exit**:
   - Closes the application.

---

## 🗂 Project Structure

- **Main Class**:
  - Initializes the program and sets up the main `JFrame`.

- **Panels**:
  - **`panelStandBy`**: Displays a default screen with the UIB logo.
  - **`panelPartida`**: Manages the gameplay, including:
    - Puzzle generation using the **Fisher-Yates Shuffle** algorithm.
    - Checking if the puzzle is solved via the `isOrdered` method.
    - Saving game results to `resultados.dat`.
  - **`panelHistorial`**: Displays game history from a file. Supports filtering by player name.
  - **`panelImagenSolucion`**: Shows the completed puzzle after the user solves it or abandons the game.

- **Helpers**:
  - `lecturaDatos`: Manages user input through dialog boxes.
  - `Partida`: Represents a game result (player name, score, date).
  - `ficheroPartidasOut`: Handles saving game results to a file.

---

## 🚀 How It Works

1. **Puzzle Creation**:
   - Splits a randomly selected image into a grid based on user input.
   - Each piece is a `JButton` with a section of the image.

2. **Gameplay**:
   - Users swap pieces to solve the puzzle.
   - The game checks after every move if the puzzle is solved.

3. **History**:
   - Game results are saved to `resultados.dat` and displayed in history panels.

4. **Customization**:
   - Users can change the image directory for puzzle generation.

---

## 🎯 Technical Highlights

- **Randomized Puzzle**: Implements the Fisher-Yates shuffle for randomness.
- **State Management**: Uses an `enum` to track application states.
- **File Handling**:
  - Reads and writes game history using `ObjectOutputStream`.
- **Dynamic UI**:
  - Updates panels based on user actions and application state.

---

## 📝 Author

- **Gaizka Medina Gordo**  
