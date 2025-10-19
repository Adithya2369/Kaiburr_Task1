package kaiburr.task1.service;
import kaiburr.task1.model.*;
import kaiburr.task1.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

@Service
public class TaskService {
    @Autowired
    private TaskRepository repo;

    public List<Task> getAll() { return repo.findAll(); }
    public Optional<Task> getById(String id) { return repo.findById(id); }
    public Task add(Task task) { return repo.save(task); }
    public void delete(String id) { repo.deleteById(id); }
    public List<Task> searchByName(String name) { return repo.findByNameContainingIgnoreCase(name); }

    public Task execute(String id) throws Exception {
        Task task = repo.findById(id).orElseThrow();
        TaskExecution exec = new TaskExecution();
        exec.setStartTime(new Date());

        Process p = Runtime.getRuntime().exec(task.getCommand());
        BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
        StringBuilder output = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) output.append(line).append("\n");
        p.waitFor();

        exec.setEndTime(new Date());
        exec.setOutput(output.toString());

        if (task.getTaskExecutions() == null) task.setTaskExecutions(new ArrayList<>());
        task.getTaskExecutions().add(exec);
        return repo.save(task);
    }
}
