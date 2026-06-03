import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindOneTask() {
        Todos todos = new Todos();

        SimpleTask simpleTask = new SimpleTask(1, "Купить хлеб");
        Epic epic = new Epic(2, new String[]{"Молоко", "Яйца"});
        Meeting meeting = new Meeting(3, "Выкатка версии", "Банк", "Среда");

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask};
        Task[] actual = todos.search("хлеб");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindSeveralTasks() {
        Todos todos = new Todos();

        SimpleTask simpleTask = new SimpleTask(1, "Купить Хлеб");

        Epic epic = new Epic(
                2,
                new String[]{"Хлеб", "Молоко"}
        );

        Meeting meeting = new Meeting(
                3,
                "Выкатка версии",
                "Банк",
                "Среда"
        );

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic};
        Task[] actual = todos.search("Хлеб");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnEmptyArrayWhenNothingFound() {
        Todos todos = new Todos();

        SimpleTask simpleTask = new SimpleTask(1, "Купить хлеб");
        Epic epic = new Epic(2, new String[]{"Молоко", "Яйца"});
        Meeting meeting = new Meeting(3, "Выкатка версии", "Банк", "Среда");

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {};
        Task[] actual = todos.search("Макароны");

        Assertions.assertArrayEquals(expected, actual);
    }
}
