package com.quasas.sports.boot.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity Class that represnt Activity Table in Database
 * Table Has it own identifier key which is different that Source identifier of Client API
 * @author <a href="mailto:dev.mohammed.othman@gmail.com">Mohammed Othman</a>
 *
 */

@Entity
@Table(name = "detailed_activity")
public class Activity implements Serializable {

	/**
	 * Generated Serial ID
	 */
	private static final long serialVersionUID = -5835794055008449952L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long identifierKey;

	@Column(name = "source_id")
	private Long sourceId;

	@Column(name = "external_id")
	private String externalId;

	@Column(name = "upload_id")
	private Long uploadId;

	@Column(name = "athlete_id")
	private int athlete;

	@Column(name = "name")
	private String name;

	@Column(name = "distance")
	private Float distance;

	@Column(name = "moving_time")
	private Integer movingTime;

	@Column(name = "elapsed_time")
	private Integer elapsedTime;

	@Column(name = "total_elevation_gain")
	private Float totalElevationGain;

	@Column(name = "type")
	private String type;

	@Column(name = "workout_type")
	private Integer workoutType;

	@Column(name = "start_date")
	private LocalDateTime startDate;

	@Column(name = "start_date_local")
	private String startDateLocal;

	@Column(name = "timezone")
	private String timezone;

	@Column(name = "achievement_count")
	private Integer achievementCount;

	@Column(name = "comment_count")
	private Integer commentCount;

	@Column(name = "athlete_count")
	private Integer athleteCount;

	@Column(name = "photo_count")
	private Integer photoCount;

	@Column(name = "trainer")
	private Boolean trainer;

	@Column(name = "commute")
	private Boolean commute;

	@Column(name = "manual")
	private Boolean manual;

	@Column(name = "private")
	private Boolean _private;

	@Column(name = "visibility")
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
