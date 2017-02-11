/**
 * Created by micha on 2/7/2017.
 */

 function savechangesBtn() {
    var valid_id = $('#id').val();
    var valid_First_name = $('#firstName').val();
    var  valid_Last_name = $('#lastName').val();
    var valid_email = $('#email').val();
    var valid_phone = $('#phone').val();
    var valid_birthday= $('#birthday').val();

    // regexpressions
    var regExpression_id = /^[0-9]{1,25}$/;
    var regExpression_F_Name = /^[A-Za-z  àèìòùÀÈÌÒÙáéíóúýÁÉÍÓÚÝâêîôûÂÊÎÔÛãñõÃÑÕäëïöüÿÄËÏÖÜŸçÇßØøÅåÆæœ]{2,15}$/;
    var regExpression_L_Name = /^[A-Za-z  àèìòùÀÈÌÒÙáéíóúýÁÉÍÓÚÝâêîôûÂÊÎÔÛãñõÃÑÕäëïöüÿÄËÏÖÜŸçÇßØøÅåÆæœ]{2,15}$/;
    var regExpression_Email = /^([0-9a-zA-Z]+[-._+&amp;])+[0-9a-zA-Z]+@([-0-9a-zA-Z]+[.])+[a-zA-Z]{2,6}$/;
    var regExpression_Phone = /^\d{3}\-\d{3}\-\d{4}$/ ;
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
            console.log("invaild input");

        }


}
function closeBtn() {
     // http://stackoverflow.com/questions/19541936/reset-remove-classes-from-a-form-after-jquery-validator-use-inside-modal
    // that was the site i fpund out how to reset the specfic classes,
    // i tried just removinvg classes
    // but i did work, i found  this solution. i was trying to
    // remove has success and error classes from my-form id, and that failed.
    // i researched the reset method implemtation on w3schools to get it to reset.
    $('.form-group').removeClass('has-error  has-feedback');
    document.getElementById("my-form").reset();


}
 var  closingBtn = $('#closing');
closingBtn.on("click",closeBtn);

 var savechanges = $('#saveChanges');
savechanges.on("click",savechangesBtn);

