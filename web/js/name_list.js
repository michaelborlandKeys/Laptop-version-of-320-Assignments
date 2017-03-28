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
            // adding comment so build way change.
        };


        for (var i = 0; i < display_Json_Data.length; i++) {
            var insertDashes;
            var phone_number = display_Json_Data[i].phone;


            if(phone_number.indexOf("-") > 0 )
            {

                insertDashes=phone_number;
            }
            else
            {
                insertDashes = display_Json_Data[i].phone.substring(0,3) + "-"
                    +display_Json_Data[i].phone.substring(3,6)+"-"+display_Json_Data[i].phone.substring(6,10);
            }
            var fieldDataDisplay = "<tr><td>"+display_Json_Data[i].id+"</td><td>"+display_Json_Data[i].first+"</td><td>"+display_Json_Data[i].last+"</td>" +
                "<td>"+insertDashes+"</td><td>"+display_Json_Data[i].email+"</td><td>"+display_Json_Data[i].birthday+"</td>" +
                "<td><button type='button' name='edit' class='edit btn' value='"+ display_Json_Data[i].id + "'>Edit</button></td>"+
                "<td><button type='button' name='delete' class='delete btn' value='" + display_Json_Data[i].id + "'>Delete</button></td></tr>";

            $("#displayUserInfo tbody").append(fieldDataDisplay);






            console.log(display_Json_Data[i].id);
            console.log(display_Json_Data[i].first);
            console.log(display_Json_Data[i].last);
            console.log(display_Json_Data[i].phone);
            console.log(display_Json_Data[i].email);
            console.log(display_Json_Data[i].birthday);

        }
        var delete_Record = $(".delete");
        delete_Record.on("click", deleteUser);

        var edit_Record= $(".edit");
        edit_Record.on("click",editUser);

    }
)

}

function deleteUser(e) {


    console.debug("Delete");
    console.debug(e.target.value);


    var url = "api/delete_name_list";
    var valid_id = e.target.value;
    var dataToServer = { id : valid_id};
    console.log(dataToServer);

    $.post(url, dataToServer, function (dataFromServer) {
        console.log("Finished calling servlet.");
        console.log(dataFromServer);
        $("#displayUserInfo tbody tr").empty();
        displayTableRecords();

    })



}
function editUser(e) {
    var editing_id = e.target.parentNode.parentNode.querySelectorAll("td")[0].innerHTML;
    var editing_First_name = e.target.parentNode.parentNode.querySelectorAll("td")[1].innerHTML;
    var editing_Last_name = e.target.parentNode.parentNode.querySelectorAll("td")[2].innerHTML ;
    var editing_phone= e.target.parentNode.parentNode.querySelectorAll("td")[3].innerHTML;
    var editing_email = e.target.parentNode.parentNode.querySelectorAll("td")[4].innerHTML;
    var editing_birthday = e.target.parentNode.parentNode.querySelectorAll("td")[5].innerHTML;
    console.debug("Edit");
    console.debug(e.target.value);

    $('#id').val(editing_id);
    $('#firstName').val(editing_First_name);
    $('#lastName').val(editing_Last_name)
    $('#email').val(editing_email);
    $('#phone').val(editing_phone);
    $('#birthday').val(editing_birthday);

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


    $('#myModal').modal('show');
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


