/**
 * Created by Arrepticius on 25.02.2017.
 */
var main = {
    registration: function () {
        var log = document.getElementById("logReg").value;
        var mail = document.getElementById("mailReg").value;
        var pass = document.getElementById("passReg").value;
        var uname = document.getElementById("user_name").value;
        $.ajax({
            type: "POST",
            url: "/SkateCom",
            dataType: "json",
            data: {requestType: "registration", login: log, password: pass, email: mail, name: uname},
            success: function (data) {
                if(data.login == "error"){
                    document.location.href = 'errorPage.html';
                }else {
                    document.location.href = 'index.html';
                }

            }
        });
    },

    log_in: function () {
        var log = document.getElementById("login").value;
        var pass = document.getElementById("pass").value;
        $.ajax({
            type: "POST",
            url: "/SkateCom",
            dataType: "json",
            data: {requestType: "login", login: log, password: pass},
            success: function (data) {
                if(data.login == "error")
                    document.location.href = 'errorPage.html';
                else
                    document.location.href = 'index.html';
                window.onload = function() {
                    document.getElementById("name").innerHTML = data.name;
                    document.getElementById("index").innerHTML = data.indexNumber;
                }

            }
        });
    }


};