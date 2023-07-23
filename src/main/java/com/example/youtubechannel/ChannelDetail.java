package com.example.youtubechannel;

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
    private static final String API_KEY = "AIzaSyCPMPX1SghBqDcvBFxkRd0hPkQ74ZoE_rM";

    public static void printDetails() {
        try {
            YouTube youTubeService = createYouTubeService();
            String channelId = "UCn0XmAUFv6d2tofMFEesSNw"; // Replace with the desired YouTube channel ID

            // Fetch channel details
            ChannelListResponse channelListResponse = youTubeService.channels()
                    .list("snippet,statistics")
                    .setId(channelId)
                    .setKey(API_KEY)
                    .execute();

            List<Channel> channels = channelListResponse.getItems();
            if (channels != null && !channels.isEmpty()) {
                Channel channel = channels.get(0);
                System.out.println("Channel Title: " + channel.getSnippet().getTitle());
                System.out.println("Channel Description: " + channel.getSnippet().getDescription());
                System.out.println("Channel Subscribers: " + channel.getStatistics().getSubscriberCount());
                // You can access other channel details in a similar manner
            } else {
                System.out.println("Channel not found!");
            }
        } catch (IOException | GeneralSecurityException e) {
            e.printStackTrace();
        }
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
