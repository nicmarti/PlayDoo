package models;

import net.sf.oval.constraint.MaxLength;
import play.data.validation.InFuture;
import play.data.validation.Required;
import play.db.jpa.Model;
import play.mvc.After;

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
    @Required
    @MaxLength(10)
    public String title;

    public boolean todoDone;

    @Temporal(TemporalType.DATE)
    @InFuture
    @Required
    public Date dueDate;

    public Todo(final String title, final Date dueDate) {
        this.title = title;
        this.dueDate = dueDate;
        todoDone = false;
    }

    public static List<Todo> fetch(int page, int pageSize) {
          return Todo.find("from Todo t order by dueDate").fetch(page, pageSize);
    }
}
