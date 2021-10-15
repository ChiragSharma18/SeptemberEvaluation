

$(document).ready(function () {


    var flag, counter = 0, path, response, i, j, structure1, obj, blogCount, component;

    path = $("div").find("#blgListing").attr("blog-path");
    blogCount = $("div").find("#blgListing").attr("blog-count");
    component = $("div").find("#blgListing");

    if (component) {
        if (path && blogCount) {
            response = $.ajax({
                type: 'GET',
                url: '/bin/bloglisting' + '?path=' + path,
                async: false

            });
        }


    }
    obj = JSON.parse(response.responseText);

    if (blogCount >= obj.length) {
        for (i = 0; i < obj.length; i++) {
            structure1 = "<li><a href=" + obj[i].blogpath + ".html><div class=blog-list-content><div class=blog-list-image><figure style = background-image:url(" + obj[i].blogthumbnail + ")></figure></div><div class=blog-list-text><spam>" + obj[i].territoryId + "</spam><h3>" + obj[i].blogtitle + "</h3><p>" + obj[i].blogpublishdate + "</p></div></div></a></li>";
            $("div").find("#blgListing").find("ul").append(structure1); 
        }

        $(".see-more-blogs").hide();
    }

    else {

        for (i = 0; i < blogCount; i++) {
            structure1 = "<li><a href=" + obj[i].blogpath + ".html><div class=blog-list-content><div class=blog-list-image><figure style = background-image:url(" + obj[i].blogthumbnail + ")></figure></div><div class=blog-list-text><spam>" + obj[i].territoryId + "</spam><h3>" + obj[i].blogtitle + "</h3><p>" + obj[i].blogpublishdate + "</p></div></div></a></li>";
            $("div").find("#blgListing").find("ul").append(structure1);
            counter++;
        }


     flag=counter;

            $(".see-more-blogs").click(function () {

                for (i=flag;i<(parseInt(flag,10) + parseInt(blogCount,10));i++) {
                    structure1 = "<li><a href=" + obj[i].blogpath + ".html><div class=blog-list-content><div class=blog-list-image><figure style = background-image:url(" + obj[i].blogthumbnail + ")></figure></div><div class=blog-list-text><spam>" + obj[i].territoryId + "</spam><h3>" + obj[i].blogtitle + "</h3><p>" + obj[i].blogpublishdate + "</p></div></div></a></li>";
                    $("div").find("#blgListing").find("ul").append(structure1);

                    counter++;
                    if(counter>=obj.length)

                    {
                        $(".see-more-blogs").hide();
                    }


                }
                flag++;


            });


    }



});