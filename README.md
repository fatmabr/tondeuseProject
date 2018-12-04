#tondeuseProject

This project permits to program the execution of the mower (tondeuse) via an injected file.

The file format is as follow:

            First line = File HEADER = Pelouse size
                X Y
                ## X = max X position  Y = max Y position. X et Y is separated by a space.
            Rest of the file lines represent a mower = (tondeuse).
                Tondeuse = 2 lines.
                    First line is initial position X Y Orientation (X and Y and orientation are separated by space)
                        Orientation :
                        N : north
                        S : South
                        E : Est
                        O : West
                    Second line represent a suite of instructions
                        D = Right
                        G = Left
                        A = Forward
File example: 

		5 5
		1 2 N
		GAGAGAGAA
		3 3 E
		AADAADADDA
		
This program once runned it creates a thread which listen on events of file injection in a configured folder.
The folder is configured in the file config.properties.

Installation steps:
- git checkout the sources.
- open the project with your favourite editor.
- configure the property "watched.file" in the /resources/config.properties.
