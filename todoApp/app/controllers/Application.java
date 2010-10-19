package controllers;

import models.Todo;
import play.mvc.*;

import java.util.Date;
import java.util.List;

public class Application extends Controller {

    public static void index(int page) {
        if (page == -1) {
            page = 0;
        }
        int pageSize = 5;
        List<Todo> listOfTodos = Todo.fetch(page, pageSize);
        int totalPage = computeTotalPage(pageSize, Todo.count());
        render(listOfTodos, page, totalPage);
    }

    public static int computeTotalPage(int pageSize, long total) {
        if (total <= pageSize) {
            return 1;
        }

        return (int) Math.rint(total/pageSize)+1;
    }

    public static void create(String title, Date dueDate) {
        Todo todo = new Todo(title, dueDate);
        todo.save();
        index(0);
    }

    public static void show(Long id, String title) {
        Todo event = Todo.findById(id);
        render(event);
    }

    public static void form(Long id) {
        if (id == null) {
            render();
        }
        Todo todo = Todo.findById(id);
        render(todo);
    }

    public static void save(Todo todo) {
        if (validation.hasErrors()) {
            if (request.isAjax()) error("Invalid value");
            render("@form", todo);
        }
        todo.save();
        index(0);

    }

    public static void done(Long id) {
        Todo todo = Todo.findById(id);
        todo.todoDone = true;
        todo.save();
        index(0);
    }

}