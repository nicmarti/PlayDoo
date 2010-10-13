package controllers;

import models.Todo;
import play.mvc.*;

import java.util.List;

public class Application extends Controller {

    public static void index() {
        List<Todo> listOfTodos=Todo.findAll() ;

        render(listOfTodos);
    }

}