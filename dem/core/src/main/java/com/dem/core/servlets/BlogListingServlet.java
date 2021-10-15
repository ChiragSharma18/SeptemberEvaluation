package com.dem.core.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.servlet.Servlet;
import javax.servlet.ServletException;

import com.day.cq.search.PredicateGroup;
import com.day.cq.search.Query;
import com.day.cq.search.QueryBuilder;
import com.day.cq.search.result.Hit;
import com.day.cq.search.result.SearchResult;
import com.google.gson.Gson;
import com.dem.core.bean.BlogListingModelBean;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(service = Servlet.class, property = { "sling.servlet.methods=" + HttpConstants.METHOD_GET,
        "sling.servlet.paths=" + "/bin/listingblog" })
public class BlogListingServlet extends SlingAllMethodsServlet {

    List<BlogListingModelBean> blogList = new ArrayList<BlogListingModelBean>();

    private Session session;

    @Reference
    private QueryBuilder builder;

    @Override
    protected final void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
            throws ServletException, IOException {

           String blogpath = request.getParameter("path");

            ResourceResolver resourceResolver = request.getResourceResolver();

            //Resource resource = resourceResolver.getResource("/content/brandsite/en_gb/jcr:content/content/blog_listing_392107439");

            session = resourceResolver.adaptTo(Session.class);

            Map<String, String> predicate = new HashMap<>();

            //`String orderBy = "/conf/brandsite/settings/wcm/templates/brandsite-blog-page-template";

            predicate.put("path", blogpath);
            predicate.put("type", "cq:Page");
            predicate.put("property", "jcr:content/cq:template");
            predicate.put("property.value","/conf/dem/settings/wcm/templates/demtemplate");
            //predicate.put("orderby", "@jcr:content/content/blog_header/blogPublishDate");
            //predicate.put("orderby.sort", "desc");
            
            blogList.clear();

            Query query = builder.createQuery(PredicateGroup.create(predicate), session);

            SearchResult searchResult = query.getResult();

            for (Hit hit : searchResult.getHits()) {

                Resource resource = null;

                try {
                    resource = hit.getResource();

                    BlogListingModelBean BlogBean = new BlogListingModelBean();

                    ValueMap valuemap = resource.getChild("jcr:content").adaptTo(ValueMap.class);
                    BlogBean.setBlogtitle(valuemap.get("blogTitle", String.class));
                    BlogBean.setBlogthumbnail(valuemap.get("blogThumbnail", String.class));
                    BlogBean.setTerritoryId(valuemap.get("territoryId", String.class));
                    BlogBean.setBlogpublishdate(valuemap.get("blogPublishDate", String.class));
                    BlogBean.setBlogpath(resource.getPath());
                    blogList.add(BlogBean);

                } catch (RepositoryException e) {
                    e.printStackTrace();
                }

            }

            /*Collections.sort(blogList, new Comparator<BlogListingModelBean>() {
                @Override
                public int compare(BlogListingModelBean o1, BlogListingModelBean o2) {
                    return -1;
                }
            });*/

            

    Gson gson = new Gson();
    String json = gson.toJson(blogList);

    response.getWriter().println(json);

    }

}