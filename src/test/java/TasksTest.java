import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {

    @Test
    public void shouldCheckRidhtQuerySimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        Todos todos = new Todos();
        todos.add(simpleTask);
        boolean expected  = true;
        boolean actual = simpleTask.matches("Позвонить");
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void shouldCheckWrongQuerySimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        Todos todos = new Todos();
        todos.add(simpleTask);
        boolean expected  = false;
        boolean actual = simpleTask.matches("Позвонить жене");
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void shouldCheckRightQueryEpic() {
        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);
        Todos todos = new Todos();
        todos.add(epic);
        boolean expected  = true;
        boolean actual = epic.matches("Молоко");
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void shouldCheckWrongQueryEpic() {
        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);
        Todos todos = new Todos();
        todos.add(epic);
        boolean expected  = false;
        boolean actual = epic.matches("Пиво");
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void shouldCheckRightQueryMeeting() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        Todos todos = new Todos();
        todos.add(meeting);
        boolean expected  = true;
        boolean actual = meeting.matches("Приложение");
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void shouldCheckWrongQueryMeeting() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        Todos todos = new Todos();
        todos.add(meeting);
        boolean expected  = false;
        boolean actual = meeting.matches("В среду");
        Assertions.assertEquals(actual, expected);
    }
}
