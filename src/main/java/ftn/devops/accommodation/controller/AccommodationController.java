package ftn.devops.accommodation.controller;

import ftn.devops.accommodation.dto.AvailabilityDTO;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ftn.devops.accommodation.dto.NewAccommodationDTO;
import ftn.devops.accommodation.dto.SearchObject;
import ftn.devops.accommodation.entity.Accommodation;
import ftn.devops.accommodation.entity.Availability;
import ftn.devops.accommodation.service.AccommodationService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/acc")
@RequiredArgsConstructor
public class AccommodationController {

    @Autowired
    private AccommodationService accommodationService;

    @GetMapping("/allAccommodations")
    public ResponseEntity<List<Accommodation>> getAllAccommodations(){
        return ResponseEntity.ok().body(accommodationService.getAllAccommodations());
    }

    @PostMapping("/searchAccommodations")
    public ResponseEntity<List<Availability>> searchAccommodations(@RequestBody SearchObject searchObject){
        return ResponseEntity.ok().body(accommodationService.searchAccommodations(searchObject));
    }
    @PostMapping("/addAccommodation")
    public ResponseEntity<List<Accommodation>> addAccommodation(@RequestBody NewAccommodationDTO accommodation){
        accommodationService.addAccommodation(accommodation);
        return ResponseEntity.ok().body(accommodationService.getAllAccommodations());
    }


    @PostMapping("/addAvailability")
    public ResponseEntity<Boolean> addAvailability(@RequestBody AvailabilityDTO availability){
        boolean ret = accommodationService.addAvailability(availability);
        return ResponseEntity.ok().body(ret);
    }

}
