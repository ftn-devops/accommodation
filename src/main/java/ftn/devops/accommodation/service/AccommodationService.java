package ftn.devops.accommodation.service;

import ftn.devops.accommodation.dto.AvailabilityDTO;
import ftn.devops.accommodation.dto.NewAccommodationDTO;
import ftn.devops.accommodation.dto.SearchObject;
import ftn.devops.accommodation.entity.Accommodation;
import ftn.devops.accommodation.entity.Availability;
import ftn.devops.accommodation.entity.view.User;
import ftn.devops.accommodation.repository.AccommodationRepository;
import ftn.devops.accommodation.repository.AvailabilityRepository;
import ftn.devops.accommodation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;

@Service
public class AccommodationService {

    @Autowired
    private AccommodationRepository accommodationRepository;

    @Autowired
    private AvailabilityRepository availabilityRepository;

    @Autowired
    private UserRepository userRepository;
    public List<Accommodation> getAllAccommodations(){
        return accommodationRepository.findAll();
    }

    public void addAccommodation(NewAccommodationDTO accommodationDTO){
        Accommodation accommodation = new Accommodation(accommodationDTO);
        User user =  userRepository.findById(accommodationDTO.getHostId()).get();
        accommodation.setHost(user);
        accommodation.setCreatedAt(Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC)));
        accommodation.setUpdatedAt(Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC)));
        accommodationRepository.save(accommodation);
    }
    public boolean addAvailability(AvailabilityDTO availabilityDTO){
        try{
            Availability availability = new Availability(availabilityDTO);
            Accommodation accommodation = accommodationRepository.getReferenceById(Integer.parseInt(availabilityDTO.getAccommodationId()));
            availability.setAccommodation(accommodation);
            availability.setCreatedAt(Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC)));
            availability.setUpdatedAt(Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC)));
            availabilityRepository.save(availability);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    public List<Availability> searchAccommodations(SearchObject searchObject){
        return availabilityRepository.searchAvailability(searchObject.getAddress(),searchObject.getGuestNumber(),searchObject.getStartDate(),searchObject.getEndDate());
    }
}
