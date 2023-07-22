package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@Table(name = "Train")
@Validated
@ToString(onlyExplicitlyIncluded = true)
public class Train implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @ToString.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "train_id")
    @JsonProperty("train_id")
    private Integer trainId;

    @ToString.Include
    @Column(name = "train_name")
    @JsonProperty("train_name")
    private String trainName;

    @ToString.Include
    @ManyToOne
    @JoinColumn(name = "source_station", referencedColumnName = "station_id")
    @JsonProperty("source_station")
    private Station sourceStation;

    @ToString.Include
    @ManyToOne
    @JoinColumn(name = "destination_station", referencedColumnName = "station_id")
    @JsonProperty("destination_station")
    private Station destinationStation;

    @ToString.Include
    @Column(name = "travel_date")
    @JsonProperty("travel_date")
    private LocalDate travelDate;

    @ToString.Include
    @Column(name = "departure_time")
    @JsonProperty("departure_time")
    private String departureTime;

    @Column(name = "created_by")
    @JsonProperty("created_by")
    private final String createdBy = "SYSTEM";

    @Column(name = "date_created")
    @JsonProperty("date_created")
    private LocalDate dateCreated;

    @Column(name = "date_updated")
    @JsonProperty("date_updated")
    private LocalDate dateUpdated;

    @ToString.Include
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "train_id", referencedColumnName = "train_id")
    @JsonProperty("train_classes")
    private List<TrainClass> trainClasses = new ArrayList<>();

    @ToString.Include
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "train_id", referencedColumnName = "train_id")
    @JsonProperty("train_seats")
    private List<TrainSeat> trainSeats = new ArrayList<>();
}
