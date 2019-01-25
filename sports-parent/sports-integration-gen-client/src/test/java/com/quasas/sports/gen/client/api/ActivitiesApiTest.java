
package com.quasas.sports.gen.client.api;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.quasas.sports.gen.client.invoker.ApiClient;
import com.quasas.sports.gen.client.model.ActivityZone;
import com.quasas.sports.gen.client.model.Comment;
import com.quasas.sports.gen.client.model.DetailedActivity;
import com.quasas.sports.gen.client.model.Lap;
import com.quasas.sports.gen.client.model.SummaryActivity;
import com.quasas.sports.gen.client.model.SummaryAthlete;
import com.quasas.sports.gen.client.model.UpdatableActivity;

/**
 * API tests for ActivitiesApi
 */
public class ActivitiesApiTest {

	private ActivitiesApi api ;
	
	ApiClient apiClient ;

	/**
	 * Create an Activity
	 *
	 * Creates a manual activity for an athlete, requires activity:write scope.
	 *
	 * @throws ApiException if the Api call fails
	 */
	@SuppressWarnings("unused")
	@Ignore
	@Test
	public void createActivityTest() {
		String name = null;
		String type = null;
//        ERRORUNKNOWN startDateLocal = null;
		Integer elapsedTime = null;
		String description = null;
		Float distance = null;
		Integer trainer = null;
//        ERRORUNKNOWN photoIds = null;
		Integer commute = null;
		DetailedActivity response = api.createActivity(name, type, null, elapsedTime, description, distance, trainer,
				null, commute);

		// TODO: test validations
	}

	/**
	 * Get Activity
	 *
	 * Returns the given activity that is owned by the authenticated athlete.
	 * Requires activity:read for Everyone and Followers activities. Requires
	 * activity:read_all for Only Me activities.
	 *
	 * @throws ApiException if the Api call fails
	 */
	@Ignore
	@Test
	public void getActivityByIdTest() {
		
		apiClient = new ApiClient("authorization_code", "31769", "5088c7ea25210b9835c5797fc279edd7745ed243",
				"https://www.strava.com/oauth/token", "964db11814b0f245384299f02057f56998ac790b");
		
		api = new ActivitiesApi(apiClient);
		
		Long id = Long.valueOf(2084377508);
		Boolean includeAllEfforts = null;
		DetailedActivity response = api.getActivityById(id, includeAllEfforts);
		
		assertNotNull(response);
		assertEquals(response.getId(), id);

	}

	/**
	 * List Activity Comments
	 *
	 * Returns the comments on the given activity. Requires activity:read for
	 * Everyone and Followers activities. Requires activity:read_all for Only Me
	 * activities.
	 *
	 * @throws ApiException if the Api call fails
	 */
	@SuppressWarnings("unused")
	@Ignore
	@Test
	public void getCommentsByActivityIdTest() {
		Long id = null;
		Integer page = null;
		Integer perPage = null;
		List<Comment> response = api.getCommentsByActivityId(id, page, perPage);

		// TODO: test validations
	}

	/**
	 * List Activity Kudoers
	 *
	 * Returns the athletes who kudoed an activity identified by an identifier.
	 * Requires activity:read for Everyone and Followers activities. Requires
	 * activity:read_all for Only Me activities.
	 *
	 * @throws ApiException if the Api call fails
	 */
	@SuppressWarnings("unused")
	@Ignore
	@Test
	public void getKudoersByActivityIdTest() {
		Integer id = null;
		Integer page = null;
		Integer perPage = null;
		List<SummaryAthlete> response = api.getKudoersByActivityId(id, page, perPage);

		// TODO: test validations
	}

	/**
	 * List Activity Laps
	 *
	 * Returns the laps of an activity identified by an identifier. Requires
	 * activity:read for Everyone and Followers activities. Requires
	 * activity:read_all for Only Me activities.
	 *
	 * @throws ApiException if the Api call fails
	 */
	@SuppressWarnings("unused")
	@Ignore
	@Test
	public void getLapsByActivityIdTest() {
		Long id = null;
		List<Lap> response = api.getLapsByActivityId(id);

		// TODO: test validations
	}

	/**
	 * List Athlete Activities
	 *
	 * Returns the activities of an athlete for a specific identifier. Requires
	 * activity:read. Only Me activities will be filtered out unless requested by a
	 * token with activity:read_all.
	 *
	 * @throws ApiException if the Api call fails
	 */
	@Ignore
	@Test
	public void getLoggedInAthleteActivitiesTest() {
		
		apiClient = new ApiClient("authorization_code", "31769", "5088c7ea25210b9835c5797fc279edd7745ed243",
				"https://www.strava.com/oauth/token", "964db11814b0f245384299f02057f56998ac790b");
		
		api = new ActivitiesApi(apiClient);
		
		Integer before = null;
		Integer after = null;
		Integer page = null;
		Integer perPage = null;
		List<SummaryActivity> response = api.getLoggedInAthleteActivities(before, after, page, perPage);

		assertNotNull(response);
		
		assertTrue(response.size() > 0);
		
	}

	/**
	 * Get Activity Zones
	 *
	 * Summit Feature. Returns the zones of a given activity. Requires activity:read
	 * for Everyone and Followers activities. Requires activity:read_all for Only Me
	 * activities.
	 *
	 * @throws ApiException if the Api call fails
	 */
	@SuppressWarnings("unused")
	@Ignore
	@Test
	public void getZonesByActivityIdTest() {
		Integer id = null;
		List<ActivityZone> response = api.getZonesByActivityId(id);

		// TODO: test validations
	}

	/**
	 * Update Activity
	 *
	 * Updates the given activity that is owned by the authenticated athlete.
	 * Requires activity:write. Also requires activity:read_all in order to update
	 * Only Me activities
	 *
	 * @throws ApiException if the Api call fails
	 */
	@SuppressWarnings("unused")
	@Ignore
	@Test
	public void updateActivityByIdTest() {
		Long id = null;
		UpdatableActivity body = null;
		DetailedActivity response = api.updateActivityById(id, body);

		// TODO: test validations
	}

}
