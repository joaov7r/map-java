package app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Map <String, Integer> count = new LinkedHashMap<>();
		
		System.out.print("Enter the files's full path: ");
		String path = sc.nextLine();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			
			String line = br.readLine();
			
			while(line != null) {
				String[] fields = line.split(",");
				String name = fields[0];
				int votes = Integer.parseInt(fields[1]);
				
				if(count.containsKey(name)) {
					int totalVotes = count.get(name);
					count.put(name, votes + totalVotes);
				}
				else {
					count.put(name, votes);
				}
				
				line = br.readLine();
			}
			
			for (String key: count.keySet()) {
				System.out.println(key + ": " + count.get(key));
			} 
		
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		sc.close();
	}

}
