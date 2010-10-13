package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import java.util.Date;

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
    public Date dueDate;

}
