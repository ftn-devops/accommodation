package ftn.devops.accommodation.dto;

import ftn.devops.accommodation.entity.AccommodationGrade;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GradeDTO {

    Integer id;
    String reviewerId;
    String reviewerUsername;
    String reviewedId;
    String reviewedName;
    int grade;
    LocalDateTime date;

    final boolean isForAccommodation = true;
    public GradeDTO(AccommodationGrade accommodationGrade){
        this.id = accommodationGrade.getId();
        this.reviewerId = accommodationGrade.getReviewer().getId().toString();
        this.reviewerUsername = accommodationGrade.getReviewer().getUsername();
        this.reviewedId = accommodationGrade.getAccommodation().getId().toString();
        this.reviewedName = accommodationGrade.getAccommodation().getName();
        this.grade = accommodationGrade.getGrade();
        this.date = accommodationGrade.getCreatedAt().toInstant().atOffset(ZoneOffset.UTC).toLocalDateTime();;
    }
}
