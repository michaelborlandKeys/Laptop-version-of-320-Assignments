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





        if($("#displayUserInfo tbody tr").length = 1 && display_Json_Data.length >0){
            $("#displayUserInfo")[0].rows[1].remove();
        };


        for (var i = 0; i < display_Json_Data.length; i++) {

            var phoneNumberFormatted = display_Json_Data[i].phone.substring(0,3) + "-"
                +display_Json_Data[i].phone.substring(3,6)+"-"+display_Json_Data[i].phone.substring(6,10);
            var fieldDataDisplay = "<tr><td>"+display_Json_Data[i].id+"</td><td>"+display_Json_Data[i].first+"</td><td>"+display_Json_Data[i].last+"</td>" +
                "<td>"+phoneNumberFormatted+"</td><td>"+display_Json_Data[i].email+"</td><td>"+display_Json_Data[i].birthday+"</td></tr>";
                $("#displayUserInfo tbody").append(fieldDataDisplay);
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
    $('#lastName').val("");
    $('#email').val("");
    $('#phone').val("");
    $('#birthday').val("");

// All of the jQuery to remove the style when the add button is clicked.
    $('#firstNameDiv').removeClass("has-error");
    $('#firstNameGlyph').removeClass("glyphicon-remove");
    $('#firstNameGlyph').removeClass("glyphicon-ok");
    $('#firstNameDiv').removeClass("has-success");
    $('#lastNameDiv').removeClass("has-error");
    $('#lastNameGlyph').removeClass("glyphicon-remove");
    $('#lastNameGlyph').removeClass("glyphicon-ok");
    $('#lastNameDiv').removeClass("has-success");
    $('#emailDiv').removeClass("has-error");
    $('#emailGlyph').removeClass("glyphicon-remove");
    $('#emailGlyph').removeClass("glyphicon-ok");
    $('#emailDiv').removeClass("has-success");
    $('#phoneDiv').removeClass("has-error");
    $('#phoneGlyph').removeClass("glyphicon-remove");
    $('#phoneGlyph').removeClass("glyphicon-ok");
    $('#phoneDiv').removeClass("has-success");
    $('#birthdayDiv').removeClass("has-error");
    $('#birthdayGlyph').removeClass("glyphicon-remove");
    $('#birthdayGlyph').removeClass("glyphicon-ok");
    $('#birthdayDiv').removeClass("has-success");




    // Show the hidden dialog
    $('#myModal').modal('show');
}

var addItemButton = $('#addItem');
addItemButton.on("click", showDialogAdd);


// Call your code.
displayTableRecords();


