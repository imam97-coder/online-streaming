package com.test.onlinestream.controller;

import com.test.onlinestream.dto.VideoSearchDTO;
import com.test.onlinestream.entity.Video;
import com.test.onlinestream.service.VideoService;
import com.test.onlinestream.utils.constant.ApiUrlConstant;
import com.test.onlinestream.utils.customresponse.PageResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(ApiUrlConstant.VIDEO_PATH)
public class VideoController {

    VideoService videoService;

    @Autowired
    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }

    @PostMapping
    public Video saveVideo(@RequestBody Video video) {
        return videoService.saveVideo(video);
    }

    @GetMapping("/{id}")
    public Video getVideoById(@PathVariable String id) {
        return videoService.getVideoById(id);
    }

    @PutMapping
    public Video updateVideo(@RequestBody Video video) {

        return videoService.updateVideo(video);
    }

    @GetMapping("search/")
    public PageResponseWrapper<Video> getVideos(@RequestParam(name = "page", defaultValue = "0") int page,
                                                   @RequestParam(name = "size", defaultValue = "5") int size,
                                                   @RequestParam(name = "name", defaultValue = "") String videoName,
                                                   @RequestParam(name = "title", defaultValue = "") String title,
                                                   @RequestParam(name = "duration", defaultValue = "") String duration) {

        VideoSearchDTO videoSearchDTO = new VideoSearchDTO();
        videoSearchDTO.setVideoName(videoName);
        videoSearchDTO.setTitle(title);

        Pageable pageable = PageRequest.of(page, size);
        Page<Video> videosPage = videoService.getCustomerPerPage(pageable, videoSearchDTO);
        return new PageResponseWrapper<Video>(videosPage);
    }
    @DeleteMapping("/{id}")
    public void deleteVideo(@PathVariable String id) {
        videoService.deleteVideo(id);
    }

    @GetMapping
    public List<Video> getVideo() {
        return videoService.getAllVideo();
    }
}