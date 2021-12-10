package oop21.sim2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class App 
{
    public static void main( String[] args ) throws Exception
    {
        //main piece from prof's solution
        List<Class> scuola = new ArrayList<>();
		
		List<Professor> docs1 = List.of(new Professor("Anna", "Esposito", "Matematica"),
				new Professor("Gennaro", "De Prisco", "Italiano"), 
				new Professor("Lucia", "D'Elia", "Storia"));
		List<Student> stu1 = List.of(new Student("Maria", "De Filippi", "S002", 
					List.of(new Mark(8, "Matematica"), new Mark(7, "Italiano"))),
				new Student("Paolo", "Antignani", "S001", 
						List.of(new Mark(4, "Matematica"), new Mark(5, "Italiano"))),
				new Student("Roberto", "Natella", "S003", 
					List.of(new Mark(8, "Matematica"), new Mark(7, "Italiano"), new Mark(6, "Storia"))));

		Class c1 = new Class(docs1, stu1, "Class1");
		scuola.add(c1);
		List<Professor> docs2 = List.of(new Professor("Pasquale", "Polli", "Matematica"),
				new Professor("Ettore", "Bassi", "Italiano"), 
				new Professor("Lucia", "D'Elia", "Storia"));
		List<Student> stu2 = List.of(new Student("Oreste", "Antigone", "S004", 
					List.of(new Mark(6, "Matematica"), new Mark(7, "Italiano"), new Mark(7, "Storia"))),
				new Student("Roberta", "Doles", "S005", 
					List.of(new Mark(5, "Matematica"), new Mark(4, "Italiano"))),
				new Student("Giuseppe", "Nittis", "S006", 
					List.of(new Mark(8, "Matematica"), new Mark(7, "Italiano"), new Mark(7, "Storia"))));
					
		Class c2 = new Class(docs2, stu2, "Class2");
		scuola.add(c2);
		List<Professor> docs3 = List.of(new Professor("Pasquale", "Polli", "Matematica"),
				new Professor("Umberto", "Smaila", "Italiano"), 
				new Professor("Lorenzo", "Bua", "Storia"));
		List<Student> stu3 = List.of(new Student("Oreste", "Antigone", "S004", 
					List.of(new Mark(4, "Matematica"), new Mark(4, "Italiano"))),
				new Student("Roberta", "Doles", "S005", 
					List.of(new Mark(6, "Matematica"), new Mark(6, "Italiano"), new Mark(6, "Storia"))),
				new Student("Giuseppe", "Nittis", "S006", 
					List.of(new Mark(5, "Matematica"), new Mark(5, "Italiano"), new Mark(5, "Storia"))));
		Class c3 = new Class(docs3, stu3, "Class3");
		scuola.add(c3);

		System.out.println("Composizione delle classi");
		scuola.forEach(System.out::println);

		System.out.println("Gli studenti con almeno 3 voti assegnati sono: " + 
		scuola.stream().flatMap(c -> c.getStudentList().stream()).filter(s -> s.getMarkList().size() >= 3).count()
		);
		
    }
}
