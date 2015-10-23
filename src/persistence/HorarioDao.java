package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Cards;
import model.Classes;
import model.Lessons;
import model.Options;
import model.Periods;

public class HorarioDao {

	private Connection c;
	
	public HorarioDao() throws SQLException{
		GenericoDao gDao = new GenericoDao();
		c = gDao.getConnection();
	}
	
	public void inserePeriods(Periods periods) throws SQLException{
		String sql = "insert into periods (period, name, short, starttime, endtime) values (?,?,?,?,?)";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, periods.getPeriod());
		ps.setInt(2, periods.getName());
		ps.setInt(3, periods.getShortperiod());
		ps.setString(4, periods.getStarttime());
		ps.setString(5, periods.getEndtime());
		ps.execute();
		ps.close();
	}
	
	public void insereOptions(Options options) throws SQLException{
		String sql = "insert into options (id, name, short, partner_id) values (?,?,?,?)";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, options.getId());
		ps.setString(2, options.getName());
		ps.setString(3, options.getShortoptions());
		ps.setInt(4, options.getPartner_id());
		ps.execute();
		ps.close();
	}
	
	public void insereLessons(Lessons lessons) throws SQLException{
		String sql = "insert into lessons (id, subjectid, classids, groupids, teacherids, classroomids, periodspercard, periodsperweek, daysdefid, weeksdefid, termsdefid) values (?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, lessons.getId());
		ps.setString(2, lessons.getSubjectid());
		ps.setString(3, lessons.getClassids());
		ps.setString(4, lessons.getGroupids());
		ps.setString(5, lessons.getTeacherids());
		ps.setString(6, lessons.getClassroomids());
		ps.setInt(7, lessons.getPeriodspercard());
		ps.setDouble(8, lessons.getPeriodsperweek());
		ps.setString(9, lessons.getDaysdefid());
		ps.setString(10, lessons.getWeeksdefid());
		ps.setString(11, lessons.getTermsdefid());
		ps.execute();
		ps.close();
	}
	
	public void insereCards(Cards cards) throws SQLException{
		String sql = "insert into cards (lessonid, classroomids, period, weeks, terms, days) values (?,?,?,?,?,?)";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, cards.getLessonid());
		ps.setString(2, cards.getClassroomids());
		ps.setInt(3, cards.getPeriod());
		ps.setInt(4, cards.getWeeks());
		ps.setInt(5, cards.getTerms());
		ps.setInt(6, cards.getDays());
		ps.execute();
		ps.close();
	}
	public void insereClasses(Classes classes) throws SQLException{
		String sql = "insert into classes (id, name, short) values (?,?,?)";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, classes.getId());
		ps.setString(2, classes.getName());
		ps.setString(3, classes.getShortclasses());
		ps.execute();
		ps.close();
	}
	
}
