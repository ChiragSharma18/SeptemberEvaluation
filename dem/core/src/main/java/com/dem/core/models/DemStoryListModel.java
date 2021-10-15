package com.dem.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = { Resource.class }, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class DemStoryListModel {

    @ValueMapValue
	private String stHeading;

	@ValueMapValue
	private String stDescription;

	@ValueMapValue
	private String stHead;

	public String getStHeading() {
		return stHeading;
	}

	public String getStDescription() {
		return stDescription;
	}

	public String getStHead() {
		return stHead;
	}
    
}