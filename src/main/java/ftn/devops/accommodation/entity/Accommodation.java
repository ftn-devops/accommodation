package ftn.devops.accommodation.entity;

import ftn.devops.accommodation.entity.view.User;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;
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
@Table(name = "accommodations")
public class Accommodation extends BaseEntity {

    private String name;

    private String address;

    private String description;

    private Integer minGuestNumber;

    private Integer maxGuestNumber;

    private Float averageGrade;

    @ManyToOne
    @JoinColumn(name = "host_id", nullable = false)
    private User host;

    @OneToMany(mappedBy = "accommodation", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private Set<Image> images = new HashSet<>();

    @OneToMany(mappedBy = "accommodation", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private Set<AccommodationGrade> grades = new HashSet<>();

    @OneToMany(mappedBy = "accommodation", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private Set<Availability> availabilities = new HashSet<>();
}
