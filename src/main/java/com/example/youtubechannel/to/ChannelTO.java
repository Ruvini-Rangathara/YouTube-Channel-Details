package com.example.youtubechannel.to;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ChannelTO {
    private String channelId;
    private String title;
    private String subscribers;
    private String publishedAt;
    private String customURL;
    private String country;
    private String videoCount;
    private String viewCount;
    private String description;

}
