package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@Table(name = "Train")
@Validated
public class Train {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "train_id")
    @JsonProperty("train_id")
    private Integer trainId;

    @Column(name = "train_name")
    @JsonProperty("train_name")
    private String trainName;

    @Column(name = "source_station")
    @JsonProperty("source_station")
    private String sourceStation;

    @Column(name = "destination_station")
    @JsonProperty("destination_station")
    private String destinationStation;

    @Column(name = "travel_date")
    @JsonProperty("travel_date")
    private LocalDate travelDate;

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

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "train_id", referencedColumnName = "train_id")
    @JsonProperty("train_classes")
    private List<TrainClass> trainClasses = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "train_id", referencedColumnName = "train_id")
    @JsonProperty("train_seats")
    private List<TrainSeat> trainSeats = new ArrayList<>();
}
