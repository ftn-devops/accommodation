package ftn.devops.accommodation.controller;

import ftn.devops.accommodation.dto.SearchObject;
import ftn.devops.accommodation.entity.Accommodation;
import ftn.devops.accommodation.entity.Availability;
import ftn.devops.accommodation.service.AccommodationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
    public ResponseEntity<List<Accommodation>> addAccommodation(@RequestBody Accommodation accommodation){
        accommodationService.addAccommodation(accommodation);
        return ResponseEntity.ok().body(accommodationService.getAllAccommodations());
    }


    @PostMapping("/addAvailability")
    public ResponseEntity<List<Accommodation>> addAvailability(@RequestBody Availability availability){
        accommodationService.addAvailability(availability);
        return ResponseEntity.ok().body(accommodationService.getAllAccommodations());
    }

}
