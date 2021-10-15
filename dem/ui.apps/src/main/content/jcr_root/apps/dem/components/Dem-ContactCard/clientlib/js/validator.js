window.alert("Chirag");

(function ($, $document) {
    "use strict";
    var el = $('[name="./contlist"]');
 
    $.validator.register("foundation.validation.validator", {
        selector: "coral-multifield",
        validate: function(el) {
 
            var max,totalPanels = el["0"].items.getAll().length;            
            max = $('[name="./contCountmax"]').val();
            if(totalPanels > max) {
             el["0"].items.last().remove();
             return "Maximum numbers of Contacts Card allowed are: "+ max;
            }
 
        }});
}($, $(document)));