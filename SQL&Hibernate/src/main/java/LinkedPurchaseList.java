import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="linkedpurchaselist")
public class LinkedPurchaseList {
  @EmbeddedId
  private KeyLinkedPurchaseList key;
  @Column(name = "student_id", insertable = false,updatable = false)
  private Integer studentId;
  @Column(name = "course_id", insertable = false,updatable = false)
  private Integer courseId;

  public KeyLinkedPurchaseList getKey() {
    return key;
  }

  public void setKey(KeyLinkedPurchaseList key) {
    this.key = key;
  }

  public Integer getStudentId() {
    return studentId;
  }

  public void setStudentId(Integer studentId) {
    this.studentId = studentId;
  }

  public Integer getCourseId() {
    return courseId;
  }

  public void setCourseId(Integer courseId) {
    this.courseId = courseId;
  }
}
