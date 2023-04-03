package com.test.onlinestream.service.Impl;

import com.test.onlinestream.dto.VideoSearchDTO;
import com.test.onlinestream.entity.Video;
import com.test.onlinestream.repository.VideoRepository;
import com.test.onlinestream.service.VideoService;
import com.test.onlinestream.spesification.VideoSpecification;
import com.test.onlinestream.utils.constant.ApiMessageResponse;
import com.test.onlinestream.utils.exception.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VideoServiceImpl implements VideoService {

    VideoRepository videoRepository;

    @Autowired
    public VideoServiceImpl(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    @Override
    public Video saveVideo(Video video) {
        return videoRepository.save(video);
    }

    @Override
    public Video updateVideo(Video video) {
        if (videoRepository.findById(video.getId()).isPresent()) {
            return saveVideo(video);
        } else {
            throw new DataNotFoundException(String.format(ApiMessageResponse.MESSAGE_VIDEO_NOT_FOUND, video.getId()));
        }
    }

    @Override
    public List<Video> getAllVideo() {
        return videoRepository.findAll();
    }

    @Override
    public Video getVideoById(String id) {
        return videoRepository.findById(id).get();
    }

    @Override
    public void deleteVideo(String id) {
        videoRepository.deleteById(id);

    }

    @Override
    public Page<Video> getCustomerPerPage(Pageable pageable, VideoSearchDTO videoSearchDTO) {
        Specification<Video> videoSpecification = VideoSpecification.getSpecification(videoSearchDTO);
        return videoRepository.findAll(videoSpecification, pageable);
    }
}