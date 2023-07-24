package com.example.youtubechannel;

import com.example.youtubechannel.to.ChannelTO;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.Channel;
import com.google.api.services.youtube.model.ChannelListResponse;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

public class ChannelDetail {
    private static ChannelTO channelTO;
    private static final String API_KEY = "AIzaSyCPMPX1SghBqDcvBFxkRd0hPkQ74ZoE_rM";

    public static ChannelTO getChannelTO(String channelId) {
        try {
            YouTube youTubeService = createYouTubeService();

            // Fetch channel details
            ChannelListResponse channelListResponse = youTubeService.channels()
                    .list("snippet,statistics")
                    .setId(channelId)
                    .setKey(API_KEY)
                    .execute();

            List<Channel> channels = channelListResponse.getItems();
            if (channels != null && !channels.isEmpty()) {
                Channel channel = channels.get(0);

                channelTO = new ChannelTO();
                channelTO.setChannelId(channelId);
                channelTO.setTitle(channel.getSnippet().getTitle());
                channelTO.setSubscribers(String.valueOf(channel.getStatistics().getSubscriberCount()));
                channelTO.setPublishedAt(String.valueOf(channel.getSnippet().getPublishedAt()));
                channelTO.setCustomURL(channel.getSnippet().getCustomUrl());
                channelTO.setCountry(channel.getSnippet().getCountry());
                channelTO.setVideoCount(String.valueOf(channel.getStatistics().getVideoCount()));
                channelTO.setViewCount(String.valueOf(channel.getStatistics().getViewCount()));
                channelTO.setDescription(channel.getSnippet().getDescription());

                return channelTO;
            }
        } catch (IOException | GeneralSecurityException e) {
            e.printStackTrace();
        }
        return null;
    }



    private static YouTube createYouTubeService() throws GeneralSecurityException, IOException {
        HttpTransport httpTransport = new NetHttpTransport();
        JsonFactory jsonFactory = JacksonFactory.getDefaultInstance(); // Use JacksonFactory
        YouTube youTubeChannelDetails = new YouTube.Builder(httpTransport, jsonFactory, null)
                .setApplicationName("YouTubeChannelDetails")
                .build();
        return youTubeChannelDetails;
    }

}
