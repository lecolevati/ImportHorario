package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import persistence.HorarioDao;
import model.Cards;
import model.Classes;
import model.Lessons;
import model.Options;
import model.Periods;

public class HorarioController {

	private String dir;
	private String nomeArq;
	
	public HorarioController(String dir, String nomeArq){
		this.dir = dir;
		this.nomeArq = nomeArq;
	}
	
	public void cadastroLessons() throws IOException, SQLException{
		File diretorio = new File(dir);
		Lessons l;
		if (diretorio.exists()){
			File arq = new File(dir,nomeArq);
			if (arq.exists()){
				FileInputStream fis = new FileInputStream(arq);
				InputStreamReader isr = new InputStreamReader(fis);
				BufferedReader br = new BufferedReader(isr);
				String linha = br.readLine();
				if (linha != null){
					linha = linha.trim();
					if (linha.contains("<")){
						linha = linha.replaceAll("/>", "");
						linha = linha.replaceAll("<", "");
					}
				}
				while (linha != null){
					l = new Lessons();
					String[] vetLinha = linha.split(" ");
					for (String valor : vetLinha){
						if (valor.contains("=")){
							String[] vetValor = valor.split("=");
							if (vetValor[0].contains("daysdefid")){
								l.setDaysdefid(vetValor[1].replaceAll("\"", ""));
							}
							if (vetValor[0].contains("periodspercard")){
								l.setPeriodspercard(Integer.parseInt(vetValor[1].replaceAll("\"", "")));
							}
							if (vetValor[0].contains("periodsperweek")){
								l.setPeriodsperweek(Double.parseDouble(vetValor[1].replaceAll("\"", "")));
							}
							if (vetValor[0].equals("id")){
								l.setId(vetValor[1].replaceAll("\"", ""));
							}
							if (vetValor[0].contains("classids")){
								l.setClassids(vetValor[1].replaceAll("\"", ""));
							}
							if (vetValor[0].contains("subjectid")){
								l.setSubjectid(vetValor[1].replaceAll("\"", ""));
							}
							if (vetValor[0].contains("teacherids")){
								l.setTeacherids(vetValor[1].replaceAll("\"", ""));
							}
							if (vetValor[0].contains("classroomids")){
								l.setClassroomids(vetValor[1].replaceAll("\"", ""));
							}
							if (vetValor[0].contains("groupids")){
								l.setGroupids(vetValor[1].replaceAll("\"", ""));
							}
							if (vetValor[0].contains("termsdefid")){
								l.setTermsdefid(vetValor[1].replaceAll("\"", ""));
							}
							if (vetValor[0].contains("weeksdefid")){
								l.setWeeksdefid(vetValor[1].replaceAll("\"", ""));
							}
						}
					}
					HorarioDao hDao = new HorarioDao();
					hDao.insereLessons(l);
					linha = br.readLine();
					if (linha != null){
						linha = linha.trim();
						if (linha.contains("<")){
							linha = linha.replaceAll("/>", "");
							linha = linha.replaceAll("<", "");
						}
					}

				}
				br.close();
				isr.close();
				fis.close();

			} else {
				throw new FileNotFoundException("Arquivo não encontrado");
			}
		} else {
			throw new FileNotFoundException("Diretório não encontrado");
		}
	}
	
	public void cadastroPeriods() throws IOException, SQLException{
		File diretorio = new File(dir);
		Periods p;
		if (diretorio.exists()){
			File arq = new File(dir,nomeArq);
			if (arq.exists()){
				FileInputStream fis = new FileInputStream(arq);
				InputStreamReader isr = new InputStreamReader(fis);
				BufferedReader br = new BufferedReader(isr);
				String linha = br.readLine();
				if (linha != null){
					linha = linha.trim();
					if (linha.contains("<")){
						linha = linha.replaceAll("/>", "");
						linha = linha.replaceAll("<", "");
					}
				}
				while (linha != null){
					p = new Periods();
					String[] vetLinha = linha.split(" ");
					for (String valor : vetLinha){
						if (valor.contains("=")){
							String[] vetValor = valor.split("=");
							if (vetValor[0].contains("name")){
								p.setName(Integer.parseInt(vetValor[1].replaceAll("\"", "")));
							}
							if (vetValor[0].contains("short")){
								p.setShortperiod(Integer.parseInt(vetValor[1].replaceAll("\"", "")));
							}
							if (vetValor[0].contains("period")){
								p.setPeriod(Integer.parseInt(vetValor[1].replaceAll("\"", "")));
							}
							if (vetValor[0].contains("start")){
								p.setStarttime(vetValor[1].replaceAll("\"", ""));
							}
							if (vetValor[0].contains("end")){
								p.setEndtime(vetValor[1].replaceAll("\"", ""));
							}
						}
					}
					HorarioDao hDao = new HorarioDao();
					hDao.inserePeriods(p);
					linha = br.readLine();
					if (linha != null){
						linha = linha.trim();
						if (linha.contains("<")){
							linha = linha.replaceAll("/>", "");
							linha = linha.replaceAll("<", "");
						}
					}

				}
				br.close();
				isr.close();
				fis.close();

			} else {
				throw new FileNotFoundException("Arquivo não encontrado");
			}
		} else {
			throw new FileNotFoundException("Diretório não encontrado");
		}
	}
	
