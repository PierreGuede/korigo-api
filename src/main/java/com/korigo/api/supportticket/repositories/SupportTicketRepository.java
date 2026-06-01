package com.korigo.api.supportticket.repositories;

import com.korigo.api.supportticket.entities.SupportTicket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SupportTicketRepository extends JpaRepository<SupportTicket, UUID> {
}
