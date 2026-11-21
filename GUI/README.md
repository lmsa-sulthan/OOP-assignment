# Whack A Mole

A simple Whack A Mole game built using **Java Swing** as an Object-Oriented Programming (OOP) project.

## About
The goal is to click the button displaying "MOLE" to increase your score. The mole randomly changes its position after each successful hit.

## Features
- 3x3 Game Board
- Random Mole Position
- Score Counter
- Hit and Miss Messages
- Restart Button

## Technologies
- Java
- Java Swing
- AWT

## GUI Components
- **JFrame:** Main window
- **JPanel:** Component container
- **JButton:** Interactive game buttons
- **JLabel:** Displays title and score
- **GridLayout:** Arranges the game board
- **ActionListener:** Handles button clicks

## Implementation of the 5 Main Components of Java Swing

The following is documentation on the implementation of the 5 key components of a graphical user interface (GUI) in the `WhackAMole.java` program, along with screenshots of the code:

### 1. Top-Level Container Class
* **Component:** `JFrame`
* **Implementation:** `JFrame` is the main window of the application. The title is set to Whack A Mole, the window size is set to 350 × 400 pixels, EXIT_ON_CLOSE closes the application when the window is closed, and setLocationRelativeTo(null) places the window in the center of the screen.

<img width="420" height="80" alt="Screenshot 2026-11-21 123941" src="https://github.com/user-attachments/assets/655e9228-d061-4d97-9284-c1417687bc6e" />

### 2. Intermediate Container Class
* **Component:** `JPanel`
* **Implementation:** `JPanel` is used as a container to group other GUI components. mainPanel uses BorderLayout to organize the main areas, while gamePanel uses GridLayout(3, 3, 5, 5) to arrange the nine game buttons in a 3 × 3 grid with spacing.

<img width="378" height="102" alt="Screenshot 2026-11-21 123953" src="https://github.com/user-attachments/assets/e6d65740-8644-46e7-8e4f-c00daaf270c5" />

### 3. Atomic Component Class
* **Components:** `JLabel` and `JButton`
* **Implementation:** `JLabel` displays the game title, current score, and game messages. `JButton` represents each cell on the game board. The button array contains nine buttons.

<img width="278" height="310" alt="Screenshot 2026-11-21 124016" src="https://github.com/user-attachments/assets/6f40771d-e8df-4700-b543-141277e2366d" />

### 4. Layout Classes
The application uses more than the required two layout managers:
- `BorderLayout` organizes the main panel into NORTH, CENTER, and SOUTH areas.
- `GridLayout(3, 3, 5, 5)` arranges the game buttons into three rows and three columns.
- `GridLayout(2, 1)` arranges the title and score labels vertically inside topPanel.
The Restart button is placed at the bottom of the main window.

<img width="398" height="441" alt="Screenshot 2026-11-21 124058" src="https://github.com/user-attachments/assets/01313c6f-88b9-4e78-b95b-0f763f6c903e" />

### 5. Event Listener
* **Component:** `ActionListener`
* **Implemtation:** `ActionListener` handles button-click events. When the player clicks a game button, the program checks whether its index matches the current mole position. A correct click increases the score, displays Nice Hit!, and moves the mole to another random position. An incorrect click displays Miss! Try Again. The Restart button resets the score and chooses a new mole position.

<img width="387" height="463" alt="Screenshot 2026-11-21 124122" src="https://github.com/user-attachments/assets/9e69f4e7-89cc-4330-9369-24506e3132e9" />

The supplied code screenshot uses a lambda expression (e -> { ... }) as an ActionListener. It handles the event, but it does not visibly show an explicit @Override method. If the assignment specifically requires an event-method override, use the anonymous-class form below in the source code and take an updated screenshot of it:
buttons[i].addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle the button click here
    }
});

## Output

Screenshots of the program execution results are saved in the `_output/` folder, with details as follows:

### 1. Initial View
<img width="421" height="492" alt="Screenshot 2026-11-21 124740" src="https://github.com/user-attachments/assets/05dd1b57-f4a7-4b1c-a31e-5324f49c3587" />

### 2. View upon Successfully Hitting the Target
<img width="421" height="492" alt="Screenshot 2026-11-21 124804" src="https://github.com/user-attachments/assets/bddd5fee-0478-437b-9123-d977022cb681" />

### 3. View upon Failing to Hit the Target
<img width="421" height="492" alt="Screenshot 2026-11-21 124808" src="https://github.com/user-attachments/assets/8261f536-26d7-40f4-82eb-cde1603545fd" /> 

## How to Run

1. Compile the program:
   ```bash
   javac WhackAMole.java
   ```

2. Run the game:
   ```bash
   java WhackAMole
   ```
