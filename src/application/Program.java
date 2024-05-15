package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Departament;
import entities.HourContrat;
import entities.Worker;
import entities.WorkerLevel;

public class Program {
	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Scanner input = new Scanner(System.in);

		System.out.print("Enter department's name:");
		String departamentName = input.nextLine();
		
		System.out.println("Enter Worker Data:");
		
		System.out.print("Name:");
		String name = input.nextLine();
		
		System.out.print("Level (Junior(1), MID_LEVEL(2) or SENIOR(3)):");
		int inputLevel = input.nextInt();
		
		WorkerLevel level = null;
		if (inputLevel == WorkerLevel.JUNIOR.getCodigo()) {
			level = WorkerLevel.JUNIOR;
		} else if (inputLevel == WorkerLevel.MID_LEVEL.getCodigo()) {
			level = WorkerLevel.MID_LEVEL;
		} else if (inputLevel == WorkerLevel.SENIOR.getCodigo()) {
			level = WorkerLevel.SENIOR;
		}
		
		System.out.print("Base salary:");
		double baseSalary = input.nextDouble();
		
		Worker worker = new Worker(name, level, baseSalary, new Departament(departamentName));
		
		System.out.print("How many contracts to this worker? ");
		int contracts = input.nextInt();
		
		for (int i = 0; i < contracts;i++) {
			System.out.printf("Enter contract #%d data:", i + 1);
			
			System.out.print("Date (dd/MM/yyy):");
			Date contractDate = sdf.parse(input.next());

			System.out.print("Value per hour:");
			Double ValuePerHour = input.nextDouble();
			
			System.out.print("Duration (hours):");
			Integer hours = input.nextInt();
			
			HourContrat contrat = new HourContrat(contractDate, ValuePerHour, hours);
			worker.addContrat(contrat);
			
			
		}

		System.out.print("Enter month and year to calculate income (MM/YYYY):");
		String MonthAndYer = input.next();
		
		int month = Integer.parseInt(MonthAndYer.substring(0,2));
		int year = Integer.parseInt(MonthAndYer.substring(3));
		System.out.println(month);
		System.out.println(year);
		
		System.out.println("Name: " + worker.getName());
		System.out.println("Departament: " + worker.getDepartamnet().getName());
		System.out.println("Income For " + MonthAndYer + ": " + String.format("%.2f", worker.income(month, year)));
		

		input.close();
	}
}
