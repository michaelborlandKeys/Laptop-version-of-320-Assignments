/**
 * Created by micha on 1/19/2017.
 */


function Part1 () {

    console.log("Hello");

}
    var part_1 = $("#button1");

    part_1.on("click",Part1);

function Part2(sum_Of_Form)
{


    var form_Val_1 = $("#field1").val();
    var form_Val_2 = $("#field2").val();
    var sum_Of_Form = $("#field3").val();

    sum_Of_Form= parseInt(form_Val_1)+parseInt(form_Val_2);

    return  sum_Of_Form= $("#field3").val(sum_Of_Form);


}
    var part_2 = $("#button2");

    part_2.on("click",Part2);


function Part3 (event)
{
    if($("#paragraphToHide").is(":visible")) {
        $("#paragraphToHide").hide();
    } else
    {
        $("#paragraphToHide").show();
    }

}

    var part_3 = $("#button3");
    part_3.on("click", Part3);

function Part4(event) {
    // Get the field
    var valid_Phone_number = $('#phoneField').val();

    // Create the regular expression
    var regExpression = /^\d{3}\-\d{3}\-\d{4}$/;

    // Test the regular expression to see if there is a match
    if (regExpression.test(valid_Phone_number)) {
      console.log("Ok") ;
    } else {
        console.log("Bad");
    }}

// Attach an action to a button click
    var part_4 = $('#button4');
    part_4.on("click", Part4);






function Part5(event) {

    // Create an empty object
    var registration_form_Object = {};

    // Set a field in the object to the value in this form field
    registration_form_Object.firstName = $("#firstName").val();
    registration_form_Object.lastName = $("#lastName").val();
    registration_form_Object.email = $("#email").val();

    // Build the JSON string based on that object's fields
    var json_registeration_String = JSON.stringify(registration_form_Object);



    // Set a field to the JSON result so we can see it.
    console.log(json_registeration_String);
}

// Attach an action to a button click
    var part_5 = $('#button5');
    part_5.on("click", Part5);
