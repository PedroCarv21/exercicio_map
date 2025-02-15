package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import entities.Candidato;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter file full path: ");
		String filePath = sc.nextLine();
		
		Map<Candidato, Integer> candidatos = new HashMap<>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))){
			
			String line = br.readLine();
			while (line != null) {
				String[] info = line.split(",");
				String nome = info[0];
				Integer votos = Integer.parseInt(info[1]);
				if (candidatos.containsKey(new Candidato(nome))) {
					candidatos.put(new Candidato(nome), candidatos.get(new Candidato(nome)) + votos);
				}
				else {
					candidatos.put(new Candidato(nome), votos);
				}
				line = br.readLine();
			}
			
			for (Candidato candidato: candidatos.keySet()) {
				System.out.printf("Candidato %s: %d%n", candidato.getNome(), candidatos.get(candidato));
				//first comment
			}
		} 
		
		catch (IOException e) {
			e.printStackTrace();
		}
		
		sc.close();
	}

}
