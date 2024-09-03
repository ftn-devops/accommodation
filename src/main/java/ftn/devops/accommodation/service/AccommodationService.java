package ftn.devops.accommodation.service;

import ftn.devops.accommodation.dto.SearchObject;
import ftn.devops.accommodation.entity.Accommodation;
import ftn.devops.accommodation.entity.Availability;
import ftn.devops.accommodation.repository.AccommodationRepository;
import ftn.devops.accommodation.repository.AvailabilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AccommodationService {

    @Autowired
    private AccommodationRepository accommodationRepository;

    @Autowired
    private AvailabilityRepository availabilityRepository;

    public List<Accommodation> getAllAccommodations(){
        return accommodationRepository.findAll();
    }

    public void addAccommodation(Accommodation accommodation){
        accommodationRepository.save(accommodation);
    }
    public void addAvailability(Availability availability){

        availabilityRepository.save(availability);
    }
    public List<Availability> searchAccommodations(SearchObject searchObject){
        return availabilityRepository.searchAvailability(searchObject.getAddress(),searchObject.getGuestNumber(),searchObject.getStartDate(),searchObject.getEndDate());
    }
}
