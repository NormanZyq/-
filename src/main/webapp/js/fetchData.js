// import * as $ from "/js/jquery-3.3.1";

function getSelectedCourse() {
    $('#selected-table-body').html('');
    $.ajax({
        url: "/course/get/my",
        dataType: "json",

        success: function (result) {
            // 解析选课内容
            for (let course of result) {
                appendSelectedResult(course);
            }
        }
    })
}

function getUserInfo() {
    $.ajax({
        url: "/user/get/login",
        dataType: "json",
        async: false,
        success: function (result) {
            $('#t1').html(result.userId);
            $('#t2').html(result.name);
            $('#psw').html('---');

        }
    })
}

function getTeachCourse() {



}

function searchCourses() {
    $('#course-table-body').html('');
    let name = $('#search-content').val();
    $.ajax({
        url: "/course/get/" + name,
        type: "GET",
        dataType: "json",
        success: function (result) {
            console.log(result);
            // 解析结果
            if (result.length === 0) {
                $('#course-table-body').html("<p class='text-center'>未找到课程</p>")
            }
            for (course of result) {
                appendSearchResult(course);
            }
        },
        error: function (result) {
            alert(result);
            console.log(result);
        }
    })
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

