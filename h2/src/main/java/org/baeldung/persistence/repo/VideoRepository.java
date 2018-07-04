package org.baeldung.persistence.repo;

import java.util.List;

import org.baeldung.persistence.model.Video;
import org.springframework.data.repository.CrudRepository;

public interface VideoRepository extends CrudRepository<Video, Long> {

    Video findByVideoId(String videoId);

    List<Video> findByTitle(String title);
    
	Video findFirstByIdLessThanOrderByIdDesc(long id);

    
}