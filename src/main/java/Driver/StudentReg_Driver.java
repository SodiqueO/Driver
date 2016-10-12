package Driver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.joda.time.LocalDate;

import Assignment1.Assignment1.Course;
import Assignment1.Assignment1.Module;
import Assignment1.Assignment1.Student;

public class StudentReg_Driver {

	public static void main(String[] args) {
		String courseName = "Computer Science & Information Technology";
	//Easier and less complicated to use arrays of Students rather than individual student objects. Same applies for the module class.
	//Chose this method after trying to create individual students and adding them to modules on at a time.
		
		Student[] s1 ={ new Student("Sodique Olabiyi", "21/10/1995", 21, 1340),
						new Student("Arsene Wenger", "14/08/1996", 20, 1343),
						new Student("José Mourinho", "21/09/1995", 21, 1421)};
		Student[] s2 ={ new Student("Josep Guardiola", "01/10/1996", 20, 1215),
						new Student("Jürgen Klopp", "29/11/1993", 22, 1589)};
		Student[] s3 ={ new Student("Antonio Conte", "14/05/1994", 22, 257),
						new Student("Mauricio Pochettino", "12/12/1992", 23, 3459)};
		//array of modules
		Module[] modules ={ new Module("Machine Learning & Data Mining","CT475", s1),
							new Module("Software Engineering III", "CT417", s2),
							new Module("Systems Modelling and Simulation", "CT561", s3)};
		
		LocalDate start = new LocalDate(2016, 9, 1);
		LocalDate end = new LocalDate(2017, 4, 25);
		Course Prog = new Course( courseName, modules, start, end );
		
		Module[] m = Prog.getModules();
		HashMap <Student, ArrayList<Module>> map_a = new HashMap<Student, ArrayList<Module>>();
		HashMap <Module, Course> map_b = new HashMap<Module, Course>();
		
		for (int i=0; i<m.length;i++){
			Student[] registeredStudents = m[i].getStudentList();
			map_b.put(m[i], Prog);
			
			for (int j=0; j<registeredStudents.length; j++){
				if (!map_a.containsKey(registeredStudents[j])){
					map_a.put(registeredStudents[j], new ArrayList<Module>());
				}
				
				map_a.get(registeredStudents[j]).add(m[i]);
			
		}

	}
		
		Set<Student> keys = map_a.keySet();
		Iterator<Student> i = keys.iterator();
		
		while(i.hasNext()){
			Student temp = i.next();
			System.out.println("Student:" + "\t" + temp.getUsername() + "\t");
			ArrayList<Module> list = map_a.get(temp);
			Iterator<Module> itr = list.iterator();
			
			System.out.println("Modules:");
			
			while(itr.hasNext()){
				Module t = itr.next();
				System.out.println(t.getModuleName() + " ");
			}
			//printing out course
			System.out.println("Course:" + map_b.get(list.get(0)).getCourseName());
		}

}
}
