package ftn.devops.accommodation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NewAccommodationDTO {

    private int hostId;
    private String name;
    private String address;
    private String description;
    private int minGuestNumber;
    private int maxGuestNumber;
}
