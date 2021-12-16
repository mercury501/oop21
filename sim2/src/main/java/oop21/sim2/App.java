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

		List <String> profs = scuola.stream().flatMap(c -> c.getProfessorList().stream().map(p -> p.getName() + " " + p.getSurname())).toList();
		Map <String, Integer> resProf = profs.stream().distinct()
			.collect(Collectors.toMap(Function.identity(), v -> Collections.frequency(profs, v))
			);

		List <String> studs = scuola.stream().flatMap(c -> c.getStudentList().stream().map(s -> s.getName() + " " + s.getSurname())).toList();
		Map <String, Integer> resStud = studs.stream().distinct()
			.collect(Collectors.toMap(Function.identity(), v -> Collections.frequency(studs, v)));


		System.out.println(
			"Numero medio di classi a cui un docente è assegnato: " + 
			resProf.values().stream().mapToInt(Integer::intValue).average().getAsDouble()
		);

		System.out.println(
			"Numero medio di classi a cui uno studente è assegnato: " + 
			resStud.values().stream().mapToInt(Integer::intValue).average().getAsDouble()
		);

		List <Student> studList = scuola.stream().flatMap(c -> c.getStudentList().stream()).toList();
		
		System.out.println("Numero di studenti con media sopra la sufficienza: "+
		scuola.stream().flatMap(c -> c.getStudentList().stream())
		.mapToDouble(s -> s.getMarkInts().stream().mapToInt(Integer::intValue).average().getAsDouble())
		.filter(p -> p>= 6).count()
		);

		System.out.println("Numero di classi in cui gli studenti con media sopra il 7 sono la maggioranza: " + 
			scuola.stream().filter(
				c -> c.getStudentList().stream().filter(
					s -> s.getMarkInts().stream().mapToInt(Integer::intValue).average().getAsDouble() >= 7).count()
					>= (double) (c.getStudentList().size() / 2)
				
			).count()
		);

		Comparator <Student> alfComp = (s1, s2) -> {
			int r = s1.getSurname().compareTo(s2.getSurname());
			if (r != 0)
				return r;
			return s1.getName().compareTo(s2.getName());
		};

		Comparator <Student> votComp = (s1, s2) -> {
			double m1 = s1.getMarkInts().stream().mapToInt(Integer::intValue).average().getAsDouble();
			double m2 = s2.getMarkInts().stream().mapToInt(Integer::intValue).average().getAsDouble();

			if (m1 > m2)
				return -1;
			if (m2 > m1)
				return 1;
			return 0;
		};

		


    }
}
