package com.example.web_project.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Guest {

    private String nickname;
    private int guest_id;
    private String password;
    private String mail;

}

