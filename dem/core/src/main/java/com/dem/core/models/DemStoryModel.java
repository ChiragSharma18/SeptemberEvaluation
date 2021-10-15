package com.dem.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class DemStoryModel {

    @Inject
	private List<DemStoryListModel> stList;

	public List<DemStoryListModel> getStList() {
		return new ArrayList<>(stList);
	}
    
}