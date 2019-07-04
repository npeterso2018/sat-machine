/*

SAT Grading and Analytics Machine for KenSAP, by Nick Peterson, June-August 2019.

Reads two CSV files and compares them against each other.
Creates n students, populating their Score fields with the comparison of the two CSVs.
Finally, creates a set of scores for each of the students

*/

//without importing the these, ScoreSet.java is useless!
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;

public class ScoreSet{

	//fields
	private Student[] scoreSet;
	private int nStudents;
	
	//getters
	public Student[] getScoreSet(){return scoreSet;}
	public int getStudentCount(){return nStudents;}
	
	//constructor function, doesn't really do much
	public ScoreSet(){
		scoreSet = null;
		nStudents = 0;
	}
	
	//creates a Student with all the right answers for comparing purposes
	public Student rightAnswers(String correctAnswers){
		try{
			QuestionList rightAnswersReading = new QuestionList(52);
			QuestionList rightAnswersWriting = new QuestionList(44);
			QuestionList rightAnswersMathNoCalc = new QuestionList(20);
			QuestionList rightAnswersMathCalc = new QuestionList(38);
			FileReader fr = new FileReader(correctAnswers);
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();
			
			//first cycle, to fill out reading answers and types
			String[] answers = br.readLine().split(",");
			String[] types = br.readLine().split(",");
			for(int i = 1; i < 53; i++){
				rightAnswersReading.list[i - 1] = new Question(types[i],answers[i],answers[i]);
			}
			
			//second cycle, to fill out writing answers and types
			answers = br.readLine().split(",");
			types = br.readLine().split(",");
			for(int i = 1; i < 45; i++){
				rightAnswersWriting.list[i - 1] = new Question(types[i],answers[i],answers[i]);
			}
			
			//third cycle, to fill out math no calc answers and types
			answers = br.readLine().split(",");
			types = br.readLine().split(",");
			for(int i = 1; i < 21; i++){
				rightAnswersMathNoCalc.list[i - 1] = new Question(types[i],answers[i],answers[i]);
			}
			
			//fourth cycle, to fill out math calc answers and types
			answers = br.readLine().split(",");
			types = br.readLine().split(",");
			for(int i = 1; i < 39; i++){
				rightAnswersMathCalc.list[i - 1] = new Question(types[i],answers[i],answers[i]);
			}
			Student ans = new Student("");
			ans.setReadingScore(rightAnswersReading);
			ans.setWritingScore(rightAnswersWriting);
			ans.setMathNoCalcScore(rightAnswersMathNoCalc);
			ans.setMathCalcScore(rightAnswersMathCalc);
			return ans;
		}
		catch(FileNotFoundException ex){
			System.out.println("Unable to open file(s).");
			return null;
		}
		catch(IOException ex){
			System.out.println("Error reading file(s).");
			return null;
		}		
	}
	//returns a list of the students with all their tests graded
	public Student[] grade(String correctAnswers, String studentAnswers, int qty){
		Student correct = rightAnswers(correctAnswers);
		Student[] gradedList = new Student[qty];
		try{
			FileReader fr = new FileReader(studentAnswers);
			BufferedReader br = new BufferedReader(fr);
			
			//takes the fluff out
			br.readLine();
			String line = br.readLine();
			
			//first cycle, to go through reading answers. Goes through each student and scores them.
			for(int s = 0; s < qty; s++){
				String[] answers = br.readLine().split(",");
				while(answers.length < 54){
					String[] temp = answers;
					answers = new String[answers.length + 1];
					for(int z = 0; z < temp.length; z++){
						answers[z] = temp[z];
					}
				}
				if(answers[51] == ""){answers[51] = "Z";}
				gradedList[s] = new Student(answers[0] + ", " + answers[1]);
				QuestionList grade = new QuestionList(52);
				for(int i = 2; i < 54; i++){
					if(answers[i] != null){answers[i] = answers[i].toUpperCase();}
					grade.list[i - 2] = new Question(correct.getReadingScore().list[i - 2].getType(),correct.getReadingScore().list[i - 2].getStudentAnswer(),answers[i]);
				}
				gradedList[s].setReadingScore(grade);
			}
			
			//second cycle, to go through writing answers.
			br.readLine();
			br.readLine();
			for(int s = 0; s < qty; s++){
				String[] answers = br.readLine().split(",");
				while(answers.length < 46){
					String[] temp = answers;
					answers = new String[answers.length + 1];
					for(int z = 0; z < temp.length; z++){
						answers[z] = temp[z];
					}
				}
				if(answers[43] == ""){answers[43] = "Z";}
				QuestionList grade = new QuestionList(44);
				for(int i = 2; i < 46; i++){
					if(answers[i] != null){answers[i] = answers[i].toUpperCase();}
					grade.list[i - 2] = new Question(correct.getWritingScore().list[i - 2].getType(),correct.getWritingScore().list[i - 2].getStudentAnswer(),answers[i]);
				}
				gradedList[s].setWritingScore(grade);
			}
		
			//third cycle, to go through math no calc answers.
			br.readLine();
			br.readLine();
			for(int s = 0; s < qty; s++){
				String[] answers = br.readLine().split(",");
				while(answers.length < 22){
					String[] temp = answers;
					answers = new String[answers.length + 1];
					for(int z = 0; z < temp.length; z++){
						answers[z] = temp[z];
					}
				}
				if(answers[19] == ""){answers[19] = "Z";}
				QuestionList grade = new QuestionList(20);
				for(int i = 2; i < 22; i++){
					if(answers[i] != null){answers[i] = answers[i].toUpperCase();}
					grade.list[i - 2] = new Question(correct.getMathNoCalcScore().list[i - 2].getType(),correct.getMathNoCalcScore().list[i - 2].getStudentAnswer(),answers[i]);
				}
				gradedList[s].setMathNoCalcScore(grade);
			}
			
			//fourth cycle, to go through math calc answers.
			br.readLine();
			br.readLine();
			for(int s = 0; s < qty; s++){
				String[] answers = br.readLine().split(",");
				while(answers.length < 40){
					String[] temp = answers;
					answers = new String[answers.length + 1];
					for(int z = 0; z < temp.length; z++){
						answers[z] = temp[z];
					}
				}
				if(answers[37] == ""){answers[37] = "Z";}
				QuestionList grade = new QuestionList(38);
				for(int i = 2; i < 40; i++){
					if(answers[i] != null){answers[i] = answers[i].toUpperCase();}
					grade.list[i - 2] = new Question(correct.getMathCalcScore().list[i - 2].getType(),correct.getMathCalcScore().list[i - 2].getStudentAnswer(),answers[i]);
				}
				gradedList[s].setMathCalcScore(grade);
			}
		scoreSet = gradedList;
		return gradedList;
		}
		catch(FileNotFoundException ex){
			System.out.println("Unable to open file(s).");
			return null;
		}
		catch(IOException ex){
			System.out.println("Error reading file(s).");
			return null;
		}
	}
	
	//test function
	public static void main(String[] args){
		ScoreSet t = new ScoreSet();
		t.grade(args[0],args[1],21);
		for(int i = 0; i < 21; i++){
			System.out.println(t.scoreSet[i]);
		}
	}
}
