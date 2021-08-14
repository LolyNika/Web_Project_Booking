package com.example.web_project.model;

import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int booking_id, full_price;
    private String date, comment, arrival_date, departure_date;
    private Room room;
    private Guest guest;
}
