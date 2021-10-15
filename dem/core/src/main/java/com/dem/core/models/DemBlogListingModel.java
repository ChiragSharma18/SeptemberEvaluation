package com.dem.core.models;

import javax.inject.Inject;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;


@Model(adaptables = { Resource.class }, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class DemBlogListingModel {

    @Inject 
    private String blgPath;

    @Inject
    private String initBgCount;

    @Inject
    private String btnText;

    public String getBlgPath(){

        return blgPath;
    }

    public String getInitBgCount(){

        return initBgCount;
    }

    public String getBtnText(){

        return btnText;
    }

    
    
}