package ftn.devops.accommodation.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import ftn.devops.accommodation.dto.AvailabilityDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "availabilities")
public class Availability extends BaseEntity {

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private Float price;

    private boolean isPriceForPerson;

    private boolean autoConfirm;

    @ManyToOne
    @JoinColumn(name = "accommodation_id", nullable = false)
    private Accommodation accommodation;

    public Availability(AvailabilityDTO availabilityDTO){
        this.startDate = availabilityDTO.getStartDate();
        this.endDate = availabilityDTO.getEndDate();
        this.isPriceForPerson = availabilityDTO.isPriceForPerson();
        this.autoConfirm = availabilityDTO.isAutoConfirm();
        this.price = availabilityDTO.getPrice();
    }
}
