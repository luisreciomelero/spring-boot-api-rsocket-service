package io.pivotal.msCRUDEmployee.messages;

import io.pivotal.msCRUDEmployee.models.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    private String origin;
    private String interaction;
    private Object data;
    private Employee employee;
    private List<String> employees;
    private long index;
    private long created = Instant.now().getEpochSecond();



    public Message(String origin, String interaction, List<String> employees) {
        this.origin = origin;
        this.interaction = interaction;
        this.index = 0;
        this.employees = employees;
    }

    public Message(String origin, String interaction, Long data) {
        this.origin = origin;
        this.interaction = interaction;
        this.index = 0;
        this.data = data;
    }


    public Message(String origin, String interaction, Employee employee) {
        this.origin = origin;
        this.interaction = interaction;
        this.index = 0;
        this.data = employee;
    }






}