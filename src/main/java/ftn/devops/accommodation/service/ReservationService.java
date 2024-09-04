package ftn.devops.accommodation.service;

import ftn.devops.accommodation.dto.ReservationDTO;
import ftn.devops.accommodation.entity.Accommodation;
import ftn.devops.accommodation.entity.Reservation;
import ftn.devops.accommodation.entity.ReservationStatus;
import ftn.devops.accommodation.entity.view.User;
import ftn.devops.accommodation.repository.AccommodationRepository;
import ftn.devops.accommodation.repository.ReservationRepository;
import ftn.devops.accommodation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccommodationRepository accommodationRepository;


    public boolean addReservation(ReservationDTO reservationDTO){
        try{
            Reservation reservation = new Reservation(reservationDTO);
            User user = userRepository.findById(Integer.parseInt(reservationDTO.getUserId())).get();
            Accommodation accommodation = accommodationRepository.getReferenceById(Integer.parseInt(reservationDTO.getAccommodationId()));
            reservation.setUser(user);
            reservation.setAccommodation(accommodation);
            reservation.setCreatedAt(Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC)));
            reservation.setUpdatedAt(Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC)));
            reservation.setReservationStatus(ReservationStatus.PENDING);
            reservationRepository.save(reservation);

        }catch (Exception e){

            return false;
        }
        return true;
    }

    public List<Reservation> getAllReservations(){
        return reservationRepository.findAll();
    }

    public boolean confirmReservation(Reservation reservationDTO){
        try{
            Reservation reservation = reservationRepository.getReferenceById(reservationDTO.getId());
            reservation.setReservationStatus(ReservationStatus.CONFIRMED);
            reservationRepository.save(reservation);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean cancelReservation(Reservation reservationDTO){
        try{
            Reservation reservation = reservationRepository.getReferenceById(reservationDTO.getId());
            reservation.setReservationStatus(ReservationStatus.CANCELED);
            reservationRepository.save(reservation);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
