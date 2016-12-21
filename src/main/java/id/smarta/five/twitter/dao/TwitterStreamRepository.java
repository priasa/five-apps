package id.smarta.five.twitter.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import id.smarta.five.twitter.entity.TwitterStream;

/**
 * 
 * @author X230
 *
 */
@Repository
public interface TwitterStreamRepository extends JpaRepository<TwitterStream, String> {

	@Query("SELECT g FROM TwitterStream g WHERE g.code LIKE ?1")
	public Page<TwitterStream> findByLikeCode(String code, Pageable page);

	@Query("SELECT g FROM TwitterStream g WHERE g.code = ?1")
	public TwitterStream findByCode(String token);
}
