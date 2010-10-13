import models.Todo;
import play.Play;
import play.jobs.Job;
import play.jobs.OnApplicationStart;
import play.test.Fixtures;

/**
 * Executed when the application starts in developer mode, to load some entries
 * into the database.
 *
 * @author Nicolas Martignole
 */
@OnApplicationStart
public class Bootstrap extends Job {

    public void doJob() {
        if (Play.mode == Play.Mode.DEV) {
            if (Todo.count() == 0) {
                Fixtures.load("test-datas.yml");
            }
        }
    }

}