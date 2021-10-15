package com.dem.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import javax.inject.Inject;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;

@Model(adaptables = Resource.class ,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class DemBlogHeaderModel {

    @Inject
    private String bgImage;

    @Inject
    private String bgDesc;

    @Inject
    private String pghead;

    public String getBgImage() {
        return bgImage;
    }

    public String getPghead() {
        return pghead;
    }

    public String getBgDesc() {
        return bgDesc;
    }

}