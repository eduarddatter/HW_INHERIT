import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {

    @Test
    public void shouldMatchForMeetingByTopic() {
        Meeting meeting = new Meeting(2, "Выкатка версии", "Приложение банка", "В среду до обеда");
        Assertions.assertTrue(meeting.matches("Выкатка"));
    }

    @Test
    public void shouldMatchForMeetingByProject() {
        Meeting meeting = new Meeting(2, "Выкатка версии", "Приложение банка", "В среду до обеда");
        Assertions.assertTrue(meeting.matches("банк"));
    }

    @Test
    public void shouldNotMatchForMeeting() {
        Meeting meeting = new Meeting(2, "Выкатка версии", "Приложение банка", "В среду до обеда");
        Assertions.assertFalse(meeting.matches("хлеб"));
    }

    @Test
    public void shouldMatchForSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(1, "Купить хлеб");
        Assertions.assertTrue(simpleTask.matches("хлеб"));
    }

    @Test
    public void shouldNotMatchForSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(1, "Купить молоко");
        Assertions.assertFalse(simpleTask.matches("хлеб"));
    }

    @Test
    public void shouldMatchForEpic() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);
        Assertions.assertTrue(epic.matches("Хлеб"));
    }

    @Test
    public void shouldNotMatchForEpic() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);
        Assertions.assertFalse(epic.matches("Макароны"));
    }

    @Test
    public void shouldSetId() {
        Task taskId = new Task(1);

        int expected = 1;
        int actual = taskId.getId();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSetTitle() {
        SimpleTask task = new SimpleTask(1, "Купить хлеб");

        String expected = "Купить хлеб";
        String actual = task.getTitle();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSetSubtasks() {
        String[] subtasks = {"Молоко", "Хлеб"};

        Epic epic = new Epic(1, subtasks);

        Assertions.assertArrayEquals(subtasks, epic.getSubtasks());
    }

    @Test
    public void shouldSetTopic() {
        Meeting meeting = new Meeting(
                1,
                "Выкатка версии",
                "Банк",
                "Среда"
        );

        Assertions.assertEquals(
                "Выкатка версии",
                meeting.getTopic()
        );
    }

    @Test
    public void shouldSetProject() {
        Meeting meeting = new Meeting(
                1,
                "Выкатка версии",
                "Банк",
                "Среда"
        );

        Assertions.assertEquals(
                "Банк",
                meeting.getProject()
        );
    }

    @Test
    public void shouldSetStart() {
        Meeting meeting = new Meeting(
                1,
                "Выкатка версии",
                "Банк",
                "Среда"
        );

        Assertions.assertEquals(
                "Среда",
                meeting.getStart()
        );
    }


}