	/**
	 * O arquivo options necessita troca de token
	 * @throws IOException
	 * @throws SQLException
	 */
	public void cadastroOptions() throws IOException, SQLException{
		File diretorio = new File(dir);
		Options o;
		if (diretorio.exists()){
			File arq = new File(dir,nomeArq);
			if (arq.exists()){
				FileInputStream fis = new FileInputStream(arq);
				InputStreamReader isr = new InputStreamReader(fis);
				BufferedReader br = new BufferedReader(isr);
				String linha = br.readLine();
				if (linha != null){
					linha = linha.trim();
					if (linha.contains("<")){
						linha = linha.replaceAll("/>", "");
						linha = linha.replaceAll("<", "");
					}
				}
				while (linha != null){
					o = new Options();
					String[] vetLinha = linha.split("---");
					for (String valor : vetLinha){
						if (valor.contains("=")){
							String[] vetValor = valor.split("=");
							if (vetValor[0].contains("id") && !vetValor[0].contains("partner")){
								o.setId(vetValor[1].replaceAll("\"", ""));
							}
							if (vetValor[0].contains("short")){
								o.setShortoptions(vetValor[1].replaceAll("\"", ""));
							}
//							if (vetValor[0].contains("partner")){
//								o.setPartner_id(Integer.parseInt(vetValor[1].replaceAll("\"", "")));
//							}
							if (vetValor[0].contains("name")){
								o.setName(vetValor[1].replaceAll("\"", ""));
							}
						}
					}
					HorarioDao hDao = new HorarioDao();
					hDao.insereOptions(o);
					linha = br.readLine();
					if (linha != null){
						linha = linha.trim();
						if (linha.contains("<")){
							linha = linha.replaceAll("/>", "");
							linha = linha.replaceAll("<", "");
						}
					}

				}
				br.close();
				isr.close();
				fis.close();

			} else {
				throw new FileNotFoundException("Arquivo não encontrado");
			}
		} else {
			throw new FileNotFoundException("Diretório não encontrado");
		}
	}

	public void cadastroCards() throws IOException, SQLException{
		File diretorio = new File(dir);
		Cards c;
		if (diretorio.exists()){
			File arq = new File(dir,nomeArq);
			if (arq.exists()){
				FileInputStream fis = new FileInputStream(arq);
				InputStreamReader isr = new InputStreamReader(fis);
				BufferedReader br = new BufferedReader(isr);
				String linha = br.readLine();
				if (linha != null){
					linha = linha.trim();
					if (linha.contains("<")){
						linha = linha.replaceAll("/>", "");
						linha = linha.replaceAll("<", "");
					}
				}
				while (linha != null){
					c = new Cards();
					String[] vetLinha = linha.split(" ");
					for (String valor : vetLinha){
						if (valor.contains("=")){
							String[] vetValor = valor.split("=");
							if (vetValor[0].contains("weeks")){
								c.setWeeks(Integer.parseInt(vetValor[1].replaceAll("\"", "")));
							}
							if (vetValor[0].contains("terms")){
								c.setTerms(Integer.parseInt(vetValor[1].replaceAll("\"", "")));
							}
							if (vetValor[0].contains("days")){
								c.setDays(Integer.parseInt(vetValor[1].replaceAll("\"", "")));
							}
							if (vetValor[0].contains("period")){
								c.setPeriod(Integer.parseInt(vetValor[1].replaceAll("\"", "")));
							}
							if (vetValor[0].contains("lessonid")){
								c.setLessonid(vetValor[1].replaceAll("\"", ""));
							}
							if (vetValor[0].contains("classroomids")){
								c.setClassroomids(vetValor[1].replaceAll("\"", ""));
							}
						}
					}
					HorarioDao hDao = new HorarioDao();
					hDao.insereCards(c);
					linha = br.readLine();
					if (linha != null){
						linha = linha.trim();
						if (linha.contains("<")){
							linha = linha.replaceAll("/>", "");
							linha = linha.replaceAll("<", "");
						}
					}

				}
				br.close();
				isr.close();
				fis.close();

			} else {
				throw new FileNotFoundException("Arquivo não encontrado");
			}
		} else {
			throw new FileNotFoundException("Diretório não encontrado");
		}
	}
	/**
	 * O arquivo classes necessita de troca de token
	 * @throws IOException
	 * @throws SQLException
	 */
	public void cadastroClasses() throws IOException, SQLException{
		File diretorio = new File(dir);
		Classes c;
		if (diretorio.exists()){
			File arq = new File(dir,nomeArq);
			if (arq.exists()){
				FileInputStream fis = new FileInputStream(arq);
				InputStreamReader isr = new InputStreamReader(fis);
				BufferedReader br = new BufferedReader(isr);
				String linha = br.readLine();
				if (linha != null){
					linha = linha.trim();
					if (linha.contains("<")){
						linha = linha.replaceAll("/>", "");
						linha = linha.replaceAll("<", "");
					}
				}
				while (linha != null){
					c = new Classes();
					String[] vetLinha = linha.split("---");
					for (String valor : vetLinha){
						if (valor.contains("=")){
							String[] vetValor = valor.split("=");
							if (vetValor[0].equals("id")){
								c.setId(vetValor[1].replaceAll("\"", ""));
							}
							if (vetValor[0].contains("name")){
								c.setName(vetValor[1].replaceAll("\"", ""));
							}
							if (vetValor[0].contains("short")){
								c.setShortclasses(vetValor[1].replaceAll("\"", ""));
							}
						}
					}
					HorarioDao hDao = new HorarioDao();
					hDao.insereClasses(c);
					linha = br.readLine();
					if (linha != null){
						linha = linha.trim();
						if (linha.contains("<")){
							linha = linha.replaceAll("/>", "");
							linha = linha.replaceAll("<", "");
						}
					}

				}
				br.close();
				isr.close();
				fis.close();

			} else {
				throw new FileNotFoundException("Arquivo não encontrado");
			}
		} else {
			throw new FileNotFoundException("Diretório não encontrado");
		}
	}
	
}
