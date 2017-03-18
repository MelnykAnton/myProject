/**
 * Created by Arrepticius on 25.02.2017.
 */
var main = {
    registration: function () {
        var log = document.getElementById("logReg").value;
        var mail = document.getElementById("mailReg").value;
        var pass = document.getElementById("passReg").value;
        $.ajax({
            type: "POST",
            url: "/SkateCom",
            dataType: "json",
            data: {requestType: "registration", login: log, password: pass, email: mail},
            success: function (data) {
                console.log(data);
                document.location.href='index.html';
            }
        });
    },

    log_in: function () {
        var log = document.getElementsByName("uname").value;
        var pass = document.getElementsByName("psw").value;
        $.ajax({
            type: "POST",
            url: "/SkateCom",
            dataType: "json",
            data: {requestType: "login", login: log, password: pass},
            success: function (data) {
                if(data.name == "error")
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