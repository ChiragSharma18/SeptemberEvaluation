package com.dem.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class DemHighlightsModel {

    @Inject
	private List<DemHighlightsListModel> hltItems;

	public List<DemHighlightsListModel> getHltItems() {
		return new ArrayList<>(hltItems);
	}
    
}
