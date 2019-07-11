# sat-machine
Files to grade and analyze many SATs at once. Improved SAT grading efficiency at KenSAP by 389% and gave valuable data that otherwise would not have been available, if graded by hand.

Background:
Given a lump of SAT answers from 21 KenSAP students and nothing else, I created the system below (the google docs link) to grade and efficiently understand their SATs. Using Java skills from my Data Structures and Algorithms class in the Spring of 2019, I built a set of files (totalling 567 lines of code) to replicate this spreadsheet in a CSV.

On https://docs.google.com/spreadsheets/d/1FK8rT0JR8h1VxZeEezu8-_GSPH1bq-cSB6kryUW34zM/edit#gid=0, if given the second and fourth spreadsheets in CSV format, the program ScoreWriter will spit out the third spreadsheet in CSV format, with a 1 wherever a question is wrong and a 0 wherever a question is right.

Download all of the files in the folder, open up Terminal, and cd to the SAT Machine directory in the terminal.

To run the program, type this into the command line:
java ScoreWriter [CSV of correct answers] [CSV of student answers].

For the example in the folder, swap the command line arguments with
example_correct_answers.csv and example_student_answers.csv, respectively.

To put the results of the program into a CSV like that in the Google Spreadsheet, add ">> [your title here].csv" (without the quotes) to the end of the command line statement.

Changes:
7/11/19 -- added a section of code that allows the program to give data on subcategories, on the Google Sheet it is the "Total Wrongs by Subcategory" section.
