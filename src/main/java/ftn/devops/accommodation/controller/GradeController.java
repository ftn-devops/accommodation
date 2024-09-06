package ftn.devops.accommodation.controller;

import ftn.devops.accommodation.dto.GradeDTO;
import ftn.devops.accommodation.entity.AccommodationGrade;
import ftn.devops.accommodation.service.GradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/grades")
@RequiredArgsConstructor
public class GradeController {

    @Autowired
    private GradeService gradeService;


    @GetMapping("/allAccommodationGrades")
    public ResponseEntity<List<GradeDTO>> getAllAccommodationGrades(){

        List<AccommodationGrade> allGrades = gradeService.getAllAccommodationGrade();
        List<GradeDTO> retVal = new ArrayList<>();
        for(AccommodationGrade grade : allGrades){
            retVal.add(new GradeDTO(grade));
        }
        return ResponseEntity.ok().body(retVal);
    }

    @PostMapping("/addAccommodationGrade")
    public ResponseEntity<Boolean> addGrade(@RequestBody GradeDTO gradeDTO){
        boolean ret = gradeService.addGradeForAccommodation(gradeDTO);
        return ResponseEntity.ok().body(ret);
    }


    @PostMapping("/deleteAccommodationGrade")
    public ResponseEntity<Boolean> deleteGrade(@RequestBody GradeDTO gradeDTO){
        boolean ret = gradeService.deleteGrade(gradeDTO);
        return ResponseEntity.ok().body(ret);
    }
}
