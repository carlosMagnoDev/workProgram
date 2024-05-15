package entities;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Worker {
	
	private String name;
	private WorkerLevel level;
	private double baseSalary;
	
	private Departament departamnet;
	private List<HourContrat> contracts = new ArrayList<>(); 
	
	public Worker () {
		
	}
	
	public Worker (String name, WorkerLevel level, double baseSalary, Departament departamnet) {
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.departamnet = departamnet;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Departament getDepartamnet() {
		return departamnet;
	}

	public void setDepartamnet(Departament departamnet) {
		this.departamnet = departamnet;
	}

	public void addContrat (HourContrat contrat) {
		this.contracts.add(contrat);
	}
	
	public void removeContrat (HourContrat contrat) {
		this.contracts.remove(contrat);
	}
	
	public Double income (Integer year, Integer month) {
		double sum = baseSalary;
		Calendar cal = Calendar.getInstance();
		
		for (HourContrat contract : contracts) {
			cal.setTime(contract.getDate());
			
			int c_yer = cal.get(Calendar.YEAR);
			int c_month = 1 + cal.get(Calendar.MONTH);
			
			if (year == c_yer && month == c_month) {
				sum += contract.totalValue();
			}
		}
		
		return sum;
		
	}
	
	
	
}
