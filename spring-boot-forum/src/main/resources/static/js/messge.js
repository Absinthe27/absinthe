$(document).ready(function () {
    $.ajax({
        type: "GET",
        url: "/message/getOne",
        dataType: 'text',
        cache: false,
        timeout: 600000,
        success: function (data) {

            var obj = JSON.parse(data);
            var bodyStr = obj.body
            var headStr = obj.head

            $('#divhead').html(headStr);
            $('#divbody').html(bodyStr);

        },
        error: function (e) {
            alert("erro")
        }
    });


    $(".messageEdit").click(function (event) {
        var id = $(this).data('message-id');
        var headID = "head" + id
        var bodyID = "body" + id
        var head = $("#" + headID).val();
        var body = $("#" + bodyID).val();

        $.ajax({
            type: "POST",
            url: "/message/add",
            data: JSON.stringify
            ({
                "id": id,
                "head": head,
                "body": body
            }),
            contentType: "application/json",
            dataType: 'text',
            cache: false,
            timeout: 600000,
            success: function (data) {

                alert("success")
            },
            error: function (e) {
                alert("erro")
            }
        });

    })
});

