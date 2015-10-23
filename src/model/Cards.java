package model;

public class Cards {

	private String lessonid;
	private int period;
	private int days;
	private int weeks;
	private int terms;
	private String classroomids;
	public String getLessonid() {
		return lessonid;
	}
	public void setLessonid(String lessonid) {
		this.lessonid = lessonid;
	}
	public int getPeriod() {
		return period;
	}
	public void setPeriod(int period) {
		this.period = period;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	public int getWeeks() {
		return weeks;
	}
	public void setWeeks(int weeks) {
		this.weeks = weeks;
	}
	public int getTerms() {
		return terms;
	}
	public void setTerms(int terms) {
		this.terms = terms;
	}
	public String getClassroomids() {
		return classroomids;
	}
	public void setClassroomids(String classroomids) {
		this.classroomids = classroomids;
	}

}
