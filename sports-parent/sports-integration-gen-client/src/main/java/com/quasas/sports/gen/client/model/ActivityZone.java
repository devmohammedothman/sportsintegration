/*
 * Strava API v3
 * Strava API
 *
 * OpenAPI spec version: 3.0.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.quasas.sports.gen.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.quasas.sports.gen.client.model.TimedZoneDistribution;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * ActivityZone
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-01-20T18:02:14.787+02:00")
public class ActivityZone {
  @JsonProperty("score")
  private Integer score = null;

  @JsonProperty("distribution_buckets")
  private TimedZoneDistribution distributionBuckets = null;

  /**
   * Gets or Sets type
   */
  public enum TypeEnum {
    HEARTRATE("heartrate"),
    
    POWER("power");

    private String value;

    TypeEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static TypeEnum fromValue(String text) {
      for (TypeEnum b : TypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("type")
  private TypeEnum type = null;

  @JsonProperty("sensor_based")
  private Boolean sensorBased = null;

  @JsonProperty("points")
  private Integer points = null;

  @JsonProperty("custom_zones")
  private Boolean customZones = null;

  @JsonProperty("max")
  private Integer max = null;

  public ActivityZone score(Integer score) {
    this.score = score;
    return this;
  }

   /**
   * Get score
   * @return score
  **/
  @ApiModelProperty(value = "")
  public Integer getScore() {
    return score;
  }

  public void setScore(Integer score) {
    this.score = score;
  }

  public ActivityZone distributionBuckets(TimedZoneDistribution distributionBuckets) {
    this.distributionBuckets = distributionBuckets;
    return this;
  }

   /**
   * Get distributionBuckets
   * @return distributionBuckets
  **/
  @ApiModelProperty(value = "")
  public TimedZoneDistribution getDistributionBuckets() {
    return distributionBuckets;
  }

  public void setDistributionBuckets(TimedZoneDistribution distributionBuckets) {
    this.distributionBuckets = distributionBuckets;
  }

  public ActivityZone type(TypeEnum type) {
    this.type = type;
    return this;
  }

   /**
   * Get type
   * @return type
  **/
  @ApiModelProperty(value = "")
  public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }

  public ActivityZone sensorBased(Boolean sensorBased) {
    this.sensorBased = sensorBased;
    return this;
  }

   /**
   * Get sensorBased
   * @return sensorBased
  **/
  @ApiModelProperty(value = "")
  public Boolean isSensorBased() {
    return sensorBased;
  }

  public void setSensorBased(Boolean sensorBased) {
    this.sensorBased = sensorBased;
  }

  public ActivityZone points(Integer points) {
    this.points = points;
    return this;
  }

   /**
   * Get points
   * @return points
  **/
  @ApiModelProperty(value = "")
  public Integer getPoints() {
    return points;
  }

  public void setPoints(Integer points) {
    this.points = points;
  }

  public ActivityZone customZones(Boolean customZones) {
    this.customZones = customZones;
    return this;
  }

   /**
   * Get customZones
   * @return customZones
  **/
  @ApiModelProperty(value = "")
  public Boolean isCustomZones() {
    return customZones;
  }

  public void setCustomZones(Boolean customZones) {
    this.customZones = customZones;
  }

  public ActivityZone max(Integer max) {
    this.max = max;
    return this;
  }

   /**
   * Get max
   * @return max
  **/
  @ApiModelProperty(value = "")
  public Integer getMax() {
    return max;
  }

  public void setMax(Integer max) {
    this.max = max;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ActivityZone activityZone = (ActivityZone) o;
    return Objects.equals(this.score, activityZone.score) &&
        Objects.equals(this.distributionBuckets, activityZone.distributionBuckets) &&
        Objects.equals(this.type, activityZone.type) &&
        Objects.equals(this.sensorBased, activityZone.sensorBased) &&
        Objects.equals(this.points, activityZone.points) &&
        Objects.equals(this.customZones, activityZone.customZones) &&
        Objects.equals(this.max, activityZone.max);
  }

  @Override
  public int hashCode() {
    return Objects.hash(score, distributionBuckets, type, sensorBased, points, customZones, max);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ActivityZone {\n");
    
    sb.append("    score: ").append(toIndentedString(score)).append("\n");
    sb.append("    distributionBuckets: ").append(toIndentedString(distributionBuckets)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    sensorBased: ").append(toIndentedString(sensorBased)).append("\n");
    sb.append("    points: ").append(toIndentedString(points)).append("\n");
    sb.append("    customZones: ").append(toIndentedString(customZones)).append("\n");
    sb.append("    max: ").append(toIndentedString(max)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

