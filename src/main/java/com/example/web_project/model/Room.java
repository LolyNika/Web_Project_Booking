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
}
