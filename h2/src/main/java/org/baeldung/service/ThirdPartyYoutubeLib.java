package org.baeldung.service;

import java.util.HashMap;

import org.baeldung.persistence.model.Video;

public interface ThirdPartyYoutubeLib {
    public HashMap<String, Video> popularVideos();

    public Video getVideo(String videoId);
}