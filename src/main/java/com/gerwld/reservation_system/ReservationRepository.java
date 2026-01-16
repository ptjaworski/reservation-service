package com.gerwld.reservation_system;

import org.springframework.data.jpa.repository.JpaRepository;
// Jpa repository - интерфейс из data jpa, дает много методов для взаимодействия с БД
//                                                          <Дженерик тип данных, Тип ID>
public interface ReservationRepository extends JpaRepository<ReservationEntity, Long> {

}