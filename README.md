# Tic Tac Toe

### How to Play
This game pits a computer against a human player.  The human player goes first and can enter a number 1-9 for the cell he wishes to place his marker, 'x'.  If the position is taken or invalid, the appropriate message will be displayed.  The user will then be asked to re-enter the input.  After the user enters valid input, the board will be displayed.  The computer will then position it's marker, 'o', for it's desired position.  The first player to get 3 in a column, diagonal, or row will be declared the winner.  In the instance that the board is full and there is no winner, a tie will be declared.

### How to Run the Program from IntelliJ
1. Git clone this repo
2. Open IntelliJ
3. Select `Import Project` and select the directory for this repo
4. Select `Create project from existing sources` and push `Next`
5. Enter a `Project name` and push `Next`
6. Once in the project, from the "Run" menu, choose "Edit Configurations"
7. Push the "+" button.  Name the project and choose "com.company.TicTacToe" for the main class.  Push "OK"
8. From the "Run" menu, chose "Run {project name}" or "Run"

## How to Run the Program from Eclipse
1. Git clone this repo
2. Open Eclipse and choose your workspace.
3. File >> Open Projects File System
4. In the line with "Import source", select "Directory" and selec the directory for this repo and push "Finish"
5. Run >> Run Configurations >> Java Application, click the new button in the upper left hand corner.
6. Give the configuration a name.
7. Click "Browse" in the "Project" section and select the folder for this repo.
8. Click "Search" in the "Main class" section and "TicTacToe - com.company"
9. Push "Apply".  Push "Run".

### How to Set `JAVA_HOME`
1. Determine your jdk. If you're on a Mac, you can determine what your current jdk is by doing the following:
  1. cd `/Library/Java/JavaVirtualMachines/`
  2. ls
2. From your `HOME` directory, run `export JAVA_HOME=/Library/Java/JavaVirtualMachines/{jdk_version}`
