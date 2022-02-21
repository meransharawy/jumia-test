package com.jumia.test.app.db.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class DbCustomer {

    private Integer id;
    private String name;
    private String phone;
}
