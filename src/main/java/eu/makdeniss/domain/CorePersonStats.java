package eu.makdeniss.domain;

import org.springframework.data.annotation.*;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;
import javax.persistence.Id;

/**
 * Created by Deniss Makarenkov on 03/04/2017.
 * Visit http://www.makdeniss.eu/
 */
@Entity
@Table(name = "core_person_stats", schema = "public", catalog = "sport")
@Document(indexName = "corepersonstats", type = "corepersonstats")
public class CorePersonStats {
    private int id;
    private String timePlayedEvent;
    private String timePlayedTotal;
    private String timePlayedEventAverage;
    private Integer eventsPlayed;
    private Integer eventsStarted;

    @Id
    @org.springframework.data.annotation.Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "time_played_event")
    public String getTimePlayedEvent() {
        return timePlayedEvent;
    }

    public void setTimePlayedEvent(String timePlayedEvent) {
        this.timePlayedEvent = timePlayedEvent;
    }

    @Basic
    @Column(name = "time_played_total")
    public String getTimePlayedTotal() {
        return timePlayedTotal;
    }

    public void setTimePlayedTotal(String timePlayedTotal) {
        this.timePlayedTotal = timePlayedTotal;
    }

    @Basic
    @Column(name = "time_played_event_average")
    public String getTimePlayedEventAverage() {
        return timePlayedEventAverage;
    }

    public void setTimePlayedEventAverage(String timePlayedEventAverage) {
        this.timePlayedEventAverage = timePlayedEventAverage;
    }

    @Basic
    @Column(name = "events_played")
    public Integer getEventsPlayed() {
        return eventsPlayed;
    }

    public void setEventsPlayed(Integer eventsPlayed) {
        this.eventsPlayed = eventsPlayed;
    }

    @Basic
    @Column(name = "events_started")
    public Integer getEventsStarted() {
        return eventsStarted;
    }

    public void setEventsStarted(Integer eventsStarted) {
        this.eventsStarted = eventsStarted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CorePersonStats that = (CorePersonStats) o;

        if (id != that.id) return false;
        if (timePlayedEvent != null ? !timePlayedEvent.equals(that.timePlayedEvent) : that.timePlayedEvent != null)
            return false;
        if (timePlayedTotal != null ? !timePlayedTotal.equals(that.timePlayedTotal) : that.timePlayedTotal != null)
            return false;
        if (timePlayedEventAverage != null ? !timePlayedEventAverage.equals(that.timePlayedEventAverage) : that.timePlayedEventAverage != null)
            return false;
        if (eventsPlayed != null ? !eventsPlayed.equals(that.eventsPlayed) : that.eventsPlayed != null) return false;
        if (eventsStarted != null ? !eventsStarted.equals(that.eventsStarted) : that.eventsStarted != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (timePlayedEvent != null ? timePlayedEvent.hashCode() : 0);
        result = 31 * result + (timePlayedTotal != null ? timePlayedTotal.hashCode() : 0);
        result = 31 * result + (timePlayedEventAverage != null ? timePlayedEventAverage.hashCode() : 0);
        result = 31 * result + (eventsPlayed != null ? eventsPlayed.hashCode() : 0);
        result = 31 * result + (eventsStarted != null ? eventsStarted.hashCode() : 0);
        return result;
    }
}
