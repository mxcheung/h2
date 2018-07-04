package org.baeldung.service;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.baeldung.persistence.model.Video;
import org.baeldung.persistence.repo.VideoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class YoutubeCacheProxy implements ThirdPartyYoutubeLib {
    private ThirdPartyYoutubeLib youtubeService;
    private HashMap<String, Video> cachePopular = new HashMap<String, Video>();
    private HashMap<String, Video> cacheAll = new HashMap<String, Video>();

	private static final Logger LOG = LoggerFactory.getLogger(YoutubeCacheProxy.class);

	@Autowired
	private VideoRepository videoRepository;
	
    public YoutubeCacheProxy() {
        this.youtubeService = new ThirdPartyYoutubeClass();
    }

    @Override
    public HashMap<String, Video> popularVideos() {
        if (cachePopular.isEmpty()) {
            cachePopular = youtubeService.popularVideos();
            videoRepository.saveAll(cachePopular.values());
        } else {
        	LOG.info("Retrieved list from cache");
        }
        return cachePopular;
    }

    @Override
    public Video getVideo(String videoId) {
//        Video video = cacheAll.get(videoId);
        Video video = videoRepository.findByVideoId(videoId);
        if (video == null) {
            video = youtubeService.getVideo(videoId);
            videoRepository.save(video);
            cacheAll.put(videoId, video);
        } else {
        	LOG.info("Retrieved video '" + videoId + "' from cache.");
        }
        return video;
    }

    @Override
    public Video addVideo(Video video) {
   		return videoRepository.save(video);
    }

    
    @Override
    public Video getLatestVideo(long id) {
   		return videoRepository.findFirstByIdLessThanOrderByIdDesc(id);
    }

    
    public void reset() {
        cachePopular.clear();
        cacheAll.clear();
    }
}