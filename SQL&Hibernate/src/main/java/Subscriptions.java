import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "subscriptions")
public class Subscriptions {
  @EmbeddedId
  private SubscriptionKey key;

 @ManyToOne(fetch = FetchType.LAZY)
 @JoinColumn(name = "student_id",insertable = false, updatable = false)
  //  @MapsId("student_id")
 private Student studentId;

  @ManyToOne(fetch = FetchType.LAZY)
 @JoinColumn(name = "course_id", insertable = false, updatable = false)
 // @MapsId("course_id")
  private Course courseId;
  @Column(name = "subscription_date")
  private Date subscriptionDate;

  public SubscriptionKey getKey() {
    return key;
  }

  public void setKey(SubscriptionKey key) {
    this.key = key;
  }

  public Student getStudentId() {
    return studentId;
  }

  public void setStudentId(Student studentId) {
    this.studentId = studentId;
  }

  public Course getCourseId() {
    return courseId;
  }

  public void setCourseId(Course courseId) {
    this.courseId = courseId;
  }

  public Date getSubscriptionDate() {
    return subscriptionDate;
  }

  public void setSubscriptionDate(Date subscriptionDate) {
    this.subscriptionDate = subscriptionDate;
  }
}
