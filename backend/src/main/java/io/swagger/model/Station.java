package io.swagger.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Validated
@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
@Table(name="Station")
public class Station implements Serializable{
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @EqualsAndHashCode.Include
  @ToString.Include
  @JsonProperty("station_id")
  @Column(name="station_id")
  private Integer stationId;

  @ToString.Include
  @JsonProperty("station_name")
  @Column(name="station_name",nullable = false)
  private String stationName;

  @Column(name="created_by",nullable = false)
  @JsonIgnore
  private String createdBy;

  @Column(name="date_created",nullable = false)
  @JsonIgnore
  private Date dateCreated;

  @Column(name="date_updated",nullable = false)
  @JsonIgnore
  private Date dateUpdated;

  @PrePersist
  protected void onCreate() {
    dateCreated = new Date();
    dateUpdated = new Date();
  }

  @PreUpdate
  protected void onUpdate() {
    dateUpdated = new Date();
  }
}
