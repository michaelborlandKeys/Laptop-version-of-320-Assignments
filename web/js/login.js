/**
 * Created by micha on 3/28/2017.
 */
<!-- AJAX Post -->

function logOut() {

    var url = "api/logout_servlet";

    $.post(url, null, function (dataFromServer) {
        console.log("Finished calling servlet.");
        console.log(dataFromServer);
        getLogin();
    });
}

function getLogin() {

    var url ="api/get_login_servlet";
var checklogin=true;


    $.post(url,null, function (dataFromServer) {
        var logInUser=dataFromServer;
        var logoffmessage= "you are not logged in"

            console.log("Finished calling servlet.");
        $('#getloginResult').append(logInUser);
        if(logInUser>=1){
            $('#getloginResult pre').empty();
        }

        if(logInUser=="null"){
            $('#invalidateSession').hide();
        }
        else{
            $('#invalidateSession').show();
        }
    });


}

function login() {

    var url = "api/login_servlet";


    var loginId = $("#loginId").val();

    var dataToServer = { loginId :loginId};

    $.post(url, dataToServer, function (dataFromServer) {
        console.log("Finished calling servlet.");
        console.log(dataFromServer);
        $("#loginId").val("");
        getLogin();
    });
}
retreive_Login = $('#tesgetlogin');
retreive_Login.on("click", getLogin);

set_Login = $('#submit_login');
set_Login.on("click", login);


logout_user = $('#invalidateSession');
logout_user.on("click", logOut);
getLogin();