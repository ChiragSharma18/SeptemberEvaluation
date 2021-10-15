package com.dem.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = { Resource.class }, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class DemContactListModel {

    @ValueMapValue
	private String contname;

	@ValueMapValue
	private String contemail;

	@ValueMapValue
	private String contdesignation;

    @ValueMapValue
	private String contimage;

    @ValueMapValue
	private String conthead;


	public String getContname() {
		return contname;
	}

	public String getContemail() {
		return contemail;
	}

    public String getContdesignation() {
		return contdesignation;
	}

    public String getContimage() {
		return contimage;
	}

	public String getConthead() {
		return conthead;
	}
    
}