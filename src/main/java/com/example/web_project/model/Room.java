package com.example.web_project.model;

import lombok.*;

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

    private int room_id, is_blocked;
    private String type;

}
