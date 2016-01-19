package view;

import java.io.IOException;
import java.sql.SQLException;

import controller.HorarioController;

public class Principal {

	private static final String DIR = "E:\\OneDrive - Centro Paula Souza 1\\Horario Fatec ZL\\2016-1\\XML"; 
	
	public static void main(String[] args) {
//		period();
//		options();
//		lessons();
//		cards();
		classes();
	}
	
	private static void classes() {
		String nomeArq = "classes.txt";
		HorarioController hController = new HorarioController(DIR, nomeArq);
		try {
			hController.cadastroClasses();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
	}

	private static void cards() {
		String nomeArq = "cards.txt";
		HorarioController hController = new HorarioController(DIR, nomeArq);
		try {
			hController.cadastroCards();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
	}

	private static void lessons() {
		String nomeArq = "lessons.txt";
		HorarioController hController = new HorarioController(DIR, nomeArq);
		try {
			hController.cadastroLessons();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}		
	}

	private static void options() {
		String nomeArq = "options.txt";
		HorarioController hController = new HorarioController(DIR, nomeArq);
		try {
			hController.cadastroOptions();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
	}

	private static void period(){
		String nomeArq = "periods.txt";
		HorarioController hController = new HorarioController(DIR, nomeArq);
		try {
			hController.cadastroPeriods();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
	}

}
