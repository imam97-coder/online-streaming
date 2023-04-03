package com.test.onlinestream.spesification;

import com.test.onlinestream.dto.VideoSearchDTO;
import com.test.onlinestream.entity.Video;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class VideoSpecification {
    public static Specification<Video> getSpecification(VideoSearchDTO videoSearchDTO) {

        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if(videoSearchDTO.getVideoName() != null){

                Predicate fullNamePredicates = criteriaBuilder.like(
                        criteriaBuilder.lower(root.get("customerName")),
                        "%" + videoSearchDTO.getVideoName().toLowerCase() + "%");
                predicates.add(fullNamePredicates);
            }

            if(videoSearchDTO.getDuration() != null){

                Predicate addressPredicates = criteriaBuilder.like(
                        criteriaBuilder.lower(root.get("customerAddress")),
                        "%" + videoSearchDTO.getDuration().toString() + "%");
                predicates.add(addressPredicates);
            }
            if(videoSearchDTO.getTitle() != null){

                Predicate titlePredicates = criteriaBuilder.equal(root.get("birthDate"),
                        videoSearchDTO.getTitle());
                predicates.add(titlePredicates);
            }

            Predicate[] arrayPredicates = predicates.toArray(new Predicate[predicates.size()]);
            return criteriaBuilder.and(arrayPredicates);
        };
    }
}
