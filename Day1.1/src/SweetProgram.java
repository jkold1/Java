import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SweetProgram {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("student.txt"));
		
		List<String> student = new ArrayList<String>();
		
		while(scan.hasNextLine()) {
			student.add(scan.nextLine());
		}
		
		for(int i = 0;i<student.size();i++) {
			System.out.println("name: "+ student.get(i));
		}
		
		scan.close();
		
	}

}
