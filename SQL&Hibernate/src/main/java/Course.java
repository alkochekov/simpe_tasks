import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Courses")
public class Course {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String name;
  private int duration;

  @Enumerated(EnumType.STRING)
  @Column(columnDefinition = "enum")
  private CourseType type;

  private String description;
  @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private Teacher teacher;
  @Column(name="students_count")
  private Integer studentsCount;
  private int price;
  @Column(name = "price_per_hour")
  private float pricePerHour;

  @OneToMany(mappedBy = "courseId",cascade = CascadeType.ALL, orphanRemoval = true)
  List<Subscriptions> studentsList=new ArrayList<>();

  public List<Subscriptions> getStudentsList() {
    return studentsList;
  }

  public void setStudentsList(List<Subscriptions> studentsList) {
    this.studentsList = studentsList;
  }
  public void setStudentsCount(Integer studentsCount) {
    this.studentsCount = studentsCount;
  }


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getDuration() {
    return duration;
  }

  public void setDuration(int duration) {
    this.duration = duration;
  }

  public CourseType getType() {
    return type;
  }

  public void setType(CourseType type) {
    this.type = type;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Teacher getTeacher() {
    return teacher;
  }

  public void setTeacher(Teacher teacher) {
    this.teacher = teacher;
  }

  public int getStudentsCount() {
    return studentsCount;
  }

  public void setStudentsCount(int studentsCount) {
    this.studentsCount = studentsCount;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public float getPricePerHour() {
    return pricePerHour;
  }

  public void setPricePerHour(float pricePerHour) {
    this.pricePerHour = pricePerHour;
  }
}
