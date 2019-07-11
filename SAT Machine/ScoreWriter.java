/*

SAT Grading and Analytics Machine for KenSAP, by Nick Peterson, June-August 2019.

Writes a set of CSVs, made for Excel / Google Sheets, that gives an explanation of the scores, given the right answers and the students' answers.

You must use a command line prompt to put the output of this program into a file, otherwise it will only print the results.

*/
import java.util.ArrayList;
import java.util.Collections;

public class ScoreWriter{
	
	//fields
	public ScoreSet grader;
	
	//constructor, doesn't really do much...
	public ScoreWriter(){grader = null;}
	
	//main function, which prints out the results in a good CSV format
	public static void main(String[] args){
		//change this variable to change the number of students
		int n = 21;
		
		//prints out the first two rows
		System.out.print("Question No.,");
		for(int i = 0; i < 52; i++){
			System.out.print((i + 1) + ",");
		}
		System.out.println("Total Wrong,Raw Score");
		System.out.println("Reading");
		
		//scores, and prints out the results
		ScoreSet grader = new ScoreSet();
		Student[] exam = grader.grade(args[0],args[1],n);
		for(int i = 0; i < n; i++){
			int totalWrong = 0;
			//prints reading results
			System.out.print(exam[i].getName() + ",");
			for(int j = 0; j < 52; j++){
				if(!exam[i].getReadingScore().list[j].isCorrect()){totalWrong++;}
				System.out.print((exam[i].getReadingScore().list[j].isCorrect() ? 1 : 0) + ",");
			}
			System.out.print(totalWrong + "," + (52 - totalWrong));
			System.out.print("\n");
		}
		System.out.print("\n");
		System.out.println("Writing and Language");
		for(int i = 0; i < n; i++){
			int totalWrong = 0;
			//prints writing results
			System.out.print(exam[i].getName() + ",");
			for(int j = 0; j < 44; j++){
				if(!exam[i].getReadingScore().list[j].isCorrect()){totalWrong++;}
				System.out.print((exam[i].getWritingScore().list[j].isCorrect() ? 1 : 0) + ",");
			}
			for(int j = 44; j < 52; j++){System.out.print(",");}
			System.out.print(totalWrong + "," + (44 - totalWrong));
			System.out.print("\n");
		}
		System.out.print("\n");
		System.out.println("Math -- NC");
		for(int i = 0; i < n; i++){
			int totalWrong = 0;
			//prints reading results
			System.out.print(exam[i].getName() + ",");
			for(int j = 0; j < 20; j++){
				if(!exam[i].getReadingScore().list[j].isCorrect()){totalWrong++;}
				System.out.print((exam[i].getReadingScore().list[j].isCorrect() ? 1 : 0) + ",");
			}
			for(int j = 20; j < 52; j++){System.out.print(",");}
			System.out.print(totalWrong + "," + (20 - totalWrong));
			System.out.print("\n");
		}
		System.out.print("\n");
		System.out.println("Math -- C");
		for(int i = 0; i < n; i++){
			int totalWrong = 0;
			//prints reading results
			System.out.print(exam[i].getName() + ",");
			for(int j = 0; j < 38; j++){
				if(!exam[i].getReadingScore().list[j].isCorrect()){totalWrong++;}
				System.out.print((exam[i].getReadingScore().list[j].isCorrect() ? 1 : 0) + ",");
			}
			for(int j = 38; j < 52; j++){System.out.print(",");}
			System.out.print(totalWrong + "," + (38 - totalWrong));
			System.out.print("\n");
		}
		System.out.print("\n");
		
		//prints the quantity of wrongs by question
		System.out.println("Quantity of Wrongs");
		System.out.print("Reading,");
		for(int i = 0; i < 52; i++){
			int qty = 0;
			for(int j = 0; j < n; j++){
				if(!(exam[j].getReadingScore().list[i].isCorrect())){
					qty++;
				}
			}
			System.out.print(qty + ",");
		}
		System.out.println();
		System.out.print("Writing,");
		for(int i = 0; i < 44; i++){
			int qty = 0;
			for(int j = 0; j < n; j++){
				if(!(exam[j].getWritingScore().list[i].isCorrect())){
					qty++;
				}
			}
			System.out.print(qty + ",");
		}
		System.out.println();
		System.out.print("Math -- NC,");
		for(int i = 0; i < 20; i++){
			int qty = 0;
			for(int j = 0; j < n; j++){
				if(!(exam[j].getWritingScore().list[i].isCorrect())){
					qty++;
				}
			}
			System.out.print(qty + ",");
		}
		System.out.println();
		System.out.print("Math -- C,");
		for(int i = 0; i < 38; i++){
			int qty = 0;
			for(int j = 0; j < n; j++){
				if(!(exam[j].getWritingScore().list[i].isCorrect())){
					qty++;
				}
			}
			System.out.print(qty + ",");
		}
		System.out.println("\n");
		
		//prints the data on the subcategories
		System.out.println("Total Wrongs by Subcategory,Count Wrong,,,,,Percent of Subcategory Wrong,,,,,Subcategory Size");
		
		//starts by creating a list of subcategories
		ArrayList uniqueReading = new ArrayList<String>();
		for(int i = 0; i < 52; i++){
			if(!(uniqueReading.contains(exam[0].getReadingScore().list[i].getType()))){uniqueReading.add(exam[0].getReadingScore().list[i].getType());}
		}
		Collections.sort(uniqueReading);
		ArrayList uniqueWriting = new ArrayList<String>();
		for(int i = 0; i < 44; i++){
			if(!(uniqueWriting.contains(exam[0].getWritingScore().list[i].getType()))){uniqueWriting.add(exam[0].getWritingScore().list[i].getType());}
		}
		Collections.sort(uniqueWriting);
		ArrayList uniqueMathNC = new ArrayList<String>();
		for(int i = 0; i < 20; i++){
			if(!(uniqueMathNC.contains(exam[0].getMathNoCalcScore().list[i].getType()))){uniqueMathNC.add(exam[0].getMathNoCalcScore().list[i].getType());}
		}
		Collections.sort(uniqueMathNC);
		ArrayList uniqueMathC = new ArrayList<String>();
		for(int i = 0; i < 38; i++){
			if(!(uniqueMathC.contains(exam[0].getMathCalcScore().list[i].getType()))){uniqueMathC.add(exam[0].getMathCalcScore().list[i].getType());}
		}
		Collections.sort(uniqueMathC);
		
		//goes through and tallies up the number in each category wrong and prints it out
		for(int i = 0; i < uniqueReading.size(); i++){
			int w = 0;
			int c = 0;
			for(int s = 0; s < n; s++){
				for(int q = 0; q < 52; q++){
					if(exam[s].getReadingScore().list[q].getType().equals(uniqueReading.get(i))){
						c++;
						if(!(exam[s].getReadingScore().list[q].isCorrect())){
							w++;
						}
					}
				}
			}
			System.out.println(uniqueReading.get(i) + "," + w + ",,,,," + c / n + ",,,,," + (float)w / (float)c);
		}
		System.out.println();
		for(int i = 0; i < uniqueWriting.size(); i++){
			int w = 0;
			int c = 0;
			for(int s = 0; s < n; s++){
				for(int q = 0; q < 44; q++){
					if(exam[s].getWritingScore().list[q].getType().equals(uniqueWriting.get(i))){
						c++;
						if(!(exam[s].getWritingScore().list[q].isCorrect())){
							w++;
						}
					}
				}
			}
			System.out.println(uniqueWriting.get(i) + "," + w + ",,,,," + c / n + ",,,,," + (float)w / (float)c);
		}
		System.out.println();
		for(int i = 0; i < uniqueMathNC.size(); i++){
			int w = 0;
			int c = 0;
			for(int s = 0; s < n; s++){
				for(int q = 0; q < 20; q++){
					if(exam[s].getMathNoCalcScore().list[q].getType().equals(uniqueMathNC.get(i))){
						c++;
						if(!(exam[s].getMathNoCalcScore().list[q].isCorrect())){
							w++;
						}
					}
				}
			}
			System.out.println(uniqueMathNC.get(i) + "," + w + ",,,,," + c / n + ",,,,," + (float)w / (float)c);
		}
		System.out.println();
		for(int i = 0; i < uniqueMathC.size(); i++){
			int w = 0;
			int c = 0;
			for(int s = 0; s < n; s++){
				for(int q = 0; q < 38; q++){
					if(exam[s].getMathCalcScore().list[q].getType().equals(uniqueMathC.get(i))){
						c++;
						if(!(exam[s].getMathCalcScore().list[q].isCorrect())){
							w++;
						}
					}
				}
			}
			System.out.println(uniqueMathC.get(i) + "," + w + ",,,,," + c / n + ",,,,," + (float)w / (float)c);
		}
	}	
}