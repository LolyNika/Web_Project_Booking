package com.example.web_project.model;

import lombok.*;

import java.util.ArrayList;

/**
 * Class with Room variables (room_id; type; is_blocked)
 * @author LolyNika
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Room {
    private int room_id, is_blocked, price;
    private String type, street, description;

    public Room(int is_blocked, int price, String type, String street, String description) {
        this.is_blocked = is_blocked;
        this.price = price;
        this.type = type;
        this.street = street;
        this.description = description;
    }
}
