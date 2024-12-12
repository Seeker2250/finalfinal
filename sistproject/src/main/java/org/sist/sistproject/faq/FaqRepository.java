package org.sist.sistproject.faq;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FaqRepository extends JpaRepository<Faq, Long> {
	Page<Faq> findAll(Pageable pageable);
	
	@Modifying
    @Query("UPDATE Faq f SET f.viewCount = f.viewCount + 1 WHERE f.id = :id")
    void updateViewCount(@Param("id") Long id);
}	