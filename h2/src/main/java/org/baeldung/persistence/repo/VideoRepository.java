package org.baeldung.persistence.repo;

import java.util.List;

import org.baeldung.persistence.model.Video;
import org.springframework.data.repository.CrudRepository;

public interface VideoRepository extends CrudRepository<Video, Long> {
	
    List<Video> findByTitle(String title);
}