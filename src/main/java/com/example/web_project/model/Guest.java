package com.example.web_project.model;

import lombok.*;

/**
 * Class with Guest variables (nickname; guest_id; password; email)
 * @author LolyNika
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode

public class Guest {

    private int guest_id;
    private String nickname, password, mail;

}

