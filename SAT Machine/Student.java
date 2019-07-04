/*

SAT Grading and Analytics Machine for KenSAP, by Nick Peterson, June-August 2019.

Student object, containing information for each student, including the four test sub-score QuestionLists.

*** TO ACCESS THE ACTUAL LIST OF QUESTION OBJECTS, YOU NEED [insert section here]Score.list ***

*/

public class Student{

	//fields
	private String name;
	private QuestionList readingScore;
	private QuestionList writingScore;
	private QuestionList mathNoCalcScore;
	private QuestionList mathCalcScore;
	
	//getter functions
	public String getName(){return name;}
	public QuestionList getReadingScore(){return readingScore;}
	public QuestionList getWritingScore(){return writingScore;}
	public QuestionList getMathNoCalcScore(){return mathNoCalcScore;}
	public QuestionList getMathCalcScore(){return mathCalcScore;}
	
	//setter functions
	public void setReadingScore(QuestionList ql){readingScore = ql;}
	public void setWritingScore(QuestionList ql){writingScore = ql;}
	public void setMathNoCalcScore(QuestionList ql){mathNoCalcScore = ql;}
	public void setMathCalcScore(QuestionList ql){mathCalcScore = ql;}
	
	//toString override for debugging
	public String toString(){
		return getName() + "\n" + getReadingScore().toString() + "\n" + getWritingScore().toString() + "\n" + getMathNoCalcScore().toString() + "\n" + getMathCalcScore().toString();
	}
	
	//constructor function, doesn't do much
	public Student(String name){this.name = name;}
}