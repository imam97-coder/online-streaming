package com.test.onlinestream.service;

import com.test.onlinestream.dto.VideoSearchDTO;
import com.test.onlinestream.entity.Video;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface VideoService {

    Video saveVideo(Video video);
    Video updateVideo(Video video);
    List<Video> getAllVideo();
    Video getVideoById(String id);
    void deleteVideo (String id);
    Page<Video> getCustomerPerPage(Pageable pageable, VideoSearchDTO videoSearchDTO);
}
