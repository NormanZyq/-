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

function searchCourses() {
    $('#course-table-body').html('');
    let name = $('#search-content').val();
    $.ajax({
        url: "/course/get/" + name,
        type: "GET",
        dataType: "json",
        success: function (result) {
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

