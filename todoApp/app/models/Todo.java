package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;

/**
 * Simple Entity
 *
 * @author Nicolas Martignole
 * @since 13 oct. 2010 21:54:26
 */
@Entity
public class Todo extends Model {
    public String title;
    public boolean todoDone;

    @Temporal(TemporalType.DATE)
    public Date dueDate;

    public Todo(String title, Date dueDate) {
        this.title = title;
        this.dueDate = dueDate;
        todoDone = false;
    }

    public static List<Todo> fetch(int page, int pageSize) {
          return Todo.find("from Todo t order by dueDate").fetch(page, pageSize);
    }
}
