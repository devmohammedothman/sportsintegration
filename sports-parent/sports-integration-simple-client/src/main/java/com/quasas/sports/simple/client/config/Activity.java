package com.quasas.sports.simple.client.config;

import java.io.Serializable;
import java.time.LocalDateTime;


public class Activity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5835794055008449952L;

	private Long identifierKey;


	private Long sourceId;


	private String externalId;


	private Long uploadId;


	private int athlete;


	private String name;


	private Float distance;


	private Integer movingTime;


	private Integer elapsedTime;


	private Float totalElevationGain;


	private String type;


	private Integer workoutType;


	private LocalDateTime startDate;


	private String startDateLocal;


	private String timezone;


	private Integer achievementCount;


	private Integer commentCount;


	private Integer athleteCount;


	private Integer photoCount;


	private Boolean trainer;


	private Boolean commute;


	private Boolean manual;


	private Boolean _private;


	private Boolean visibility;

	public Long getIdentifierKey() {
		return identifierKey;
	}

	public void setIdentifierKey(Long id) {
		this.identifierKey = id;
	}

	public Long getSourceId() {
		return sourceId;
	}

	public void setSourceId(Long sourceId) {
		this.sourceId = sourceId;
	}

	public String getExternalId() {
		return externalId;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

	public Long getUploadId() {
		return uploadId;
	}

	public void setUploadId(Long uploadId) {
		this.uploadId = uploadId;
	}

	public int getAthlete() {
		return athlete;
	}

	public void setAthlete(int athlete) {
		this.athlete = athlete;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getDistance() {
		return distance;
	}

	public void setDistance(Float distance) {
		this.distance = distance;
	}

	public Integer getMovingTime() {
		return movingTime;
	}

	public void setMovingTime(Integer movingTime) {
		this.movingTime = movingTime;
	}

	public Integer getElapsedTime() {
		return elapsedTime;
	}

	public void setElapsedTime(Integer elapsedTime) {
		this.elapsedTime = elapsedTime;
	}

	public Float getTotalElevationGain() {
		return totalElevationGain;
	}

	public void setTotalElevationGain(Float totalElevationGain) {
		this.totalElevationGain = totalElevationGain;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getWorkoutType() {
		return workoutType;
	}

	public void setWorkoutType(Integer workoutType) {
		this.workoutType = workoutType;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public String getStartDateLocal() {
		return startDateLocal;
	}

	public void setStartDateLocal(String startDateLocal) {
		this.startDateLocal = startDateLocal;
	}

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public Integer getAchievementCount() {
		return achievementCount;
	}

	public void setAchievementCount(Integer achievementCount) {
		this.achievementCount = achievementCount;
	}

	public Integer getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
	}

	public Integer getAthleteCount() {
		return athleteCount;
	}

	public void setAthleteCount(Integer athleteCount) {
		this.athleteCount = athleteCount;
	}

	public Integer getPhotoCount() {
		return photoCount;
	}

	public void setPhotoCount(Integer photoCount) {
		this.photoCount = photoCount;
	}

	public Boolean getTrainer() {
		return trainer;
	}

	public void setTrainer(Boolean trainer) {
		this.trainer = trainer;
	}

	public Boolean getCommute() {
		return commute;
	}

	public void setCommute(Boolean commute) {
		this.commute = commute;
	}

	public Boolean getManual() {
		return manual;
	}

	public void setManual(Boolean manual) {
		this.manual = manual;
	}

	public Boolean get_private() {
		return _private;
	}

	public void set_private(Boolean _private) {
		this._private = _private;
	}

	public Boolean getVisibility() {
		return visibility;
	}

	public void setVisibility(Boolean visibility) {
		this.visibility = visibility;
	}

	@Override
	public String toString() {
		return "Activity [id=" + identifierKey + ", sourceId=" + sourceId + ", name=" + name + ", startDate=" + startDate
				+ ", trainer=" + trainer + ", commute=" + commute + ", manual=" + manual + ", _private=" + _private
				+ ", visibility=" + visibility + "]";
	}

}
