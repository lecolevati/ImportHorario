package view;

import java.io.IOException;
import java.sql.SQLException;

import controller.HorarioController;

public class Principal {

	public static void main(String[] args) {
//		period();
//		options();
//		lessons();
//		cards();
		classes();
	}
	
	private static void classes() {
		String dir = "E:\\OneDrive - Centro Paula Souza 1\\Horario Fatec ZL\\2015-2\\HTML\\XML";
		String nomeArq = "classes.txt";
		HorarioController hController = new HorarioController(dir, nomeArq);
		try {
			hController.cadastroClasses();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
	}

	private static void cards() {
		String dir = "E:\\OneDrive - Centro Paula Souza 1\\Horario Fatec ZL\\2015-2\\HTML\\XML";
		String nomeArq = "cards.txt";
		HorarioController hController = new HorarioController(dir, nomeArq);
		try {
			hController.cadastroCards();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
	}

	private static void lessons() {
		String dir = "E:\\OneDrive - Centro Paula Souza 1\\Horario Fatec ZL\\2015-2\\HTML\\XML";
		String nomeArq = "lessons.txt";
		HorarioController hController = new HorarioController(dir, nomeArq);
		try {
			hController.cadastroLessons();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}		
	}

	private static void options() {
		String dir = "E:\\OneDrive - Centro Paula Souza 1\\Horario Fatec ZL\\2015-2\\HTML\\XML";
		String nomeArq = "options.txt";
		HorarioController hController = new HorarioController(dir, nomeArq);
		try {
			hController.cadastroOptions();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
	}

	private static void period(){
		String dir = "E:\\OneDrive - Centro Paula Souza 1\\Horario Fatec ZL\\2015-2\\HTML\\XML";
		String nomeArq = "periods.txt";
		HorarioController hController = new HorarioController(dir, nomeArq);
		try {
			hController.cadastroPeriods();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
	}

}
