function getSelectedCourse() {
    $.ajax({
        url: "/course/get/my",
        dataType: "json",

        success: function (result) {
            // 解析选课内容
            console.log(result);
        }
    })
}

function getTeachCourse() {



}


function getTests() {
    $.ajax({
        url: "/test/get/my",
        dataType: "json",

        success: function (result) {
            // 解析选课内容
            console.log(result);
        }
    })
}

