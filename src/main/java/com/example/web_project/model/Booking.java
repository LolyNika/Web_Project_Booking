package com.example.web_project.model;

import lombok.*;

import java.time.LocalDate;

/**
 * Class with Booking variables (booking_id; date; comment; room; guest)
 * @author LolyNika
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode

public class Booking {

    private int booking_id;
    private String date, comment;
    private Room room;
    private Guest guest;

}
