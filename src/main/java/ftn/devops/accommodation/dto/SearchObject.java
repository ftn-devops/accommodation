package ftn.devops.accommodation.dto;

import lombok.*;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SearchObject {
    String address;
    LocalDateTime startDate;
    LocalDateTime endDate;
    int guestNumber;
}
