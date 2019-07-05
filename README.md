# sat-machine
Files to grade and analyze many SATs at once.

On https://docs.google.com/spreadsheets/d/1FK8rT0JR8h1VxZeEezu8-_GSPH1bq-cSB6kryUW34zM/edit#gid=0, if given the second and fourth spreadsheets in CSV format, the program ScoreWriter will spit out the third spreadsheet in CSV format, with a 1 wherever a question is wrong and a 0 wherever a question is right.

Download all of the files in the folder, open up Terminal, and cd to the SAT Machine directory in the terminal.

To run the program, type this into the command line:
java ScoreWriter [CSV of correct answers] [CSV of student answers].

For the example in the folder, swap the command line arguments with
example_correct_answers.csv and example_student_answers.csv, respectively.

To put the results of the program into a CSV like that in the Google Spreadsheet, add ">> [your title here].csv" (without the quotes) to the end of the command line statement. 
