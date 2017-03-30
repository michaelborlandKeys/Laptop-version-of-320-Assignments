/**
 * Created by micha on 3/28/2017.
 */
<!-- AJAX Post -->
function logOut() {

    var url = "api/invalidate_session_servlet";

    $.post(url, null, function (dataFromServer) {
        console.log("Finished calling servlet.");
        console.log(dataFromServer);
    });
}

function getLogin() {

    var url = "api/get_session_servlet";

    $.post(url, null, function (dataFromServer) {
        console.log("Finished calling servlet.");
        console.log(dataFromServer);
        $('#getSessionResult').html(dataFromServer)
    });
}

function setLogin() {

    var url = "api/set_session_servlet";

    var sessionKey = $("#sessionKey").val();
    var sessionValue = $("#sessionValue").val();

    var dataToServer = {sessionKey : sessionKey, sessionValue : sessionValue};

    $.post(url, dataToServer, function (dataFromServer) {
        console.log("Finished calling servlet.");
        console.log(dataFromServer);
        $("#sessionKey").val("");
        $("#sessionValue").val("");
    });
}
retreive_Login = $('#getSessionJava');
retreive_Login.on("click", getLogin);

set_Login = $('#setSessionJava');
set_Login.on("click", setLogin);


logout_user = $('#invalidateSession');
logout_user.on("click", logOut);