package me.rudrade.todo_list.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Document("Task")
public class Task {

    @Id
    private String id;

    private String name;

    private String description;
    
    private boolean completed;
    
    private LocalDate dueDate;
}
