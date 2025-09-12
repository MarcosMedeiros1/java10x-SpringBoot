package dev.java10x.HobbitCrud.Hobbit;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HobbitRepository extends JpaRepository<HobbitModel, Long> {
}
