/**
 * Created by micha on 2/7/2017.
 */

 function savechangesBtn() {

    var valid_First_name = $('#firstName').val();
    var  valid_Last_name = $('#lastName').val();
    var valid_email = $('#email').val();
    var valid_phone = $('#phone').val();
    var valid_birthday= $('#birthday').val();
    var valid_form = true;

    // regexpressions
   // for future validation var regExpression_id = /^[0-9]{1,25}$/;
    var regExpression_F_Name = /^[A-Za-z  àèìòùÀÈÌÒÙáéíóúýÁÉÍÓÚÝâêîôûÂÊÎÔÛãñõÃÑÕäëïöüÿÄËÏÖÜŸçÇßØøÅåÆæœ]{2,15}$/;
    var regExpression_L_Name = /^[A-Za-z  àèìòùÀÈÌÒÙáéíóúýÁÉÍÓÚÝâêîôûÂÊÎÔÛãñõÃÑÕäëïöüÿÄËÏÖÜŸçÇßØøÅåÆæœ]{2,15}$/;
    var regExpression_Email = /^([0-9a-zA-Z]+[-._+&amp;])+[0-9a-zA-Z]+@([-0-9a-zA-Z]+[.])+[a-zA-Z]{2,6}$/;
    var regExpression_Phone = /^\d{3}[-]*\d{3}[-]*\d{4}$/ ;
    var regExpression_Birthday = /^\d{4}\-\d{2}\-\d{2}$/;

    // Create the regular expression


        if(regExpression_F_Name.test(valid_First_name))
        {
            $('#firstNameDiv').removeClass("has-error");
            $('#firstNameGlyph').removeClass("glyphicon-remove");
            $('#firstNameGlyph').addClass("glyphicon-ok");
            $('#firstNameDiv').addClass("has-success");
            console.log("vaild input");

        }
        else
        {

            $('#firstNameDiv').addClass("has-error");
            $('#firstNameGlyph').addClass("glyphicon-remove");
            $('#firstNameGlyph').removeClass("glyphicon-ok");
            $('#firstNameDiv').removeClass("has-success");
            valid_form = false;
            console.log("Invalid Input");


        }
        if(regExpression_L_Name.test(valid_Last_name))
        {
            $('#lastNameDiv').removeClass("has-error");
            $('#lastNameGlyph').removeClass("glyphicon-remove");
            $('#lastNameGlyph').addClass("glyphicon-ok");
            $('#lastNameDiv').addClass("has-success");
            console.log("vaild input");
        }
        else
        {
            $('#lastNameDiv').addClass("has-error");
            $('#lastNameGlyph').addClass("glyphicon-remove");
            $('#lastNameGlyph').removeClass("glyphicon-ok");
            $('#lastNameDiv').removeClass("has-success");
            valid_form = false;
            console.log("invaild input");

        }
        if(regExpression_Email.test(valid_email))
        {
            $('#emailDiv').removeClass("has-error");
            $('#emailGlyph').removeClass("glyphicon-remove");
            $('#emailGlyph').addClass("glyphicon-ok");
            $('#emailDiv').addClass("has-success");
            console.log("vaild input");
        }
        else
        {
            $('#emailDiv').addClass("has-error");
            $('#emailGlyph').addClass("glyphicon-remove");
            $('#emailGlyph').removeClass("glyphicon-ok");
            $('#emailDiv').removeClass("has-success");
            valid_form = false;
            console.log("invaild input");

        }
        if(regExpression_Phone.test(valid_phone))
        {
            $('#phoneDiv').removeClass("has-error");
            $('#phoneGlyph').removeClass("glyphicon-remove");
            $('#phoneGlyph').addClass("glyphicon-ok");
            $('#phoneDiv').addClass("has-success");
            console.log("vaild input");
        }
        else
        {
            $('#phoneDiv').addClass("has-error");
            $('#phoneGlyph').addClass("glyphicon-remove");
            $('#phoneGlyph').removeClass("glyphicon-ok");
            $('#phoneDiv').removeClass("has-success");
            valid_form = false;

            console.log("invaild input");

        }
        if(regExpression_Birthday.test(valid_birthday))
        {
            $('#birthdayDiv').removeClass("has-error");
            $('#birthdayGlyph').removeClass("glyphicon-remove");
            $('#birthdayGlyph').addClass("glyphicon-ok");
            $('#birthdayDiv').addClass("has-success");

            console.log("vaild input");
        }
        else
        {
            $('#birthdayDiv').addClass("has-error");
            $('#birthdayGlyph').addClass("glyphicon-remove");
            $('#birthdayGlyph').removeClass("glyphicon-ok");
            $('#birthdayDiv').removeClass("has-success");
            valid_form = false;
            console.log("invaild input");

        }
        valid_form = true;
        if(valid_form == true){
            // call new  servlet here
            <!-- AJAX Post -->
                console.log("is form vaild")
                var url = "api/name_list_edit";
                var dataToServer = { first : valid_First_name,last : valid_Last_name
                , email: valid_email , phone: valid_phone,
                    birthday : valid_birthday
                };
            $.ajax({
                type: 'POST',
                url: url,
                data: JSON.stringify(dataToServer),
                success: function()  {
                    $('#myModal').modal('hide');

                    $("#displayUserInfo tbody tr").empty();
                    displayTableRecords();
                },
                contentType: "application/json",
                dataType: 'text' // Could be JSON or whatever too
            });
        }

        else
        {
            valid_form == false;
            showDialogAdd();

            // valid form == false;
        }


}

 var savechanges = $('#saveChanges');
savechanges.on("click",savechangesBtn);


