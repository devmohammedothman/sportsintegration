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
import com.quasas.sports.gen.client.model.BaseStream;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;

/**
 * TemperatureStream
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-01-20T18:02:14.787+02:00")
public class TemperatureStream {
  @JsonProperty("original_size")
  private Integer originalSize = null;

  /**
   * The level of detail (sampling) in which this stream was returned
   */
  public enum ResolutionEnum {
    LOW("low"),
    
    MEDIUM("medium"),
    
    HIGH("high");

    private String value;

    ResolutionEnum(String value) {
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
    public static ResolutionEnum fromValue(String text) {
      for (ResolutionEnum b : ResolutionEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("resolution")
  private ResolutionEnum resolution = null;

  /**
   * The base series used in the case the stream was downsampled
   */
  public enum SeriesTypeEnum {
    DISTANCE("distance"),
    
    TIME("time");

    private String value;

    SeriesTypeEnum(String value) {
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
    public static SeriesTypeEnum fromValue(String text) {
      for (SeriesTypeEnum b : SeriesTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("series_type")
  private SeriesTypeEnum seriesType = null;

  @JsonProperty("data")
  private List<Integer> data = null;

  public TemperatureStream originalSize(Integer originalSize) {
    this.originalSize = originalSize;
    return this;
  }

   /**
   * The number of data points in this stream
   * @return originalSize
  **/
  @ApiModelProperty(value = "The number of data points in this stream")
  public Integer getOriginalSize() {
    return originalSize;
  }

  public void setOriginalSize(Integer originalSize) {
    this.originalSize = originalSize;
  }

  public TemperatureStream resolution(ResolutionEnum resolution) {
    this.resolution = resolution;
    return this;
  }

   /**
   * The level of detail (sampling) in which this stream was returned
   * @return resolution
  **/
  @ApiModelProperty(value = "The level of detail (sampling) in which this stream was returned")
  public ResolutionEnum getResolution() {
    return resolution;
  }

  public void setResolution(ResolutionEnum resolution) {
    this.resolution = resolution;
  }

  public TemperatureStream seriesType(SeriesTypeEnum seriesType) {
    this.seriesType = seriesType;
    return this;
  }

   /**
   * The base series used in the case the stream was downsampled
   * @return seriesType
  **/
  @ApiModelProperty(value = "The base series used in the case the stream was downsampled")
  public SeriesTypeEnum getSeriesType() {
    return seriesType;
  }

  public void setSeriesType(SeriesTypeEnum seriesType) {
    this.seriesType = seriesType;
  }

  public TemperatureStream data(List<Integer> data) {
    this.data = data;
    return this;
  }

  public TemperatureStream addDataItem(Integer dataItem) {
    if (this.data == null) {
      this.data = new ArrayList<Integer>();
    }
    this.data.add(dataItem);
    return this;
  }

   /**
   * The sequence of temperature values for this stream, in celsius degrees
   * @return data
  **/
  @ApiModelProperty(value = "The sequence of temperature values for this stream, in celsius degrees")
  public List<Integer> getData() {
    return data;
  }

  public void setData(List<Integer> data) {
    this.data = data;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TemperatureStream temperatureStream = (TemperatureStream) o;
    return Objects.equals(this.originalSize, temperatureStream.originalSize) &&
        Objects.equals(this.resolution, temperatureStream.resolution) &&
        Objects.equals(this.seriesType, temperatureStream.seriesType) &&
        Objects.equals(this.data, temperatureStream.data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(originalSize, resolution, seriesType, data);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TemperatureStream {\n");
    
    sb.append("    originalSize: ").append(toIndentedString(originalSize)).append("\n");
    sb.append("    resolution: ").append(toIndentedString(resolution)).append("\n");
    sb.append("    seriesType: ").append(toIndentedString(seriesType)).append("\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
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

