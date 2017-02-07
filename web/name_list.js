/**
 * Created by micha on 1/31/2017.
 */




function displayTableRecords() {
    // Here's where your code is going to go.


    var url = "api/name_list_get";

    $.getJSON(url, null, function(display_Json_Data) {
        // display_Json_Data is an object. You can set a breakpoint, or print
        // it to see the fields. Specifically, it is an array of objects.
        // Here we loop the array and print the first name.


        $("#displayUserInfo")[0].rows[1].remove();
        for (var i = 0; i < display_Json_Data.length; i++) {
            var fieldDataGet = $('#displayUserInfo').val();
            var fieldDataDisplay = "<tr><td>"+display_Json_Data[i].id+"</td><td>"+display_Json_Data[i].first+"</td><td>"+display_Json_Data[i].last+"</td>" +
                                    "<td>"+display_Json_Data[i].phone+"</td><td>"+display_Json_Data[i].email+"</td><td>"+display_Json_Data[i].birthday+"</td></tr>";
            $("#displayUserInfo tbody").append(fieldDataDisplay);
            console.log("testing if the log prints to the console on server")

            console.log(display_Json_Data[i].id);
            console.log(display_Json_Data[i].first);
            console.log(display_Json_Data[i].last);
            console.log(display_Json_Data[i].phone);
            console.log(display_Json_Data[i].email);
            console.log(display_Json_Data[i].birthday);

        }

    }
);

}

function showDialogAdd() {

    // Print that we got here
    console.log("Opening add item dialog");

    // Clear out the values in the form.
    // Otherwise we'll keep values from when we last
    // opened or hit edit.
    // I'm getting it started, you can finish.
    $('#id').val("");
    $('#firstName').val("");

    // Show the hidden dialog
    $('#myModal').modal('show');
}

var addItemButton = $('#addItem');
addItemButton.on("click", showDialogAdd);


// Call your code.
displayTableRecords();


