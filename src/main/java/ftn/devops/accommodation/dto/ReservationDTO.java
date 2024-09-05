package ftn.devops.accommodation.dto;

import ftn.devops.accommodation.entity.Accommodation;
import ftn.devops.accommodation.entity.ReservationStatus;
import ftn.devops.accommodation.entity.view.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDTO {
    Integer id;
    String userId;
    String accommodationId;
    LocalDateTime startDate;
    LocalDateTime endDate;
    float price;
    int numberOfPersons;
    ReservationStatus reservationStatus;
}
