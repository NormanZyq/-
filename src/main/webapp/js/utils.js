var userId;


function navBar() {


}

function login(id, password) {
    $.ajax({
        url: "/user/login",
        dataType: "text",
        method: "POST",
        data: {
            userId: id,
            password: password
        },
        success: function (result) {
            if (result == 'ok') {
                alert("OK!!!!");
                userId = id;
            } else {
                alert("失败");
            }
        }
    })
}