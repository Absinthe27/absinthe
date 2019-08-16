$(document).ready(function () {


    $.ajax({
        type: "GET",
        url: "/notification/getNum",
        dataType: 'text',
        cache: false,
        timeout: 600000,
        success: function (data) {
            var obj = JSON.parse(data);
            $("#notificationNum").html(obj);
        },
        error: function (e) {
            alert("erro")
        }
    });


});

