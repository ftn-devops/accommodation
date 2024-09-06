package ftn.devops.accommodation.service;

import ftn.devops.accommodation.dto.GradeDTO;
import ftn.devops.accommodation.entity.Accommodation;
import ftn.devops.accommodation.entity.AccommodationGrade;
import ftn.devops.accommodation.entity.view.User;
import ftn.devops.accommodation.messaging.messages.AccommodationRatedMessage;
import ftn.devops.accommodation.messaging.notifier.IAccommodationNotifier;
import ftn.devops.accommodation.repository.AccommodationRepository;
import ftn.devops.accommodation.repository.GradeRepository;
import ftn.devops.accommodation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;

@Service
public class GradeService {

    @Autowired
    private GradeRepository gradeRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccommodationRepository accommodationRepository;

    @Autowired
    private IAccommodationNotifier accommodationNotifier;

    public boolean addGradeForAccommodation(GradeDTO gradeDTO) {
        try {
            AccommodationGrade accommodationGrade = new AccommodationGrade();
            accommodationGrade.setGrade(gradeDTO.getGrade());
            accommodationGrade.setCreatedAt(Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC)));
            accommodationGrade.setUpdatedAt(Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC)));

            User user = userRepository.getReferenceById(Integer.parseInt(gradeDTO.getReviewerId()));
            accommodationGrade.setReviewer(user);

            Accommodation accommodation = accommodationRepository.getReferenceById(
                Integer.parseInt(gradeDTO.getReviewedId()));
            accommodationGrade.setAccommodation(accommodation);

            gradeRepository.save(accommodationGrade);

            var message = AccommodationRatedMessage.builder()
                .accommodationName(accommodation.getName())
                .recipientEmail(user.getEmail())
                .rating(Float.valueOf(accommodationGrade.getGrade()))
                .build();
            accommodationNotifier.fireAccommodationRatedNotification(message);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<AccommodationGrade> getAllAccommodationGrade() {
        return gradeRepository.findAll();
    }

    public boolean deleteGrade(GradeDTO gradeDTO) {
        try {
            AccommodationGrade grade = gradeRepository.getReferenceById(gradeDTO.getId());
            gradeRepository.delete(grade);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
