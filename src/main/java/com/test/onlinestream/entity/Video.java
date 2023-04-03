package com.test.onlinestream.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "mst_video")
@NoArgsConstructor
@Getter
@Setter
public class Video {
    @Id
    @Column(name = "video_id")
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    @Column
    private String title;
    @Column
    private  String description;
    @Column
    private  String duration;
}
