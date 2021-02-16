package io.pivotal.msCRUDEmployee.messages;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    private String origin;
    private String interaction;
    private String data;
    private long index;
    private long created = Instant.now().getEpochSecond();

    public Message(String origin, String interaction, String data) {
        this.origin = origin;
        this.interaction = interaction;
        this.index = 0;
        this.data = data;
    }

    public Message(String origin, String interaction, long index, String data) {
        this.origin = origin;
        this.interaction = interaction;
        this.index = index;
        this.data = data;

    }
}