package com.dem.core.bean;

import java.util.Arrays;
import java.util.Date;

import org.apache.sling.api.resource.Resource;

public class BlogListingModelBean {

    private String blogpath;

    private String blogtitle;

    private String blogpublishdate;

    private String blogthumbnail;
    
    private String territoryId;

    public void setBlogpath(String blogpath){
        this.blogpath=blogpath;
    }

    public void setBlogtitle(String blogtitle){
        this.blogtitle=blogtitle;
    }

    public void setBlogpublishdate(String blogpublishdate){
        this.blogpublishdate=blogpublishdate;
    }

    public void setBlogthumbnail(String blogthumbnail){
        this.blogthumbnail=blogthumbnail;
    }

    public void setTerritoryId(String territoryId){
        this.territoryId=territoryId;
    }

    public String getBlogpath(){
        return blogpath;
    }

    public String getBlogtitle(){
        return blogtitle;
    }

    public String getBlogpublishdate(){
        return blogpublishdate;
    }

    public String getBlogthumbnail(){
        return blogthumbnail;
    }

    public String getTerritoryId(){
        return territoryId;
    }

    /*@Override
    public int compareTo(BlogListingModelBean o) {
        // TODO Auto-generated method stub
        return 0;
    } */
    
}
