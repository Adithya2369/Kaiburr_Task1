package kaiburr.task1.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "tasks")
public class task {
    @Id
    private String id;
    private String name;
    private String owner;
    private String command;
    private List<TaskExecution> taskExecutions;
}
