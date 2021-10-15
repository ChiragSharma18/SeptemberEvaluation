package com.dem.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = { Resource.class }, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class DemHighlightsListModel {

    @ValueMapValue
	private String hltHead;

	@ValueMapValue
	private String hltDesc;

	public String getHltHead() {
		return hltHead;
	}

	public String getHltDesc() {
		return hltDesc;
	}

}