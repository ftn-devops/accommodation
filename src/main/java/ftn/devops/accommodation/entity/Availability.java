package ftn.devops.accommodation.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "availability")
public class Availability extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "accommodationId")
    Accommodation accommodation;

    LocalDateTime startDate;
    LocalDateTime endDate;
    float price;
    boolean isPriceForPerson;
    boolean autoConfirm;
}
