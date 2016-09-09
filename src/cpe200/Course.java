package cpe200;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Course {
    public Course() {
        course_name = "TBA";
        course_id ="000000";
        lecturer = "TBA";
        max_students = 30;
        no_students = 0;
    }
    public Course(String n, String cid) {
        this.course_name = !n.equalsIgnoreCase("") ? n : "TBA";
        this.course_id = !cid.equalsIgnoreCase("") ? cid : "000000";
        lecturer = "TBA";
        max_students = 30;
        no_students = 0;
    }
    public Course(String n, String cid, String l) {
        this.course_name = !n.equalsIgnoreCase("") ? n : "TBA";
        this.course_id = !cid.equalsIgnoreCase("") ? cid : "000000";
        this.lecturer = !l.equalsIgnoreCase("") ? l : "TBA";
        max_students = 30;
        no_students = 0;
    }
    public Course(String n, String cid, String l, int max) {
        this.course_name = !n.equalsIgnoreCase("") ? n : "TBA";
        this.course_id = !cid.equalsIgnoreCase("") ? cid : "000000";
        this.lecturer = !l.equalsIgnoreCase("") ? l : "TBA";
        this.max_students = max > 9 ? max : 30;
        no_students = 0;
    }
    public String getCourse_name() {
        return course_name;
    }
    public void setCourse_name(String course_name) {
        this.course_name = !course_name.equalsIgnoreCase("")?course_name:this.course_name;
    }
    public String getCourse_id() {
        return course_id;
    }
    public void setCourse_id(String course_id) {
        this.course_id = isValidCourse_id(course_id)?course_id:this.course_id;
    }
    public String getLecturer() {
        return lecturer;
    }
    public void setLecturer(String l) {
        this.lecturer = !l.equalsIgnoreCase("") ? l : this.lecturer;
    }
    public int getMax_students() {
        return max_students;
    }
    public void setMax_students(int max) {
        this.max_students = max > 9 ? max : this.max_students;
    }
    public int getNo_students() {
        return no_students;
    }
    public void setNo_students(int no_students) {
        this.no_students = no_students >=0 && no_students < this.max_students?no_students:this.no_students;
    }
    @Override
    public String toString() {
        String o = this.course_name + " ("
                + this.course_id + "), Teacher: "
                + this.lecturer + ", has ";
        if(this.no_students < 2){
            return no_students==1?o+"ONE student, [maximum: "+this.max_students+"]":o+"NO student, [maximum: "+this.max_students+"]";
        }
        return o+this.no_students+" students, [maximum: "+this.max_students+"]";
    }
    private boolean isValidCourse_id(String id) {
        Pattern p = Pattern.compile(idREGEX);
        Matcher m = p.matcher(id);
        return m.matches()?true:false;
    }
    // Regular expression for the Student ID pattern
    private static final String idREGEX = "\\d{6}";
    // all private attributes
    private String course_name;
    private String course_id;
    private String lecturer;
    private int max_students;
    private int no_students;
}