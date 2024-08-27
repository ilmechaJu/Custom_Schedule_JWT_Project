package com.sparta.jpa_customschedule.dto;

import com.sparta.jpa_customschedule.entity.Comments;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentsResponseDto {
    private final Long commentId;
    private final String username;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;
    private final String comments;



    public CommentsResponseDto(Comments savedComments) {
        this.commentId = savedComments.getComment_id();
        this.username = savedComments.getUsername();
        this.createdAt = savedComments.getCreatedAt();
        this.modifiedAt = savedComments.getModifiedAt();
        this.comments = savedComments.getComments();
    }
}
