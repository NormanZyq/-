function getMyCourse() {
    $.ajax({
        url: "/course/get/my",
        dataType: "json",

        success: function (result) {
            // 解析选课内容
            console.log(result);
        }
    })
}
