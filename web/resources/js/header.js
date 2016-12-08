/**
 * Created by Денис on 08.12.2016.
 */
require(["dojo/dom", "dojo/request", "dojo/json",
        "dojo/_base/array", "dojo/domReady!"],
    function(dom, request, JSON, arrayUtil){
        // Results will be displayed in resultDiv
        var resultDiv = dom.byId("select-employee");

        // Request the JSON data from the server
        request.get("/docflow/rest/v1/organizations/100001/employees", {
            // Parse data from JSON to a JavaScript object
            handleAs: "json"
        }).then(function(data){
                // Display the data sent from the server
                var html = "";

                arrayUtil.forEach(data, function(item,i){
                    html += "<option"+" data-id="+item.id+"> " + item.firstName +" "+ item.lastName+" "+item.middleName+"</option>";
                });


                resultDiv.innerHTML = html;
            },
            function(error){
                // Display the error returned
                resultDiv.innerHTML = error;
            });
    }
);