package controllers;

import models.Todo;
import play.mvc.*;

import java.util.Date;
import java.util.List;

public class Application extends Controller {

    public static void index() {
        List<Todo> listOfTodos = Todo.findAll();

        render(listOfTodos);
    }

    public static void create(String title, Date dueDate) {
        Todo todo = new Todo(title, dueDate);
        todo.save();
        index();
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
        index();

    }

}