package ftn.devops.accommodation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AvailabilityDTO {

    String accommodationId;
    LocalDateTime startDate;
    LocalDateTime endDate;
    boolean isPriceForPerson;
    boolean autoConfirm;
    int guestNumber;
    float  price;
}
