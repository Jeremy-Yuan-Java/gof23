public class CourseBuilderClient {
    public static void main(String[] args) {
        Course course = new CourseBuilder().addHomework("homework").addNote("note").addName("Name").addMeans("means").build();
        System.out.println(course);
    }
}

class CourseBuilder{
    private Course course=new Course();
    public CourseBuilder addName(String name){
        course.setName(name);
        return this;
    }
    public CourseBuilder addMeans(String means){
        course.setMeans(means);
        return this;
    }

    public CourseBuilder addNote(String note){
        course.setNote(note);
        return this;
    }

    public CourseBuilder addHomework(String homework){
        course.setHomework(homework);
        return this;
    }
    public Course build(){
        return course;
    }
}

class Course{
    private String name;
    private String means;
    private String note;
    private String homework;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMeans() {
        return means;
    }

    public void setMeans(String means) {
        this.means = means;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getHomework() {
        return homework;
    }

    public void setHomework(String homework) {
        this.homework = homework;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", means='" + means + '\'' +
                ", note='" + note + '\'' +
                ", homework='" + homework + '\'' +
                '}';
    }
}