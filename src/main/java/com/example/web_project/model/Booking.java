package com.example.web_project.model;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode

public class Booking {

    private int booking_id;
    private String date;
    private String comment;
    private Room room;
    private Guest guest;

}
