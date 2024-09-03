package ftn.devops.accommodation.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "accommodation")
public class Accommodation extends BaseEntity {

    private String name;

    private String hostId;

    private String address;

    private String description;

    private int minGuestNumber;

    private int maxGuestNumber;

    private Float avgRate;

    private List<String> images;

    @JsonIgnore
    @OneToMany(mappedBy = "accommodation",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Availability> availabilities;

    private List<String> rates;

}
