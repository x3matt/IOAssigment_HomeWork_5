import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) throws Exception{
		
		getPersonsFileSortedByTECHsum("File.txt", "Persons.txt");
		
		}
	public static void getPersonsFileSortedByTECHsum(String fileName1,String fileName2) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader(fileName1));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(fileName2)));
		List<Person> list = br
				.lines()
				.map(s -> s.split(","))
				.map(s -> new Person(s[0], s[1], new Technique(Integer.parseInt(s[3]), s[2])))
				.collect(Collectors.toList());
		br.close();
		makeList(list).stream().sorted().forEach(p -> pw.println(p));
		pw.flush();
		pw.close();
	}
	private static List<String> makeList(List<Person> input){
		List<String> list = new ArrayList<>();
		for (int i = 0; i < input.size(); i++) {
			String res = input.get(i).getFirstName()+" "+input.get(i).getLastName()+","+getSumPrice(input).get(i);
			list.add(res);		
	}
		return list.stream().distinct().collect(Collectors.toList());
   }
	private static List<Integer> getSumPrice(List<Person> input) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < input.size(); i++) {
			Integer sum=0;
			String tmp1 = input.get(i).getFirstName()+" "+input.get(i).getLastName();
			for (int j = 0; j < input.size(); j++) {
				String tmp2 = input.get(j).getFirstName()+" "+input.get(j).getLastName();
				if(tmp1.equals(tmp2)) {
					sum=input.get(j).getTech().getPrice()+sum;
				}
			}
			list.add(sum);
		}
		return list;
	}
}