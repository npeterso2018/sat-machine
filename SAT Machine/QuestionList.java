/*

SAT Grading and Analytics Machine for KenSAP, by Nick Peterson, June-August 2019.

Array-based implementation of a list of Question objects. This array will allow for very easy data management.

*/

public class QuestionList{

	//fields for the array that stores the objects and the length of said array
	private int length;
	public Question[] list;
	
	//constructor
	public QuestionList(int length){
		this.length = length;
		this.list = new Question[length];
	}
	
	//getter for length
	public int getLength(){return length;}
	
	//toString override for debugging
	public String toString(){
		String s = "";
		for(int i = 1; i < getLength(); i++){
			s += list[i].toString();
		}
		s += "\n";
		return s;
	}
	
	//main test function
	public static void main(String args[]){
		QuestionList test = new QuestionList(2);
		System.out.println("Answer should be 2 : " + test.getLength());
		
		test.list[0] = new Question("CA","C","D");
		test.list[1] = new Question("XP","995","995");
		
		System.out.println("Answer should be XP : " + test.list[1].getType());
		System.out.println("Answer should be D : " + test.list[0].getStudentAnswer());
	}
}
