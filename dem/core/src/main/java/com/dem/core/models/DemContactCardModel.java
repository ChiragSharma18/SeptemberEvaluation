package com.dem.core.models;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;


@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class DemContactCardModel {

    @Inject
	private List<DemContactListModel> contlist;

	public List<DemContactListModel> getContlist() {
		return new ArrayList<>(contlist);
	}
    
}