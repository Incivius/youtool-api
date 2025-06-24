package com.youtool_api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "channels")
public class ChannelData {

    @Id
    private String id;

    // tive que mudar o nome dos campos pra inglês pro mapper identificar automaticamente
    private String name;
    private String description;
    private long subscribers;
    private long views;

    public String getId() { return id; }
    public String getName() { return name; }
    public long getSubscribers() { return subscribers; }
    public long getViews() { return views; }
    public String getDescription() { return description; }

    public void setId(String id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setSubscribers(long subscribers) { this.subscribers = subscribers; }
    public void setViews(long views) { this.views = views; }
    public void setDescription(String description) { this.description = description; }
}
