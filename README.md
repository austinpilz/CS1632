#PITT CS1632 (Quality Assurance) - Project 3
This is an individual project for CS1632 at the University of Pittsburgh. 

## Running the PExpect
1. Compile both client and server jars with `ant -Dconfig=Server` and `ant -Dconfig=Client`, respectively.
2. Run `java -jar dist/Server/BattleshipServer.jar` in it's own terminal.
3. Run `python run.py` in a second terminal. (Python 2.7)

## Project Description
This will be an individual project. You will be responsible for implementing Junit tests for `edu.pitt.battleshipgame.common.board.*` and `edu.pitt.battleshipgame.common.ships.*.` You should use Mocks, Doubles, Fakes, and Stubs where appropriate.In addition to the Junit tests you will also write a PExpect test that will attempt to play a complete game. This test does not need to, and should not, implement any AI. Think of a configuration of the board that will allow a game to be over in as few moves as possible. This script will need to be multi-threaded since it will manage 2 clients and a server.

NOTE: PExpect is not currently available on Windows. If you are on Windows you will have to use a Pitt Unix machine to do this. Alternatively, you could install a Linux distro in a VM or dual boot.

Extra Credit: If you have an application that supports a GUI in addition to the CLI you may automate the GUI for extra credit. You should be able to accomplish this using a Junit framework and hooks into the Java swing objects to send button clicks. Other ideas for Extra Credit should be discussed with me in advance to make sure they are worthwhile.

## Grading
Each component (Junit and PExpect) will account for 50% of the grade. You will be graded on 4 categories:

1) Test Completeness
2) Test Correctness
3) Code maintainability – Documentation, style, etc.
4) Code modularity – Proper use of Mocks, Doubles, etc.

Extra Credit cannot exceed 15% of the overall value of the assignment.

## How to build

You can build this project one at the command line with Apache Ant
or through the NetBeans GUI.

## Building with NetBeans:

You only need to use the NetBeans configuration menus to switch between
building or running the client and the server.

In order to build the project through NetBeans:
1) Use the "Open Project" menu item and point it to the cloned
   project.
2) Set the config to "Server" and click build.
3) Set the config to "Client" and click build.

In order to run the project through NetBeans:
1) Set the config to "Server".
2) Right Click the project and click run.
3) Set the config to "Client".
4) Right click the project and click run.
5) Repeat steps 3 and 4 to get a second client.

## Building on the Command Line with Apache Ant:

Building the client or server with Apache Ant requires you to set a
configuration variable. This variable will be set to the last
NetBeans build target by default

In order to build 
1) Change to the directory of the cloned project.
2) Run "ant -Dconfig=Server" to build the server.
3) Run "ant -Dconfig=Client" to build the client.

In order to run the project on the command line:
1) Open 3 shells and cd to the directory of the cloned project.
2) Run "java -jar dist/Server/BattleshipServer.jar" in one shell.
3) Run "java -jar dist/Client/BattleshipClient.jar" in the other shells.

