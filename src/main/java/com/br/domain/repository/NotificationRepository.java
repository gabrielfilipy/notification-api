package com.br.domain.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.br.domain.model.Notification;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, UUID>{

}
