package com.aahar.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MessDTO {
	private String messName;
    private String address;
    private Long locationId;
    private String description;
    private String contactNumber;
    private String openingHours;
    private Long messOwnerId;
}
