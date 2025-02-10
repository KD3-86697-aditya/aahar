package com.aahar.dtos;

import com.aahar.pojos.Mess;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class MessUpdateResponse {
    private Long id;
    private String messName;
    private String firstName;
    private String lastName;
    private String ownerPhone;
    private String ownerEmail;
    private String address;
    private LocationDTO location; 

    public MessUpdateResponse(Mess mess) {
        this.id = mess.getId();
        this.messName = mess.getMessName();
        this.firstName = mess.getMessOwner().getFirstName();
        this.lastName = mess.getMessOwner().getLastName();
        this.ownerPhone = mess.getMessOwner().getPhoneNumber();
        this.ownerEmail = mess.getMessOwner().getEmail();
        this.address = mess.getAddress();
        this.location = new LocationDTO(mess.getLocation()); 
    }
}
