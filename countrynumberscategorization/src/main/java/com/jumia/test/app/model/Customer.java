package com.jumia.test.app.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@EqualsAndHashCode
public class Customer {

    private String customerName;
    private String phoneNumber;
    private String countryName;
    private String countryCode;
    private Boolean state;
}
