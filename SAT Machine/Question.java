/*

SAT Grading and Analytics Machine for KenSAP, by Nick Peterson, June-August 2019.

A class built for INDIVIDUAL questions on the SAT, does not have capability to create a data structure.

*/

public class Question{

	//fields
	public String correctAnswer;
	public String studentAnswer;
	private boolean correct;
	private String type;
	
	//constructor, taking the correct answer and the student answer and comparing them and basing the correct value off of the comparison
	public Question(String type, String correctAnswer, String studentAnswer){
		this.type = type;
		this.correctAnswer = correctAnswer;
		this.studentAnswer = studentAnswer;
		if(correctAnswer.equals(studentAnswer)){correct = true;}
		else{correct = false;}
	}
	
	//getter functions, no setters needed beyond the one above
	public String getCorrectAnswer(){return correctAnswer;}
	public String getStudentAnswer(){return studentAnswer;}
	public boolean isCorrect(){return correct;}
	public String getType(){return type;}
	
	//toString override for debugging purposes
	public String toString(){
		return "Correct: " + correctAnswer + ", Student: " + studentAnswer + ", Correct? " + correct + ", Type: " + getType() + "\n";
	}
	
	//main test function
	public static void main(String[] args){
		Question A = new Question("RH", "B", "B");
		System.out.println("Answer should be true : " + A.isCorrect());
		
		Question B = new Question("AT", "", "12");
		System.out.println("Answer should be false : " + B.isCorrect());
		
		System.out.println("Answer should be B : " + A.getCorrectAnswer());
		System.out.println("Answer should be 12 : " + B.getStudentAnswer());
		System.out.println("Answer should be RH : " + A.getType());
	}
}